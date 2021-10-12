package io.github.damingerdai.qnamaker;

import io.github.powerbotkit.autoconfigure.EnableBotBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBotBuilder
public class QnamakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QnamakerApplication.class, args);
    }
}
