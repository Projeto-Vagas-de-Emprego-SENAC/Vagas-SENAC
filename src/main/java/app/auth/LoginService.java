//AuthenticationService.java
package app.auth;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

//import app.config.JwtServiceGenerator;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class LoginService {

	 private final WebClient webClient = WebClient.create("http://localhost:6969/realms/pm03/protocol/openid-connect/token");

	    public String logar(String username, String password) {
	        return webClient.post()
	                .bodyValue("grant_type=password&client_id=keycloakAPI&client_secret=ZXiQZ3CsQQXp6vHJU5PJoWNIiSKvvHYL&username=" 
	                        + username + "&password=" + password)
	                .header("Content-Type", "application/x-www-form-urlencoded")
	                .retrieve()
	                .bodyToMono(String.class)
	                .block();
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Autowired
//	private LoginRepository repository;
//	@Autowired
//	private JwtServiceGenerator jwtService;
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//
//	
//	public String logar(Login login) {
//
//		String token = this.gerarToken(login);
//		return token;
//
//	}
//
//
//
//	public String gerarToken(Login login) {
//		authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(
//						login.getUsername(),
//						login.getPassword()
//						)
//				);
//		Usuario user = repository.findByUsername(login.getUsername()).get();
//		String jwtToken = jwtService.generateToken(user);
//		return jwtToken;
//	}


}
