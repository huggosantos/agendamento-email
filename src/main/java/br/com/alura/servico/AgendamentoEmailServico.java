package br.com.alura.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.alura.DAO.AgendamentoEmailDAO;
import br.com.alura.entidade.AgendamentoEmail;

@Stateless
public class AgendamentoEmailServico {

	@Inject
	private AgendamentoEmailDAO dao;
	
	public List<AgendamentoEmail> listar() { 
		return dao.listar();
	}
	
	public List<AgendamentoEmail> listarPorNaoAngedado() { 
		return dao.listaPorNaoAngedando();
	}
	
	public void inserir(AgendamentoEmail agendametnoEmail) {
		agendametnoEmail.setAgendado(false);
		dao.inserir(agendametnoEmail);		
	}
	
	public void alterar(AgendamentoEmail agendametnoEmail) {
		agendametnoEmail.setAgendado(true);
		dao.alterar(agendametnoEmail);
	}
	
}
