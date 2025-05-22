package com.m2i.entity;

import java.time.LocalDateTime;

import com.m2i.model.LoanStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private double montant;
    private double taux;
    private LocalDateTime dateDebut;
    private LocalDateTime dateEcheance;
    private LoanStatus statut;
    
    
	/**
	 * 
	 */
	public Loan() {
		super();
		
		statut = LoanStatus.APPROVED;
		dateDebut = LocalDateTime.now();
		dateEcheance = dateDebut.plusMonths(1);
	}
	
	/**
	 * @return the loanId
	 */
	public Long getLoanId() {
		return loanId;
	}
	/**
	 * @param loanId the loanId to set
	 */
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
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
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}
	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}
	/**
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
	/**
	 * @return the dateDebut
	 */
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}
	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * @return the dateEcheance
	 */
	public LocalDateTime getDateEcheance() {
		return dateEcheance;
	}
	/**
	 * @param dateEcheance the dateEcheance to set
	 */
	public void setDateEcheance(LocalDateTime dateEcheance) {
		this.dateEcheance = dateEcheance;
	}
	/**
	 * @return the statut
	 */
	public LoanStatus getStatut() {
		return statut;
	}
	/**
	 * @param statut the statut to set
	 */
	public void setStatut(LoanStatus statut) {
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", client=" + client + ", montant=" + montant + ", taux=" + taux
				+ ", dateDebut=" + dateDebut + ", dateEcheance=" + dateEcheance + ", statut=" + statut + "]";
	}
}

