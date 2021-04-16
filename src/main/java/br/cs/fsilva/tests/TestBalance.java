package br.cs.fsilva.tests;

import br.cs.fsilva.core.BaseTest;
import br.cs.fsilva.core.Propriedades;
import br.cs.fsilva.pages.HomePage;
import br.cs.fsilva.pages.MenuPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBalance extends BaseTest {

  HomePage page = new HomePage();
  MenuPage menu = new MenuPage();

  @Test
  public void teste1_SaldoContas(){
    menu.acessarTelaPrincipal();
    Assert.assertEquals("500.00", page.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
  }
}
