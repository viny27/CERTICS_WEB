package br.certics.view.bean.areacompetencia;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.certics.controller.facade.AreaCompetenciaFacade;
import br.certics.model.entity.AreaCompetenciaEntity;
import br.certics.view.bean.ApplicationContextBean;
import br.certics.view.bean.MessageUtils;
import br.finf.control.facade.FacadeProvider;

@ViewScoped
@ManagedBean(name="areaCompetenciaBean")
public class AreaCompetenciaBean {

	private String titulo;
	private String perguntaChave;
	private String descricao;

	@ManagedProperty(value = "#{applicationContextBean}")
	private ApplicationContextBean applicationContext;
	
	public void salvar() {
		AreaCompetenciaEntity areaCompetencia = new AreaCompetenciaEntity();
		areaCompetencia.setTitulo(titulo);
		areaCompetencia.setPerguntaChave(perguntaChave);
		areaCompetencia.setDescricao(descricao);
		
		AreaCompetenciaFacade facade = FacadeProvider.get().provide(AreaCompetenciaFacade.class);
		facade.salvar(areaCompetencia);
		
		MessageUtils.addInfoMessage("�rea de compet�ncia salvo com sucesso!");
		limpar();
	}
	
	public void limpar() {
		titulo = null;
		descricao = null;
		perguntaChave = null;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPerguntaChave() {
		return perguntaChave;
	}

	public void setPerguntaChave(String perguntaChave) {
		this.perguntaChave = perguntaChave;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ApplicationContextBean getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContextBean applicationContext) {
		this.applicationContext = applicationContext;
	}

}
