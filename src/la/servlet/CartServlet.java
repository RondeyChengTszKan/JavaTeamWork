package la.servlet;

import la.bean.CartBean;
import la.servlet.model.OrderItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");
            if (action == null || action.length() == 0 || action.equals("show")) {
                gotoPage(request, response, "/showCart.jsp");
            } else if (action.equals("add")) {
                int id = Integer.parseInt(request.getParameter("item_id"));
                HttpSession session = request.getSession(true);
                CartBean cart = (CartBean) session.getAttribute("cart");
                if (cart == null) {
                    cart = new CartBean();
                    session.setAttribute("cart", cart);
                }

                OrderItem order = new OrderItem();
                order.setName(request.getParameter("name"));
                order.setPrice(Integer.parseInt(request.getParameter("price")));
                order.setSize(request.getParameter("size"));
                order.setColor(request.getParameter("color"));
                // 個数は今は1
                cart.addCart(order, 1);
                gotoPage(request, response, "/index.jsp");

                // TODO: deteleアクションを作成する
            } else {
                request.setAttribute("message", "正しく操作してください");
                gotoPage(request, response, "/showError.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "内部エラーが発生しました");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private void gotoPage(HttpServletRequest request,HttpServletResponse response, String page)throws ServletException,IOException{
        RequestDispatcher rd=request.getRequestDispatcher(page);
        rd.forward(request,response);
    }
}
