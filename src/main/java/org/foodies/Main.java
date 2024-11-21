package org.foodies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}