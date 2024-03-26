package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.PecaDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletarPeca implements Logica{

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idPeca = req.getParameter("idPeca");
        Long id = Long.parseLong(idPeca);

        PecaDao dao = new PecaDao();
        dao.remover(id);

        res.sendRedirect("listaPecas");
    }
}
