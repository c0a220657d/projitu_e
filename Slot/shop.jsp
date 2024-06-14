<%@ page contentType="text/html; charset=UTF-8" %>
<html>   
    <head>
        <meta charset="UTF-8">
        <title>shop</title>
    </head>     
<body>
    <table border="1">
        
        <tr>
            <td>ID</td>
            <td>UserID</td>
            <td>Password</td>
        </tr>
        <%
        //Point: Servletから設定されたセッションから，自分で決めたキーでデータを取得し，
        //そしてIteratorにしてください．
        ArrayList<UserInfoBean> list = (ArrayList<UserInfoBean>)session.getAttribute("userlist");
        Iterator<UserInfoBean> ite = list.iterator();
        
        //結果の表示
        while(ite.hasNext()){
            //Point: Iteratorの次の要素をbeanへ格納させてください．
            UserInfoBean bean = ite.next();
        %>
        <%-- HTML内にJSPコードをスクリプト式として埋め込む--%>
            <tr>
            <td><%=bean.getID()%></td>
            <td><%=bean.getUserID()%></td>
            <td><%=bean.getPassword()%></td>
            </tr>
        <%
        }
        %>
        </table>

<a href="home.jsp">戻る</a>
</body>
</html>