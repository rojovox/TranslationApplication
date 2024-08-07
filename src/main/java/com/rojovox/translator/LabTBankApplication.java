package com.rojovox.translator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.rojovox.translator.config.ApiKeyHolder;

import java.util.Scanner;

@SpringBootApplication
public class LabTBankApplication {

    public static void main(String[] args) {

        SpringApplication.run(LabTBankApplication.class, args);

        // Запрос ключа API при запуске
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your API key: ");
        String apiKey = scanner.nextLine();
        ApiKeyHolder.setApiKey(apiKey);
    }

}
