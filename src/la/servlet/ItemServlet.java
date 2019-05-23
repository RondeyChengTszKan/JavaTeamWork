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

public class ItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

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

    }
}
