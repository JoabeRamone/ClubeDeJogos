package clube.bo;

import java.util.List;

import clube.dao.VideogameDAO;
import clube.model.Videogame;

public class VideogameBO {
	
	final static VideogameDAO dao = new VideogameDAO();	

	public void salvar(Videogame videogame) {
		dao.salvar(videogame);
	}

	public void remover(Long id) {
		dao.remover(id);
	}
	
	public List<Videogame> listar(){
		return dao.listarTudo();
	}
	
	public Videogame encontrarPorId(Long id) {
		return dao.encontrar(id);
	}
	
	
}
