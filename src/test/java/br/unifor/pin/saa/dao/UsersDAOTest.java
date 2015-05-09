package br.unifor.pin.saa.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRES_NEW)
@TransactionConfiguration(defaultRollback=false)
public class UsersDAOTest {
	@Autowired
	private UsersDAO usersDAO;

	@Test
	public void testSalvar() {
		final String cpf = "111.222.333-44";
		final String email = "testando@teste.com";
		final String senha = "123456";
		
		Users users = new Users();
		users.setCpf(cpf);
		users.setEmail(email);
		users.setSenha(senha);
		
		usersDAO.salvar(users);
		
		Users usersRetorno = usersDAO.buscarPorCpf(cpf);
		
		Assert.assertNotNull(usersRetorno);
		
		usersDAO.excluir(users);
	}
	
	@Test
	public void testAtualizar(){
		final String cpf = "111.222.333-44";
		final String email = "testando@teste.com";
		final String emailAlterado = "alo@mundo.com";
		final String senha = "123456";
		
		Users users = new Users();
		users.setCpf(cpf);
		users.setEmail(email);
		users.setSenha(senha);
		
		usersDAO.salvar(users);
		users.setEmail(emailAlterado);
		usersDAO.atualizar(users);

		Assert.assertEquals(emailAlterado, users.getEmail());
		
		usersDAO.excluir(users);
	}
	@Test
	public void testBuscarPorId(){
		final String cpf = "111.222.333-44";
		final String email = "testando@teste.com";
		final String senha = "123456";
		
		Users users = new Users();
		users.setCpf(cpf);
		users.setEmail(email);
		users.setSenha(senha);
		
		usersDAO.salvar(users);
		
		Users usersRetorno = usersDAO.buscarPorId(users.getId());
		
		Assert.assertNotNull(usersRetorno);
		
		usersDAO.excluir(usersRetorno);
	}
	@Test
	public void testBuscarPorCpf(){
		final String cpf = "111.222.333-44";
		final String email = "testando@teste.com";
		final String senha = "123456";
		
		Users users = new Users();
		users.setCpf(cpf);
		users.setEmail(email);
		users.setSenha(senha);
		
		usersDAO.salvar(users);
		
		Users usersRetorno = usersDAO.buscarPorCpf(users.getCpf());
		
		Assert.assertNotNull(usersRetorno);
		
		usersDAO.excluir(usersRetorno);
	}

}
