package com.ctsi.sddx.bestpay.sdk.config;

import com.ctsi.sddx.bestpay.sdk.BestPay;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(prefix = "best-pay", name = "enabled", matchIfMissing = false)
@EnableConfigurationProperties({BestPayConfiguration.class})
public class BestPayAutoConfiguration {


    @Bean
    public BestPay bestPay(ObjectMapper objectMapper,
                           RestTemplateBuilder restTemplateBuilder,
                           BestPayConfiguration bestPayConfiguration) {
        return new BestPay(objectMapper, restTemplateBuilder, bestPayConfiguration);
    }


}
