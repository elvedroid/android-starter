package com.elveselimoski.starterapp.json

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class DateTypeAdapter : TypeAdapter<Date>() {
    @Throws(IOException::class)
    override fun write(out: JsonWriter, value: Date) {
        out.value(value.toString())
    }

    @Throws(IOException::class)
    override fun read(jsonreader: JsonReader): Date {
        val dateString = jsonreader.nextString()
        val date = SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(dateString)
        return date
    }

    companion object {
        private const val DATE_FORMAT = "yyyy-MM-dd'T'hh:mmZ"
    }
}
