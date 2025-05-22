package com.m2i.entity;

import jakarta.persistence.*;

@Entity
public class ApiClient {

    @Id
    private String apiKey;

    private String nomApp;
    private String secretHash;
    private String scopes;
    
	/**
	 * 
	 */
	public ApiClient() {
		super();
	}
	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}
	/**
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	/**
	 * @return the nomApp
	 */
	public String getNomApp() {
		return nomApp;
	}
	/**
	 * @param nomApp the nomApp to set
	 */
	public void setNomApp(String nomApp) {
		this.nomApp = nomApp;
	}
	/**
	 * @return the secretHash
	 */
	public String getSecretHash() {
		return secretHash;
	}
	/**
	 * @param secretHash the secretHash to set
	 */
	public void setSecretHash(String secretHash) {
		this.secretHash = secretHash;
	}
	/**
	 * @return the scopes
	 */
	public String getScopes() {
		return scopes;
	}
	/**
	 * @param scopes the scopes to set
	 */
	public void setScopes(String scopes) {
		this.scopes = scopes;
	}
	@Override
	public String toString() {
		return "ApiClient [apiKey=" + apiKey + ", nomApp=" + nomApp + ", secretHash=" + secretHash + ", scopes="
				+ scopes + "]";
	}
}

