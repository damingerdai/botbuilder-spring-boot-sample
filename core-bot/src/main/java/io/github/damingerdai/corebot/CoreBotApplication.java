package io.github.damingerdai.corebot;

import io.github.powerbotkit.autoconfigure.EnableBotBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBotBuilder
public class CoreBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreBotApplication.class, args);
    }
}
