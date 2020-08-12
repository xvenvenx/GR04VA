// needed packages and imports

package book.jakarta8.calypsojpa.ejb;

import java.util.List;


import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import book.jakarta8.calypsojpa.jpa.Buchung;
import book.jakarta8.calypsojpa.jpa.BuchungProjektUebersicht;

@Singleton
public class BuchungDAO {
    @PersistenceContext
    private EntityManager em;
    
 // creates a list that is filled by a SQL query      
	
    public List<Buchung> allBuchungs() {	
      TypedQuery<Buchung> q = em.createQuery("SELECT u FROM Buchung u", Buchung.class);
      List<Buchung> l = q.getResultList();
      return l;
    }
    
// Constructors for new, update, delete and get    

    public Buchung getBuchung(int id_buchung) {
      return em.find(Buchung.class, id_buchung);
    }
	
    public int newBuchung(String dtm, double std, int id_projektkonto, int id_anwender) {
    	Buchung u = new Buchung();
    	u.setDtm(dtm);
    	u.setStd(std);
    	u.setId_projektkonto(id_projektkonto);
    	u.setId_anwender(id_anwender);
    	em.persist(u);
      	em.flush(); // needed to get the ID
      	return u.getId_buchung();
    }
	
    public void updateBuchung(String dtm, double std, int id_projektkonto,int id_anwender,int id_buchung) {
    	Buchung u = em.find(Buchung.class, id_buchung);
        u.setDtm(dtm);
        u.setStd(std);
        u.setId_projektkonto(id_projektkonto);
        u.setId_anwender(id_anwender);
      em.persist(u);
    }
	
    public void deleteBuchung(int id_buchung) {
      Buchung u = em.find(Buchung.class, id_buchung);
      em.remove(u);
    } 
    
// creates a list that is filled with SQL query for our Overview
    
    public List<BuchungProjektUebersicht> allBuchungProjektUebersichts() {	
        Query q = em.createNativeQuery("SELECT SUM(STD)SUM_STD,COUNT(STD)COUNT_STD, ID_PROJEKTKONTO FROM BUCHUNG GROUP BY ID_PROJEKTKONTO", BuchungProjektUebersicht.class);
        List<BuchungProjektUebersicht> l = q.getResultList();
        return l;
      }

}