package la.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import la.servlet.model.Customer;
import la.bean.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession(false);
        Customer bean=new Customer();
        bean.setName(request.getParameter("userName"));
        String pass=request.getParameter("passWord");

        if(session==null||session.getAttribute("Login")==null){
            LoginCheckBean lcb=new LoginCheckBean();
            if(lcb.getCustomer(bean,pass)!=null){
                request.setAttribute("bean",bean);
                RequestDispatcher rd=request.getRequestDispatcher("/showItem.jsp");
                rd.forward(request,response);
                session.setAttribute("Login",bean);
            }
            else{
                request.setAttribute("bean",bean);
                RequestDispatcher rd=request.getRequestDispatcher("/showError.jsp");
                rd.forward(request,response);
            }
        }else{
            bean=(Customer)session.getAttribute("Login");
            request.setAttribute("bean",bean);
            RequestDispatcher rd=request.getRequestDispatcher("/showError.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
