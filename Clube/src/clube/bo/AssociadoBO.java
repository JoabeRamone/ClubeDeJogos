package clube.bo;

import java.util.List;

import clube.dao.AssociadoDAO;
import clube.model.Associado;

public class AssociadoBO {

	final static AssociadoDAO dao = new AssociadoDAO();

	public void salvar(Associado associado) {
		dao.salvar(associado);
	}

	public void remover(Long id) {
		dao.remover(id);
	}
	
	
	public Associado encontrarPorId_FullList(Long id) {
		return dao.encontrarPorId_fullList(id);
	}
	
	//FIXME implementar busca por nome
	public List<Associado> listarPorNome(String nome) {
		return dao.listarTudo();
	}

	public List<Associado> listar() {
		return dao.listarTudo();
	}
}
