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

import book.jakarta8.calypsojpa.ejb.ProjektDAO;
import book.jakarta8.calypsojpa.jpa.Projekt;

//the URL that we used
/**
 * REST Web Service
 * http://localhost:8080/calypso-jpa/static/main.html
 */

//the main path to get the reference to this and the other classes for PROJEKT 

@Path("/projekt")
public class Calypso_projekt {
	
// enterprise java bean	
    @EJB private ProjektDAO projekts;
   
 // default path; @GET is a method that is initiate in "script.js"; it filled the list with the needed informations;   
    
    @Path("/")
    @GET
    @Produces("application/json")
    public Response list() {
      List<Projekt> projektList = projekts.allProjekts();
      StringBuilder outStr = new StringBuilder();
      outStr.append("[");
      outStr.append(
        projektList.stream().sorted().
        map((Projekt itm) -> 
          "{\"pname\":\"" + 
              itm.getPname() + "\"," +
          "\"id_projekt\":" + itm.getId_projekt() + "}"
        ).collect(Collectors.joining(","))
      );		
      outStr.append("]");
      return Response.ok().entity(
        outStr.toString() 
      ).build();
    }

  //default path with the id of the PROJEKT class;  @GET is a method that is initiate in "script.js"; it filled the list with the needed informations;    
    
    @Path("/{id_projekt}")
    @GET
    @Produces("application/json")
    public Response entity(@PathParam("id_projekt") int id_projekt) {
      Projekt a = projekts.getProjekt(id_projekt);		
      return Response.ok().entity(
        "{\"pname\":\"" +  
            a.getPname() + "\", " +
        "\"id_projekt\":" + a.getId_projekt() + "}"		
      ).build();
    }
    
 // default path; @Post is a method that is initiate in "script.js"; it filled the defined places with the saved informations; especially for new PROJEKT    
    
    @Path("/")
    @POST
    @Produces("application/json")
    public Response post(
          @FormParam("pname") String pname) {
      int newId_projekt = projekts.newProjekt(pname);
      return Response.ok().entity("{\"id_Projekt\":"+ newId_projekt +"}").
          build();
    }
    
  //default path with the id of the PROJEKT class; @Put is a method that is initiate in "script.js"; it filled the defined places with the saved informations; especially for PROJEKT you want to update    
    
    @Path("/{id_projekt}")
    @PUT
    @Produces("application/json")
    public Response put(
          @FormParam("pname") String pname,
          @PathParam("id_projekt") int id_projekt) {
      projekts.updateProjekt(id_projekt,pname);
      return Response.ok().entity("{}").build();
    }
    
  //default path with the id of the PROJEKT class; @Delete is a method that is initiate in "script.js"; it delete an PROJEKT    
    
    @Path("/{id_projekt}")
    @DELETE
    @Produces("application/json")
    public Response del(@PathParam("id_projekt") int id_projekt) {
      projekts.deleteProjekt(id_projekt);
      return Response.ok().entity("{}").build();
    }  
}