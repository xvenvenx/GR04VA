//needed packages and imports

package book.jakarta8.calypsojpa;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import book.jakarta8.calypsojpa.ejb.BuchungDAO;
import book.jakarta8.calypsojpa.jpa.Buchung;


//the URL that we used
/**
 * REST Web Service
 * http://localhost:8080/calypso-jpa/static/main.html
 */

//the main path to get the reference to this and the other classes for BUCHUNG 

@Path("/buchung")
public class Calypso_buchung {
	
// enterprise java bean	
	
    @EJB private BuchungDAO buchungs;
   
 // default path; @GET is a method that is initiate in "script.js"; it filled the list with the needed informations;
    
    @Path("/")
    @GET
    @Produces("application/json")
    public Response list() {
      List<Buchung> buchungList = buchungs.allBuchungs();
      StringBuilder outStr = new StringBuilder();
      outStr.append("[");
      outStr.append(
        buchungList.stream().sorted().
        map((Buchung itm) -> 
        	"{\"dtm\":\"" + itm.getDtm() + "\"," +
        	"\"std\":\"" + itm.getStd() + "\"," +
        	"\"id_projektkonto\":\"" + itm.getId_projektkonto() + "\"," +
        	"\"id_anwender\":\"" + itm.getId_anwender() + "\"," +
        	"\"id_buchung\":" + itm.getId_buchung() + "}"
        ).collect(Collectors.joining(","))
      );		
      outStr.append("]");
      return Response.ok().entity(
        outStr.toString() 
      ).build();
    }
    
  //default path with the id of the BUCHUNG class;  @GET is a method that is initiate in "script.js"; it filled the list with the needed informations;    
    
    @Path("/{id_buchung}")
    @GET
    @Produces("application/json")
    public Response entity(@PathParam("id_buchung") int id_buchung) {
      Buchung u = buchungs.getBuchung(id_buchung);		
      return Response.ok().entity(
        "{\"dtm\":\"" + u.getDtm() + "\", " +
		"\"std\":\"" + u.getStd() + "\"," +
		"\"id_projektkonto\":\"" + u.getId_projektkonto() + "\"," +
		"\"id_anwender\":\"" + u.getId_anwender() + "\"," +
		"\"id_buchung\":" + u.getId_buchung() + "}"			
      ).build();
    }
    
 // default path; @Post is a method that is initiate in "script.js"; it filled the defined places with the saved informations; especially for new BUCHUNG    
    
    @Path("/")
    @POST
    @Produces("application/json")
    public Response post(
          @FormParam("dtm") String dtm,
          @FormParam("std") Double std,
          @FormParam("id_projektkonto") int id_projektkonto,
          @FormParam("id_anwender") int id_anwender) {
      int newId_buchung = buchungs.newBuchung(dtm, std,id_projektkonto,id_anwender);
      return Response.ok().entity("{\"id_Buchung\":"+ newId_buchung +"}").
          build();
    }
    
//default path with the id of the BUCHUNG class; @Put is a method that is initiate in "script.js"; it filled the defined places with the saved informations; especially for BUCHUNG you want to update
    
    
    @Path("/{id_buchung}")
    @PUT
    @Produces("application/json")
    public Response put(
          @FormParam("dtm") String dtm,
          @FormParam("std") Double std,
          	@FormParam("id_projektkonto") int id_projektkonto,
          	@FormParam("id_anwender") int id_anwender,
          @PathParam("id_buchung") int id_buchung) {
      buchungs.updateBuchung(dtm,std,id_projektkonto,id_anwender,id_buchung);
      return Response.ok().entity("{}").build();
    }
    
  //default path with the id of the BUCHUNG class; @Delete is a method that is initiate in "script.js"; it delete an BUCHUNG    
    
    @Path("/{id_buchung}")
    @DELETE
    @Produces("application/json")
    public Response del(@PathParam("id_buchung") int id_buchung) {
      buchungs.deleteBuchung(id_buchung);
      return Response.ok().entity("{}").build();
    }  
}