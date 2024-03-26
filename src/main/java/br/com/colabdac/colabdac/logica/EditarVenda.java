package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.VendaDao;
import br.com.colabdac.colabdac.entities.Venda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarVenda implements Logica {

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String idVenda = req.getParameter("id");
        String data = req.getParameter("data");
        String IdCliente = req.getParameter("idcliente");

        Venda venda = new Venda();
        venda.setId(Long.parseLong(idVenda));
        venda.setData(data);
        venda.setIdCliente(Long.parseLong(IdCliente));

        VendaDao dao;
        try {
            dao = new VendaDao();
            dao.alterar(venda);
        } catch (Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("listaVendas");
    }

}
