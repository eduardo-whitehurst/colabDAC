package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ItemVendaDao;
import br.com.colabdac.colabdac.entities.ItemVenda;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaItemVenda implements Logica{
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String idVenda = req.getParameter("idVenda");
        String idPeca = req.getParameter("idPeca");
        String quantidade = req.getParameter("quantidade");

        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setIdVenda(Long.valueOf(idVenda));
        itemVenda.setIdPeca(Long.valueOf(idPeca));
        itemVenda.setQuantidade(Integer.parseInt(quantidade));

        ItemVendaDao dao;

        try {
            dao = new ItemVendaDao();
            dao.inserirItemVenda(itemVenda);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("/itemvenda-adicionada.jsp");
        rd.forward(req, res);


    }

}