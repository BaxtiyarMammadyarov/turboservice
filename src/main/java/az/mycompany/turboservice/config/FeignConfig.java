package az.mycompany.turboservice.config;


import az.mycompany.turboservice.client.*;
import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@EnableFeignClients(clients = {BrandClient.class
        , CityClient.class
        , ContactInfoClient.class
        , FilterClient.class
        , FuelTypeClient.class
        ,ModelClient.class
        ,ProductClient.class
        ,UserClient.class})
public class FeignConfig {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }
}
