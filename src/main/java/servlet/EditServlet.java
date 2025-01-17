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
import model.entity.TimeBean;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		int id = Integer.parseInt(request.getParameter("id"));

		// timeデータを格納する変数
		TimeBean time = null;

		// TimeDAOクラスのインスタンス生成
		TimeDAO dao = new TimeDAO();

		try {
			// TimeDAOクラスのgetTimeOneメソッド呼び出し、勤怠データ取得
			time = dao.getTimeOne(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// リクエストスコープにtweetデータをセット
		request.setAttribute("time", time);

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		int id = Integer.parseInt(request.getParameter("id"));
		Date date = Date.valueOf(request.getParameter("date"));
		Time startTime = Time.valueOf(request.getParameter("startTime") + ":00");
		Time endTime = Time.valueOf(request.getParameter("endTime") + ":00");
		Time overTime = Time.valueOf(request.getParameter("overTime") + ":00");

		// TimeDAOクラスのインスタンス生成
		TimeDAO dao = new TimeDAO();

		try {
			// TimeDAOクラスのeditメソッド呼び出し、勤怠データ更新
			dao.edit(id, date, startTime, endTime, overTime);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("list");
		rd.forward(request, response);
	}

}
