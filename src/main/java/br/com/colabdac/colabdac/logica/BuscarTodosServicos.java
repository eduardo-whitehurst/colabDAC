package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ClienteDao;
import br.com.colabdac.colabdac.dao.ServicoDao;
import br.com.colabdac.colabdac.entities.Cliente;
import br.com.colabdac.colabdac.entities.Servico;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;



public class BuscarTodosServicos implements Logica{
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ServicoDao servicoDao;

        try {
            servicoDao = new ServicoDao();

            List<Servico> servicos = servicoDao.listarTodos();
            req.setAttribute("servicos", servicos);

            RequestDispatcher rd = req.getRequestDispatcher("pages/pagina-servicos.jsp");
            rd.forward(req, res);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
