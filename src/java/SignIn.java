
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.servlet.login;

/**
 *
 * @author om
 */
public class SignIn extends HttpServlet {

    login objLogin;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        objLogin = new login();
        Boolean isLogin = objLogin.authorizeUser(request.getParameter("txtUserName"), request.getParameter("txtPassword"));
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title></title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+(isLogin?"correct user name and password":"either user name or passowrd is wrong")+ "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
