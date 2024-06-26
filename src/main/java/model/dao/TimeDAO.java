package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import model.entity.TimeBean;

public class TimeDAO {
	/**
	 * timeリスト取得する
	 * @return timeリスト
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<TimeBean> getTimeList() throws ClassNotFoundException, SQLException {
		// リストの初期化
		List<TimeBean> timeList = new ArrayList<>();

		// SQL文
		String sql = "SELECT id, employee_id, date, start_time, end_time, over_time FROM time";

		// データベース接続
		// PreparedStatementでSQL実行の準備
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// SQL実行し、実行結果の表と現在の行を指しているカーソルを取得
			ResultSet res = pstmt.executeQuery();

			// 実行結果の表から順番に値を取得
			// nextでカーソルを1行ずつ移動させる
			while (res.next()) {
				int id = res.getInt("id");
				int employee_id = res.getInt("employee_id");
				Date date = res.getDate("date");
				Time start_time = res.getTime("start_time");
				Time end_time = res.getTime("end_time");
				Time over_time = res.getTime("over_time");

				// DBから取得した値を初期値として、TimeBeanのインスタンス生成
				TimeBean todo = new TimeBean(id, employee_id, date, start_time, end_time, over_time);

				// timeListにインスタンスを追加
				timeList.add(todo);
			}
		}
		return timeList;
	}

	/**
	 * 日付を指定したtimeリスト取得する
	 * @return timeリスト
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<TimeBean> searchTimeList(Date date) throws ClassNotFoundException, SQLException {
		// リストの初期化
		List<TimeBean> timeList = new ArrayList<>();

		// SQL文
		String sql = "SELECT id, employee_id, date, start_time, end_time, over_time FROM time WHERE date = ?";

		// データベース接続
		// PreparedStatementでSQL実行の準備
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// 1つ目のプレースホルダーに引数dateの値をセット
			pstmt.setDate(1, date);

			// SQL実行し、実行結果の表と現在の行を指しているカーソルを取得
			ResultSet res = pstmt.executeQuery();

			// 実行結果の表から順番に値を取得
			// nextでカーソルを1行ずつ移動させる
			while (res.next()) {
				int id = res.getInt("id");
				int employee_id = res.getInt("employee_id");
				Time start_time = res.getTime("start_time");
				Time end_time = res.getTime("end_time");
				Time over_time = res.getTime("over_time");

				// DBから取得した値を初期値として、TimeBeanのインスタンス生成
				TimeBean todo = new TimeBean(id, employee_id, start_time, end_time, over_time);

				// timeListにインスタンスを追加
				timeList.add(todo);
			}
		}
		return timeList;
	}

	/**
	 * 勤怠データを登録する
	 * @return count
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int register(int employee_id, Date date, Time start_time, Time end_time, Time over_time)
			throws ClassNotFoundException, SQLException {
		int count = 0; // 登録件数を格納する変数

		// SQL文（プレースホルダー2つ）
		String sql = "INSERT INTO time(employee_id, date, start_time, end_time, over_time) VALUES(?, ?, ?, ?, ?)";

		// データベース接続
		// PreparedStatementでSQL実行の準備
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// 1つ目のプレースホルダーに引数employee_idの値をセット
			pstmt.setInt(1, employee_id);
			// 2つ目のプレースホルダーに引数dateの値をセット
			pstmt.setDate(2, date);
			// 3つ目のプレースホルダーに引数start_timeの値をセット
			pstmt.setTime(3, start_time);
			// 4つ目のプレースホルダーに引数end_timeの値をセット
			pstmt.setTime(4, end_time);
			// 5つ目のプレースホルダーに引数over_timeの値をセット
			pstmt.setTime(5, over_time);

			// SQL実行し、登録件数をcountに代入
			count = pstmt.executeUpdate();
		}
		return count;
	}

	/**
	 * 指定した勤怠データを1件取得する
	 * @return time
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public TimeBean getTimeOne(int id) throws ClassNotFoundException, SQLException {
		// time情報を格納する変数
		TimeBean time = null;

		// SQL文（プレースホルダー1つ）
		String sql = "SELECT id, date, start_time, end_time, over_time FROM time WHERE id = ?";

		// データベース接続
		// PreparedStatementでSQL実行の準備
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// 1つ目のプレースホルダーに引数idの値をセット
			pstmt.setInt(1, id);

			// SQL実行し、実行結果の表と現在の行を指しているカーソルを取得
			ResultSet res = pstmt.executeQuery();

			// 実行結果の表からtweetテーブルの値を取得
			if (res.next()) {
				Date date = res.getDate("date");
				Time start_time = res.getTime("start_time");
				Time end_time = res.getTime("end_time");
				Time over_time = res.getTime("over_time");

				// DBから取得した値を初期値として、TimeBeanのインスタンス生成
				time = new TimeBean(id, date, start_time, end_time, over_time);
			}
		}
		return time;
	}

	/**
	 * 勤怠データを編集する
	 * @return count
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int edit(int id, Date date, Time start_time, Time end_time, Time over_time)
			throws ClassNotFoundException, SQLException {
		int count = 0; // 更新件数を格納する変数

		// SQL文（プレースホルダー3つ）
		String sql = "UPDATE time SET date = ?, start_time = ?, end_time = ?, over_time = ? WHERE id = ?";

		// データベース接続
		// PreparedStatementでSQL実行の準備
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setDate(1, date);
			pstmt.setTime(2, start_time);
			pstmt.setTime(3, end_time);
			pstmt.setTime(4, over_time);
			pstmt.setInt(5, id);

			// SQL実行し、更新件数をcountに代入
			count = pstmt.executeUpdate();
		}
		return count;
	}

	/**
	 * 残業時間を取得する
	 * @return overリスト
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<TimeBean> over(int employee_id) throws ClassNotFoundException, SQLException {
		// リストの初期化
		List<TimeBean> overList = new ArrayList<>();

		// SQL文
		String sql = "SELECT date, over_time FROM time WHERE employee_id = ?";

		// データベース接続
		// PreparedStatementでSQL実行の準備
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, employee_id);

			// SQL実行し、実行結果の表と現在の行を指しているカーソルを取得
			ResultSet res = pstmt.executeQuery();

			// 実行結果の表から順番に値を取得
			// nextでカーソルを1行ずつ移動させる
			while (res.next()) {
				Date date = res.getDate("date");
				Time over_time = res.getTime("over_time");

				// DBから取得した値を初期値として、TimeBeanのインスタンス生成
				TimeBean todo = new TimeBean(date, over_time);

				// overListにインスタンスを追加
				overList.add(todo);
			}
		}
		return overList;
	}

	/**
	 * 勤怠データを削除する
	 * @return count
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int count = 0; // 削除件数を格納する変数

		// SQL文（プレースホルダー1つ）
		String sql = "DELETE FROM time WHERE id = ?";

		// データベース接続
		// PreparedStatementでSQL実行の準備
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// 1つ目のプレースホルダーに引数idの値をセット
			pstmt.setInt(1, id);

			// SQL実行し、削除件数をcountに代入
			count = pstmt.executeUpdate();
		}
		return count;
	}
}