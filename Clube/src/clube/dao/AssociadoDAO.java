package clube.dao;

import clube.model.Associado;
import util.dao.GenericDAO;

public class AssociadoDAO extends GenericDAO<Associado, Long> {

	public AssociadoDAO() {
		super(Associado.class);
	}

	public Associado encontrarPorId_fullList(Long id) {
		return this.getEntityManager().createNamedQuery("Associado.encontrarPorId_fullList", Associado.class)
				.setParameter("id", id).getSingleResult();

	}

}
