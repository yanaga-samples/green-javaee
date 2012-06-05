package br.com.yanaga.green_javaee.service;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.yanaga.green_javaee.Pessoa;

@RunWith(Arquillian.class)
public class PessoaServiceTest {

	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackages(true, "br.com.yanaga.green_javaee")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
	}

	@EJB
	PessoaService pessoaService;

	@Test
	public void testSave() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Yanaga");
		Pessoa savedPessoa = pessoaService.save(pessoa);
		assertNotNull(savedPessoa);
		assertNotNull(savedPessoa.getId());
	}

}
