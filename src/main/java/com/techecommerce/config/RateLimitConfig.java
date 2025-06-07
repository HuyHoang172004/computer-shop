package com.techecommerce.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RateLimitConfig {

    @Value("${app.rate-limit.requests-per-second}")
    private int requestsPerSecond;

    @Value("${app.rate-limit.burst}")
    private int burst;

    @Bean
    public Bucket createNewBucket() {
        Bandwidth limit = Bandwidth.simple(requestsPerSecond, Duration.ofSeconds(1))
                .withInitialTokens(burst);
        return Bucket4j.builder()
                .addLimit(limit)
                .build();
    }
} 