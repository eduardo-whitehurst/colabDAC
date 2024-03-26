package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ClienteDao;
import br.com.colabdac.colabdac.dao.ServicoDao;
import br.com.colabdac.colabdac.entities.Cliente;
import br.com.colabdac.colabdac.entities.Servico;
import br.com.colabdac.colabdac.entities.Veiculo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BuscarPorIdServico implements Logica{
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idServico = req.getParameter("idServico");
        Long id = Long.parseLong(idServico);

        ServicoDao dao = new ServicoDao();

        Servico servico = dao.buscarPorId(id);
        req.setAttribute("idServico", servico.getId());
        req.setAttribute("nome", servico.getNome());
        req.setAttribute("descricao", servico.getDescricao());
        req.setAttribute("valor", servico.getValor());
        req.setAttribute("idFuncionario", servico.getIdFuncionario());

        RequestDispatcher rd = req.getRequestDispatcher("pages/editarServico.jsp");
        rd.forward(req, res);
    }
}
