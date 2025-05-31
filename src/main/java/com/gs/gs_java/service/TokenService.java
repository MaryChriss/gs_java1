package com.gs.gs_java.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gs.gs_java.model.Token;
import com.gs.gs_java.model.User;

@Service
public class TokenService {

    private Instant experiesAt = LocalDateTime.now().plusMinutes(120).toInstant(ZoneOffset.ofHours(-3));
    private Algorithm algorithm = Algorithm.HMAC256("secret-muito-secreto-que-ninguem-pode-saber");

    public Token createToken(User user) {
        var jwt = JWT.create()
                .withSubject(user.getIdUser().toString())
                .withClaim("email", user.getEmail())
                .withExpiresAt(experiesAt)
                .sign(algorithm);

        return new Token(jwt, "Bearer", user.getEmail());
    }

    public User getUserFromToken(String jwt) {
        var jwtVerified = JWT.require(algorithm).build().verify(jwt);
        return User.builder()
                .idUser(Long.valueOf(jwtVerified.getSubject()))
                .email(jwtVerified.getClaim("email").asString())
                .build();

    }

}