package br.cs.fsilva.pages;

import br.cs.fsilva.core.BasePage;
import org.openqa.selenium.By;

public class AccountPage extends BasePage {

  public void setNome(String nome){
    escreveNoCampo("nome", nome);
  }

  public void salvar(){
    clicarBotaoPorTexto("Salvar");
  }

  public String obterMensagemSucesso(){
    return  obterTexto(By.xpath("//div[@class='alert alert-success']"));
  }
  public String obterMensagemErro(){
    return  obterTexto(By.xpath("//div[@class='alert alert-danger']"));
  }

  public void clicarAlterarConta(String contaTeste) {
    obterCelula("Conta", contaTeste, "Ações" , "tabelaContas")
            .findElement(By.xpath(". //span[@class='glyphicon glyphicon-edit']")).click();   //*[@id='tabelaContas']//tbody/tr[5]/td[2]//span[@class='glyphicon glyphicon-edit']
  }

  public void clicarExcluirConta(String contaTeste) {
    obterCelula("Conta", contaTeste, "Ações" , "tabelaContas")
            .findElement(By.xpath(". //span[@class='glyphicon glyphicon-remove-circle']")).click();   //*[@id='tabelaContas']//tbody/tr[5]/td[2]//span[@class='glyphicon glyphicon-edit']
  }
}
