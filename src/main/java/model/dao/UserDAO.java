package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class UserDAO {
	/**
	 * ユーザーを認証しログインする
	 * @return user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public UserBean login(String name, String password) throws ClassNotFoundException, SQLException {

		// SQL文
		String sql = "SELECT * FROM user WHERE name = ? AND password = ?";

		// データベース接続
		// PreparedStatementでSQL実行の準備
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// 1つ目のプレースホルダーに引数nameの値をセット
			pstmt.setString(1, name);
			// 2つ目のプレースホルダーに引数passwordの値をセット
			pstmt.setString(2, password);

			// SQL実行
			ResultSet res = pstmt.executeQuery();

			// User情報を取得
			// nextでカーソルを1行ずつ移動させる
			if (res.next()) {
				UserBean user = new UserBean();
				user.setId(res.getInt("id"));
				user.setName(res.getString("name"));
				user.setPassword(res.getString("password"));
				return user;
			} else {
				return null;
			}
		}
	}
}