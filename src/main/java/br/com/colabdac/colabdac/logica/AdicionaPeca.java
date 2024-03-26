package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.PecaDao;
import br.com.colabdac.colabdac.entities.Peca;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaPeca implements Logica{
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String nome = req.getParameter("nome");
        String valor = req.getParameter("valor");

        Peca peca = new Peca();
        peca.setNome(nome);
        peca.setValor(valor);

        PecaDao dao;

        try {
            dao = new PecaDao();
            dao.inserirPeca(peca);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("pages/peca-adicionada.jsp");
        rd.forward(req, res);


    }

}
