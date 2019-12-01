package controller;

import bean.Message;
import repository.daoImpl.MessageDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static utill.ApplicationConstants.*;

@WebServlet(name = "MessageServlet", urlPatterns = "/message")
public class MessageServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageDaoImpl messageDao = new MessageDaoImpl();

        long sender = Long.parseLong(request.getParameter(SENDER_KEY));
        long recipient = Long.parseLong(request.getParameter(RECIPIENT_KEY));
        String text = request.getParameter(TEXT_KEY);
        String action = request.getParameter(ACTION_KEY);
        HttpSession session = request.getSession();

        if (action.toLowerCase().equals(SEND_KEY)) {
            Message message = new Message();
            message.setSender(sender);
            message.setRecipient(recipient);
            message.setText(text);
            messageDao.insert(message);
            List<Message> messages = messageDao.getAll();
            session.setAttribute(MESSAGE_KEY, message);
            session.setAttribute(MESSAGES_KEY, messages);
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            try {
                writer.println("<h2>Message send successfully</h2>");
            } finally {
                writer.close();
            }
           // getServletContext().getRequestDispatcher(BOOKS_JSP).forward(request, response);
        } else if (action.toLowerCase().equals(MESSAGES_KEY)) {
            List<Message> mymessages = messageDao.getMyMessages(recipient);
            session.setAttribute(MYMESSAGES_KEY, mymessages);
            getServletContext().getRequestDispatcher(BOOKS_JSP).forward(request, response);
        }
    }


}
