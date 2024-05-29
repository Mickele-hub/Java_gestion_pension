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
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mickele
 */
public class bd {
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
public static boolean ajouterPersonne(Personne personne, Connection connection) {
    boolean ajoutReussi = false;
    try {
        // Préparer la requête d'insertion pour la table Personne
        String sqlPersonne = "INSERT INTO PERSONNE (IM, Nom, Prenoms, datenais, diplome, Contact, statut, situation, NomConjoint, PrenomConjoint) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statementPersonne = connection.prepareStatement(sqlPersonne, Statement.RETURN_GENERATED_KEYS);
        // Remplir les paramètres de la requête pour la table Personne
        statementPersonne.setString(1, personne.getIM());
        statementPersonne.setString(2, personne.getNom());
        statementPersonne.setString(3, personne.getPrenoms());
        statementPersonne.setDate(4, new java.sql.Date(personne.getDatenais().getTime())); // Conversion de java.util.Date à java.sql.Date
        statementPersonne.setString(5, personne.getDiplome());
        statementPersonne.setString(6, personne.getContact());
        statementPersonne.setBoolean(7, personne.isStatut());
        statementPersonne.setString(8, personne.getSituation());
        statementPersonne.setString(9, personne.getNomConjoint());
        statementPersonne.setString(10, personne.getPrenomConjoint());

        // Exécuter la requête pour la table Personne
        int rowsInsertedPersonne = statementPersonne.executeUpdate();

        // Si l'insertion dans la table Personne a réussi
        if (rowsInsertedPersonne > 0) {
            System.out.println("Nouvelle personne insérée avec succès !");

            // Récupérer l'IM généré pour la personne insérée
            ResultSet generatedKeys = statementPersonne.getGeneratedKeys();
            String IM = null;
            if (generatedKeys.next()) {
                IM = generatedKeys.getString(1);
            }

            // Si la personne n'est ni divorcée ni veuve, ajouter un conjoint
            if (!personne.getSituation().equals("divorcé(e)") && !personne.getSituation().equals("veuf(e)")) {
                // Générer le numéro de pension aléatoire
                String numPension = generateRandomNumPension();
                // Préparer la requête d'insertion pour la table Conjoint
                String sqlConjoint = "INSERT INTO CONJOINT (numPension, nomConjoint, prenomConjoint, IM, montant) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statementConjoint = connection.prepareStatement(sqlConjoint);
                // Remplir les paramètres de la requête pour la table Conjoint
                statementConjoint.setString(1, numPension);
                statementConjoint.setString(2, personne.getNomConjoint());
                statementConjoint.setString(3, personne.getPrenomConjoint());
                statementConjoint.setString(4, IM);
                statementConjoint.setInt(5, 0);

                // Exécuter la requête pour la table Conjoint
                int rowsInsertedConjoint = statementConjoint.executeUpdate();

                // Si l'insertion dans la table Conjoint a réussi
                if (rowsInsertedConjoint > 0) {
                    System.out.println("Nouveau conjoint inséré avec succès !");
                    ajoutReussi = true;
                }
            } else {
                ajoutReussi = true; // Marquer l'ajout comme réussi même si aucun conjoint n'est ajouté
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de l'insertion d'une nouvelle personne dans la base de données !");
    }
    return ajoutReussi;
}



// Méthode pour générer un numéro de pension aléatoire
private static String generateRandomNumPension() {
    // Générer un nombre aléatoire entre 100000 et 999999
    int num = (int) (Math.random() * 900000) + 100000;
    return String.valueOf(num);
}

public static boolean supprimerPersonne(String IM, Connection connection) {
    boolean suppressionReussie = false;
    try {
        // Commencer une transaction
        connection.setAutoCommit(false);

        // Supprimer les enregistrements dépendants dans la table CONJOINT
        String sqlConjoint = "DELETE FROM CONJOINT WHERE IM = ?";
        PreparedStatement statementConjoint = connection.prepareStatement(sqlConjoint);
        statementConjoint.setString(1, IM);
        statementConjoint.executeUpdate();

        // Supprimer la personne dans la table PERSONNE
        String sqlPersonne = "DELETE FROM PERSONNE WHERE IM = ?";
        PreparedStatement statementPersonne = connection.prepareStatement(sqlPersonne);
        statementPersonne.setString(1, IM);
        int rowsDeleted = statementPersonne.executeUpdate();
        
        if (rowsDeleted > 0) {
            System.out.println("Personne supprimée avec succès !");
            suppressionReussie = true;
            connection.commit();
        } else {
            System.out.println("Aucune personne correspondante trouvée pour la suppression.");
            connection.rollback();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de la suppression de la personne de la base de données !");
        try {
            connection.rollback();
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
    } finally {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException autoCommitEx) {
            autoCommitEx.printStackTrace();
        }
    }
    return suppressionReussie;
}

    public static boolean modifierPersonne(Personne personne, Connection connection) {
    boolean modificationReussie = false;
    try {
        // Préparer la requête de mise à jour pour la table Personne
        String sqlPersonne = "UPDATE PERSONNE SET Nom = ?, Prenoms = ?, datenais = ?, diplome = ?, Contact = ?, statut = ?, situation = ?, NomConjoint = ?, PrenomConjoint = ? WHERE IM = ?";
        PreparedStatement statementPersonne = connection.prepareStatement(sqlPersonne);
        // Remplir les paramètres de la requête pour la table Personne
        statementPersonne.setString(1, personne.getNom());
        statementPersonne.setString(2, personne.getPrenoms());
        statementPersonne.setDate(3, new java.sql.Date(personne.getDatenais().getTime())); // Conversion de java.util.Date à java.sql.Date
        statementPersonne.setString(4, personne.getDiplome());
        statementPersonne.setString(5, personne.getContact());
        statementPersonne.setBoolean(6, personne.isStatut());
        statementPersonne.setString(7, personne.getSituation());
        statementPersonne.setString(8, personne.getNomConjoint());
        statementPersonne.setString(9, personne.getPrenomConjoint());
        statementPersonne.setString(10, personne.getIM());

        // Exécuter la requête pour la table Personne
        int rowsUpdatedPersonne = statementPersonne.executeUpdate();

        // Si la mise à jour dans la table Personne a réussi
        if (rowsUpdatedPersonne > 0) {
            System.out.println("Personne mise à jour avec succès !");
            // Si la personne n'est ni divorcée ni veuve, mettre à jour le conjoint
            if (!personne.getSituation().equals("divorcé(e)") && !personne.getSituation().equals("veuf(e)")) {
                // Préparer la requête de mise à jour pour la table Conjoint
                String sqlConjoint = "UPDATE CONJOINT SET nomConjoint = ?, prenomConjoint = ? WHERE numPension = (SELECT numPension FROM CONJOINT WHERE nomConjoint = ? AND prenomConjoint = ?)";
                PreparedStatement statementConjoint = connection.prepareStatement(sqlConjoint);
                // Remplir les paramètres de la requête pour la table Conjoint
                statementConjoint.setString(1, personne.getNomConjoint());
                statementConjoint.setString(2, personne.getPrenomConjoint());
                statementConjoint.setString(3, personne.getNomConjoint());
                statementConjoint.setString(4, personne.getPrenomConjoint());

                // Exécuter la requête pour la table Conjoint
                int rowsUpdatedConjoint = statementConjoint.executeUpdate();

                // Si la mise à jour dans la table Conjoint a réussi
                if (rowsUpdatedConjoint > 0) {
                    System.out.println("Conjoint mis à jour avec succès !");
                    modificationReussie = true;
                }
            } else {
                modificationReussie = true; // Marquer la modification comme réussie même si aucun conjoint n'est modifié
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de la mise à jour de la personne dans la base de données !");
    }
    return modificationReussie;
}

  
}
