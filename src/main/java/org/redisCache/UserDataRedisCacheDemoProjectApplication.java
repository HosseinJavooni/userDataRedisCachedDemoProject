package org.redisCache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.redisCache")
public class UserDataRedisCacheDemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserDataRedisCacheDemoProjectApplication.class, args);
    }

}
