package br.cs.fsilva.suits;


import br.cs.fsilva.core.DriverFactory;
import br.cs.fsilva.pages.LoginPage;
import br.cs.fsilva.tests.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static br.cs.fsilva.core.DriverFactory.killDriver;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestAccount.class,
        TestMovement.class,
        TestRemoveMovementAccount.class,
        TestBalance.class,
        TestResume.class

})
public class SuiteGeral {

  private static LoginPage page = new LoginPage();

  // efetuando login aqui na suite, para acelerar os testes. Antes estava na BaseTest
  @BeforeClass
  public static void inicializa(){
    page.acessarTelaInicial();

    page.setEmail("fran@silva");
    page.setSenha("123456");
    page.entrar();
  }

  @AfterClass
  public static void finaliza(){
    killDriver();
  }

  /* GERENCIAMENTO DE MASSA DE DADOS
   * para conseguir executar todos os testes na mesma suite, temos que garantir que a massa que o teste necessita
   * esteja pronta no momento em que o mesmo esteja sendo executado. colocar os metodos em uma ordem que permita a execução
   * completa.
   * O JUnit não garante a ordem que vai executar os testes, para isso aplicamos um recurso chamado: fix Method order
   */
}
