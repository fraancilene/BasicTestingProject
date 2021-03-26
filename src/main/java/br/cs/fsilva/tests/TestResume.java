package br.cs.fsilva.tests;

import br.cs.fsilva.core.BaseTest;
import br.cs.fsilva.pages.MenuPage;
import br.cs.fsilva.pages.ResumePage;
import org.junit.Assert;
import org.junit.Test;

public class TestResume extends BaseTest {

  private MenuPage menuPage = new MenuPage();
  private ResumePage resumoPage = new ResumePage();

  @Test
  public void testExcluirMovimentacao(){
    menuPage.acessarTelaResumo();
    resumoPage.excluirMovimentacao();

    Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());


  }
}
