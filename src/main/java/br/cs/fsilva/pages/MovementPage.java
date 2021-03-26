package br.cs.fsilva.pages;

import br.cs.fsilva.core.BasePage;
import br.cs.fsilva.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static br.cs.fsilva.core.DriverFactory.getDriver;

public class MovementPage extends BasePage {

  public void setDataMovimentacao(String data){
    escreveNoCampo("data_transacao", data);
  }

  public void setDataPagamento(String data){
    escreveNoCampo("data_pagamento", data);
  }

  public void setDescricao(String descricao){
    escreveNoCampo("descricao", descricao);
  }

  public void setInteressado(String interessado){
    escreveNoCampo("interessado", interessado);
  }

  public void setValor(String valor){
    escreveNoCampo("valor", valor);
  }

  public void setContas(String conta){
    selecionarCombo("conta", conta);
  }

  public void setStatusPago(){
    clicarBotao("status_pago");
  }

  public void salvar(){
    clicarBotaoPorTexto("Salvar");
  }

  public String obterMensagemSucesso(){
    return  obterTexto(By.xpath("//div[@class='alert alert-success']"));
  }

  public List<String> obterErros(){
    List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
    List <String> retorno = new ArrayList<String>();
    for (WebElement erro: erros){
      retorno.add(erro.getText());
    }
    return retorno;
  }



}
