package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Damage(
    val damage_dice: String?,
    val damage_type: DamageType?
): Parcelable{
    private companion object : Parceler<Damage> {
        override fun Damage.write(parcel: Parcel, flags: Int) {
            parcel.writeString(damage_dice)
            parcel.writeParcelable(damage_type, 0)
        }

        override fun create(parcel: Parcel): Damage {
            // Custom read implementation

            val returnDamage : Damage = Damage(
                parcel.readString() ?: "",
                parcel.readParcelable<DamageType>(DamageType::class.java.classLoader) ?: DamageType("", "", "")
            )

            return returnDamage
        }
    }
}