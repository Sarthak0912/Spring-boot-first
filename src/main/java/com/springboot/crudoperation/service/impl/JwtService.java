package com.springboot.crudoperation.service.impl;

import io.jsonwebtoken.Claims;
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
import java.util.function.Function;

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

    public String extractUsername(String token){
        return extractClaims(token,Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims,T> claimsFunction){
        Claims claims=extractAllClaims(token);
        return claimsFunction.apply(claims);

    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignupKey()).build().parseClaimsJws(token).getBody();
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
    public Date extractExpiration(String token){
        return extractClaims(token,Claims::getExpiration);
    }
    public Boolean isTokenExpired(String token){
        return extractExpiration(token).after(new Date());
    }

    public Boolean isTokenValid(String token,UserDetails userDetails){
        return (userDetails.getUsername().equals(extractUsername(extractUsername(token))) && isTokenExpired(token));
    }


}
