package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ServicoVendaDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletarServicoVenda implements Logica{

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idServicoVenda = req.getParameter("idServicoVenda");
        Long id = Long.parseLong(idServicoVenda);

        ServicoVendaDao dao = new ServicoVendaDao();
        dao.removerServicoVenda(id);

        res.sendRedirect("listarServicoVenda");
    }
}
