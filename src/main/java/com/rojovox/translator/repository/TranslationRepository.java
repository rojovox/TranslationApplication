package com.rojovox.translator.repository;

import com.rojovox.translator.model.TranslationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<TranslationRequest, Long> {
}
