package clube.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EmprestimoItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name = "emprestimo_id")
	private Emprestimo emprestimo;
	
	@ManyToOne
	@JoinColumn(name = "jogo_id")
	private AssociadoVideogameJogo jogo;
	
	@Column
	private Enum<JogoStatus> status=JogoStatus.EMPRESTADO;
	
	@Temporal(TemporalType.DATE)
 	private Date dataDevolucao;
	
	
}
