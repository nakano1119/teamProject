package servlet;

import java.io.IOException;
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
 * Servlet implementation class OverServlet
 */
@WebServlet("/over")
public class OverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OverServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("over-list.jsp");
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
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));

		// timeデータを格納する変数
		List<TimeBean> overList = null;
		String error = "";

		// TimeDAOクラスのインスタンス生成
		TimeDAO dao = new TimeDAO();

		try {
			// TimeDAOクラスのoverメソッド呼び出し、残業データ取得
			overList = dao.over(employeeId);
			if (overList.isEmpty()) {
				error = "該当の従業員が存在しません。";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// リクエストスコープに残業データをセット
		request.setAttribute("overList", overList);

		// 転送
		request.setAttribute("error", error);
		RequestDispatcher rd = request.getRequestDispatcher("over-list.jsp");
		rd.forward(request, response);
	}

}
