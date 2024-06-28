package dev.profitsoft.jfd.gatewaysample.gateway.repository;

import dev.profitsoft.jfd.gatewaysample.gateway.auth.dto.UserInfo;
import dev.profitsoft.jfd.gatewaysample.gateway.data.UserSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

@Repository
@RequiredArgsConstructor
public class UserSessionRepository {

    private final R2dbcEntityTemplate entityTemplate;

    public Mono<UserSession> createSession(UserInfo userInfo, Instant expiresAt) {
        UserSession userSession = UserSession.builder()
                .id(UUID.randomUUID().toString())
                .email(userInfo.getEmail())
                .name(userInfo.getName())
                .expiresAt(expiresAt)
                .build();

        return entityTemplate.insert(userSession);
    }

    public Mono<UserSession> findById(String id) {
        return entityTemplate.selectOne(
                query(where("id").is(id)), UserSession.class);
    }
}
