package clube.dao.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import clube.dao.AssociadoDAO;
import clube.model.Associado;

public class AssociadoTest {

	private Associado associado;
	private AssociadoDAO dao = new AssociadoDAO();
	
	@Test
	public void testSalvar() {
		associado = new Associado("Pedro", "67 99999-1234", "Rua Coxim, 33 - COXIM-MS");

		associado = dao.salvar(associado);
		
		assertTrue(associado.getId() > 0);

	}
}
