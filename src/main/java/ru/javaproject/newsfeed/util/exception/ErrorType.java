package ru.javaproject.newsfeed.util.exception;

public enum ErrorType {
    APP_ERROR("Ошибка приложения"),
    DATA_NOT_FOUND("Данные не найдены"),
    DATA_ERROR("Ошибка в данных"),
    VALIDATION_ERROR("Ошибка формата данных");

    private final String errorCode;

    ErrorType(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}