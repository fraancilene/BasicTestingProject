package br.cs.fsilva.tests;

import br.cs.fsilva.core.BaseTest;
import br.cs.fsilva.pages.AccountPage;
import br.cs.fsilva.pages.MenuPage;
import org.junit.Test;

public class TestAccount extends BaseTest {

  MenuPage menuPage = new MenuPage();
  AccountPage contaPage = new AccountPage();

  @Test
  public void testInserirConta(){
    menuPage.acessarTelaInserirContas();
    contaPage.setNome("Conta do teste");
    contaPage.salvar();


  }

}
