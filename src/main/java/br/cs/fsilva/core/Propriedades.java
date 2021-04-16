package br.cs.fsilva.core;

// classe para reuso do browser
public class Propriedades {

  public static boolean FECHAR_BROWSER = false; // o browser abrirá uma vez e fechará ao final de todos os testes

public static Browsers browser = Browsers.CHROME;
//public static Browsers browser = Browsers.FIREFOX;
//public static Browsers browser = Browsers.IE_EXPLORER;
public static String NOME_CONTA_ALTERADA = "Conta Alterada " + System.nanoTime();

  // chaveamento de browsers
  public enum Browsers {
    CHROME,
    FIREFOX,
    IE_EXPLORER
  }


  /*a prática correta é que cada teste abra seu browser, execute e feche.*/
}
