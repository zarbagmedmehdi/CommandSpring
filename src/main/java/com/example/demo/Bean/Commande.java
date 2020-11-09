package com.example.demo.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Commande {
   @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private double montantTotal;
    private double montantPayeCheque;
    private double montantPayeEspace;
    private Date  dateCreation ;
    private Date dernierPaiement;
    private Boolean archived;


    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDernierPaiement() {
        return dernierPaiement;
    }

    public void setDernierPaiement(Date dernierPaiement) {
        this.dernierPaiement = dernierPaiement;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Commande(String reference, double montantTotal, double montantPayeCheque, double montantPayeEspace, Date dateCreation, Date dernierPaiement, Boolean archived) {
        this.reference = reference;
        this.montantTotal = montantTotal;
        this.montantPayeCheque = montantPayeCheque;
        this.montantPayeEspace = montantPayeEspace;
        this.dateCreation = dateCreation;
        this.dernierPaiement = dernierPaiement;
        this.archived = archived;
    }

    public Commande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public double getMontantPayeCheque() {
        return montantPayeCheque;
    }

    public void setMontantPayeCheque(double montantPayeCheque) {
        this.montantPayeCheque = montantPayeCheque;
    }

    public double getMontantPayeEspace() {
        return montantPayeEspace;
    }

    public void setMontantPayeEspace(double montantPayeEspace) {
        this.montantPayeEspace = montantPayeEspace;
    }
    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", montantTotal=" + montantTotal +
                ", montantPayeCheque=" + montantPayeCheque +
                ", montantPayeEspace=" + montantPayeEspace +
                ", dateCreation=" + dateCreation +
                ", dernierPaiement=" + dernierPaiement +
                ", archived=" + archived +
                '}';
    }

}
