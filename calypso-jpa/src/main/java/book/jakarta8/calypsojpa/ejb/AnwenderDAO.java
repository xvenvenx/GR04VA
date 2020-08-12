// needed packages and imports

package book.jakarta8.calypsojpa.ejb;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import book.jakarta8.calypsojpa.jpa.Anwender;

@Singleton
public class AnwenderDAO {
    @PersistenceContext
    private EntityManager em;
    
 // creates a list that is filled by a SQL query    
	
    public List<Anwender> allAnwenders() {	
      TypedQuery<Anwender> q = em.createQuery("SELECT a FROM Anwender a", Anwender.class);
      List<Anwender> l = q.getResultList();
      return l;
      }
   
 // Constructors for new, update, delete and get

    public Anwender getAnwender(int id_anwender) {
      return em.find(Anwender.class, id_anwender);
    }
	
    public int newAnwender(String aname, String pw, String fkraft) {
    	Anwender a = new Anwender();
    	a.setAname(aname);
    	a.setPw(pw);
    	a.setFkraft(fkraft);
    	em.persist(a);
      	em.flush(); // needed to get the ID
      	return a.getId_anwender();
    }
	
    public void updateAnwender(int id_anwender,String aname,String pw, String fkraft) {
      Anwender a = em.find(Anwender.class, id_anwender);
      a.setAname(aname);
      a.setPw(pw);
      a.setFkraft(fkraft);
      em.persist(a);
    }
	
    public void deleteAnwender(int id_anwender) {
      Anwender a = em.find(Anwender.class, id_anwender);
      em.remove(a);
    }
}