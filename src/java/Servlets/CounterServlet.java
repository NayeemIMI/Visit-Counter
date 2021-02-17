package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import Beans.Counter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CounterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher Dispatch = request.getRequestDispatcher("VisitCounter");
        Dispatch.include(request, response); 
        HttpSession Session = request.getSession(true);
        Counter Count = (Counter)Session.getAttribute("Count");          
        PrintWriter out = response.getWriter();
        
        out.println("<html><head>");
        out.println("<title>Access Counter!</title>");            
        out.println("</head><body>");
        out.print("<h1 align=center style=\"color:green;\">" + request.getAttribute("Text"));
        if(!Session.isNew()){
        out.print(Count.GetCount() + " times.</h1>");
        }
        out.println("</body></html>");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}