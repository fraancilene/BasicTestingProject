package br.cs.fsilva.core;
import br.cs.fsilva.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.cs.fsilva.core.DriverFactory.killDriver;
import static br.cs.fsilva.core.DriverFactory.getDriver;

public class BaseTest {

  private LoginPage page = new LoginPage();

  // a partir daqui vai tirar o screenchots antes de fechar o browser
  @Rule
  public TestName testName= new TestName();

  // efetuando login
  @Before
  public void inicializaPagina(){
    page.acessarTelaInicial();
    page.setEmail("fran@silva");
    page.setSenha("123456");
    page.entrar();

  }

  // metodo que será chamado depois de cada teste
    @After
    public void FinalizaBrowser() throws IOException {
        // para tirar screnchot da tela
        TakesScreenshot ss  = (TakesScreenshot) getDriver();
       File arquivo = ss.getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(arquivo, new File("target" +File.separator+ "screenshots"
               + File.separator +  testName.getMethodName() + "screenshot.jpg"));


       // aqui vai fechar o browser
        if (br.cs.fsilva.core.Propriedades.FECHAR_BROWSER){
            killDriver();
        }



    }
}
