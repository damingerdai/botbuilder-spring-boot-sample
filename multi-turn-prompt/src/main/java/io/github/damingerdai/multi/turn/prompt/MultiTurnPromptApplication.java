package io.github.damingerdai.multi.turn.prompt;

import io.github.powerbotkit.autoconfigure.EnableBotBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBotBuilder
public class MultiTurnPromptApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiTurnPromptApplication.class, args);
    }
}
