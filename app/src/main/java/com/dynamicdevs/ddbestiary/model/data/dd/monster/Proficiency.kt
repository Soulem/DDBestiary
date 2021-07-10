package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Proficiency(
    val proficiency: ProficiencyX?,
    val value: Int?
): Parcelable{
    private companion object : Parceler<Proficiency> {
        override fun Proficiency.write(parcel: Parcel, flags: Int) {
            parcel.writeParcelable(proficiency, 0)
            parcel.writeInt(value?: 0)
        }

        override fun create(parcel: Parcel): Proficiency {
            // Custom read implementation
            val returnProficiency : Proficiency = Proficiency(
                parcel.readParcelable<ProficiencyX>(ProficiencyX::class.java.classLoader) ?: ProficiencyX("","",""),
                parcel.readInt())

            return returnProficiency
        }
    }
}