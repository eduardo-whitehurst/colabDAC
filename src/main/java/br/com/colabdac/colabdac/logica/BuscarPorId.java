package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ClienteDao;
import br.com.colabdac.colabdac.entities.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class BuscarPorId implements Logica {
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idCliente = req.getParameter("idCliente");
        Long id = Long.parseLong(idCliente);

        ClienteDao dao = new ClienteDao();

        Cliente cliente = dao.byId(id);

        req.setAttribute("idCliente", cliente.getId());
        req.setAttribute("nome", cliente.getNome());
        req.setAttribute("cpf", cliente.getCpf());

        RequestDispatcher rd = req.getRequestDispatcher("editar.jsp");
        rd.forward(req, res);
    }
}
