package com.rojovox.translator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.concurrent.CompletableFuture;

@Service
public class TranslationService {

    private final RestTemplate restTemplate;

    @Value("${rapidapi.key}")
    private String apiKey;

    @Value("${rapidapi.host}")
    private String apiHost;

    public TranslationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CompletableFuture<String> translateText(String text, String targetLang) {
        return CompletableFuture.supplyAsync(() -> {
            String url = "https://google-translate1.p.rapidapi.com/language/translate/v2";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-rapidapi-key", apiKey);
            headers.set("x-rapidapi-host", apiHost);

            String body = String.format("{\"q\": \"%s\", \"target\": \"%s\"}", text, targetLang);
            HttpEntity<String> request = new HttpEntity<>(body, headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return extractTranslatedText(response.getBody());
            } else {
                throw new RuntimeException("Translation failed with status: " + response.getStatusCode());
            }
        });
    }

    private String extractTranslatedText(String responseBody) {

        return responseBody;
    }
}