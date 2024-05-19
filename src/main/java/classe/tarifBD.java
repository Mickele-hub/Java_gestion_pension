/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mickele
 */
public class tarifBD {
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
    public static boolean ajouterTarif(Tarif tarif, Connection connection) {
        boolean ajoutReussi = false;
        try {
            // Préparer la requête d'insertion
            String sql = "INSERT INTO TARIF (Num_tarif, Diplome, Categorie, Montant) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            // Remplir les paramètres de la requête
            statement.setString(1, tarif.getNumTarif());
            statement.setString(2, tarif.getDiplome());
            statement.setString(3, tarif.getCategorie());
            statement.setInt(4, tarif.getMontant());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Nouveau tarif insérée avec succès !");
                ajoutReussi = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de l'insertion de la nouvelle tarif dans la base de données !");
        }
        return ajoutReussi;
    }
    public static boolean supprimerTarif(String Num_tarif, Connection connection) {
    boolean suppressionReussie = false;
    try {
        // Préparer la requête de suppression
        String sql = "DELETE FROM TARIF WHERE Num_tarif = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        // Remplir les paramètres de la requête
        statement.setString(1, Num_tarif);
        // Exécuter la requête
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Tarif supprimée avec succès !");
            suppressionReussie = true;
        } else {
            System.out.println("Aucun Tarif correspondante trouvée pour la suppression.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de la suppression du tarif de la base de données !");
    }
    return suppressionReussie;
}
    public static boolean modifierTarif(Tarif tarif, Connection connection) {
    boolean modificationReussie = false;
    try {
        // Préparer la requête de mise à jour
        String sql = "UPDATE TARIF SET Diplome = ?, Categorie = ?, Montant = ? WHERE  Num_tarif = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        // Remplir les paramètres de la requête
        statement.setString(1, tarif.getDiplome());
        statement.setString(2, tarif.getCategorie());
        statement.setInt(3, tarif.getMontant());
        statement.setString(4, tarif.getNumTarif());
        // Exécuter la requête
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Tarif mise à jour avec succès !");
            modificationReussie = true;
        } else {
            System.out.println("Aucun Tarif correspondante trouvée pour la mise à jour.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de la mise à jour du tarif dans la base de données !");
    }
    return modificationReussie;
    }
}
