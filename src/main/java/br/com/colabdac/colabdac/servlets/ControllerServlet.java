package br.com.colabdac.colabdac.servlets;

import br.com.colabdac.colabdac.logica.Logica;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.ExceptionListener;
import java.io.IOException;

@SuppressWarnings("serial")
public class ControllerServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String parametro = req.getParameter("logica");
        String nomeClasse = "br.com.colabdac.colabdac.servlets." + parametro;

        try {
            Class classe = Class.forName(nomeClasse);

            Logica logica = (Logica) classe.newInstance();
            logica.executa(req, res);
        } catch(Exception e) {
            throw new ServletException("Houve um erro: ", e);
        }
    }

}
