package br.unifor.pin.saa.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Instituicoes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRED)
public class InstituicoesDAOTest {
	
	@Autowired
	private InstituicoesDAO instituicoesDAO;

	@Test
	public void testAtualizar() {
		final String nome = "Universidade de Fortaleza";
		final String nomeAlterado = "UNIFOR";
		final String endereco = "Av. Washington Soares, 1321";
		final String telefone = "3477-3000";
		
		Instituicoes instituicao = new Instituicoes();
		instituicao.setNome(nome);
		instituicao.setEndereco(endereco);
		instituicao.setTelefone(telefone);
		
		instituicoesDAO.salvar(instituicao);
		instituicao.setNome(nomeAlterado);
		instituicoesDAO.atualizar(instituicao);
		instituicao = instituicoesDAO.buscarPorId(instituicao.getId());
		
		Assert.assertEquals(nomeAlterado, instituicao.getNome());
	}

}
