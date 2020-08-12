// CLASS BUCHUNG

// needed packages and imports

package book.jakarta8.calypsojpa.jpa;


import javax.persistence.*;
import javax.validation.constraints.*;


// declare of entity, table name and sequence of table 

@Entity
@Table(name= "BUCHUNG")
@SequenceGenerator(name="Buchung_SEQ", initialValue=50, allocationSize = 50)
public class Buchung implements Comparable<Buchung> {

// declare of column names and variables
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="Buchung_SEQ")	
    @Column(name = "ID_BUCHUNG")
    private int id_buchung;
	
    @NotNull
    @Column(name = "DTM")
    private String dtm;

    @NotNull
    @Column(name = "STD")
    private Double std;
	
    @NotNull
    @Column(name = "ID_PROJEKTKONTO")
    private int id_projektkonto;
    
    @NotNull
    @Column(name = "ID_ANWENDER")
    private int id_anwender;

    @Override
    public int compareTo(Buchung o) {
      if(o.dtm.compareTo(dtm) != 0)
        return -o.dtm.compareTo(dtm);
      return -o.std.compareTo(std);
    }


 // get and set methods for every variable    
    
    public String getDtm() {
		return dtm;   	
	}

	public Double getStd() {
		return std;
	}

	public int getId_projektkonto() {
		return id_projektkonto;		
	}
	
	public int getId_anwender() {
		return id_anwender;		
	}

	public int getId_buchung() {
		return id_buchung;
	}

// ------------------------------------------------------------------------------
	
	public void setDtm(String dtm) {
		this.dtm= dtm;	
	}

	public void setStd(Double std) {
		this.std=std;
	}

	public void setId_projektkonto(int id_projektkonto) {
		this.id_projektkonto=id_projektkonto;
	}

	public void setId_anwender(int id_anwender) {
		this.id_anwender=id_anwender;
	}

}