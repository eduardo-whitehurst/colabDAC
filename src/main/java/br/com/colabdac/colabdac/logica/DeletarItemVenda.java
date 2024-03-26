package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ItemVendaDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletarItemVenda implements Logica{

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idItemVenda = req.getParameter("idItemVenda");
        Long id = Long.parseLong(idItemVenda);

        ItemVendaDao dao = new ItemVendaDao();
        dao.removerItemVenda(id);

        res.sendRedirect("listarItemVenda");
    }
}
