package com.ldd.volley.bean;

public class Notes {

	/* "Hit": 0,
     "Body": "各业主注意,2014年12月12日，因管道改造施工，将停水一天,具体时间为：8:00---17:00，请提前做好准备。为此给大家带来的不便敬请谅解。",
     "PropertyManagerID": 21,
     "Header": "2014年12月12日小区停水通知",
     "PropertyID": 13,
     "NoteID": 55,
     "isValid": 1,
     "CTime": "1417797345840",
     "Signature": "银都国际物业办公司",
     "Priority": 9*/
	
	private String Hit;
	private String Body;
	private int PropertyManagerID;
	private String Header;
	private int PropertyID;
	private int NoteID;
	private int  isValid;
	private String CTime;
	private String Signature;
	private int Priority;
	public Notes() {
		super();
	}
	public Notes(String hit, String body, int propertyManagerID, String header,
			int propertyID, int noteID, int isValid, String cTime,
			String signature, int priority) {
		super();
		Hit = hit;
		Body = body;
		PropertyManagerID = propertyManagerID;
		Header = header;
		PropertyID = propertyID;
		NoteID = noteID;
		this.isValid = isValid;
		CTime = cTime;
		Signature = signature;
		Priority = priority;
	}
	public String getHit() {
		return Hit;
	}
	public void setHit(String hit) {
		Hit = hit;
	}
	public String getBody() {
		return Body;
	}
	public void setBody(String body) {
		Body = body;
	}
	public int getPropertyManagerID() {
		return PropertyManagerID;
	}
	public void setPropertyManagerID(int propertyManagerID) {
		PropertyManagerID = propertyManagerID;
	}
	public String getHeader() {
		return Header;
	}
	public void setHeader(String header) {
		Header = header;
	}
	public int getPropertyID() {
		return PropertyID;
	}
	public void setPropertyID(int propertyID) {
		PropertyID = propertyID;
	}
	public int getNoteID() {
		return NoteID;
	}
	public void setNoteID(int noteID) {
		NoteID = noteID;
	}
	public int getIsValid() {
		return isValid;
	}
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	public String getCTime() {
		return CTime;
	}
	public void setCTime(String cTime) {
		CTime = cTime;
	}
	public String getSignature() {
		return Signature;
	}
	public void setSignature(String signature) {
		Signature = signature;
	}
	public int getPriority() {
		return Priority;
	}
	public void setPriority(int priority) {
		Priority = priority;
	}
	
	
}
