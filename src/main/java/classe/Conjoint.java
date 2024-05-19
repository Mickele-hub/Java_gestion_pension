/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

/**
 *
 * @author Mickele
 */
public class Conjoint {
    private String numPension;
    private String nomConjoint;
    private String prenomConjoint;
    private int montant;

    // Constructeur
    public Conjoint(String numPension, String nomConjoint, String prenomConjoint, int montant) {
        this.numPension = numPension;
        this.nomConjoint = nomConjoint;
        this.prenomConjoint = prenomConjoint;
        this.montant = montant;
    }

    // Getters et Setters
    public String getNumPension() {
        return numPension;
    }

    public void setNumPension(String numPension) {
        this.numPension = numPension;
    }

    public String getNomConjoint() {
        return nomConjoint;
    }

    public void setNomConjoint(String nomConjoint) {
        this.nomConjoint = nomConjoint;
    }

    public String getPrenomConjoint() {
        return prenomConjoint;
    }

    public void setPrenomConjoint(String prenomConjoint) {
        this.prenomConjoint = prenomConjoint;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
