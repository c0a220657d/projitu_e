package pnw.Slot;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserEntryServlet")
public class UserEntryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String dateBirth = request.getParameter("dateBirth");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // JDBCドライバのロード
            Class.forName("com.mysql.cj.jdbc.Driver");

            // データベース接続
            String dbUrl = "jdbc:mysql://localhost:3306/2024e";
            String dbUser = "root";
            String dbPassword = "password"; // 自分のDBパスワードに変更してください
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // SQL文の作成
            String sql = "INSERT INTO user_management (user_name, password, date_birth) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setString(3, dateBirth);

            // SQLの実行
            int result = pstmt.executeUpdate();
            if (result > 0) {
                response.sendRedirect("user_entry_success.jsp"); // 登録成功後のリダイレクト先
            } else {
                response.sendRedirect("user_entry_failure.jsp"); // 登録失敗後のリダイレクト先
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("user_entry_failure.jsp"); // エラー時のリダイレクト先
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
