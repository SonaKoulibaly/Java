package core;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Fonction {
    public static String formatDate(Date date){
        String format="dd/MM/yyyy";//06/jan/2023
        DateFormat dF=new SimpleDateFormat(format);
        String dateEString= dF.format(date);
       return dateEString;
    }
}
