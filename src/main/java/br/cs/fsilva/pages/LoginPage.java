package br.cs.fsilva.pages;

import br.cs.fsilva.core.BasePage;
import br.cs.fsilva.core.DriverFactory;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

  public void acessarTelaInicial(){
    DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
  }

  public void  setEmail(String email){
    escreveNoCampo("email", email);
  }

  public void setSenha(String senha){
    escreveNoCampo("senha", senha);
  }

  public void entrar(){
    clicarBotaoPorTexto("Entrar");
  }

//  public void logar (String email, String senha){
//    setEmail(email);
//    setSenha(senha);
//    entrar();
//  }
}
