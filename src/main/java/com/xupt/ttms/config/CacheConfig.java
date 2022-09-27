package com.xupt.ttms.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
public class CacheConfig {
    @Bean("movieKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "movie_" + method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }

    @Bean("ticketKeyGenerator")
    public KeyGenerator keyGenerator1() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "ticket_" + method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }

    @Bean("videoKeyGenerator")
    public KeyGenerator keyGenerator2() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "video_" + method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }

    @Bean("planKeyGenerator")
    public KeyGenerator keyGenerator3() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "plan_" + method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }

    @Bean("orderKeyGenerator")
    public KeyGenerator keyGenerator4() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "order_" + method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }

    @Bean("myLikeKeyGenerator")
    public KeyGenerator keyGenerator5() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "myLike_" + method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }

    @Bean("hallKeyGenerator")
    public KeyGenerator keyGenerator8() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "hall_" + method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }

    @Bean("seatKeyGenerator")
    public KeyGenerator keyGenerator9() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "seat_" + method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }
}
