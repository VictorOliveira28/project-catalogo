package com.victoroliveira.catalogo.services;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victoroliveira.catalogo.dto.EmailDTO;
import com.victoroliveira.catalogo.dto.NewPasswordDTO;
import com.victoroliveira.catalogo.entities.PasswordRecover;
import com.victoroliveira.catalogo.entities.User;
import com.victoroliveira.catalogo.repositories.PasswordRecoverRepository;
import com.victoroliveira.catalogo.repositories.UserRepository;
import com.victoroliveira.catalogo.services.exceptions.ResourceNotFoundException;

@Service
public class AuthService {

	@Value("${email.password-recover.token.minutes}")
	private Long tokenMinutes;
	
	@Value("${email.password-recover.uri}")
	private String recoverUri;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordRecoverRepository passwordRecoverRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Transactional
	public void createRecoverToken(EmailDTO body) {
		
		User user = userRepository.findByEmail(body.getEmail());
		
		if(user == null) {
			throw new ResourceNotFoundException("Email not found");
		}
		
		String token = UUID.randomUUID().toString();
		
		PasswordRecover entity = new PasswordRecover();
		entity.setEmail(body.getEmail());
		entity.setToken(token);
		entity.setExpiration(Instant.now().plusSeconds(tokenMinutes * 60L));
		entity = passwordRecoverRepository.save(entity);
		
		String text = "Acesse o link para definir uma nova senha \n\n"
				+ recoverUri + token + ". Validade de " + tokenMinutes + " minutos"; 
		
		emailService.sendEmail(body.getEmail(), "Recuperação de Senha", text);
		
	}

	@Transactional
	public void saveNewPassword(NewPasswordDTO body) {
		
		List<PasswordRecover> result = passwordRecoverRepository.searchValidTokens(body.getToken(), Instant.now());
		
		if(result.size() == 0) {
			throw new ResourceNotFoundException("Invalid Token");
		}
		
		User user = userRepository.findByEmail(result.get(0).getEmail());
		user.setPassword(passwordEncoder.encode(body.getPassword()));
		user = userRepository.save(user);
	}
	
	protected User autheticated() {
		
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
			String username = jwtPrincipal.getClaim("username");
			return userRepository.findByEmail(username);
		} catch(Exception e) {
			throw new UsernameNotFoundException("Invalid user");
		}
	}
	
}
