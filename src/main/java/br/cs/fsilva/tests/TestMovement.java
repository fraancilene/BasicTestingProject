package br.cs.fsilva.tests;

import br.cs.fsilva.core.BaseTest;
import br.cs.fsilva.core.Propriedades;
import br.cs.fsilva.pages.MenuPage;
import br.cs.fsilva.pages.MovementPage;
import br.cs.fsilva.utils.DataUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static br.cs.fsilva.utils.DataUtils.obterDataFormatada;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMovement extends BaseTest {

  MenuPage menuPage = new MenuPage();
  private MovementPage movePage = new MovementPage();


  @Test
  public void test1_InserirMovimentacao(){
    menuPage.acessarTelaInserirMovimentacao();
    movePage.setDataMovimentacao(obterDataFormatada(new Date()));
    movePage.setDataPagamento(obterDataFormatada(new Date()));
    movePage.setDescricao("Movimentação de Teste");
    movePage.setInteressado("Interessado qualquer");
    movePage.setValor("500");
    movePage.setContas(Propriedades.NOME_CONTA_ALTERADA);

    movePage.setStatusPago();
    movePage.salvar();

    Assert.assertEquals("Movimentação adicionada com sucesso!", movePage.obterMensagemSucesso());
  }

  @Test
  public void test2_CamposObrigatorios(){
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
  public void test3_InserirMovimentacaoFutura(){
    menuPage.acessarTelaInserirMovimentacao();

    Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

    movePage.setDataMovimentacao(obterDataFormatada(dataFutura));
    movePage.setDataPagamento(obterDataFormatada(dataFutura));
    movePage.setDescricao("Movimentação de Teste");
    movePage.setInteressado("Interessado qualquer");
    movePage.setValor("500");
    movePage.setContas(Propriedades.NOME_CONTA_ALTERADA);
    movePage.setStatusPago();
    movePage.salvar();

    // aseertivas
    List<String> erros = movePage.obterErros();
    Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
    Assert.assertEquals(1, erros.size());


  }

}
