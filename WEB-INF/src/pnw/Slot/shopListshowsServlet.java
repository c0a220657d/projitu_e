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

@WebServlet("/Slot/ShopListShowServlet")
public class ShopListShowServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KadaiListShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // HTTP応答のエンコード設定
        response.setContentType("text/html; charset=UTF-8");

        ResultSet rs;
        String forwardURL = "/ex06/kadailist.jsp";
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
                /**
                 * Point: PnwDBをインスタンス化して，かつtestdbに接続する ようにして下さい．また，必要に応じて上にあるimport文で
                 * PnwDBがimportされている状態にしてください．
                 */
                PnwDB db = new PnwDB("testdb");
                	
                String sql = "SELECT * FROM userinfo";
                PreparedStatement stmt = db.getStmt(sql);

                // 実行結果取得
                rs = stmt.executeQuery();
                // データがなくなるまで(rs.next()がfalseになるまで)繰り返す
                int cnt = 0;
                ArrayList<UserInfoBean> infoArray = new ArrayList<UserInfoBean>();
                while (rs.next()) {
                    // カラムの値を取得する．
                    int id = rs.getInt("id");
                    String uid = rs.getString("userid");
                    String pass = rs.getString("password");
                    // beanを生成
                    UserInfoBean bean = new UserInfoBean(uid, pass);
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