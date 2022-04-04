package cn.maoookai.dami3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DamiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DamiApplication.class, args);
    }
}
