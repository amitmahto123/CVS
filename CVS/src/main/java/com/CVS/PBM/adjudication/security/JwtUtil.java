package com.CVS.PBM.adjudication.security;


import java.util.Date;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    private SecretKey signingKey;
    private JwtParser jwtParser;

    // Token validity in milliseconds (e.g., 1 hours)
    private static final long EXPIRATION_TIME_MS = 360000;

    @PostConstruct
    public void init() {
        this.signingKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        this.jwtParser = Jwts.parser()
                .verifyWith(signingKey)
                .build();
    }

    public String generateToken(String username) {
    	Date now= new Date();
		Date expireTime = new Date(now.getTime() + EXPIRATION_TIME_MS);
		return Jwts.builder().subject(username)
				.issuedAt(now)
				.expiration(expireTime)
				.signWith(signingKey)
				.compact();
		}
	
		 public Claims extractAllClaims(String token) {
		        return jwtParser.parseSignedClaims(token).getPayload();
		    }

		    public String extractUsername(String token) {
		        return extractAllClaims(token).getSubject();
		    }

		    public Boolean validateToken(String token, String username) {
		        final String extractedUsername = extractUsername(token);
		        return (extractedUsername.equals(username) && !isTokenExpired(token));
		    }

		    private Boolean isTokenExpired(String token) {
		        return extractAllClaims(token).getExpiration().before(new Date());
		    }
		
        
}
    
