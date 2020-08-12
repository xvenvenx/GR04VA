// needed packages and imports

package book.jakarta8.calypsojpa.ejb;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import book.jakarta8.calypsojpa.jpa.Projektkonto;

@Singleton
public class ProjektkontoDAO {
    @PersistenceContext
    private EntityManager em;
    
 // creates a list that is filled by a SQL query    
	
    public List<Projektkonto> allProjektkontos() {	
      TypedQuery<Projektkonto> q = em.createQuery("SELECT c FROM Projektkonto c", Projektkonto.class);
      List<Projektkonto> l = q.getResultList();
      return l;
       }
    
 // Constructors for new, update, delete and get

    public Projektkonto getProjektkonto(int id_projektkonto) {
      return em.find(Projektkonto.class, id_projektkonto);
    }
	
    public int newProjektkonto(String pbez, double soll_std, String buchungszeitraum_dtm_a,String buchungszeitraum_dtm_b,int id_projekt) {
    	Projektkonto c = new Projektkonto();
    	c.setPbez(pbez);
    	c.setSoll_std(soll_std);
    	c.setBuchungszeitraum_dtm_a(buchungszeitraum_dtm_a);
    	c.setBuchungszeitraum_dtm_b(buchungszeitraum_dtm_b);
    	c.setId_projekt(id_projekt);
    	em.persist(c);
      	em.flush(); // needed to get the ID
      	return c.getId_projektkonto();
    }
	
    public void updateProjektkonto(int id_projektkonto, String pbez, double soll_std, String buchungszeitraum_dtm_a,String buchungszeitraum_dtm_b,int id_projekt) {
      Projektkonto c = em.find(Projektkonto.class, id_projektkonto);
  	  c.setPbez(pbez);
  	  c.setSoll_std(soll_std);
  	  c.setBuchungszeitraum_dtm_a(buchungszeitraum_dtm_a);
  	  c.setBuchungszeitraum_dtm_b(buchungszeitraum_dtm_b);
  	  c.setId_projekt(id_projekt);
      em.persist(c);
    }
	
    public void deleteProjektkonto(int id_projektkonto) {
      Projektkonto c = em.find(Projektkonto.class, id_projektkonto);
      em.remove(c);
    }
    
}