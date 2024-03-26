package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.PecaDao;
import br.com.colabdac.colabdac.entities.Peca;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarPeca implements Logica {

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String idPeca = req.getParameter("id");
        String nome = req.getParameter("nome");
        String valor = req.getParameter("valor");

        Peca peca = new Peca();
        peca.setId(Long.parseLong(idPeca));
        peca.setNome(nome);
        peca.setValor(valor);

        PecaDao dao;
        try {
            dao = new PecaDao();
            dao.alterar(peca);
        } catch (Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("listaPecas");
    }

}
