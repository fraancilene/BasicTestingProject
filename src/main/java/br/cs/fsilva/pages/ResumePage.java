package br.cs.fsilva.pages;

import br.cs.fsilva.core.BasePage;
import org.openqa.selenium.By;

public class ResumePage extends BasePage {

  public void excluirMovimentacao(){
    clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
  }

  public String obterMensagemSucesso(){
    return  obterTexto(By.xpath("//div[@class='alert alert-success']"));
  }
}
