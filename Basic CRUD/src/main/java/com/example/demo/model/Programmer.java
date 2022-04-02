package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Programmer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "programmer_Id")
	private int pId;
	@Column(name = "programmer_name")
	private String pName;
	@Column(name = "programmer_language")
	private String pLang;
	
	
	public Programmer() {
		super();
	}


	public Programmer(int pId, String pName, String pLang) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pLang = pLang;
	}


	public int getpId() {
		return pId;
	}


	public void setpId(int pId) {
		this.pId = pId;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getpLang() {
		return pLang;
	}


	public void setpLang(String pLang) {
		this.pLang = pLang;
	}
	
	@Override
	public String toString() {
		return "Programmer [pId=" + pId + ", pName" + pName + ", pLang" + pLang +"]";
	}
	
}
