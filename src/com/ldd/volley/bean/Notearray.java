package com.ldd.volley.bean;

import java.util.ArrayList;

public class Notearray {
	 /* "desc": "³É¹¦",
	    "code": 200*/

	private String desc;
	private int code;
	private ArrayList<Notes> notearray;
	
	
	public Notearray() {
		super();
	}
	
	public Notearray(String desc, int code, ArrayList<Notes> notearray) {
		super();
		this.desc = desc;
		this.code = code;
		this.notearray = notearray;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public ArrayList<Notes> getNotearray() {
		return notearray;
	}
	public void setNotearray(ArrayList<Notes> notearray) {
		this.notearray = notearray;
	}
	
	

}
