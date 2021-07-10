package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpecialAbility(
    val desc: String?,
    val name: String?,
    val usage: UsageX?
): Parcelable{
    private companion object : Parceler<SpecialAbility> {
        override fun SpecialAbility.write(parcel: Parcel, flags: Int) {
            parcel.writeString(desc)
            parcel.writeString(name)
            parcel.writeParcelable(usage, 0)
        }

        override fun create(parcel: Parcel): SpecialAbility {
            // Custom read implementation
            val returnProficiency : SpecialAbility = SpecialAbility(
                parcel.readString() ?: "",
                parcel.readString() ?: "",
                parcel.readParcelable<UsageX>(UsageX::class.java.classLoader) ?: UsageX(0,""))

            return returnProficiency
        }
    }
}