package com.example.practicing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personne")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = true)
    private int nbrVote;

    @Column(nullable=false)
    private boolean hasVoted;

    public Personne() {
    }

    public Personne(String nom, String prenom, int nbrVote, boolean hasVoted) {
        this.nom = nom;
        this.prenom = prenom;
        this.nbrVote = nbrVote;
        this.hasVoted = hasVoted;
    }

    /**
     * @return Long return the idClient
     */
    public Long getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return String return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return BigInteger return the number of vote
     */
    public int getNbrVote() {
        return nbrVote;
    }

    /**
     * @param nbrVote the number of Vote to set
     */
    public void setNbrVote(int nbrVote) {
        this.nbrVote = nbrVote;
    }


    /**
     * @return boolean return the hasVoted
     */
    public boolean isHasVoted() {
        return hasVoted;
    }

    /**
     * @param hasVoted the hasVoted to set
     */
    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

}
