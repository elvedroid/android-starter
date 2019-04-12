package com.elveselimoski.starterapp.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTypeAdapter extends TypeAdapter<Date> {

    private final static String DATE_FORMAT = "yyyy-MM-dd'T'hh:mmZ";

    public void write(JsonWriter out, Date value) throws IOException {
        out.value(value.toString());
    }

    public Date read(JsonReader jsonreader) throws IOException {
        String dateString = jsonreader.nextString();
        try {
            return new SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
