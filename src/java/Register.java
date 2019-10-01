
import com.servlet.login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author om
 */
public class Register extends HttpServlet {

    login register;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        register = new login();
        int IsRegsistered = register.RegisterUser(request.getParameter("txtFirstName"), request.getParameter("txtLastName"), request.getParameter("txtEmailId"), request.getParameter("txtPassword"), request.getParameter("txtDOB"), request.getParameter("txtGender"), request.getParameter("txtMobile"));
        if(IsRegsistered>0)
        {
            HttpSession Session =request.getSession();
            Session.setAttribute("UserName", request.getParameter("txtFirstName"));
            response.sendRedirect("./Welcome");
        }
        
    }

}
