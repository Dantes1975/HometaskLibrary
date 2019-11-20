package controller;

import bean.Authenticate;
import bean.Role;
import bean.User;
import bean.Users_roles;
import repository.AuthenticateDaoImpl;
import repository.RoleDaoImpl;
import repository.UserDaoImpl;
import repository.Users_rolesDaoImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AuthenticateServlet", urlPatterns = {"/auth", "/guest"})

public class AuthenticateServlet extends HttpServlet {

    private final AuthenticateDaoImpl authenticateDao = new AuthenticateDaoImpl();
    private final Users_rolesDaoImpl users_rolesDao = new Users_rolesDaoImpl();
    private final RoleDaoImpl roleDao = new RoleDaoImpl();
    private final UserDaoImpl userDao = new UserDaoImpl();
    private Authenticate aut;
    private Role role;
    private User user;
    private Users_roles users_roles;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Authenticate> authenticateList = authenticateDao.getAll();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String action = request.getParameter("action");
        HttpSession session = request.getSession();


        if (action.toLowerCase().equals("login")) {
            if (login == null || login.isEmpty()) {
                throw new RuntimeException("Invalid User Login");
            } else if (password == null || password.isEmpty()) {
                throw new RuntimeException("Invalid User Password");
            } else {

                aut = authenticateDao.getByLogin(login);

                if (aut != null) {
                    if (login.equals(aut.getLogin()) && password.equals(aut.getPassword())) {
                        user = userDao.getById(aut.getId());
                        users_roles = users_rolesDao.getByUserID(user.getId());
                        role = roleDao.getById(users_roles.getRole_id());

                        session.setAttribute("authenticate", aut);
                        session.setAttribute("user", user);
                        session.setAttribute("role", role);
                        session.setAttribute("authent", authenticateList);


                        getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);


                    } else {
                        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                    }
                } else {
                    getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                }

            }
        }
        if (action.toLowerCase().equals("guest")) {
            request.setAttribute("list", "books not found");
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        }
    }
}


