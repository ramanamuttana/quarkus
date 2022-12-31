package org.acme;

import java.net.URL;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TvSeries {
	
	private Long id;
	
	private String name;
	
	private URL url;
	
	private String summary;
	
	private String language;
	
	private Set<String> geners;
	
	private URL officialSite;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Set<String> getGeners() {
		return geners;
	}

	public void setGeners(Set<String> geners) {
		this.geners = geners;
	}

	public URL getOfficialSite() {
		return officialSite;
	}

	public void setOfficialSite(URL officialSite) {
		this.officialSite = officialSite;
	}

}
