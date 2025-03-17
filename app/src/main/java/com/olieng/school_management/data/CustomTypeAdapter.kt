package com.olieng.school_management.data

import androidx.room.PrimaryKey
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.olieng.school_management.model.SchoolData

class CustomTypeAdapter:TypeAdapter<SchoolData>() {
    override fun write(out: JsonWriter, value: SchoolData?) {
        value?.let {
            out.beginObject() // Start writing the object
            out.name("schoolId").value(it.schoolId)
            out.name("name").value(it.name)
            out.name("country").value(it.country)
            out.name("createdAt").value(it.createdAt)
            out.name("organizationName").value(it.organizationName)
            out.endObject()
        }
    }

    override fun read(`in`: JsonReader?): SchoolData {
       var schoolId = 0
        var name =""
        var createdAt=""
        var country=""
        var organizationName=""

        `in`?.beginObject()
        if (`in` != null) {
            while (`in` .hasNext()){
                when( `in` .nextName()){
                    "schoolId" -> schoolId =`in`.nextInt()
                    "name" -> name =`in` .nextString()
                    "createdAt" -> createdAt= `in` .nextString()
                    "country" -> country= `in` .nextString()
                    "organizationName" -> organizationName= `in` .nextString()
                    else-> `in` .skipValue()

                }

            }
        }
        `in`?.endObject()
        return SchoolData(schoolId, name, createdAt, country, organizationName)
    }
}