package br.cs.fsilva.tests;

import br.cs.fsilva.core.BaseTest;
import br.cs.fsilva.pages.AccountPage;
import br.cs.fsilva.pages.MenuPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestAccount extends BaseTest {

  MenuPage menuPage = new MenuPage();
  AccountPage contasPage = new AccountPage();

  @Test
  public void testInserirConta(){
    menuPage.acessarTelaInserirContas();

    contasPage.setNome("Conta teste2");
    contasPage.salvar();

    Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
  }

  @Ignore
  @Test
  public void testeAlterarConta(){
    menuPage.acessarTelaListarContas();

    contasPage.clicarAlterarConta("Conta Teste");
    contasPage.setNome("Conta teste Alterada");
    contasPage.salvar();
    Assert.assertEquals("Conta Alterada com sucesso!", contasPage.obterMensagemSucesso());

  }

  @Test
  public void inserirContaComMesmoNome(){
    menuPage.acessarTelaInserirContas();
    contasPage.setNome("Conta teste");
    contasPage.salvar();
    Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro() );
  }


}
