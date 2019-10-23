package clube.controller.associado;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import clube.model.Associado;
import clube.model.AssociadoVideogame;
import clube.model.AssociadoVideogameJogo;
import clube.model.Videogame;
import clube.service.ClubeService;
import clube.service.IClubeService;

@ManagedBean
@ViewScoped
public class AssociadoMB implements Serializable {

	private static final long serialVersionUID = 7376834516863092920L;

	private IClubeService service = ClubeService.getInstance();

	private Associado associado;
	
	private List<Videogame> videogames;
	
	private Videogame selectedVideogame = new Videogame();
	private AssociadoVideogame currentAssociadoVideogame;
	private String novoJogo;
	
	
	private boolean enableVideogameAdd;
	private boolean enableVideogameDel;
	

	@PostConstruct
	public void init() {
		videogames = service.listarVideogames();
		
		associado = (Associado) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("associado");

		if (associado == null)
			associado = new Associado();
		else {
			associado = service.encontrarAssociadoPorId_fullList(associado.getId());
		}
			
	}
	
	
	public void videogameSelecionado(ValueChangeEvent e) {
		
		enableVideogameAdd = enableVideogameDel = false;

		if( "".equals(e.getNewValue()) || e.getNewValue() == null ) {
			selectedVideogame = new Videogame();
			return;
		}
		
		Long videogameId = (Long) e.getNewValue();
		selectedVideogame.setId(videogameId);
		
				
		currentAssociadoVideogame = null;
		
		for (AssociadoVideogame associadoVideogame : associado.getVideogames()) {
			if(associadoVideogame.getVideogame().getId().equals(videogameId)) {
				enableVideogameDel = true;
				currentAssociadoVideogame = associadoVideogame;
			}
		}
		
		if (currentAssociadoVideogame == null) {
			enableVideogameAdd = true;
		}
	}
	
	public String adicionarVideogame() {
		
		selectedVideogame = service.encontrarPorId(selectedVideogame.getId());
		
		currentAssociadoVideogame = associado.addVideogame(selectedVideogame);
		
		enableVideogameDel = true;
		enableVideogameAdd = false;
		
		FacesMessage fm = new FacesMessage("Videogame adicionado com sucesso!");
		FacesContext.getCurrentInstance().addMessage("Sucesso", fm);
		
		return null;
	}
	
	
	public String removerVideogame() {
		
		for (AssociadoVideogame associadoVideogame : associado.getVideogames()) {
			if(associadoVideogame.getVideogame().getId().equals(selectedVideogame.getId())) {
				associado.getVideogames().remove(associadoVideogame);
				currentAssociadoVideogame = null;
				enableVideogameDel = false;
				enableVideogameAdd = true;
				selectedVideogame = new Videogame();
				
				FacesMessage fm = new FacesMessage("Videogame removido com sucesso!");
				FacesContext.getCurrentInstance().addMessage("Sucesso", fm);
				
				break;
			}
		}
		
		return null;
	}
	
	
	public String adicionarJogo() {
		
		if("".equals(novoJogo)) {
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Informe o título do jogo", "Informe o título do jogo");
			FacesContext.getCurrentInstance().addMessage("Erro", fm);
			return null;
		}
		
		currentAssociadoVideogame.addJogo(novoJogo);
		
		novoJogo = "";
		
		FacesMessage fm = new FacesMessage("Jogo adicionado com sucesso!");
		FacesContext.getCurrentInstance().addMessage("Sucesso", fm);
		
		return null;
	}
	
	public String excluirJogo(AssociadoVideogameJogo jogo ) {
		for (AssociadoVideogameJogo avj : currentAssociadoVideogame.getJogos()) {
			if(avj.equals(jogo)) {
				currentAssociadoVideogame.getJogos().remove(avj);
				
				FacesMessage fm = new FacesMessage("Jogo excluído com sucesso!");
				FacesContext.getCurrentInstance().addMessage("Sucesso", fm);

				break;
			}
			
		}
		
		return null;
	}

	public String salvar() {

		service.salvarAssociado(associado);

		FacesMessage fm = new FacesMessage("Associado salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage("Sucesso", fm);

		return null;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}



	public List<Videogame> getVideogames() {
		return videogames;
	}

	public void setVideogames(List<Videogame> videogames) {
		this.videogames = videogames;
	}

	public Videogame getSelectedVideogame() {
		return selectedVideogame;
	}

	public void setSelectedVideogame(Videogame selectedVideogame) {
		this.selectedVideogame = selectedVideogame;
	}


	public boolean isEnableVideogameAdd() {
		return enableVideogameAdd;
	}


	public void setEnableVideogameAdd(boolean enableVideogameAdd) {
		this.enableVideogameAdd = enableVideogameAdd;
	}


	public boolean isEnableVideogameDel() {
		return enableVideogameDel;
	}


	public void setEnableVideogameDel(boolean enableVideogameDel) {
		this.enableVideogameDel = enableVideogameDel;
	}


	public AssociadoVideogame getCurrentAssociadoVideogame() {
		return currentAssociadoVideogame;
	}


	public void setCurrentAssociadoVideogame(AssociadoVideogame currentAssociadoVideogame) {
		this.currentAssociadoVideogame = currentAssociadoVideogame;
	}


	public String getNovoJogo() {
		return novoJogo;
	}


	public void setNovoJogo(String novoJogo) {
		this.novoJogo = novoJogo;
	}


	

}
