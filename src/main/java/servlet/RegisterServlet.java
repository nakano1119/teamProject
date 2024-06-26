package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TimeDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング
		request.setCharacterEncoding("utf-8");

		// リクエストパラメータの取得
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		Date date = Date.valueOf(request.getParameter("date"));
		Time start_time = Time.valueOf(request.getParameter("start_time") + ":00");
		Time end_time = Time.valueOf(request.getParameter("end_time") + ":00");
		Time over_time = Time.valueOf(request.getParameter("over_time") + ":00");

		// TimeDAOクラスのインスタンス生成
		TimeDAO dao = new TimeDAO();

		try {
			// TimeDAOクラスregisterメソッドにemployee_id, date, start_time, end_time, over_timeを渡しデータベース登録
			dao.register(employee_id, date, start_time, end_time, over_time);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("list");
		rd.forward(request, response);
	}
}