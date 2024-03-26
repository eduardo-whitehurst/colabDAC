package br.com.colabdac.colabdac.servlets;

import br.com.colabdac.colabdac.controllers.UsuarioController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cadastroUsuarioServlet", value = "/cadastro")
public class CadastroUsuarioServlet extends HttpServlet {
    UsuarioController usuarioController = new UsuarioController();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute("sessionToken");
        if (sessionToken != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/cadastro-usuario.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String confirmarSenha = request.getParameter("senha-confirmar");
        boolean hasCreatedAccount = this.usuarioController.criarUsuario(
                email, senha, confirmarSenha
        );
        if (!hasCreatedAccount) {
            PrintWriter out = response.getWriter();
            out.println("<html><body><b>Erro ao criar usuário!</b></body></html>");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);

    }

    public void destroy() {
    }
}
