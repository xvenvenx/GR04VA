// CLASS PROJEKTKONTO

// needed packages and imports

package book.jakarta8.calypsojpa.jpa;

import javax.persistence.*;
import javax.validation.constraints.*;

//declare of entity, table name and sequence of table 

@Entity
@Table(name= "PROJEKTKONTO")
@SequenceGenerator(name="Projektkonto_SEQ", initialValue=50, allocationSize = 50)
public class Projektkonto implements Comparable<Projektkonto> {
	
// declare of column names and variables
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="Projektkonto_SEQ")	
    @Column(name = "ID_PROJEKTKONTO")
    private int id_projektkonto;
    	
    @NotNull
    @Column(name = "PBEZ")
    private String pbez;

    @NotNull
    @Column(name = "SOLL_STD")
    private double soll_std;
	
    @NotNull
    @Column(name = "BUCHUNGSZEITRAUM_DTM_A")
    private String  buchungszeitraum_dtm_a;
    
    @NotNull
    @Column(name = "BUCHUNGSZEITRAUM_DTM_B")
    private String buchungszeitraum_dtm_b;
    
    @NotNull
    @Column(name = "ID_PROJEKT")
    private int id_projekt;

    @Override
    public int compareTo(Projektkonto o) {
      if(o.pbez.compareTo(pbez) != 0)
        return -o.pbez.compareTo(pbez);
      return id_projektkonto;
    }
 
 // get and set methods for every variable 
    
	public String getPbez() {
		// TODO Auto-generated method stub
		return pbez;
	}

	public double getSoll_std() {
		// TODO Auto-generated method stub
		return soll_std;
	}

	public String getBuchungszeitraum_dtm_a() {
		return buchungszeitraum_dtm_a;
	}
	
	public String getBuchungszeitraum_dtm_b() {
		return buchungszeitraum_dtm_b;
	}
	
	public int getId_projektkonto() {
		return id_projektkonto;
	}
	public int getId_projekt(){
		return id_projekt;
	}

	public void setPbez(String pbez) {
		this.pbez= pbez;
		
	}

	public void setSoll_std(double soll_std) {
		this.soll_std=soll_std;
	}


	public void setBuchungszeitraum_dtm_a(String buchungszeitraum_dtm_a) {
		this.buchungszeitraum_dtm_a=buchungszeitraum_dtm_a;
	}
	
	public void setBuchungszeitraum_dtm_b(String buchungszeitraum_dtm_b) {
		this.buchungszeitraum_dtm_b=buchungszeitraum_dtm_b;
	}
	
	public void setId_projekt(int id_projekt) {
		this.id_projekt=id_projekt;
	}

    // + getters and setters for all properties

}
