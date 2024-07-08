package med.voll.api.infra.security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import med.voll.api.models.entities.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
	@Value("${api.security.token.secret}")
	private String secret;
	private final String ISSUER = "API Voll.med";

	public String generateToken(User user) {
		System.out.println("Chave: " + secret);
		try {
			var algorithm = Algorithm.HMAC256(secret);
			return JWT.create()
					       .withIssuer(ISSUER)
					       .withSubject(user.getUsername())
					       .withExpiresAt(expirationDate())
					       .sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Erro ao gerar token: " + exception);
		}
	}

	private Instant expirationDate() {
		return LocalDateTime.now()
				       .plusHours(2)
				       .toInstant(ZoneOffset.of("-03:00"));
	}

		public String getSubject(String tokenJWT) {
			try {
				var algorithm = Algorithm.HMAC256(secret);
				return JWT.require(algorithm)
									.withIssuer(ISSUER)
									.build()
									.verify(tokenJWT)
									.getSubject();
			} catch (JWTVerificationException exception) {
				new RuntimeException("Erro ao gerar token: " + exception);
			}
			return null;
		}
}
