package sopt.org.FourthSeminar.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import sopt.org.FourthSeminar.exception.Error;
import sopt.org.FourthSeminar.exception.model.UnauthorizedException;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {
    @Value("${jwt.secret}")
    private String jwtSecret;

    private final RedisTemplate<String, String> redisTemplate;

    @PostConstruct
    protected void init() {
        jwtSecret = Base64.getEncoder()
                .encodeToString(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    // JWT 토큰 발급
    private String issuedToken(final String userId, final Long duration, final String type) {
        final Date now = new Date();

        final Claims claims = Jwts.claims()
                .setSubject(type)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + duration));

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setClaims(claims)
                .signWith(getSigningKey())
                .compact();

    }

    // JWT 액세스 토큰 발급
    public String issuedAccessToken(String userId) {
        final long duration = 120 * 60 * 1000L;
        return issuedToken(userId, duration, "access_token");
    }

    // JWT 리프레시 토큰 발급
    public String issuedRefreshToken(String userId) {
        final Long duration = 120 * 60 * 30 * 1000L;
        String refreshToken = issuedToken(userId, duration, "refresh_token");
        redisTemplate.opsForValue().set(String.valueOf(userId), refreshToken, Duration.ofMillis(duration));
        return refreshToken;
    }


    private Key getSigningKey() {
        final byte[] keyBytes = jwtSecret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // JWT 토큰 검증
    public boolean verifyToken(String token) {
        try {
            final Claims claims = getBody(token);
            return true;
        } catch (RuntimeException e) {
            if (e instanceof ExpiredJwtException) {
                throw new UnauthorizedException(Error.TOKEN_TIME_EXPIRED_EXCEPTION,
                        Error.TOKEN_TIME_EXPIRED_EXCEPTION.getMessage());
            }
            return false;
        }
    }

    private Claims getBody(final String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // JWT 토큰 내용 확인
    public String getJwtContents(String token) {
        final Claims claims = getBody(token);
        return (String) claims.get("userId");
    }

}
