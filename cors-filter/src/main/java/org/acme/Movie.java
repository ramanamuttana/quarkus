package org.acme;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name="Movie",description="Movie representation")
public class Movie {
	
	private Long id;
	
	@Schema(required=true)
	private String movie;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
}
