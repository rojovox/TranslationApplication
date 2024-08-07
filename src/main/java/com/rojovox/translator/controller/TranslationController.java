package com.rojovox.translator.controller;

import com.rojovox.translator.model.TranslationRequest;
import com.rojovox.translator.repository.TranslationRepository;
import com.rojovox.translator.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/translate")
public class TranslationController {

    private final TranslationService translationService;
    private final TranslationRepository translationRepository;

    @Autowired
    public TranslationController(TranslationService translationService, TranslationRepository translationRepository) {
        this.translationService = translationService;
        this.translationRepository = translationRepository;
    }

    @PostMapping
    public CompletableFuture<String> translateText(@RequestParam String text, @RequestParam String targetLang,
                                                   HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();

        return translationService.translateText(text, targetLang)
                .thenApply(translatedText -> {
                    saveTranslationRequest(ipAddress, text, translatedText);
                    return translatedText;
                });
    }

    private void saveTranslationRequest(String ipAddress, String inputText, String translatedText) {
        TranslationRequest translationRequest = new TranslationRequest();
        translationRequest.setIpAddress(ipAddress);
        translationRequest.setInputText(inputText);
        translationRequest.setTranslatedText(translatedText);
        translationRepository.save(translationRequest);
    }
}