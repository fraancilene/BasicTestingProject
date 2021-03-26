package br.cs.fsilva.tests;

import br.cs.fsilva.core.BaseTest;
import br.cs.fsilva.pages.MenuPage;
import br.cs.fsilva.pages.MovementPage;
import br.cs.fsilva.utils.DataUtils;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static br.cs.fsilva.utils.DataUtils.obterDataFormatada;

public class TestMovement extends BaseTest {

  MenuPage menuPage = new MenuPage();
  private MovementPage movePage = new MovementPage();


  @Test
  public void testInserirMovimentacao(){
    menuPage.acessarTelaInserirMovimentacao();
    movePage.setDataMovimentacao("01/02/2021");
    movePage.setDataPagamento("02/02/2021");
    movePage.setDescricao("Movimentação de Teste");
    movePage.setInteressado("Interessado qualquer");
    movePage.setValor("500");
    movePage.setContas("Conta teste");
    movePage.setStatusPago();
    movePage.salvar();

    Assert.assertEquals("Movimentação adicionada com sucesso!", movePage.obterMensagemSucesso());
  }

  @Test
  public void testCamposObrigatorios(){
    menuPage.acessarTelaInserirMovimentacao();
    movePage.salvar();
    // assertivas
    List<String> erros = movePage.obterErros();
    //Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
   //Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
    Assert.assertTrue(erros.containsAll(Arrays.asList(
            "Data da Movimentação é obrigatório", "Data do pagamento é obrigatório" , "Descrição é obrigatório",
            "Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número")));

    Assert.assertEquals(6, erros.size());
  }

  @Test
  public void testInserirMovimentacaoFutura(){
    menuPage.acessarTelaInserirMovimentacao();

    Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

    movePage.setDataMovimentacao(obterDataFormatada(dataFutura));
    movePage.setDataPagamento(obterDataFormatada(dataFutura));
    movePage.setDescricao("Movimentação de Teste");
    movePage.setInteressado("Interessado qualquer");
    movePage.setValor("500");
    movePage.setContas("Conta teste");
    movePage.setStatusPago();
    movePage.salvar();

    // aseertivas
    List<String> erros = movePage.obterErros();
    Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
    Assert.assertEquals(1, erros.size());


  }

}
