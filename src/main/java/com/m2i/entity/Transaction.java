package com.m2i.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

import com.m2i.model.TransactionStatus;
import com.m2i.model.TransactionType;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "account_src")
    @NotNull(message = "Le compte source est obligatoire")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "account_tgt")
    @NotNull(message = "Le compte cible est obligatoire")
    private Account targetAccount;

    @Positive(message = "Le montant doit être strictement positif")
    private double montant;

    @PastOrPresent(message = "La date ne peut pas être dans le futur")
    @NotNull(message = "La date de la transaction est obligatoire")
    private LocalDateTime dateHeure;

    @NotNull(message = "Le type de transaction est obligatoire")
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @NotNull(message = "Le statut de la transaction est obligatoire")
    @Enumerated(EnumType.STRING)
    private TransactionStatus statut;

    // Constructeur par défaut
    public Transaction() {
        this.dateHeure = LocalDateTime.now();
        this.statut = TransactionStatus.PENDING;
    }

    // Getters & Setters

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(Account targetAccount) {
        this.targetAccount = targetAccount;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public TransactionStatus getStatut() {
        return statut;
    }

    public void setStatut(TransactionStatus statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", sourceAccount=" + sourceAccount + ", targetAccount="
                + targetAccount + ", montant=" + montant + ", dateHeure=" + dateHeure + ", type=" + type + ", statut="
                + statut + "]";
    }
}
