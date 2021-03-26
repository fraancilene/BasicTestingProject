package br.cs.fsilva.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataUtils {

  // obter datas para testes de data futura
  public static Date obterDataComDiferencaDias(int dias){
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, dias);
    return calendar.getTime();

  }

  public static String obterDataFormatada(Date data){
    DateFormat  format = new SimpleDateFormat("dd/MM/YYYY");
    return format.format(data);
  }

}
