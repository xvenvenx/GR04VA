// CLASS ANWENDER

// needed packages and imports

package book.jakarta8.calypsojpa.jpa;

import javax.persistence.*;
import javax.validation.constraints.*;


//declare of entity, table name and sequence of table

@Entity
@Table(name= "ANWENDER")
@SequenceGenerator(name="Anwender_SEQ", initialValue=50, allocationSize = 50)

//declare of column names and variables

public class Anwender implements Comparable<Anwender> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="Anwender_SEQ")	
    @Column(name = "ID_ANWENDER")
    private int id_anwender;
	
    @NotNull
    @Column(name = "ANAME")
    private String aname;

    @NotNull
    @Column(name = "PW")
    private String pw;
	
    @NotNull
    @Column(name = "FKRAFT")
    private String fkraft;

    @Override
    public int compareTo(Anwender o) {
      if(o.aname.compareTo(aname) != 0)
        return -o.aname.compareTo(aname);
      return -o.pw.compareTo(pw);
    }

  
// get and set methods for every variable
    
	public String getAname() {
		// TODO Auto-generated method stub
		return aname;
	}

	public String getPw() {
		// TODO Auto-generated method stub
		return pw;
	}

	public String getFkraft() {
		return fkraft;
	}

	public int getId_anwender() {
		// TODO Auto-generated method stub
		return id_anwender;
	}

	public void setAname(String aname) {
		this.aname= aname;
		
	}

	public void setPw(String pw) {
		this.pw=pw;
	}


	public void setFkraft(String fkraft) {
		// TODO Auto-generated method stub
		this.fkraft=fkraft;
	}


}
