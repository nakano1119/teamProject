package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TimeDAO;
import model.entity.TimeBean;

/**
 * Servlet implementation class SearchListServlet
 */
@WebServlet("/search-list")
public class SearchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("search-list.jsp");
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
		Date date = Date.valueOf(request.getParameter("date"));

		// timeデータを格納する変数
		List<TimeBean> timeList = null;
		String error = "";

		// TimeDAOクラスのインスタンス生成
		TimeDAO dao = new TimeDAO();

		try {
			// TimeDAOクラスのsearchTimeListメソッド呼び出し、勤怠データ取得
			timeList = dao.searchTimeList(date);
			if (timeList.isEmpty()) {
				error = "勤怠情報が登録されていません。";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// リクエストスコープに勤怠データをセット
		request.setAttribute("timeList", timeList);

		// 転送
		request.setAttribute("error", error);
		RequestDispatcher rd = request.getRequestDispatcher("search-list.jsp");
		rd.forward(request, response);
	}

}
