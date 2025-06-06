package com.github.yuriserka.rocketseatorders.core.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BusinessException extends RuntimeException {
    final String message;
}
