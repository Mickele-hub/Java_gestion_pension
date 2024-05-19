/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;
import java.util.Date;
/**
 *
 * @author Mickele
 */
public class Personne {
    private String IM;
    private String nom;
    private String prenoms;
    private Date datenais;
    private String diplome;
    private String contact;
    private boolean statut;
    private String situation;
    private String nomConjoint;
    private String prenomConjoint;
    
    public Personne(String IM, String nom, String prenoms, Date datenais, String diplome, String contact, boolean statut, String situation, String nomConjoint, String prenomConjoint) {
        this.IM = IM;
        this.nom = nom;
        this.prenoms = prenoms;
        this.datenais = datenais;
        this.diplome = diplome;
        this.contact = contact;
        this.statut = statut;
        this.situation = situation;
        this.nomConjoint = nomConjoint;
        this.prenomConjoint = prenomConjoint;
    }
    public String getIM() {
        return IM;
    }

    public void setIM(String IM) {
        this.IM = IM;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public Date getDatenais() {
        return datenais;
    }

    public void setDatenais(Date datenais) {
        this.datenais = datenais;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
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
}
