package io.github.damingerdai.welcomebot;

import io.github.powerbotkit.autoconfigure.EnableBotBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBotBuilder
public class WelcomeBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(WelcomeBotApplication.class, args);
    }
}
