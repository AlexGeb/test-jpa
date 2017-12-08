package fr.brico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.brico.model.Article;

public class TestJpa {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestJpa.class);

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dta-test-jpa");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Article> res = em.createQuery("select a from Article a", Article.class);
		if (res != null) {
			List<Article> articles = res.getResultList();
			for (Article a : articles) {
				LOGGER.info(a.toString());
			}
		}
		em.close();
		emf.close();
	}

}
