package br.com.colabdac.colabdac.servlets;

import br.com.colabdac.colabdac.logica.AdicionaCliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "clienteServerlet", value = "/cadastraCliente")
public class ClienteServerlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("adiciona-cliente.html");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AdicionaCliente addCliente = new AdicionaCliente();
        try {
            addCliente.executa(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
