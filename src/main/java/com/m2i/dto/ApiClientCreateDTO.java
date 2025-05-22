package com.m2i.dto;

public record ApiClientCreateDTO(
    String apiKey,
    String nomApp,
    String secretHash,
    String scopes
) {}
