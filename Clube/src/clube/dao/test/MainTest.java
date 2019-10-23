package clube.dao.test;

import java.util.List;

import org.junit.Test;

import clube.dao.AssociadoDAO;
import clube.dao.VideogameDAO;
import clube.model.Associado;
import clube.model.Videogame;

public class MainTest {

	private VideogameDAO videogameDAO = new VideogameDAO();
	private AssociadoDAO associadoDAO = new AssociadoDAO();

	@Test
	public void reset() {

	}

	@Test
	public void populate() {

		Videogame videogame = new Videogame("PS4");
		videogameDAO.salvar(videogame);
		
		Associado associado = new Associado("Paulo", "67 99999-1234", "Rua Coxim, 33 - COXIM-MS",  videogame);
		associadoDAO.salvar(associado);
		
		videogame = new Videogame("XBOX");
		videogame = videogameDAO.salvar(videogame);
		
		associado.addVideogame(videogame);
		associadoDAO.salvar(associado);

		
		associado = new Associado("Pedro", "67 99555-2223", "Rua Treze, 54 - SILVOLANDIA-MS", videogame);
		associadoDAO.salvar(associado);
		
		associado.addVideogame(videogame);
		associadoDAO.salvar(associado);
		
		
//		atualizarAssociado();
//		removerAssociado();
//		
//		atualizarVideogame();
//		removerVideogame();

	}

	public void atualizarVideogame() {
		List<Videogame> list = videogameDAO.listarTudo();
		if (list.size() > 0) {
			Videogame videogame = list.get(0);
			videogame.setNome("Teste");
			videogameDAO.salvar(videogame);
		}

	}

	public void removerVideogame() {
		videogameDAO.remover(1l);
	}

	public void atualizarAssociado() {
		List<Associado> list = associadoDAO.listarTudo();
		if (list.size() > 0) {
			Associado associado = list.get(0);
			associado.setNome("Teste");
			associadoDAO.salvar(associado);
		}

	}

	public void removerAssociado() {
		associadoDAO.remover(1l);
	}

}
