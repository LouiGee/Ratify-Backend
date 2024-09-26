package com.example.testing22092024.Config;

import io.github.bucket4j.Bucket;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.time.Duration.ofMinutes;

@Configuration
@RequiredArgsConstructor


public class BucketConfig {

    @Bean
    public Bucket createBucket() {

        return Bucket.builder().addLimit(limit -> limit.capacity(3).refillGreedy(1, ofMinutes(1))).build();
    }
}
