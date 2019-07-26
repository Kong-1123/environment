package com.xdmd.environment.company.Utils;

import com.xdmd.environment.company.Pojo.JwtInformation;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    public static final String SUBJECT = "onehee";

    public static final long EXPIRE = 1000*60;  //过期时间，毫秒，一周

    //秘钥
    public static final  String APPSECRET = "onehee666";

    /**
     * 生成jwt
     * @param jwtInformation
     * @return
     */
    public static String geneJsonWebToken(JwtInformation jwtInformation){

        if(jwtInformation == null || jwtInformation.getCid() == null || jwtInformation.getCompanyName() == null ||
                jwtInformation.getUid() == null || jwtInformation.getUsername() == null){
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("uid",jwtInformation.getUid())
                .claim("uname",jwtInformation.getUsername())
                .claim("cid",jwtInformation.getCid())
                .claim("cname",jwtInformation.getCompanyName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();

        return token;
    }


    /**
     * 校验token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token ){

        try{
            final Claims claims =  Jwts.parser().setSigningKey(APPSECRET).
                    parseClaimsJws(token).getBody();
            return  claims;

        }catch (Exception e){ }
        return null;

    }


}
