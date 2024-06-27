package model.entity;

import java.io.Serializable;

public class UserBean implements Serializable {
	/**
	 * userID
	 */
	private int id;

	/**
	 * user名前
	 */
	private String name;

	/**
	 * user password
	 */
	private String password;

	/**
	 * 引数なしデフォルトコンストラクタ
	 */
	public UserBean() {
	}

	/**
	 * 引数ありコンストラクタ
	 */
	public UserBean(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}