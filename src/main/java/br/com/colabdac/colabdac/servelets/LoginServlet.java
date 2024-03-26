package br.com.colabdac.colabdac.servelets;

import br.com.colabdac.colabdac.controllers.LoginController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private final LoginController loginController = new LoginController();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute("sessionToken");
        if (sessionToken != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        boolean isLoginSuccessful = false;
        try {
            isLoginSuccessful = loginController.login(email, senha);
            System.out.println(isLoginSuccessful);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        if (isLoginSuccessful) {
            String sessionToken = "logado";
            HttpSession session = request.getSession();
            session.setAttribute("sessionToken", sessionToken);
            response.sendRedirect("home");
        } else {
            response.sendRedirect("login");
        }
    }
    public void destroy() {
    }
}
