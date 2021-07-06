package br.com.agendamentoemail.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.agendamentoemail.entidade.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDAO {

	@PersistenceContext
	private EntityManager entityManager;


	public List<AgendamentoEmail> listar() {		
		return entityManager.createQuery("SELECT ae FROM AgendamentoEmail ae",
				AgendamentoEmail.class).getResultList();

	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		entityManager.persist(agendamentoEmail);		
	}
	
	public List<AgendamentoEmail> listaPorNaoAngedando(){
		return entityManager.createQuery("SELECT ae FROM AgendamentoEmail ae WHERE ae.agendado=false",
				AgendamentoEmail.class).getResultList();
	}
	
	public void alterar(AgendamentoEmail agendamentoEmail) {
		entityManager.merge(agendamentoEmail);
	}

}
