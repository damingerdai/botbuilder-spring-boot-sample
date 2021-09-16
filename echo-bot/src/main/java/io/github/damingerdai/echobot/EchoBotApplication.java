package io.github.damingerdai.echobot;

import io.github.powerbotkit.autoconfigure.EnableBotBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBotBuilder
public class EchoBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(EchoBotApplication.class, args);
    }

}
