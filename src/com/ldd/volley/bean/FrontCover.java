package com.ldd.volley.bean;

public class FrontCover {

/*	 "path": "http://service.exiudaojia.com/tofleaimage.aspx?imageID=313",
     "FleaPictureID": 313,
     "Description": "»Ò³£Æ¯ÁÁµÄÂÌÂá¡«¡«¡«"*/
	private String path;
	private int FleaPictureID;
	private String Description;
	public FrontCover() {
		super();
	}
	public FrontCover(String path, int fleaPictureID, String description) {
		super();
		this.path = path;
		FleaPictureID = fleaPictureID;
		Description = description;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getFleaPictureID() {
		return FleaPictureID;
	}
	public void setFleaPictureID(int fleaPictureID) {
		FleaPictureID = fleaPictureID;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
