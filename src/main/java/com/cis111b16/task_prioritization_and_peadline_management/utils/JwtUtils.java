package com.cis111b16.task_prioritization_and_peadline_management.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final String KEY="CIS111B";

    public static String genToken(Map<String,Object> claims){
        return JWT.create().withClaim("claims",claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*3600*12))
                .sign(Algorithm.HMAC256(KEY));
    }

    public static Map<String,Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(KEY)).build()
                .verify(token).getClaim("claims").asMap();
    }
}
