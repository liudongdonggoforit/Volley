package com.ldd.volley.bean;

public class Fleas {

	/* "Description": "»Ò³£Æ¯ÁÁµÄÂÌÂá¡«¡«¡«",
     "Header": "È«ÐÂÂÌÂá",
     "CategoryID": 0,
     "Contact": "15010526735",
     "FleaID": 148,
     "UserID": 10276,
     "PropertyID": 2658,
     "CTime": "1442314496917",
     "FrontCover": {
         "path": "http://service.exiudaojia.com/tofleaimage.aspx?imageID=313",
         "FleaPictureID": 313,
         "Description": "»Ò³£Æ¯ÁÁµÄÂÌÂá¡«¡«¡«"*/
	private String Description;
	private String Header;
	private int CategoryID;
	private String Contact;
	private int FleaID;
	private long UserID;
	private Long PropertyID;
	private String CTime;
	private FrontCover FrontCover;
	public Fleas() {
		super();
	}
	public Fleas(String description, String header, int categoryID,
			String contact, int fleaID, long userID, Long propertyID,
			String cTime) {
		super();
		Description = description;
		Header = header;
		CategoryID = categoryID;
		Contact = contact;
		FleaID = fleaID;
		UserID = userID;
		PropertyID = propertyID;
		CTime = cTime;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getHeader() {
		return Header;
	}
	public void setHeader(String header) {
		Header = header;
	}
	public int getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public int getFleaID() {
		return FleaID;
	}
	public void setFleaID(int fleaID) {
		FleaID = fleaID;
	}
	public long getUserID() {
		return UserID;
	}
	public void setUserID(long userID) {
		UserID = userID;
	}
	public Long getPropertyID() {
		return PropertyID;
	}
	public void setPropertyID(Long propertyID) {
		PropertyID = propertyID;
	}
	public String getCTime() {
		return CTime;
	}
	public void setCTime(String cTime) {
		CTime = cTime;
	}
	public  FrontCover getFrontCover() {
		return FrontCover;
	}
	public void setFrontCover(FrontCover frontCover) {
		FrontCover = frontCover;
	}
	
	

}
