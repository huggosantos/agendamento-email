package br.com.agendamentoemail.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import br.com.agendamentoemail.entidade.AgendamentoEmail;
import br.com.agendamentoemail.servico.AgendamentoEmailServico;

// informar o caminho da fila com JNDI, e o tipo "QUEUE"
@MessageDriven(activationConfig = {
		@ActivationConfigProperty( propertyName = "destinationLookup",
				propertyValue = "java:/jms/queue/EmailQueue"),
		@ActivationConfigProperty(propertyName = "destinationType",
		propertyValue = "javax.jms.Queue")
})
public class AgendamentoEmailMDB implements MessageListener{
	
	@Inject
	private AgendamentoEmailServico agendamentoEmailServico;

	@Override
	public void onMessage(Message message) {
		try {
			AgendamentoEmail agendamentoEmail = message.getBody(AgendamentoEmail.class);
			agendamentoEmailServico.enviar(agendamentoEmail);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
	

}
