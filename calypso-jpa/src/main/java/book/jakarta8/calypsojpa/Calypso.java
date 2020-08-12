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

import book.jakarta8.calypsojpa.ejb.AnwenderDAO;
import book.jakarta8.calypsojpa.jpa.Anwender;


// the URL that we used
/**
 * REST Web Service
 * http://localhost:8080/calypso-jpa/static/main.html
 */

// the main path to get the reference to this and the other classes for ANWENDER 

@Path("/anwender")
public class Calypso {
	
// enterprise java bean
	
    @EJB private AnwenderDAO anwenders;
   
// default path; @GET is a method that is initiate in "script.js"; it filled the list with the needed informations;
    
    @Path("/")
    @GET
    @Produces("application/json")
    public Response list() {
      List<Anwender> anwenderList = anwenders.allAnwenders();
      StringBuilder outStr = new StringBuilder();
      outStr.append("[");
      outStr.append(
        anwenderList.stream().sorted().
        map((Anwender itm) -> 
          "{\"aname\":\"" + 
              itm.getAname() + "\"," +
          "\"pw\":\"" + 
              itm.getPw() + "\"," +
          "\"fkraft\":\"" + 
              itm.getFkraft() + "\"," +
          "\"id_anwender\":" + itm.getId_anwender() + "}"
        ).collect(Collectors.joining(","))
      );		
      outStr.append("]");
      return Response.ok().entity(
        outStr.toString() 
      ).build();
    }
    
//default path with the id of the ANWENDER class;  @GET is a method that is initiate in "script.js"; it filled the list with the needed informations;
    
    @Path("/{id_anwender}")
    @GET
    @Produces("application/json")
    public Response entity(@PathParam("id_anwender") int id_anwender) {
      Anwender a = anwenders.getAnwender(id_anwender);		
      return Response.ok().entity(
        "{\"aname\":\"" +  
            a.getAname() + "\", " +
        "\"pw\":\"" + 
            a.getPw() + "\", " +
        "\"fkraft\":\"" + 
            a.getFkraft() + "\", " +
        "\"id_anwender\":" + a.getId_anwender() + "}"		
      ).build();
    }
    
// default path; @Post is a method that is initiate in "script.js"; it filled the defined places with the saved informations; especially for new ANWENDER
    
    @Path("/")
    @POST
    @Produces("application/json")
    public Response post(
          @FormParam("aname") String aname,
          @FormParam("pw") String pw,
          @FormParam("fkraft") String fkraft) {
      int newId_anwender = anwenders.newAnwender(aname, pw, fkraft);
      return Response.ok().entity("{\"id_Anwender\":"+ newId_anwender +"}").
          build();
    }
    
//default path with the id of the ANWENDER class; @Put is a method that is initiate in "script.js"; it filled the defined places with the saved informations; especially for ANWENDER you want to update

    @Path("/{id_anwender}")
    @PUT
    @Produces("application/json")
    public Response put(
          @FormParam("aname") String aname,
          @FormParam("pw") String pw,
          @FormParam("fkraft") String fkraft,
          @PathParam("id_anwender") int id_anwender) {
      anwenders.updateAnwender(id_anwender,aname, pw, fkraft);
      return Response.ok().entity("{}").build();
    }
    
//default path with the id of the ANWENDER class; @Delete is a method that is initiate in "script.js"; it delete an ANWENDER
    
    @Path("/{id_anwender}")
    @DELETE
    @Produces("application/json")
    public Response del(@PathParam("id_anwender") int id_anwender) {
      anwenders.deleteAnwender(id_anwender);
      return Response.ok().entity("{}").build();
    }  
}
    