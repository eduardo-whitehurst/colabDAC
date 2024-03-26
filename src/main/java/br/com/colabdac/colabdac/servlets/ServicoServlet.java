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

@WebServlet(urlPatterns = {"/cadastraServico", "/listaServico", "/editarServico", "/selectServico", "/selectDelServico"})
public class ServicoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute("sessionToken");
        if (sessionToken != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/Servico.html");

            response.getWriter().append("Served at: ").append(request.getContextPath());
            String action = request.getServletPath();

            if(action.equals("/listaServico")){
                servicos(request, response);
            } else if (action.equals("/editarServico")) {
                editar(request, response);
            } else if (action.equals("/selectServico")) {
                selecionarPorId(request, response);
            } else if (action.equals("/selectDelServico")) {
                remover(request, response);
            } else if (action.equals("/cadastraServico")) {
                RequestDispatcher dispatcher1 = request.getRequestDispatcher("pages/adiciona-servico.html");
                dispatcher1.forward(request, response);
            } else {

                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/login.jsp");
            dispatcher.forward(request, response);
        }

    }

    protected void servicos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuscarTodosServicos buscarTodos = new BuscarTodosServicos();

        try {
            buscarTodos.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        if(action.equals("/cadastraServico")) {
            cadastrar(request, response);
        }
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) {
        EditarServico editarServico = new EditarServico();

        try {
            editarServico.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selecionarPorId(HttpServletRequest request, HttpServletResponse response) {
        BuscarPorIdServico buscarPorIdServico = new BuscarPorIdServico();

        try {
            buscarPorIdServico.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastrar(HttpServletRequest request, HttpServletResponse response) {
        AdicionarServico addServico = new AdicionarServico();
        try {
            addServico.executa(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(HttpServletRequest request, HttpServletResponse response) {
        DeletarServico deletarServico = new DeletarServico();

        try {
            deletarServico.executa(request, response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
