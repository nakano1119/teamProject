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
	 * 社員id
	 */
	private int employeeId;

	/**
	 * 日付
	 */
	private Date date;

	/**
	 * 出勤時間
	 */
	private Time startTime;

	/**
	 * 退勤時間
	 */
	private Time endTime;

	/**
	 * 残業時間
	 */
	private Time overTime;

	/**
	 * 引数なしデフォルトコンストラクタ
	 */
	public TimeBean() {
	}

	/**
	 * 引数ありコンストラクタ
	 */
	public TimeBean(int id, int employeeId, Date date, Time startTime, Time endTime,
			Time overTime) {
		this.id = id;
		this.employeeId = employeeId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.overTime = overTime;
	}

	public TimeBean(int id, Date date, Time startTime, Time endTime, Time overTime) {
		this.id = id;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.overTime = overTime;
	}

	public TimeBean(int id, int employeeId, Time startTime, Time endTime, Time overTime) {
		this.id = id;
		this.employeeId = employeeId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.overTime = overTime;
	}

	public TimeBean(Date date, Time overTime) {
		this.date = date;
		this.overTime = overTime;
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
	 * @return employee_id
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employee_id セットする employee_id
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public Time getStartTime() {
		return startTime;
	}

	/**
	 * @param start_time セットする start_time
	 */
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return end_time
	 */
	public Time getEndTime() {
		return endTime;
	}

	/**
	 * @param end_time セットする end_time
	 */
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return over_time
	 */
	public Time getOverTime() {
		return overTime;
	}

	/**
	 * @param over_time セットする over_time
	 */
	public void setOverTime(Time overTime) {
		this.overTime = overTime;
	}
}