package org.acme;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/tvseries")
public class TvSeriesResource {
	
	@RestClient 
	@Inject
	TvSeriesProxy proxy;
	
	private  List<TvSeries> tvSeries=new ArrayList<>();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@QueryParam("title") String title) {
		TvSeries tvSerie=proxy.get("Game of thrones");
		tvSeries.add(tvSerie);
		return Response.ok(tvSeries).build();
	}

}
