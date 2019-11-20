package controller;

import bean.Book;
import repository.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OperationWhitsBooksServlet", urlPatterns = {"/listbooks", "/takebooks"})
public class OperationWhitsBooksServlet extends HttpServlet {
    private BookDaoImpl bookDao = new BookDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if (action.toLowerCase().equals("list")) {
            List <Book> books = bookDao.getAll();
            session.setAttribute("listbooks", books);
            getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
        }


        getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
    }


}
