// CLASS BUCHUNG PROJEKT ÜBERISCHT

// needed packages and imports

package book.jakarta8.calypsojpa.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//declare of entity

@Entity
public class BuchungProjektUebersicht implements Comparable<BuchungProjektUebersicht> {
	
//declare of column names and variables
	
    @NotNull
    @Column(name = "SUM_STD")
    private Double sumSTD;

    @NotNull
    @Column(name = "COUNT_STD")
    private Double countSTD;
	
    @Id
    @NotNull
    @Column(name = "ID_PROJEKTKONTO")
    private int id_projektkonto;
    
 // get and set methods for every variable    
    
    public Double getSUM_STD() {
		return sumSTD;   	
	}

	public Double getCountSTD() {
		return countSTD;
	}

	public int getId_projektkonto() {
		return id_projektkonto;		
	}

	@Override
	public int compareTo(BuchungProjektUebersicht arg0) {
		// TODO Auto-generated method stub
		return 0;
	}   
}