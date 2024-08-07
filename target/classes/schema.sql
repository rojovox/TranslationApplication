CREATE TABLE translation_request (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     ip_address VARCHAR(15) NOT NULL,
                                     input_text VARCHAR(255) NOT NULL,
                                     translated_text VARCHAR(255) NOT NULL,
                                     request_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);