package com.example.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="log")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	//カラム名に対応するフィールド
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="logdate")
	private Date logdate;
	
	
	//リレーション（関係性）を定義してあるフィールド
	//フィールドには参照先　@JoinColumnにはキー名
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;


	/**
	 * ログ時刻とユーザーIDを指定してインスタンスを生成
	 * 値生成を簡単にするため
	 * @param logdate
	 * @param user
	 */
	public Log(Date logdate, User user) {
		super();
		this.logdate = logdate;
		this.user = user;
	}

	/**
	 * デフォルトコンストラクタは必須
	 *
	 */
	public Log() {
		super();
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getLogdate() {
		return logdate;
	}


	public void setLogdate(Date logdate) {
		this.logdate = logdate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	

}
