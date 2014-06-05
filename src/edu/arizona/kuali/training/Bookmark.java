package edu.arizona.kuali.training;

public class Bookmark {
	private String name;
	private String url;
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bookmark(String name, String url) {
		this.id = BookmarkSequenceManager.getNextSeqence();
		this.name = name;
		this.url = url;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
