package io.github.damingerdai.using.cards;

import io.github.powerbotkit.autoconfigure.EnableBotBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBotBuilder
public class UsingCardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsingCardsApplication.class, args);
    }
}