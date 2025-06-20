package com.github.yuriserka.rocketseatinvoices.core.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BusinessException extends RuntimeException {
    final String message;
}
