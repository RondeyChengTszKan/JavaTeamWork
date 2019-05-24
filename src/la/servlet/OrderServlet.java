package la.servlet;

import la.bean.CartBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if (session == null) { // セッションオブジェクトなし
            request.setAttribute("msg", "セッションが切れています。もう一度トップページより操作してください。");
            gotoPage(request, response, "/shopping/errInternal.jsp");
            return;
        }
        CartBean cart = (CartBean) session.getAttribute("cart");
        if (cart == null) { // カートがない
            request.setAttribute("mse", "正しく操作してください。");
            gotoPage(request, response, "/shopping/errInternal.jsp");
            return;
        }

//        try {
//            // パラメータの解析
//            String action = request.getParameter("action");
//            // input_customerまたはパラメータなしの場合は顧客情報入力ページを表示
//            if (action == null || action.length() == 0 || action.equals("input_customer")) {
//                gotoPage(request, response, "/shopping/customerInfo.jsp");
//                // confirmは確認処理を行う
//            } else if (action.equals("confirm")) {
//                CustomerBean bean = new CustomerBean();
//                bean.setName(request.getParameter("name"));
//                bean.setAddress(request.getParameter("address"));
//                bean.setTel(request.getParameter("tel"));
//                bean.setEmail(request.getParameter("email"));
//                session.setAttribute("customer", bean);
//                gotoPage(request, response, "/shopping/confirm.jsp");
//                // orderは注文確定
//            } else if (action.equals("order")) {
//                CustomerBean customer = (CustomerBean) session.getAttribute("customer");
//                if (customer == null) { // 顧客情報がない
//                    request.setAttribute("msg", "正しく操作してください。");
//                    gotoPage(request, response, "/shopping/errInternal.jsp");
//                }
//
//                OrderDAO order = new OrderDAO();
//                int orderNumber = order.saveOrder(customer, cart);
//                // 注文後はセッション情報をクリアする
//                session.removeAttribute("cart");
//                session.removeAttribute("customer");
//                // 注文番号をクライアントへ送る
//                request.setAttribute("orderNumber", orderNumber);
//                gotoPage(request, response, "/shopping/order.jsp");
//            } else { // actionの値が不正
//                request.setAttribute("message", "正しく操作してください。");
//                gotoPage(request, response, "/shopping/errInternal.jsp");
//            }
//        } catch (DAOException e) {
//            e.printStackTrace();
//            request.setAttribute("message", "内部エラーが発生しました。");
//            gotoPage(request, response, "/shopping/errInternal.jsp");
//        }
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
