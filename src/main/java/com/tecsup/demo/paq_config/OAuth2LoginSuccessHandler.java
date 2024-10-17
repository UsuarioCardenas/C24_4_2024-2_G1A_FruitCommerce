package com.tecsup.demo.paq_config;

import com.tecsup.demo.paq_model.paq_entity.RegistrationSource;
import com.tecsup.demo.paq_model.paq_entity.UserRole;
import com.tecsup.demo.paq_model.paq_entity.Usuario;
import com.tecsup.demo.paq_service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final UsuarioService usuarioService;
    private final String frontendUrl;

    public OAuth2LoginSuccessHandler(UsuarioService usuarioService, @Value("${frontend.url}") String frontendUrl) {
        this.usuarioService = usuarioService;
        this.frontendUrl = frontendUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;

        if ("google".equals(oAuth2AuthenticationToken.getAuthorizedClientRegistrationId())) {
            DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();
            Map<String, Object> attributes = principal.getAttributes();

            // Captura los datos de la cuenta de Google
            String email = attributes.getOrDefault("email", "").toString();
            String name = attributes.getOrDefault("name", "").toString();
            String telefono = attributes.getOrDefault("phone_number", "").toString(); // Si Google lo proporciona
            String direccion = attributes.getOrDefault("address", "").toString();    // Si Google lo proporciona

            usuarioService.findByEmail(email).ifPresentOrElse(user -> {
                // Actualizar el contexto de seguridad con el usuario existente, pero sin rol definido
                user.setRole(UserRole.NINGUNO); // Asignar rol 'Ninguno'
                usuarioService.save(user); // Actualiza el usuario en la base de datos

                DefaultOAuth2User newUser = new DefaultOAuth2User(
                        List.of(new SimpleGrantedAuthority(user.getRole().name())), attributes, "email"
                );
                Authentication securityAuth = new OAuth2AuthenticationToken(
                        newUser, List.of(new SimpleGrantedAuthority(user.getRole().name())),
                        oAuth2AuthenticationToken.getAuthorizedClientRegistrationId()
                );
                SecurityContextHolder.getContext().setAuthentication(securityAuth);

            }, () -> {
                // Crear un nuevo usuario si no existe
                Usuario usuario = new Usuario();
                usuario.setRole(UserRole.NINGUNO);  // Asignar rol 'Ninguno'
                usuario.setEmail(email);
                usuario.setUsuario(name);
                usuario.setTelefono(telefono);  // Guardar el teléfono
                usuario.setDireccion(direccion);  // Guardar la dirección
                usuario.setSource(RegistrationSource.GOOGLE);
                usuarioService.save(usuario);

                // Actualizar el contexto de seguridad con el nuevo usuario
                DefaultOAuth2User newUser = new DefaultOAuth2User(
                        List.of(new SimpleGrantedAuthority(usuario.getRole().name())), attributes, "email"
                );
                Authentication securityAuth = new OAuth2AuthenticationToken(
                        newUser, List.of(new SimpleGrantedAuthority(usuario.getRole().name())),
                        oAuth2AuthenticationToken.getAuthorizedClientRegistrationId()
                );
                SecurityContextHolder.getContext().setAuthentication(securityAuth);
            });
        }

        this.setAlwaysUseDefaultTargetUrl(true);
        this.setDefaultTargetUrl(frontendUrl); // Redirige a la URL del frontend
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
