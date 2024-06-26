package model.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class TimeBean implements Serializable {
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
	 * 社員id
	 */
	private int employee_id;

	/**
	 * 日付
	 */
	private Date date;

	/**
	 * 出勤時間
	 */
	private Time start_time;

	/**
	 * 退勤時間
	 */
	private Time end_time;

	/**
	 * 残業時間
	 */
	private Time over_time;

	/**
	 * 引数なしデフォルトコンストラクタ
	 */
	public TimeBean() {
	}

	/**
	 * 引数ありコンストラクタ
	 */
	public TimeBean(int id, String name, String password, int employee_id, Date date, Time start_time, Time end_time,
			Time over_time) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.employee_id = employee_id;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.over_time = over_time;
	}

	public TimeBean(int id, Date date, Time start_time, Time end_time, Time over_time) {
		this.id = id;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.over_time = over_time;
	}

	public TimeBean(int id, int employee_id, Date date, Time start_time, Time end_time, Time over_time) {
		this.id = id;
		this.employee_id = employee_id;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.over_time = over_time;
	}

	public TimeBean(int id, int employee_id, Time start_time, Time end_time, Time over_time) {
		this.id = id;
		this.employee_id = employee_id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.over_time = over_time;
	}

	public TimeBean(Date date, Time over_time) {
		this.date = date;
		this.over_time = over_time;
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

	/**
	 * @return employee_id
	 */
	public int getEmployee_id() {
		return employee_id;
	}

	/**
	 * @param employee_id セットする employee_id
	 */
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	/**
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date セットする date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return start_time
	 */
	public Time getStart_time() {
		return start_time;
	}

	/**
	 * @param start_time セットする start_time
	 */
	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}

	/**
	 * @return end_time
	 */
	public Time getEnd_time() {
		return end_time;
	}

	/**
	 * @param end_time セットする end_time
	 */
	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}

	/**
	 * @return over_time
	 */
	public Time getOver_time() {
		return over_time;
	}

	/**
	 * @param over_time セットする over_time
	 */
	public void setOver_time(Time over_time) {
		this.over_time = over_time;
	}
}