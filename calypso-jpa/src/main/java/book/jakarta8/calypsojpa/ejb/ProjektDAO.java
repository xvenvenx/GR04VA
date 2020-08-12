// needed packages and imports

package book.jakarta8.calypsojpa.ejb;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import book.jakarta8.calypsojpa.jpa.Projekt;


@Singleton
public class ProjektDAO {
    @PersistenceContext
    private EntityManager em;
    
// creates a list that is filled by a SQL query
    
    public List<Projekt> allProjekts() {	
      TypedQuery<Projekt> r = em.createQuery("SELECT b FROM Projekt b", Projekt.class);
      List<Projekt> h = r.getResultList();
      return h;
    }
    
// Constructors for new, update, delete and get

    public Projekt getProjekt(int id_projekt) {
      return em.find(Projekt.class, id_projekt);
    }
	
    public int newProjekt(String pname) {
    	Projekt b = new Projekt();
    	b.setPname(pname);
    	em.persist(b);
      	em.flush(); // needed to get the ID
      	return b.getId_projekt();
    }
	
    public void updateProjekt(int id_projekt,String pname) {
      Projekt b = em.find(Projekt.class, id_projekt);
      b.setPname(pname);
      em.persist(b);
    }
	
    public void deleteProjekt(int id_projekt) {
      Projekt b = em.find(Projekt.class, id_projekt);
      em.remove(b);
    }   
}