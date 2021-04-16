package br.cs.fsilva.tests;

import br.cs.fsilva.core.BaseTest;
import br.cs.fsilva.core.Propriedades;
import br.cs.fsilva.pages.AccountPage;
import br.cs.fsilva.pages.MenuPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRemoveMovementAccount extends BaseTest {

  MenuPage menuPage = new MenuPage();
  AccountPage contasPage = new AccountPage();

  @Test
  public void excluirContaComMovimentacao(){
    menuPage.acessarTelaListarContas();
    contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);

    Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro() );
  }

}
