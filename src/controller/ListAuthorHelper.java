package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListAuthor;

public class ListAuthorHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistfile");

	public void insertAuthor(ListAuthor li) {
		//
		String authorEntered = li.getAuthorName();
		System.out.println("test inside lah.insertAuthor :"+authorEntered);
		
		List<ListAuthor> matchAuthors = searchForAuthorByName(authorEntered);
		if(matchAuthors.isEmpty()) {//if no match, add new author to the database then get that entry from the database so we know the id.
			//insert if not already existing
			EntityManager em=emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(li);
			em.getTransaction().commit();
			em.close();
		}
	}
	
	public List<ListAuthor> showAllAuthors(){
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<ListAuthor> allAuthors	= em.createQuery("SELECT i FROM ListAuthor i").getResultList();
		return allAuthors;
	}
	
	public	void	deleteAuthor(ListAuthor	toDelete)	{
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListAuthor>	typedQuery	= em.createQuery("select li	from ListAuthor	li	where li.authorName	=	:selectedAuthorName",	ListAuthor.class);
		
		//Substitute	parameter	with	actual	data	from	the	toDelete	Author
		typedQuery.setParameter("selectedAuthorName",	toDelete.getAuthorName());
		
		//we only want one	result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a	new	listAuthor
		//ADDED check if any result
		
		try 
			{
			ListAuthor	result	=	typedQuery.getSingleResult();
		
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
	public ListAuthor searchForAuthorById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListAuthor found = em.find(ListAuthor.class, idToEdit);
		em.close();
		return	found;	
	}
	
	public void updateAuthor(ListAuthor toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();	
	}
	
	public List<ListAuthor> searchForAuthorByName(String authorName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListAuthor>	typedQuery	=	em.createQuery("select	li	from ListAuthor	li	where	li.authorName	=	:selectedAuthorName",	ListAuthor.class);
		typedQuery.setParameter("selectedAuthorName", authorName);
		List<ListAuthor>	foundAuthors	=	typedQuery.getResultList();
		em.close();
		return	foundAuthors;
	}
	
	public void cleanUp(){
	emfactory.close();
	}
}
