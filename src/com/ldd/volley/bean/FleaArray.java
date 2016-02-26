package com.ldd.volley.bean;

import java.util.ArrayList;

public class FleaArray {
	private String desc;
	private int code;
	private ArrayList<Fleas> fleaarray;
	public FleaArray() {
		super();
	}
	public FleaArray(String desc, int code, ArrayList<Fleas> fleaarray) {
		super();
		this.desc = desc;
		this.code = code;
		this.fleaarray = fleaarray;
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
	public ArrayList<Fleas> getFleaarray() {
		return fleaarray;
	}
	public void setFleaarray(ArrayList<Fleas> fleaarray) {
		this.fleaarray = fleaarray;
	}
	
	

}
