package Servlets;

import Beans.Counter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VisitCounter extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession Session = request.getSession(true);
        Counter Count = (Counter)Session.getAttribute("Count");
        
        if(Count == null) {
            Count=new Counter();
            Session.setAttribute("Count", Count);
            request.setAttribute("Text", "Welcome New User.");
        }
        else
            request.setAttribute("Text", "Welcome Back! You have visited this website ");
        Count.SetCount();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}