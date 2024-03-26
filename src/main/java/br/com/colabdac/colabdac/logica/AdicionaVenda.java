package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.VendaDao;
import br.com.colabdac.colabdac.entities.Venda;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaVenda implements Logica{
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String data = req.getParameter("data");
        String idcliente = req.getParameter("idCliente");

        Venda venda = new Venda();
        venda.setData(data);
        venda.setIdCliente(Long.valueOf(idcliente));

        VendaDao dao;

        try {
            dao = new VendaDao();
            dao.inserirVenda(venda);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("pages/venda-adicionada.jsp");
        rd.forward(req, res);


    }

}