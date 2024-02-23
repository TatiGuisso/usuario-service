package com.grupo16.usuarioservice.gateway.token;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.grupo16.usuarioservice.domain.Usuario;
import com.grupo16.usuarioservice.gateway.TokenGateway;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGatewayImpl implements TokenGateway {
	@Value("${api.security.token.secret}")
	private String secret;

	@Override
	public String getToken(Usuario usuario) {
		try {

			SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

			Date now = new Date();

			byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
			SecretKeySpec signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

			Map<String, Object> infos = new HashMap<>();
			infos.put("userId", usuario.getId());
			infos.put("userRole", usuario.getRole().name());
			
			JwtBuilder builder = Jwts.builder()
					.setId(UUID.randomUUID().toString())
					.setIssuedAt(now)
					.setSubject(usuario.getLogin())
					.setIssuer("usuario-service")
					.setExpiration(getExpirationDate())
					.setClaims(infos)
					.signWith(signingKey, signatureAlgorithm);

			return builder.compact();
		} catch (Exception e) {
			throw new RuntimeException("Error while generating token", e);
		}
	}

	private Date getExpirationDate() {
		return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
	}


}
