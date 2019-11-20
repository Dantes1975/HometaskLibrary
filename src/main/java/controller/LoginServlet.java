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

@WebServlet(name = "LoginServlet", urlPatterns = {"/login", "/set"})
public class LoginServlet extends HttpServlet {
    private final UserDaoImpl userDao = new UserDaoImpl();
    private final AuthenticateDaoImpl authDao = new AuthenticateDaoImpl();
    private final Users_rolesDaoImpl user_role = new Users_rolesDaoImpl();
    private final RoleDaoImpl roleDao = new RoleDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, RuntimeException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String rol = request.getParameter("role");
        int age = Integer.parseInt(request.getParameter("age"));
        HttpSession session = request.getSession();
        Authenticate auth = new Authenticate();
        Users_roles usrl = new Users_roles();
        User user = new User();
        Role role;


        if (login == null || login.isEmpty()) {
            throw new RuntimeException("Invalid User Login");
        } else if (password == null || password.isEmpty()) {
            throw new RuntimeException("Invalid User Password");
        } else if (name == null || name.isEmpty()) {
            throw new RuntimeException("Invalid User Name");
        } else if (surname == null || surname.isEmpty()) {
            throw new RuntimeException("Invalid User Surname");
        } else if (email == null || email.isEmpty()) {
            throw new RuntimeException("Invalid User Email");
        } else if (age == 0) {
            throw new RuntimeException("Invalid User Age");
        } else {

            if (!authDao.isExistByLogin(login)) {
                auth.setLogin(login);
                auth.setPassword(password);
                authDao.insert(auth);
            } else {
                throw new RuntimeException("This User Login is exist");
            }

            user.setName(name);
            user.setSurname(surname);
            user.setEmail(email);
            user.setAge(age);
            userDao.insert(user);


            usrl.setUser_id(user.getId());


            if (rol.toLowerCase().equals("user")) {
                usrl.setRole_id(2);
            } else if (rol.toLowerCase().equals("admin")) {
                usrl.setRole_id(1);
            }

            user_role.insert(usrl);

            role = roleDao.getById(usrl.getRole_id());


            session.setAttribute("authenticate", auth);
            session.setAttribute("user", user);
            session.setAttribute("role", role);

        }

        session.setAttribute("authent", authDao.getAll());

        getServletContext().getRequestDispatcher("/start.jsp").forward(request, response);
    }

}

