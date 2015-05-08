package br.unifor.pin.saa.bussines;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.dao.UsersDAO;
import br.unifor.pin.saa.entity.Users;

@Component
public class UsersBO {

	private static final Logger logger = LoggerFactory
			.getLogger(UsersBO.class);

	@Autowired
	private UsersDAO usersDAO;

	public void salvar(Users users) {
		loggerInit("salvar");
		usersDAO.salvar(users);
		loggerFinhish("salvar");
	}
	
	public void atualizar(Users users){
		loggerInit("atualizar");
		usersDAO.atualizar(users);
		loggerFinhish("atualizar");
		
	}

	public Users buscarPorCpf(String cpf) {
		loggerInit("BuscaUsersPorCPF");
		Users users = usersDAO.buscarPorCpf(cpf);
		loggerInit("BuscaUsersPorCPF");
		return users;
	}
	
	public Users buscarPorId(Long id){
		return usersDAO.buscarPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Users users) {
		loggerInit("excluir");
		users = usersDAO.buscarPorId(users.getId());
		usersDAO.excluir(users);
		loggerFinhish("excluir");
	}

	public void loggerInit(String method) {
		logger.debug("Inicio do método " + method + " da classe"
				+ this.getClass().getName());
	}

	public void loggerFinhish(String method) {
		logger.debug("Fim do método "+method+" da classe"
				+ this.getClass().getName());
	}
	
}
