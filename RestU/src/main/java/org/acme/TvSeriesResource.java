package org.acme;

import java.util.ArrayList;
import java.util.List;

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
	TvSeriesProxy tvSeriesProxy;
	
	@RestClient 
	EpisodeProxy episodeProxy;
	
	private  List<TvSeries> tvSeries=new ArrayList<>();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@QueryParam("title") String title) {
		TvSeries tvSerie=tvSeriesProxy.get(title);
		List<Episode> episodes=episodeProxy.get(tvSerie.getId());
		tvSeries.add(tvSerie);
		return Response.ok(episodes).build();
	}

}
