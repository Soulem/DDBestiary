package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dc(
    val dc_type: DcType?,
    val dc_value: Int?,
    val success_type: String?
): Parcelable{
    private companion object : Parceler<Dc> {
        override fun Dc.write(parcel: Parcel, flags: Int) {
            parcel.writeParcelable(dc_type, 0)
            parcel.writeInt(dc_value?: 0)
            parcel.writeString(success_type)
        }

        override fun create(parcel: Parcel): Dc {
            // Custom read implementation
            val returnDc : Dc = Dc(
                parcel.readParcelable<DcType>(DcType::class.java.classLoader) ?: DcType("", "", ""),
                parcel.readInt(),
                parcel.readString() ?: "")

            return returnDc
        }
    }
}