package com.miage.altea.battle_ui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Configuration
public class RestConfiguration {

    @Bean
    RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Arrays.asList((httpRequest, bytes, clientHttpRequestExecution) -> {
            httpRequest.getHeaders().setAcceptLanguageAsLocales(List.of(LocaleContextHolder.getLocale()));
            return  clientHttpRequestExecution.execute(httpRequest, bytes);
        }));
        return restTemplate;
    }
}
