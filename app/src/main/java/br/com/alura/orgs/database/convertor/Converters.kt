package br.com.alura.orgs.database.convertor

import androidx.room.TypeConverter
import java.math.BigDecimal

class Converters {

    @TypeConverter
    fun doubleToBigDecimal(value: Double?): BigDecimal {
        return value?.let { BigDecimal(value.toString()) } ?: BigDecimal.ZERO
    }

    @TypeConverter
    fun bigDecimalToDouble(value: BigDecimal?): Double? {
        return value?.let { value.toDouble() }
    }
}