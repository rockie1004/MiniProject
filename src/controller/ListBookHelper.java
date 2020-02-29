package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListBook;

public class ListBookHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistfile");
	
	public void insertBook(ListBook li) {
		EntityManager em=emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public	List<ListBook>	showAllBooks(){
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<ListBook>	allBooks = em.createQuery("SELECT i FROM ListBook i").getResultList();
		return	allBooks;
		}
	
	public void deleteBook(ListBook	toDelete)	{
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListBook>	typedQuery	=	em.createQuery("select	li	from ListBook	li	where	li.author	=	:selectedAuthor	and	li.title	=	:selectedTitle",	ListBook.class);
		
		//Substitute	parameter	with	actual	data	from	the	toDelete	Book
		typedQuery.setParameter("selectedAuthor",	toDelete.getAuthor());
		typedQuery.setParameter("selectedTitle",	toDelete.getTitle());
		
		//we	only	want	one	result
		typedQuery.setMaxResults(1);
		
		//get	the	result	and	save	it	into	a	new	list	Book
		//ADDED check if any result
		
		try 
			{
			ListBook	result	=	typedQuery.getSingleResult();
		
			//remove	it
			em.remove(result);
			em.getTransaction().commit();
			em.close();
			}
		catch (NoResultException none) 
			{
			System.out.println("No matching entry was found.");
			return;
		}
	
	}
	public ListBook searchForBookById(int idToEdit) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		ListBook	found	=	em.find(ListBook.class,	idToEdit);
		em.close();
		return	found;	
	}
	public void updateBook(ListBook toEdit) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();	
	}
	
	public List<ListBook> searchForBookByTitle(String title) {
		EntityManager em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListBook>	typedQuery	=	em.createQuery("select	li	from ListBook	li	where	li.title	=	:selectedTitle",	ListBook.class);
		typedQuery.setParameter("selectedTitle",	title);
		List<ListBook>	foundBooks	=	typedQuery.getResultList();
		em.close();
		return	foundBooks;
	}
	
	public	void	cleanUp(){
	emfactory.close();
	}
}
