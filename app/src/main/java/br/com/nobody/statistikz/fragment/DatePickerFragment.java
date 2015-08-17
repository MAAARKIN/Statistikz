package br.com.nobody.statistikz.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.nobody.statistikz.app.App;
import br.com.nobody.statistikz.util.DateUtils;
import br.com.nobody.statistikz.util.Extra;


public class DatePickerFragment extends DialogFragment {

    private DatePickerDialog.OnDateSetListener onDateSetListener;

    public void setOnDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.onDateSetListener = onDateSetListener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        Bundle params = getArguments();
        if (params != null) {
            String source = params.getString(Extra.DATA);
            Date dateFromParams = DateUtils.StringToDate(source, "dd/MM/yyyy");
            c.setTime((dateFromParams != null ? dateFromParams : new Date()));
        } else {
            c.setTime(new Date());
        }

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), onDateSetListener, year, month, day);
    }
}
