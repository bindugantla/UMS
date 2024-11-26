package org.jsp.ums;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("select option");
			System.out.println("1) Login");
			System.out.println("2) Create Account");
			System.out.println("3) DeleteById");
			System.out.println("4) SelectAll");
			System.out.println("5) exit");
			int choice = s.nextInt();
			switch (choice) {
			case 1:
				login();
				break;
			case 2:
				insertUser();
				break;
			case 3:
				deleteById();
				break;
			case 4:
				selectAll();
				break;
			case 5:
				System.out.println("thank u for using my apllication");
				break;

			default:
				System.err.println("Invalid choice....");
				break;
			}
		}
	}

	static void login() {
		System.out.print("enter userName : ");
		String username = s.next();
		System.out.print("enter password : ");
		String password = s.next();

		Query q = em.createQuery("select u from User u where u.username=:un and u.password=:pwd");
		q.setParameter("un", username);
		q.setParameter("pwd", password);
		User user = (User) q.getSingleResult();
		System.out.println(user);

	}

	static void insertUser() {

		System.out.print("enter name : ");
		String name = s.next();
		System.out.print("enter userName : ");
		String username = s.next();
		System.out.print("enter email : ");
		String email = s.next();
		System.out.print("enter phone : ");
		long phone = s.nextLong();
		System.out.print("enter password : ");
		String password = s.next();

		User u = new User(0, name, username, email, phone, password);
		EntityTransaction et = em.getTransaction();

		et.begin();
		User user= em.merge(u);
		et.commit();
		System.out.println(user);
		System.out.println(" User Inserted Successfully.....");
	}

	static void deleteById() {
		System.out.println("enter user ID to delete :");
		int id = s.nextInt();
		User u = em.find(User.class, id);

		if (u != null) // if id is not present it shows null by using find method.
		{
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(u);
			et.commit();
		}
		else 
		{
			System.out.println("Invalid User Id ...");
		}
	}
	static void selectAll(){
		Query q = em.createQuery("from User");
		List <User> li = q.getResultList();
		for(User u:li)
		{
			System.out.println(u);
		}
		
	}
}
