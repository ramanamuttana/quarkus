package org.acme;

import java.util.ArrayList;
import java.util.stream.Collectors;  
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.Movie;

@Path("/movies")
public class MovieResource {
	
	public static List<Object> movies=new ArrayList<>();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovies() {
		
		return Response.ok(movies).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/size")
	public Integer countMovies() {
		
		return movies.size();
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMovies(Movie newMovie) {
		movies.add(newMovie);
		return Response.ok(movies).build();
		
	}
	
	@PUT 
	@Path("{id}/{movie}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMovies(@PathParam("id") Long id,@PathParam("movie")String updateMovie) {
	  movies=movies.stream().map(movieValues-> { 
      if(((Movie) movieValues).getId().equals(id)) { 
    	  ((Movie) movieValues).setMovie(updateMovie);
    	  return  updateMovie; 
    	  } 
      return movieValues;
	  
	  }).collect(Collectors.toList());
	  
	  return Response.ok(movies).build(); 
	 }
	 
	
	
	@DELETE
	@Path("{movieToDelete}")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response deleteMovie(@PathParam("movieToDelete")String movieToDelete) {
		boolean removed=movies.remove(movieToDelete);
		return removed ? Response.noContent().build():
			Response.status(Response.Status.BAD_REQUEST).build();	
	}

}
