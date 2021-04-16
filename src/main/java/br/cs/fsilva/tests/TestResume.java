package br.cs.fsilva.tests;

import br.cs.fsilva.core.BaseTest;
import br.cs.fsilva.core.DriverFactory;
import br.cs.fsilva.pages.MenuPage;
import br.cs.fsilva.pages.ResumePage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static br.cs.fsilva.core.DriverFactory.getDriver;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestResume extends BaseTest {

  private MenuPage menuPage = new MenuPage();
  private ResumePage resumoPage = new ResumePage();

  @Test
  public void test1_ExcluirMovimentacao(){
    menuPage.acessarTelaResumo();
    resumoPage.excluirMovimentacao();

    Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
  }

  @Test //(expected=NoSuchElementException.class)
  public void test2_ResumoMensal(){ // teste resumo mensal vazio
    menuPage.acessarTelaResumo();
    Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());


    // melhor forma de verificar a tabela vazia
    List<WebElement> elementosEncontrados =
            getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
    Assert.assertEquals(0, elementosEncontrados.size());

//    try{
//      DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
//      Assert.fail();
//    } catch (NoSuchElementException e){

  }

}
