package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class DamageX(
    val damage_dice: String?,
    val damage_type: DamageTypeX?
): Parcelable{
    private companion object : Parceler<DamageX> {
        override fun DamageX.write(parcel: Parcel, flags: Int) {
            parcel.writeString(damage_dice)
            parcel.writeParcelable(damage_type, 0)
        }

        override fun create(parcel: Parcel): DamageX {
            // Custom read implementation

            val returnDamageX : DamageX = DamageX(
                parcel.readString() ?: "",
                parcel.readParcelable<DamageTypeX>(DamageTypeX::class.java.classLoader) ?: DamageTypeX("", "", "")
            )

            return returnDamageX
        }
    }
}