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

import book.jakarta8.calypsojpa.ejb.ProjektkontoDAO;
import book.jakarta8.calypsojpa.jpa.Projektkonto;


//the URL that we used

/**
 * REST Web Service
 * http://localhost:8080/calypso-jpa/static/main.html
 */

//the main path to get the reference to this and the other classes for PROJEKTKONTO 

@Path("/projektkonto")
public class Calypso_pk {
	
// enterprise java bean
	
    @EJB private ProjektkontoDAO projektkontos;
   
 // default path; @GET is a method that is initiate in "script.js"; it filled the list with the needed informations;
    
    @Path("/")
    @GET
    @Produces("application/json")
    public Response list() {
      List<Projektkonto> projektkontoList = projektkontos.allProjektkontos();
      StringBuilder outStr = new StringBuilder();
      outStr.append("[");
      outStr.append(
        projektkontoList.stream().sorted().
        map((Projektkonto itm) -> 
          "{\"pbez\":\"" + 
              itm.getPbez() + "\"," +
          "\"soll_std\":\"" + 
              itm.getSoll_std() + "\"," +
          "\"buchungszeitraum_dtm_a\":\"" + 
              itm.getBuchungszeitraum_dtm_a() + "\"," +
           "\"buchungszeitraum_dtm_b\":\"" + 
              itm.getBuchungszeitraum_dtm_b() + "\"," +
            "\"id_projekt\":\"" + 
              itm.getId_projekt() + "\"," +           
          "\"id_projektkonto\":" + itm.getId_projektkonto() + "}"
        ).collect(Collectors.joining(","))
      );		
      outStr.append("]");
      return Response.ok().entity(
        outStr.toString() 
      ).build();
    }
    
  //default path with the id of the PROJEKTKONTO class;  @GET is a method that is initiate in "script.js"; it filled the list with the needed informations;    
    
    @Path("/{id_projektkonto}")
    @GET
    @Produces("application/json")
    public Response entity(@PathParam("id_projektkonto") int id_projektkonto) {
      Projektkonto c = projektkontos.getProjektkonto(id_projektkonto);		
      return Response.ok().entity(
        "{\"pbez\":\"" + 
            c.getPbez() + "\"," +
         "\"soll_std\":\"" + 
            c.getSoll_std() + "\"," +
         "\"buchungszeitraum_dtm_a\":\"" + 
             c.getBuchungszeitraum_dtm_a() + "\"," +
          "\"buchungszeitraum_dtm_b\":\"" + 
              c.getBuchungszeitraum_dtm_b() + "\"," +
           "\"id_projekt\":\"" + 
              c.getId_projekt() + "\"," +           
            "\"id_projektkonto\":" + c.getId_projektkonto() + "}"	
      ).build();
    }
    
 // default path; @Post is a method that is initiate in "script.js"; it filled the defined places with the saved informations; especially for new PROJEKTKONTO 
    
    @Path("/")
    @POST
    @Produces("application/json")
    public Response post(
          @FormParam("pbez") String pbez,
          @FormParam("soll_std") double soll_std,
          @FormParam("buchungszeitraum_dtm_a") String buchungszeitraum_dtm_a,
          @FormParam("buchungszeitraum_dtm_b") String buchungszeitraum_dtm_b,
          @FormParam("id_projekt") int id_projekt){
      int newId_projektkonto = projektkontos.newProjektkonto(pbez, soll_std,buchungszeitraum_dtm_a,buchungszeitraum_dtm_b,id_projekt);
      return Response.ok().entity("{\"id_Projektkonto\":"+ newId_projektkonto +"}").
          build();
    }
    
//default path with the id of the PROJEKTKONTO class; @Put is a method that is initiate in "script.js"; it filled the defined places with the saved informations; especially for PROJEKTKONTO you want to update
    
    
    @Path("/{id_projektkonto}")
    @PUT
    @Produces("application/json")
    public Response put(
            @FormParam("pbez") String pbez,
            @FormParam("soll_std") double soll_std,
            @FormParam("buchungszeitraum_dtm_a") String buchungszeitraum_dtm_a,
            @FormParam("buchungszeitraum_dtm_b") String buchungszeitraum_dtm_b,
            @FormParam("id_projekt") int id_projekt,
            @PathParam("id_projektkonto") int id_projektkonto) {
      projektkontos.updateProjektkonto(id_projektkonto,pbez, soll_std,buchungszeitraum_dtm_a,buchungszeitraum_dtm_b,id_projekt);
      return Response.ok().entity("{}").build();
    }

//default path with the id of the PROJEKTKONTO class; @Delete is a method that is initiate in "script.js"; it delete an PROJEKTKONTO

    @Path("/{id_projektkonto}")
    @DELETE
    @Produces("application/json")
    public Response del(@PathParam("id_projektkonto") int id_projektkonto) {
      projektkontos.deleteProjektkonto(id_projektkonto);
      return Response.ok().entity("{}").build();
    }  
}
   