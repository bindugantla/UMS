package org.jsp.ums;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetch {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em1 = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager();
		EntityManager em3 = emf.createEntityManager();
		User u1 = em1.find(User.class, 1);
		User u2 = em2.find(User.class, 1);
		User u3 = em3.find(User.class, 1);

	}
}
