package br.com.colabdac.colabdac.servlets;

import br.com.colabdac.colabdac.logica.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cadastraFuncionarios", "/listaFuncionarios", "/editaFuncionarios", "/selecionaFuncionarios", "/removeFuncionarios"})
public class FuncionarioServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute("sessionToken");
        if (sessionToken != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/Funcionario.html");
            response.getWriter().append("Served at: ").append(request.getContextPath());
            String action = request.getServletPath();

            if(action.equals("/listaFuncionarios")){
                funcionarios(request, response);
            } else if (action.equals("/editaFuncionarios")) {
                editar(request, response);
            } else if (action.equals("/selecionaFuncionarios")) {
                selecionarPorId(request, response);
            } else if (action.equals("/removeFuncionarios")) {
                remover(request, response);
            }else if (action.equals("/cadastraFuncionarios")) {
                dispatcher = request.getRequestDispatcher("pages/Form-funcionario.html");
                dispatcher.forward(request, response);
            } else {
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/login.jsp");
            dispatcher.forward(request, response);
        }


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getServletPath();
        if (action.equals("/cadastraFuncionarios")) {
            criarFuncionarios(request, response);
        }
    }


    public void criarFuncionarios(HttpServletRequest request, HttpServletResponse response) {
        CriarFuncionario criarFuncionario = new CriarFuncionario();
        try {
            criarFuncionario.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void funcionarios(HttpServletRequest request, HttpServletResponse response) {
        ListarFuncionarios buscarTodos = new ListarFuncionarios();

        try {
            buscarTodos.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void editar(HttpServletRequest request, HttpServletResponse response) {
        EditarFuncionario editarFuncionario = new EditarFuncionario();

        try {
            editarFuncionario.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selecionarPorId(HttpServletRequest request, HttpServletResponse response) {
        BuscarPorIdFuncionario buscarPorId = new BuscarPorIdFuncionario();

        try {
            buscarPorId.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remover(HttpServletRequest request, HttpServletResponse response) {
        DeletarFuncionario deletarPorId = new DeletarFuncionario();

        try {
            deletarPorId.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
