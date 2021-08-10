package com.example.cacheexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication //Spring Uygulama Bağlamının otomatik yapılandırmasını sağlar
@EnableCaching //Uygulamamızdan rest erişimine açık olan üye bilgilerine her defasında erişiminde cachelenmiş olan verilerden getirecektir.
public class CacheExampleApplication {

    public static void main(String[] args) {

        SpringApplication.run(CacheExampleApplication.class, args);
    }

}
