package clube.dao;

import clube.model.Associado;
import clube.model.Emprestimo;
import clube.model.EmprestimoItem;
import util.dao.GenericDAO;

public class EmprestimoDAO extends GenericDAO<EmprestimoItem, Long> {

	public EmprestimoDAO() {
		super(EmprestimoItem.class);
	}

	public Emprestimo encontrarPorId_fullList(Long id) {
		return this.getEntityManager().createNamedQuery("Associado.encontrarPorId_fullList", Emprestimo.class)
				.setParameter("id", id).getSingleResult();

	}

}
