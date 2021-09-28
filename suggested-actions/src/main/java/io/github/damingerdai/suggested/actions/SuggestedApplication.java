package io.github.damingerdai.suggested.actions;

import io.github.powerbotkit.autoconfigure.EnableBotBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBotBuilder
public class SuggestedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuggestedApplication.class, args);
    }
}
