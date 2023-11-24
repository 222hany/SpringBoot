package com.kh.springdb.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private int mno;
	private String mname;
	private String memail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mbirth = new Date();
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public Date getMbirth() {
		return mbirth;
	}
	public void setMbirth(Date mbirth) {
		this.mbirth = mbirth;
	}
}