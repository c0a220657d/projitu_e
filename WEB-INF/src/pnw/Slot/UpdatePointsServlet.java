package pnw.Slot;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pnw.common.PnwDB;
import javax.servlet.RequestDispatcher;

@WebServlet("/UpdatePointsServlet")
public class UpdatePointsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Fetch current points from session
        int currentPoints = (int) session.getAttribute("Point");
        int user_id = (int)session.getAttribute("UserID");

        try{
            PnwDB db = new PnwDB("2024e");
            String sql = "UPDATE user_management SET point=?, WHERE user_id=?";
            PreparedStatement stmt = db.getStmt(sql);
            stmt.setInt(1, currentPoints);
            stmt.setInt(2, user_id);
            int ret2 = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally{
            System.out.println();
        }
        session.setAttribute("Point", currentPoints);
        request.getRequestDispatcher("/Slot/home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
