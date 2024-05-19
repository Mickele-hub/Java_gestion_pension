/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author Mickele
 */
public class payerBD {
     public static Connection getConnection(String url, String utilisateur, String motDePasse) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.println("Connexion à la base de données PostgreSQL réussie !");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la connexion à la base de données PostgreSQL !");
        }
        return connection;
    }
    public static boolean ajouterPayement(Payer payer, Connection connection) {
    boolean ajoutReussi = false;
    try {
        // Récupération du diplôme de la personne sélectionnée
        String diplome = null;
        String im = payer.getIM();
        String sqlDiplome = "SELECT Diplome FROM PERSONNE WHERE IM = ?";
        PreparedStatement statementDiplome = connection.prepareStatement(sqlDiplome);
        statementDiplome.setString(1, im);
        ResultSet resultSetDiplome = statementDiplome.executeQuery();
        if(resultSetDiplome.next()) {
            diplome = resultSetDiplome.getString("Diplome");
        } else {
            // Gérer le cas où aucun diplôme n'est trouvé
            System.err.println("Aucun diplôme trouvé pour cet IM.");
            return false;
        }

        // Récupération du numéro de tarif en fonction du diplôme de la personne
        String numTarif = null;
        String sqlNumTarif = "SELECT Num_tarif FROM TARIF WHERE Diplome = ?";
        PreparedStatement statementNumTarif = connection.prepareStatement(sqlNumTarif);
        statementNumTarif.setString(1, diplome);
        ResultSet resultSetNumTarif = statementNumTarif.executeQuery();
        if(resultSetNumTarif.next()) {
            numTarif = resultSetNumTarif.getString("Num_tarif");
        } else {
            // Gérer le cas où aucun numéro de tarif n'est trouvé
            System.err.println("Aucun numéro de tarif trouvé pour ce diplôme.");
            return false;
        }

        // Préparer la requête d'insertion
        String sql = "INSERT INTO PAYER (IM, Num_tarif, date_paiement) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        // Remplir les paramètres de la requête
        statement.setString(1, payer.getIM());
        statement.setString(2, numTarif);
        statement.setDate(3, new java.sql.Date(payer.getDatePaiement().getTime()));

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Nouveau paiement inséré avec succès !");
            ajoutReussi = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de l'insertion du nouveau paiement dans la base de donnée");
                
    }
         return ajoutReussi;
    }
    public static boolean supprimerPayer(Date datePaiement, Connection connection) {
    boolean suppressionReussie = false;
    try {
        // Préparer la requête de suppression
        String sql = "DELETE FROM PAYER WHERE date_paiement = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        // Remplir les paramètres de la requête
        statement.setDate(1, new java.sql.Date(datePaiement.getTime()));
        // Exécuter la requête
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Payement supprimée avec succès !");
            suppressionReussie = true;
        } else {
            System.out.println("Aucun payement correspondante trouvée pour la suppression.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de la suppression du payement de la base de données !");
    }
    return suppressionReussie;
}
   public static boolean modifierPayement(Payer payer, Connection connection) {
    boolean modificationReussie = false;
    try {
        // Récupération du diplôme de la personne sélectionnée
        String diplome = null;
        String im = payer.getIM();
        String sqlDiplome = "SELECT Diplome FROM PERSONNE WHERE IM = ?";
        PreparedStatement statementDiplome = connection.prepareStatement(sqlDiplome);
        statementDiplome.setString(1, im);
        ResultSet resultSetDiplome = statementDiplome.executeQuery();
        if(resultSetDiplome.next()) {
            diplome = resultSetDiplome.getString("Diplome");
        } else {
            // Gérer le cas où aucun diplôme n'est trouvé
            System.err.println("Aucun diplôme trouvé pour cet IM.");
            return false;
        }

        // Récupération du numéro de tarif en fonction du diplôme de la personne
        String numTarif = null;
        String sqlNumTarif = "SELECT Num_tarif FROM TARIF WHERE Diplome = ?";
        PreparedStatement statementNumTarif = connection.prepareStatement(sqlNumTarif);
        statementNumTarif.setString(1, diplome);
        ResultSet resultSetNumTarif = statementNumTarif.executeQuery();
        if(resultSetNumTarif.next()) {
            numTarif = resultSetNumTarif.getString("Num_tarif");
        } else {
            // Gérer le cas où aucun numéro de tarif n'est trouvé
            System.err.println("Aucun numéro de tarif trouvé pour ce diplôme.");
            return false;
        }

        // Préparer la requête de mise à jour
        String sql = "UPDATE PAYER SET Num_tarif = ?, date_paiement = ? WHERE IM = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        // Remplir les paramètres de la requête
        statement.setString(1, numTarif);
        statement.setDate(2, new java.sql.Date(payer.getDatePaiement().getTime()));
        statement.setString(3, im);
        // Exécuter la requête
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Paiement mis à jour avec succès !");
            modificationReussie = true;
        } else {
            System.out.println("Aucun paiement correspondant trouvé pour la mise à jour.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de la mise à jour du paiement dans la base de données !");
    }
    return modificationReussie;
}

}
