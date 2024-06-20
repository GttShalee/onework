package cn.shalee;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 12:27
 * @注释
 */
public class JwtTest {

    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","shalee");

        String token = JWT.create()
                .withClaim("user", claims) //添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 3))   //添加过期时间
                .sign(Algorithm.HMAC256("shalee"));

        System.out.println(token);
    }

    @Test
    public void testParse() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MTc5MTgzMjN9.jptBHW5z2lslfluUnpq4rWDo7kQSR9PD50q_wG34erU";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("shalee")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        Map<String, Claim> claims = decodedJWT.getClaims();

        System.out.println(claims.get("user"));
    }

    //失效情况 篡改 + 过期
}
