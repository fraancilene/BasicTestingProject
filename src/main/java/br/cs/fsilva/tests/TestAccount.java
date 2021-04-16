package br.cs.fsilva.tests;

import br.cs.fsilva.core.BaseTest;
import br.cs.fsilva.core.Propriedades;
import br.cs.fsilva.pages.AccountPage;
import br.cs.fsilva.pages.MenuPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

// anotação para execução dos testes - em ordem alfabetica
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAccount extends BaseTest {

  MenuPage menuPage = new MenuPage();
  AccountPage contasPage = new AccountPage();

  @Test
  public void test1_InserirConta(){
    menuPage.acessarTelaInserirContas();
    contasPage.setNome("Conta teste");
    contasPage.salvar();

    Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
  }

  @Test
  public void test2_AlterarConta(){
    menuPage.acessarTelaListarContas();
    contasPage.clicarAlterarConta("Conta teste");
    contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
    contasPage.salvar();
    Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());

  }

  @Test
  public void test3_inserirContaComMesmoNome(){
    menuPage.acessarTelaInserirContas();
    contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
    contasPage.salvar();
    Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro() );
  }


}
