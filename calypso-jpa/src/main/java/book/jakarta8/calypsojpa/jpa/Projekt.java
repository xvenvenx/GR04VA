// CLASS PROJEKT

// needed packages and imports

package book.jakarta8.calypsojpa.jpa;



import javax.persistence.*;
import javax.validation.constraints.*;



//declare of entity, table name and sequence of table 

@Entity
@Table(name= "PROJEKT")
@SequenceGenerator(name="Projekt_SEQ", initialValue=50, allocationSize = 50)
public class Projekt implements Comparable<Projekt> {
	
// declare of column names and variables
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="Projekt_SEQ")	
    @Column(name = "ID_PROJEKT")
    private int id_projekt;

    @NotNull
    @Column(name = "PNAME")
    private String pname;

    @Override
    public int compareTo(Projekt o) {
      if(o.pname.compareTo(pname) != 0)
      return -o.pname.compareTo(pname);
	return id_projekt;
	
    }

// get and set methods for every variable  
    
	public String getPname() {
		// TODO Auto-generated method stub
		return pname;
	}
	public int getId_projekt() {
		// TODO Auto-generated method stub
		return id_projekt;
	}

	public void setPname(String pname) {
		this.pname= pname;
		
	}

}