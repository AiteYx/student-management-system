package com.hbsfdx.system.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatConversion {

    public static Date StringToDate(String string) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(string);
    }

    public static String DateToString(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return  sdf.format(date);
    }
}
