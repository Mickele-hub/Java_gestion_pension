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
public class Payer {
    private String IM;
    private String numTarif;
    private Date datePaiement;

    // Constructeur
    public Payer(String IM, String numTarif, Date datePaiement) {
        this.IM = IM;
        this.numTarif = numTarif;
        this.datePaiement = datePaiement;
    }

    // Getters et Setters
    public String getIM() {
        return IM;
    }

    public void setIM(String IM) {
        this.IM = IM;
    }

    public String getNumTarif() {
        return numTarif;
    }

    public void setNumTarif(String numTarif) {
        this.numTarif = numTarif;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }
}