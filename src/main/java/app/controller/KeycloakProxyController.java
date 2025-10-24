package app.controller;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/api/keycloak")
public class KeycloakProxyController {

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody Map<String, String> userData) {
        try {
            String username = userData.get("username");
            String email = userData.get("email");
            String password = userData.get("password");

            // Pega token admin
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders tokenHeaders = new HttpHeaders();
            tokenHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            
            MultiValueMap<String, String> tokenBody = new LinkedMultiValueMap<>();
            tokenBody.add("grant_type", "client_credentials");
            tokenBody.add("client_id", "admin-cli");
            tokenBody.add("client_secret", "NChR53bnbpxJEfxmTWpKB1pHN8pTyDz0");
            
            HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<>(tokenBody, tokenHeaders);
            ResponseEntity<Map> tokenResponse = restTemplate.postForEntity(
                "http://localhost:6969/realms/pm03/protocol/openid-connect/token",
                tokenRequest,
                Map.class
            );
            
            String accessToken = (String) tokenResponse.getBody().get("access_token");
            
            // Cria usuário
            HttpHeaders userHeaders = new HttpHeaders();
            userHeaders.setBearerAuth(accessToken);
            userHeaders.setContentType(MediaType.APPLICATION_JSON);
            
            Map<String, Object> userPayload = new HashMap<>();
            userPayload.put("username", username);
            userPayload.put("email", username + "@tempmail.com"); // ✅ Cria email fake válido
            userPayload.put("firstName", username);  // ✅ ADICIONA
            userPayload.put("lastName", "Usuario");  // ✅ ADICIONA
            userPayload.put("enabled", true);
            userPayload.put("emailVerified", true);
            userPayload.put("requiredActions", List.of()); // ✅ ADICIONA ESSA LINHA - lista vazia
            
            Map<String, Object> credential = new HashMap<>();
            credential.put("type", "password");
            credential.put("value", password);
            credential.put("temporary", false);
            userPayload.put("credentials", List.of(credential));
            
            HttpEntity<Map<String, Object>> userRequest = new HttpEntity<>(userPayload, userHeaders);
            restTemplate.postForEntity(
                "http://localhost:6969/admin/realms/pm03/users",
                userRequest,
                String.class
            );
            
            return ResponseEntity.ok().body(Map.of("message", "Usuário criado com sucesso"));
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        try {
            String username = credentials.get("username");
            String password = credentials.get("password");

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            
            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("grant_type", "password");
            body.add("client_id", "keycloakAPI");
            body.add("username", username);
            body.add("password", password);
            
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);
            ResponseEntity<Map> response = restTemplate.postForEntity(
                "http://localhost:6969/realms/pm03/protocol/openid-connect/token",
                request,
                Map.class
            );
            
            return ResponseEntity.ok(response.getBody());
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body(Map.of("error", "Credenciais inválidas"));
        }
    }
}

