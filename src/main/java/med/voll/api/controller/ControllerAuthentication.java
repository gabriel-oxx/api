package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.infra.security.TokenService;
import med.voll.api.infra.security.dataTokenJWT;
import med.voll.api.models.entities.user.AuthenticationData;
import med.voll.api.models.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class ControllerAuthentication {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenService tokenService;

	@PostMapping
	ResponseEntity signIn(@RequestBody @Valid AuthenticationData data) {
		var token = new UsernamePasswordAuthenticationToken(data.userName(), data.password());
		var authentication = authenticationManager.authenticate(token);
			var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
		return ResponseEntity.ok(tokenJWT);
	}

}
