package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.PecaDao;
import br.com.colabdac.colabdac.entities.Peca;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class BuscarPorIdPeca implements Logica {
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idPeca = req.getParameter("idPeca");
        Long id = Long.parseLong(idPeca);

        PecaDao dao = new PecaDao();

        Peca peca = dao.buscarPorId(id);

        req.setAttribute("idPeca", peca.getId());
        req.setAttribute("nome", peca.getNome());
        req.setAttribute("valor", peca.getValor());

        RequestDispatcher rd = req.getRequestDispatcher("editarPeca.jsp");
        rd.forward(req, res);
    }
}
