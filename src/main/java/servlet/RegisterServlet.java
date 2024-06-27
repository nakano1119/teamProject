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
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		Date date = Date.valueOf(request.getParameter("date"));
		Time startTime = Time.valueOf(request.getParameter("startTime") + ":00");
		Time endTime = Time.valueOf(request.getParameter("endTime") + ":00");
		Time overTime = Time.valueOf(request.getParameter("overTime") + ":00");

		// TimeDAOクラスのインスタンス生成
		TimeDAO dao = new TimeDAO();

		try {
			// TimeDAOクラスregisterメソッドにemployee_id, date, start_time, end_time, over_timeを渡しデータベース登録
			dao.register(employeeId, date, startTime, endTime, overTime);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("list");
		rd.forward(request, response);
	}
}