package pnw.Slot;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pnw.common.PnwDB;

import javax.servlet.RequestDispatcher;

@WebServlet("/Slot/RankingServlet")
public class RankingServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // HTTP応答のエンコード設定
        response.setContentType("text/html; charset=UTF-8");

        ResultSet rs;
        String forwardURL = "/Slot/ranking.jsp";
        /**
         * Point: リクエストからセッションを取得するように埋めて下さい．
         */
        HttpSession session = request.getSession();
        /**
         * Point: セッションにもしuserlistというキーに対応する値があれば，という条件を書いて下さい． ヒント:
         * userlistというキーで値を取得しようとしたが（sessionのメソッドを使う），それがnullでないならば
         */
        if ( session.getAttribute("userlist") != null) {
        } else {
            
            // nullなら，DBから取得する．
            try {
                PnwDB db = new PnwDB("2024e");
                	
                String sql = "SELECT * FROM user_management ORDER BY point DESC LIMIT 5;";
                PreparedStatement stmt = db.getStmt(sql);

                // 実行結果取得
                rs = stmt.executeQuery();
                // データがなくなるまで(rs.next()がfalseになるまで)繰り返す
                int cnt = 0;
                ArrayList<UserPointBean> infoArray = new ArrayList<UserPointBean>();
                while (rs.next()) {
                    // カラムの値を取得する．
                    String id = rs.getString("user_name");
                    int point = rs.getInt("point");
                    // beanを生成
                    UserPointBean bean = new UserPointBean(id, point);
                    bean.setID(id);
                    // Listへbeanを追加する．
                    infoArray.add(bean);
                    // 見つかった
                    cnt++;
                }
                /**
                 * Point: sessionへ，userlistという名前でinfoArrayをセットしてください．
                 */
                session.setAttribute("userlist", infoArray);

            } catch (Exception e) {
                e.printStackTrace();
            }
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



