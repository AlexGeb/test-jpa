package fr;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.banque.model.Adresse;
import fr.banque.model.Banque;
import fr.banque.model.Client;
import fr.banque.model.LivretA;
import fr.banque.model.Virement;
import fr.brico.model.Article;
import fr.brico.model.BonCommande;
import fr.brico.model.Fournisseur;

public class TestJpa {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestJpa.class);

	public static void main(String[] args) {
		// test();
		tp4();
	}

	private static void tp4() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dta-tp4-jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();

		Banque banque = new Banque();
		banque.setNom("Société Générale");
		em.persist(banque);

		Client client = new Client();
		client.setBanque(banque);
		client.setNom("Dupond");
		client.setPrenom("Jean");
		Adresse adresse = new Adresse();
		adresse.setCodePostal(75000);
		adresse.setNumero(12);
		adresse.setRue("rue de la Paix");
		adresse.setVille("Paris");
		client.setAdresse(adresse);
		em.persist(client);

		LivretA livretA = new LivretA();
		livretA.getClients().add(client);
		livretA.setNumero("4587952");
		livretA.setSolde(1452.458);
		livretA.setTaux(1.2);
		Virement virement = new Virement();
		virement.setBeneficiaire("Jeanne Dupont");
		virement.setCompte(livretA);
		virement.setDate(LocalDateTime.now());
		virement.setMontant(14.12);
		virement.setMotif("week end");
		em.persist(virement);
		livretA.getOperations().add(virement);
		em.persist(livretA);

		
		
		tr.commit();
		em.close();
		emf.close();
	}

	private static void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dta-test-jpa");
		EntityManager em = emf.createEntityManager();

		BonCommande bon = em.find(BonCommande.class, 2);
		if (bon != null) {
			LOGGER.info(bon.getArticles().toString());
		}

		EntityTransaction tr = em.getTransaction();
		tr.begin();

		Article article = new Article();
		article.setDesignation("Truelle");
		article.setId(11);
		article.setRef("B04");
		article.setPrix(15.42);
		article.setFournisseur(em.find(Fournisseur.class, 2));
		em.persist(article);

		tr.commit();

		/*
		 * //Articles TypedQuery<Article> res =
		 * em.createQuery("select a from Article a", Article.class); if (res != null) {
		 * List<Article> articles = res.getResultList(); for (Article a : articles) {
		 * LOGGER.info(a.toString()); } }
		 * 
		 * //Fournisseurs TypedQuery<Fournisseur> resFou =
		 * em.createQuery("select f from Fournisseur f", Fournisseur.class); if (resFou
		 * != null) { List<Fournisseur> fou = resFou.getResultList(); for (Fournisseur f
		 * : fou) { LOGGER.info(f.toString()); } }
		 * 
		 * //Bons de commande TypedQuery<BonCommande> resBon =
		 * em.createQuery("select b from BonCommande b", BonCommande.class); if (resFou
		 * != null) { List<BonCommande> bons = resBon.getResultList(); for (BonCommande
		 * b : bons) { LOGGER.info(b.toString()); } }
		 */

		em.close();
		emf.close();
	}

}
