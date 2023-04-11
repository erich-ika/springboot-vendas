package io.github.erichika.rest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class ApiErrors {

    @Getter
    private final List<String> errors;

    public ApiErrors(String mensagem) {
        this.errors = Collections.singletonList(mensagem);
    }
}
