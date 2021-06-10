package az.mycompany.turboservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

@EnableFeignClients
public class TurboserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurboserviceApplication.class, args);
    }

}
