package br.cs.fsilva.pages;

import br.cs.fsilva.core.BasePage;

public class MenuPage extends BasePage {

  public void acessarTelaInserirContas(){
    clicarLink("Contas");
    clicarLink("Adicionar");
  }
}
