package br.com.agendamentoemail.servico;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.agendamentoemail.DAO.AgendamentoEmailDAO;
import br.com.agendamentoemail.entidade.AgendamentoEmail;

@Stateless
public class AgendamentoEmailServico {

	private static final Logger LOGGER =
			Logger.getLogger(AgendamentoEmailServico.class.getName());
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
	
	public void enviar(AgendamentoEmail agendametnoEmail) {
		try {
			Thread.sleep(5000);
			LOGGER.info("O e-mail do(a) usuário(a)"+agendametnoEmail.getEmail()+" foi enviado!");
		}catch (Exception e) {
			LOGGER.warning(e.getMessage());
		}
		
	}
	
}
