package la.servlet;

import la.servlet.model.Clothes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    public void init() throws ServletException {
        // TODO: initで商品一覧を取得
        List<Clothes> list = new ArrayList<>() {{
            add(new Clothes());
        }};
        list.get(0).setName("JSTシャツ");
        list.get(0).setPrice(3000);
        list.get(0).setImage("1.jpeg");
        list.get(0).setColor("黄色");
        list.get(0).setSize("M");
        getServletContext().setAttribute("clothes", list);

//        try {
//            ClothesDAO dao = new ClothesDAO();
//            List<Clothes> list = dao.findAllClothes();
//            getServletContext().setAttribute("clothes", list);
//        } catch (DAOException e) {
//            e.printStackTrace();
//            throw new ServletException();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            String action = request.getParameter("action");
            if (action == null || action.equals("list") || action.length() == 0) {
                gotoPage(request, response, "/index.jsp");
            } else if (action.equals("show")) {
                int id = Integer.parseInt(request.getParameter("id"));
                // TODO: dao.getById みたいなのする

                // ここからモックデータ
                id = 1;
                Clothes clothe = new Clothes();
                clothe.setSize("S M L");
                clothe.setColor("yellow white");
                clothe.setImage("1.jpeg");
                clothe.setPrice(3000);
                clothe.setName("JSTシャツ");
            } else {
                request.setAttribute("message", "正しく操作してください");
                gotoPage(request, response, "/showError.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "内部エラーが発生しました");
            gotoPage(request, response, "/showError.jsp");
        }
    }
}
