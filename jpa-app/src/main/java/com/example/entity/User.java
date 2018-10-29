package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
//persistenceはデータ永続化（マッピング）のEntity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	// テーブルのカラム名に対するフィールドを作成
	@Id // PRIMARY KEYにセットしてあるカラムに着けるアノテーション
	@Column(name = "id")
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "pass")
	private String pass;

	/**
	 * ユーザー登録するためにインスタンスを生成
	 * idとpassだけで登録するため
	 * @param id
	 * @param pass
	 */
	public User(String id, String pass, String name) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
	}
	
	/**
	 * why?
	 */
	public User() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
