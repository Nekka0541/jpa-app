package com.example.form;

import java.io.Serializable;

/**
 * ログイン画面に入力された値を運ぶDTO (Data Transfer Object)
 * 
 * @author sjdu002
 *
 */
public class LoginForm implements Serializable {

	private static final long serialVersionUID = 1L;

	// フィールド
	private String id;
	private String pass;

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

}
