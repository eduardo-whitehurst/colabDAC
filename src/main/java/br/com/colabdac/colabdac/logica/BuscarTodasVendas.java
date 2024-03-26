package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.VendaDao;
import br.com.colabdac.colabdac.entities.Venda;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BuscarTodasVendas implements Logica{
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        VendaDao vendaDao;

        try {
            vendaDao = new VendaDao();

            List<Venda> vendas = vendaDao.listarTodas();
            req.setAttribute("vendas", vendas);

            RequestDispatcher rd = req.getRequestDispatcher("pagina-vendas.jsp");
            rd.forward(req, res);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
