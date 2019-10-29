package clube.bo;

import java.util.List;

import clube.dao.AssociadoVideogameJogoDAO;
import clube.model.AssociadoVideogameJogo;

public class AssociadoVideogameJogoBO {
	
	final static AssociadoVideogameJogoDAO dao = new AssociadoVideogameJogoDAO();	

	public void salvar(AssociadoVideogameJogo videogame) {
		dao.salvar(videogame);
	}

	public void remover(Long id) {
		dao.remover(id);
	}
	
	public List<AssociadoVideogameJogo> listar(){
		return dao.listarTudo();
	}
	
	public AssociadoVideogameJogo encontrarPorId(Long id) {
		return dao.encontrar(id);
	}
	
	
}
