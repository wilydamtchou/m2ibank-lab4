package com.m2i.model;

public record ApiClientDTO(
    String apiKey,
    String nomApp,
    String secretHash,
    String scopes
) {}

