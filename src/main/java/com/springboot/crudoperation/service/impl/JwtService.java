package com.springboot.crudoperation.service.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService {

    @Value("${jwt.security.secret-key}")
    String secretKey;
    @Getter
    @Value("${jwt.security.expiry-time}")
    Long expiryTime;

    public String extractName(String token){

        return null;
    }

    public String generateToken(UserDetails userDetails){

       return Jwts.builder().setClaims(new HashMap<>()).setSubject(userDetails.getUsername()).
                setExpiration(new Date(System.currentTimeMillis()+expiryTime)).
               setIssuedAt(new Date(System.currentTimeMillis())).
               signWith(getSignupKey(), SignatureAlgorithm.HS256).compact();

    }

    private Key getSignupKey() {
       byte[] keyData= Decoders.BASE64.decode(secretKey);
       return Keys.hmacShaKeyFor(keyData);
    }


}
