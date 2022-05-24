package com.utina.core.display.bean;

import java.time.Instant;

public class BuildInfo {
	
	private String name;
	private String version;
	private Instant time;
	private String releaseNote;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	public Instant getTime() {
		return time;
	}
	public void setTime(Instant time) {
		this.time = time;
	}
	public String getReleaseNote() {
		return releaseNote;
	}
	public void setReleaseNote(String releaseNote) {
		this.releaseNote = releaseNote;
	}
	
	

}
