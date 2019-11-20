package controller;


import repository.AuthenticateDaoImpl;
import repository.UserDaoImpl;
import repository.Users_rolesDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "DeleteServlet", urlPatterns = {"/delete", "/on", "/off"})
public class DeleteServlet extends HttpServlet {
    private final UserDaoImpl userDao = new UserDaoImpl();
    private final AuthenticateDaoImpl authDao = new AuthenticateDaoImpl();
    private final Users_rolesDaoImpl user_role = new Users_rolesDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String type = request.getParameter("type");
        long id = Long.parseLong(request.getParameter("id"));
        HttpSession session = request.getSession();

        if (action.toLowerCase().equals("delete")) {
            userDao.delete(id);
            authDao.delete(id);
            user_role.delete(id);
        } else if (action.toLowerCase().equals("on")) {
            session.setAttribute("authenticate", authDao.authOn(id));

        } else if (action.toLowerCase().equals("off")) {
            if (type.toLowerCase().equals("block")) {
                session.setAttribute("authenticate", authDao.authBlock(id));
            } else if (type.toLowerCase().equals("off")) {
                session.setAttribute("authenticate", authDao.authOff(id));
            }
        }

        session.setAttribute("users", userDao.getAll());
        session.setAttribute("authent", authDao.getAll());

        getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
    }


}
