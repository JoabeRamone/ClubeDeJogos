package clube.service;

import java.io.Serializable;
import java.util.List;

import clube.model.Associado;
import clube.model.Videogame;

public interface IClubeService extends Serializable {
	
	// falta complementar as assinaturas, exceptions, etc
	
	public void emprestimo();
	
	public void devolucao();
	
	public void salvarAssociado(Associado associado);
	
	public void removerAssociado(Long id);
	
	public void salvarVideogame(Videogame videogame);
	
	public void removerVideogame(Long id);
	
	public List<Videogame> listarVideogames();

	public List<Associado> listarAssociadosPorNome(String nomeAssociado);
	
	public Associado encontrarAssociadoPorId_fullList(Long id);
	
	public Videogame encontrarPorId(Long id);
	

}
