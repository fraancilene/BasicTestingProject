package br.cs.fsilva.pages;

import br.cs.fsilva.core.BasePage;
import org.openqa.selenium.By;

public class AccountPage extends BasePage {

  public void setNome(String nome){
    escreveNoCampo("nome", nome);
  }

  public void salvar(){
    clicarRadioEcheckbox(By.xpath("//button[.='Salvar']"));
  }

  public String obterMensagemSuceeso(){
    return  obterTexto(By.xpath("//div[@class='alert alert-success']"));
  }
}
