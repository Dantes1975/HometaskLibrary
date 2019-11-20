import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogServlet", urlPatterns = {"/login", "/registr", "/add", "/delete"}, initParams = {
        @WebInitParam(description = "fusername", name = "fusername", value = "admin"),
        @WebInitParam(description = "fuserpassword", name = "fuserpassword", value = "1"),
        @WebInitParam(description = "susername", name = "susername", value = "admin1"),
        @WebInitParam(description = "suserpassword", name = "suserpassword", value = "1"),
})


public class LogServlet extends HttpServlet {
    UserDAO userDAO = UserDAO.getInstance();

    @Override
    public void init() throws ServletException {

        String fusername = getInitParameter("fusername");
        String fuserpassword = getInitParameter("fuserpassword");
        String susername = getInitParameter("susername");
        String suserpassword = getInitParameter("suserpassword");
        userDAO.add(new User(fusername, fuserpassword, Roles.ADMIN));
        userDAO.add(new User(susername, suserpassword, Roles.ADMIN));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String log = req.getParameter("login");
        String pass = req.getParameter("password");
        String action = req.getParameter("action");
        String role = req.getParameter("role");
        User user = null;
        ServletContext servletContext = req.getServletContext();
        HttpSession session = req.getSession();

        if (action.toLowerCase().equals("registr")) {
            if (userDAO.isUserExist(log, pass) == true) {
                session.setAttribute("user", userDAO.getUser(log, pass));
                session.setAttribute("users", userDAO.userList());
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/admin.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/login.jsp");
                requestDispatcher.forward(req, resp);
            }
        }


        if (action.toLowerCase().equals("login")) {
            user = new User(log, pass, Roles.USER);
            userDAO.add(user);
            session.setAttribute("user", user);
            session.setAttribute("users", userDAO.userList());
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/admin.jsp");
            requestDispatcher.forward(req, resp);
        }

        if (action.toLowerCase().equals("add")) {
            if (role.equals("USER")) {
                user = new User(log, pass, Roles.USER);
                userDAO.add(user);
            } else if (role.equals("ADMIN")) {
                user = new User(log, pass, Roles.ADMIN);
                userDAO.add(user);
            }
            session.setAttribute("user", user);
            session.setAttribute("users", userDAO.userList());
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/admin.jsp");
            requestDispatcher.forward(req, resp);
        }

        if (action.toLowerCase().equals("delete")) {
            userDAO.delete(userDAO.getUser(log, pass));
            session.setAttribute("users", userDAO.userList());
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/admin.jsp");
            requestDispatcher.forward(req, resp);
        }

    }

}

