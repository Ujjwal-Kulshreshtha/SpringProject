package com.backendev.banking_app.exception;

import java.time.LocalDateTime;

public record ErrorDetail(LocalDateTime timStamp,
                          String message,
                          String details,
                          String errorCode) {
}
