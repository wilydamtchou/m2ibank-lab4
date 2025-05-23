package com.m2i.dto;

import java.io.Serializable;

public class JSFClientCreateDTO implements Serializable {
	private String nom;
    private String prenom;
    private String email;
    private String telephone;
    
    
	public JSFClientCreateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "JSFClientCreateDTO [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone
				+ "]";
	}
}
