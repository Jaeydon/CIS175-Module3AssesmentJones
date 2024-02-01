/**
 * @author Jaeydon Jones - jmjones31@dmacc.edu
 * CIS175 22895 - Java II
 * {#/#/2024}
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AdventurerInventory;

public class InventoryHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("adventurerbag");
	
		public void addInventory(AdventurerInventory aInv) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(aInv);
			em.getTransaction().commit();
			em.close();
		}
		
		public void editInventory(AdventurerInventory toEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}
		
		public List<AdventurerInventory> searchForItemCategory(String itemCategory) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<AdventurerInventory> typedQuery = em.createQuery
	("SELECT ai FROM AdventurerInventory ai WHERE ai.itemCategory = :selectedItemcat", AdventurerInventory.class);
			
			typedQuery.setParameter("selectedMake", itemCategory);
			List<AdventurerInventory> foundInventory = typedQuery.getResultList();
			em.close();
			
			return foundInventory;
		}
		
		public List<AdventurerInventory> searchForItem(String item) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<AdventurerInventory> typedQuery = em.createQuery
	("SELECT ai FROM AdventurerInventory ai WHERE ai.item = :selectedItem",AdventurerInventory.class);
			
			typedQuery.setParameter("selectedModel", item);
			List<AdventurerInventory> foundInventory = typedQuery.getResultList();
			em.close();
			
			return foundInventory;
		}
		
		public AdventurerInventory searchForGold(int goldToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			AdventurerInventory foundID = em.find(AdventurerInventory.class, goldToEdit);			
			em.close();
			
			return foundID;
		}
		
		public void deleteInventory(AdventurerInventory toRemove) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			
			// have to make sure to match class instance variable names in statement
			TypedQuery<AdventurerInventory> typedQuery = em.createQuery
	("SELECT ai FROM AdventurerInventory ai WHERE ai.itemCategory = :selectedItemcat AND ai.item = :selectedItem", AdventurerInventory.class);
			
			typedQuery.setParameter("selectedItemCategory", toRemove.getItemCategory());
			typedQuery.setParameter("selectedItem", toRemove.getItem());
			typedQuery.setMaxResults(1);
			
			AdventurerInventory searchResult = typedQuery.getSingleResult();
			
			em.remove(searchResult);
			em.getTransaction().commit();
			em.close();
		}

	public List<AdventurerInventory> showAllInventory() {
		// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			
			@SuppressWarnings("unchecked")
			List<AdventurerInventory> allInventory =
					em.createQuery("SELECT i FROM AdventurerInventory i").getResultList();
			
			em.close();
			
		return allInventory;
	}
	
		public void closeIH() {
		// TODO Auto-generated method stub
		emfactory.close();
	}



}