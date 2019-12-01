package controller;


import repository.daoImpl.AuthenticateDaoImpl;
import repository.daoImpl.BorrowDaoImpl;
import repository.daoImpl.UserDaoImpl;
import repository.daoImpl.Users_rolesDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static utill.ApplicationConstants.*;


@WebServlet(name = "DeleteServlet", urlPatterns = {"/delete", "/on", "/off"})
public class OperationWhithUserServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDaoImpl userDao = new UserDaoImpl();
        AuthenticateDaoImpl authDao = new AuthenticateDaoImpl();
        Users_rolesDaoImpl user_role = new Users_rolesDaoImpl();
        BorrowDaoImpl borrowDao = new BorrowDaoImpl();
        String action = request.getParameter(ACTION_KEY);
        String type = request.getParameter(TYPE_KEY);
        long id = Long.parseLong(request.getParameter(ID_KEY));
        HttpSession session = request.getSession();

        if (action.toLowerCase().equals(DELETE_KEY)) {
            userDao.delete(id);
            authDao.delete(id);
            user_role.delete(id);
        } else if (action.toLowerCase().equals(ON_KEY)) {
            session.setAttribute(AUTHENTICATE_KEY, authDao.authOn(id));
        } else if (action.toLowerCase().equals(OFF_KEY)) {
            if (type.toLowerCase().equals(BLOCK_KEY)) {
                session.setAttribute(AUTHENTICATE_KEY, authDao.authBlock(id));
            } else if (type.toLowerCase().equals(OFF_KEY)) {
                borrowDao.deleteUserById(id);
                session.setAttribute(AUTHENTICATE_KEY, authDao.authOff(id));
            }
        }
        session.setAttribute(USERS_KEY, userDao.getAll());
        session.setAttribute(AUTHENT_KEY, authDao.getAll());
        getServletContext().getRequestDispatcher(ADMIN_JSP).forward(request, response);


    }
}
