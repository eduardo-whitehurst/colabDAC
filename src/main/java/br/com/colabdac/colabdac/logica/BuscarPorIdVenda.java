package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.VendaDao;
import br.com.colabdac.colabdac.entities.Venda;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class BuscarPorIdVenda implements Logica {
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idVenda = req.getParameter("idVenda");
        Long id = Long.parseLong(idVenda);

        VendaDao dao = new VendaDao();

        Venda venda = dao.buscarPorId(id);

        req.setAttribute("idVenda", venda.getId());
        req.setAttribute("data", venda.getData());
        req.setAttribute("idCliente", venda.getIdCliente());

        RequestDispatcher rd = req.getRequestDispatcher("editarVenda.jsp");
        rd.forward(req, res);
    }
}
