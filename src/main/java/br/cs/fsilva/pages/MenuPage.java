package br.cs.fsilva.pages;

import br.cs.fsilva.core.BasePage;

public class MenuPage extends BasePage {

  public void acessarTelaInserirContas(){
    clicarLink("Contas");
    clicarLink("Adicionar");
  }
  public void acessarTelaListarContas(){
    clicarLink("Contas");
    clicarLink("Listar");
  }

  public void acessarTelaInserirMovimentacao(){
    clicarLink("Criar Movimentação");
  }
  public void acessarTelaResumo(){
    clicarLink("Resumo Mensal");
  }
  public void acessarTelaPrincipal(){
    clicarLink("Home");
  }
}
