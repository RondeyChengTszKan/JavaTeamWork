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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession(false);
 /*       CustomerBean bean=new CustomerBean();
        bean.setName(request.getParameter("name"));
        bean.setPass(request.getParameter("pass"));

        if(session==null||session.getAttribute("Login")==null){
            LoginCheckBean lcb=new LoginCheckBean();
            if(lcb.getCustomer(bean)!=null){
                request.setAttribute("bean",bean);
                RequestDispatcher rd=request.getRequestDispatcher("/loginSuccess.jsp");
                rd.forward(request,response);
                session.setAttribute("Login",bean);
            }
            else{
                request.setAttribute("bean",bean);
                RequestDispatcher rd=request.getRequestDispatcher("/loginFail.jsp");
                rd.forward(request,response);
            }
        }else{
            bean=(CustomerBean)session.getAttribute("Login");
            request.setAttribute("bean",bean);
            RequestDispatcher rd=request.getRequestDispatcher("/loginAlready.jsp");
            rd.forward(request,response);
        }*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
