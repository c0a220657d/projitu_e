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

import org.w3c.dom.Text;

import pnw.common.PnwDB;

import javax.servlet.RequestDispatcher;

@WebServlet("/Slot/ShopListShowServlet")
public class ShopListShowServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopListShowServlet() {
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
        ResultSet item_rs;
        String forwardURL = "/Slot/shop_buy.jsp";
        /**
         * Point: リクエストからセッションを取得するように埋めて下さい．
         */
        //HttpSession session = request.getSession();
        /**
         * Point: セッションにもしuserlistというキーに対応する値があれば，という条件を書いて下さい． ヒント:
         * userlistというキーで値を取得しようとしたが（sessionのメソッドを使う），それがnullでないならば
         */

        try {
            /**
             * Point: PnwDBをインスタンス化して，かつtestdbに接続する ようにして下さい．また，必要に応じて上にあるimport文で
             * PnwDBがimportされている状態にしてください．
             */
            PnwDB db = new PnwDB("2024e");
            
            String sql = "SELECT * FROM shop_db";
            String item_sql = "SELECT item_name FROM item_db WHERE item_id = ?";
            PreparedStatement stmt = db.getStmt(sql);
            PreparedStatement item_stmt = db.getStmt(item_sql);

            // 実行結果取得
            rs = stmt.executeQuery();
            // データがなくなるまで(rs.next()がfalseになるまで)繰り返す
            int cnt = 0;
            ArrayList<ShopInfoBean> infoArray = new ArrayList<ShopInfoBean>();
            while (rs.next()) {
                // カラムの値を取得する．
                int id = rs.getInt("user_id");
                int itemid = rs.getInt("item_id");
                int itemprice = rs.getInt("item_price");
                int goodsid = rs.getInt("goods_id");
                // beanを生成
                ShopInfoBean bean = new ShopInfoBean(id,itemid,itemprice,goodsid);
                //item_rs = item_stmt.executeQuery(item_sql);
                //System.out.println("aaaaaaaaaaaaaaa");
                // bean.setID(id);
                // Listへbeanを追加する．
                infoArray.add(bean);
                // 見つかった
                cnt++;
            }
            for (ShopInfoBean info : infoArray) {
                item_stmt.setInt(1,info.getItemID());
                System.out.println(info.getItemID());
                item_rs = item_stmt.executeQuery();
                while (item_rs.next()) {
                    String item_name = item_rs.getString("item_name");
                    info.setItemName(item_name);
                }
                
            }
            /**
             * Point: sessionへ，userlistという名前でinfoArrayをセットしてください．
             */
            request.setAttribute("shoplist", infoArray);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println();
        }
        // 外部ファイルに転送する準備
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
        // 外部ファイルに表示処理を任せる
        dispatcher.forward(request, response);
        System.out.println("World!");
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