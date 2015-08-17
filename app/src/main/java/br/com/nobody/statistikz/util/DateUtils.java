package br.com.nobody.statistikz.util;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import br.com.nobody.statistikz.app.App;

/**
 * Created by Marquinhos on 15/08/15.
 */
public class DateUtils {

    public static String DateFormat(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        Locale local = new Locale("pt","BR");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", local);
        return dateFormat.format(calendar.getTime());
    }

    public static String DateNowFormat() {
        Calendar calendar = Calendar.getInstance();
        Locale local = new Locale("pt","BR");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", local);
        return dateFormat.format(calendar.getTime());
    }

    public static Date StringToDate(String source, String pattern) {
        DateFormat formatter = new SimpleDateFormat(pattern);
        try {
            Date dateFromSource = formatter.parse(source);
            return dateFromSource;
        } catch (ParseException e) {
            Log.e(App.LOG_STATISTIKZ, "Problema durante o parser da data", e);
        }
        return null;
    }

//    public static String DateToString(Date dateToParse, String pattern) {
//        DateFormat formatter = new SimpleDateFormat(pattern);
//        try {
//            Date dateFromSource = formatter.parse(source);
//            c.setTime(dateFromSource);
//        } catch (ParseException e) {
//            c.setTime(new Date());
//            Log.e(App.LOG_STATISTIKZ, "Problema durante o parser da data", e);
//        }
//        return null;
//    }
}
