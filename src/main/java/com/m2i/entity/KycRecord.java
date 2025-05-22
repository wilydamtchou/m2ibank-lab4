package com.m2i.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.m2i.model.KycStatus;

@Entity
public class KycRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kycId;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private LocalDateTime dateSoumission;
    private KycStatus statut;
    
	/**
	 * 
	 */
	public KycRecord() {
		super();
		
		statut = KycStatus.ENABLED;
		dateSoumission = LocalDateTime.now();
	}
	/**
	 * @return the kycId
	 */
	public Long getKycId() {
		return kycId;
	}
	/**
	 * @param kycId the kycId to set
	 */
	public void setKycId(Long kycId) {
		this.kycId = kycId;
	}
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/**
	 * @return the dateSoumission
	 */
	public LocalDateTime getDateSoumission() {
		return dateSoumission;
	}
	/**
	 * @param dateSoumission the dateSoumission to set
	 */
	public void setDateSoumission(LocalDateTime dateSoumission) {
		this.dateSoumission = dateSoumission;
	}
	/**
	 * @return the statut
	 */
	public KycStatus getStatut() {
		return statut;
	}
	/**
	 * @param statut the statut to set
	 */
	public void setStatut(KycStatus statut) {
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "KycRecord [kycId=" + kycId + ", client=" + client + ", dateSoumission=" + dateSoumission + ", statut="
				+ statut + "]";
	}   
}
