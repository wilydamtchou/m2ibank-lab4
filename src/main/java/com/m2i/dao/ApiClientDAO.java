package com.m2i.dao;

import com.m2i.entity.ApiClient;
import java.util.List;

public interface ApiClientDAO {
    void create(ApiClient apiClient);
    ApiClient findByApiKey(String apiKey);
    List<ApiClient> findAll();
    void update(ApiClient apiClient);
    void delete(ApiClient apiClient);
}

