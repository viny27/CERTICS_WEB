package br.certics.controller.facade;

import java.util.List;

import br.certics.model.be.PessoaFisicaBE;
import br.certics.model.entity.PessoaFisicaEntity;
import br.finf.control.facade.AbstractFacade;
import br.finf.dao.DBSession;
import br.finf.filter.QueryBuilder;

public class PessoaFisicaFacade extends AbstractFacade {

	public PessoaFisicaFacade(DBSession session) {
		super(session);
	}

	public List<PessoaFisicaEntity> executeQuery(QueryBuilder query) {
		return getBE(PessoaFisicaBE.class).executeQueryList(query);
	}

	public boolean isCPFUsado(String cpf) {
		return getBE(PessoaFisicaBE.class).isCPFUsado(cpf);
	}

	public void salvar(PessoaFisicaEntity pessoaFisica) {
		getBE(PessoaFisicaBE.class).save(pessoaFisica);
	}

}
