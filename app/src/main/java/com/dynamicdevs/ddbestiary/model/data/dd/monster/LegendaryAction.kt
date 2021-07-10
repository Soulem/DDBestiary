package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class LegendaryAction(
    val damage: List<DamageX>?,
    val dc: DcX?,
    val desc: String?,
    val name: String?
): Parcelable{
    private companion object : Parceler<LegendaryAction> {
        override fun LegendaryAction.write(parcel: Parcel, flags: Int) {
            parcel.writeArray(arrayOf(damage))
            parcel.writeParcelable(dc, 0)
            parcel.writeString(desc)
            parcel.writeString(name)
        }

        override fun create(parcel: Parcel): LegendaryAction {
            // Custom read implementation
            val returnLegendaryAction : LegendaryAction = LegendaryAction(
                arrayListOf<DamageX>().apply{
                    parcel.readList(this,DamageX::class.java.classLoader)} as List<DamageX>,
                parcel.readParcelable<DcX>(DcX::class.java.classLoader) ?: DcX(DcTypeX("","",""), 0, ""),
                parcel.readString() ?: "",
                parcel.readString() ?: "")

            return returnLegendaryAction
        }
    }
}