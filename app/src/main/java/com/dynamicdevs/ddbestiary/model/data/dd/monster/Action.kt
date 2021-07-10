package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Action(
    val attack_bonus: Int?,
    val damage: List<Damage>?,
    val dc: Dc?,
    val desc: String?,
    val name: String?,
    val options: Options?,
    val usage: Usage?
): Parcelable{
    private companion object : Parceler<Action> {
        override fun Action.write(parcel: Parcel, flags: Int) {
            parcel.writeInt(attack_bonus?: 0)
            parcel.writeArray(arrayOf(damage))
            parcel.writeParcelable(dc, 0)
            parcel.writeString(desc)
            parcel.writeString(name)
            parcel.writeParcelable(options, 0)
            parcel.writeParcelable(usage, 0)
        }

        override fun create(parcel: Parcel): Action {
            // Custom read implementation
            val list : List<List<From>> = emptyList()

            val returnAction : Action = Action(
                parcel.readInt(),
                arrayListOf<Damage>().apply{
                    parcel.readList(this,Damage::class.java.classLoader)} as List<Damage>,
                parcel.readParcelable<Dc>(Dc::class.java.classLoader)  ?: Dc(
                    DcType("", "", ""),
                    0,
                    ""),
                parcel.readString() ?: "",
                parcel.readString() ?: "",
                parcel.readParcelable<Options>(Options::class.java.classLoader) ?: Options(0, list),
                parcel.readParcelable<Usage>(Usage::class.java.classLoader) ?: Usage("", 0, "")
            )

            return returnAction
        }
    }
}