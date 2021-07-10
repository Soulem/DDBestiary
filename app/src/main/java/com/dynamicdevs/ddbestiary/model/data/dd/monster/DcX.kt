package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class DcX(
    val dc_type: DcTypeX?,
    val dc_value: Int?,
    val success_type: String?
): Parcelable{
    private companion object : Parceler<DcX> {
        override fun DcX.write(parcel: Parcel, flags: Int) {
            parcel.writeParcelable(dc_type, 0)
            parcel.writeInt(dc_value?: 0)
            parcel.writeString(success_type)
        }

        override fun create(parcel: Parcel): DcX {
            // Custom read implementation
            val returnCcX : DcX = DcX(
                parcel.readParcelable<DcTypeX>(DcTypeX::class.java.classLoader) ?: DcTypeX("", "", ""),
                parcel.readInt(),
                parcel.readString() ?: "")

            return returnCcX
        }
    }
}