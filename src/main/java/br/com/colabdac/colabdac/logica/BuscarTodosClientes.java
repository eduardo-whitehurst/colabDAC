package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ClienteDao;
import br.com.colabdac.colabdac.entities.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BuscarTodosClientes implements Logica{
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ClienteDao clienteDao;

        try {
            clienteDao = new ClienteDao();

            List<Cliente> clientes = clienteDao.all();
            req.setAttribute("clientes", clientes);

            RequestDispatcher rd = req.getRequestDispatcher("pages/pagina-clientes.jsp");
            rd.forward(req, res);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
