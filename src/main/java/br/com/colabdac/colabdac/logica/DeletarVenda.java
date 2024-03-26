package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.VendaDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletarVenda implements Logica{

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idVenda = req.getParameter("idVenda");
        Long id = Long.parseLong(idVenda);

        VendaDao dao = new VendaDao();
        dao.remover(id);

        res.sendRedirect("listaVendas");
    }
}
