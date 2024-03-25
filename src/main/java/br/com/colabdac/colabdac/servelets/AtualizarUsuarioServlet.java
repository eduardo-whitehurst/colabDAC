package br.com.colabdac.colabdac.servelets;

import br.com.colabdac.colabdac.controllers.UsuarioController;
import br.com.colabdac.colabdac.entities.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "atualizarUsuarioServlet", value = "/atualizar")
public class AtualizarUsuarioServlet extends HttpServlet {
    UsuarioController usuarioController = new UsuarioController();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute("sessionToken");
        if (sessionToken != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-usuario.html");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute("sessionToken");
        if (sessionToken != null) {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String novaSenha = request.getParameter("novaSenha");
            String confirmarSenha = request.getParameter("confirmarSenha");
            if (senha == null || novaSenha == null || confirmarSenha == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-usuario.html");
                dispatcher.forward(request, response);
            }
            assert senha != null;
            if (!senha.equals(novaSenha)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-usuario.html");
                dispatcher.forward(request, response);
            }
            if (usuarioController.atualizarUsuario(email, senha)) {
                System.out.println("Usuário atualizado com sucesso!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-usuario.html");
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        }
    }
}
