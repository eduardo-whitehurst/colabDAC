package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.PecaDao;
import br.com.colabdac.colabdac.entities.Peca;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BuscarTodasPecas implements Logica{
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        PecaDao pecaDao;

        try {
            pecaDao = new PecaDao();

            List<Peca> pecas = pecaDao.listarTodos();
            req.setAttribute("pecas", pecas);

            RequestDispatcher rd = req.getRequestDispatcher("pagina-pecas.jsp");
            rd.forward(req, res);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}