package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("/singlesearch")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri="http://api.tvmaze.com/")
public interface TvSeriesProxy {
	
//	http://api.tvmaze.com/singlesearch/shows
	
	@GET
	@Path("/shows")
	TvSeries get(@QueryParam("q") String title); 

}
