package br.cs.fsilva.pages;

import br.cs.fsilva.core.BasePage;

public class HomePage extends BasePage {

  public String obterSaldoConta(String nome){
    return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
  }
}
