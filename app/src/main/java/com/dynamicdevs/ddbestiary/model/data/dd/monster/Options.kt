package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Options(
    val choose: Int?,
    val from: List<List<From>>?
): Parcelable{
    private companion object : Parceler<Options> {
        override fun Options.write(parcel: Parcel, flags: Int) {
            parcel.writeInt(choose?: 0)
            parcel.writeArray(arrayOf(from))
        }

        override fun create(parcel: Parcel): Options {
            // Custom read implementation
            val returnOptions : Options = Options(
                parcel.readInt(),
                arrayListOf<List<From>>().apply{
                    arrayListOf<From>().apply{
                    parcel.readList(this,From::class.java.classLoader)}} as List<List<From>>)

            return returnOptions
        }
    }
}