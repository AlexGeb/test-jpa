package fr.brico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.brico.model.Article;
import fr.brico.model.BonCommande;
import fr.brico.model.Fournisseur;

public class TestJpa {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestJpa.class);

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dta-test-jpa");
		EntityManager em = emf.createEntityManager();
		
		BonCommande bon = em.find(BonCommande.class, 1);
		if(bon!=null) {
			LOGGER.info(bon.getArticles().toString());
		}
		
		/*
		//Articles
		TypedQuery<Article> res = em.createQuery("select a from Article a", Article.class);
		if (res != null) {
			List<Article> articles = res.getResultList();
			for (Article a : articles) {
				LOGGER.info(a.toString());
			}
		}
		
		//Fournisseurs
		TypedQuery<Fournisseur> resFou = em.createQuery("select f from Fournisseur f", Fournisseur.class);
		if (resFou != null) {
			List<Fournisseur> fou = resFou.getResultList();
			for (Fournisseur f : fou) {
				LOGGER.info(f.toString());
			}
		}
		
		//Bons de commande
		TypedQuery<BonCommande> resBon = em.createQuery("select b from BonCommande b", BonCommande.class);
		if (resFou != null) {
			List<BonCommande> bons = resBon.getResultList();
			for (BonCommande b : bons) {
				LOGGER.info(b.toString());
			}
		}
		*/

		em.close();
		emf.close();
	}

}
