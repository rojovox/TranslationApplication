# Translation Application

## Описание

Веб-приложение на Java с использованием Spring Boot, 
которое переводит текст с одного языка на другой 
с использованием Google Translate API через RapidAPI. 
Приложение поддерживает асинхронный перевод и сохраняет информацию 
о запросах в базе данных.

## Требования

- Java 17 или выше
- Maven
- Spring Boot
- PostgreSQL (или другая реляционная база данных)
- RapidAPI аккаунт с ключом API для Google Translate API

## Использование

1.	Введите ключ API

    При первом запуске приложение запросит ключ API для Google Translate API. 
    Введите ваш ключ, который вы получили через RapidAPI.

2.	Перевод текста. 

    Отправьте запрос на перевод
    Используйте Postman или другой инструмент для тестирования API, чтобы отправить POST-запрос:

    URL: http://localhost:8080/translate
    Метод: POST
    Параметры:
    text: Текст, который нужно перевести (например, Hello world)
    targetLang: Целевой язык (например, ru)

Пример запроса:

    POST /translate
    Content-Type: application/x-www-form-urlencoded

    text=Hello%20world&targetLang=ru
