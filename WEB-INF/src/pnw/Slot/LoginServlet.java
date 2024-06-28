package pnw.Slot;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pnw.common.PnwDB;

import javax.servlet.RequestDispatcher;

@WebServlet("/Slot/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String user_id = request.getParameter("userID");
		String password = request.getParameter("Password");
		String forwardURL = "user_login.jsp";

		ResultSet rs;
        HttpSession session = request.getSession();

		try {
			PnwDB db = new PnwDB("2024e");
			String sql = "SELECT * FROM userinfo where userid=?";
			PreparedStatement stmt = db.getStmt(sql);
			stmt.setInt(1, Integer.parseInt(user_id));
			// 実行結果取得
			rs = stmt.executeQuery();
			//String id = rs.getString("userid");
			String pass = rs.getString("password");
			if (password.equals(pass)) {
                session.setAttribute("UID",user_id);
				forwardURL = "home.jsp";
			} else {
                response.sendRedirect("user_entry_failure.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
            response.sendRedirect("user_entry_failure.jsp");
		}

		// 外部ファイルに転送する準備
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
		// 外部ファイルに表示処理を任せる
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}