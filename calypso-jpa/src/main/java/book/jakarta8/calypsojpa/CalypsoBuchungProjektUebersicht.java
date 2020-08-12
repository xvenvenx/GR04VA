//needed packages and imports

package book.jakarta8.calypsojpa;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;

import javax.ws.rs.core.Response;

import book.jakarta8.calypsojpa.ejb.BuchungDAO;
import book.jakarta8.calypsojpa.jpa.BuchungProjektUebersicht;

//the URL that we used

/**
 * REST Web Service
 * http://localhost:8080/calypso-jpa/static/main.html
 */

//the main path to get the reference to this and the other classes for BUCHUNGPROJEKTUEBERSICHT 

@Path("/buchungProjektUebersicht")
public class CalypsoBuchungProjektUebersicht { 
	
// enterprise java bean
	
    @EJB private BuchungDAO buchungs;
    
 // default path with "/uebersicht"; @GET is a method that is initiate in "script.js"; it filled the list with the needed informations;    
   
	    @Path("/uebersicht")
	    @GET
	    @Produces("application/json")
	    public Response buchungProjektUebersicht() {
	      List<BuchungProjektUebersicht> buchungProjektUebersicht = buchungs.allBuchungProjektUebersichts();
	      StringBuilder outStr = new StringBuilder();
	      outStr.append("[");
	      outStr.append(
	    		  buchungProjektUebersicht.stream().sorted().
	        map((BuchungProjektUebersicht itm) -> 
	        	"{\"SUM_STD\":\"" + itm.getSUM_STD() + "\"," +
	        	"\"COUNT_STD\":\"" + itm.getCountSTD() + "\"," +
	        	"\"id_projektkonto\":\"" + itm.getId_projektkonto() + "\"}"
	        ).collect(Collectors.joining(","))
	      );		
	      outStr.append("]");
	      return Response.ok().entity(
	        outStr.toString() 
	      ).build();
	    } 
}
