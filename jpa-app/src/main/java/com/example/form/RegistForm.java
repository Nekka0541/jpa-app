package com.example.form;

import java.io.Serializable;

/**
 * フォームに入力された値を登録する
 * @author sjdu002
 *
 */
public class RegistForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String pass;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
