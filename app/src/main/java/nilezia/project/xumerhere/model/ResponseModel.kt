package nilezia.project.xumerhere.model

import android.os.Parcel
import android.os.Parcelable
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import nilezia.project.xumerhere.data.Restaurant

class ResponseModel() : Parcelable {

    var total_entries: Long = 0
    var per_page: Int = 0
    var current_page: Int = 0
    var restaurants: MutableList<Restaurant> = mutableListOf()

    constructor(parcel: Parcel) : this() {
        total_entries = parcel.readLong()
        per_page = parcel.readInt()
        current_page = parcel.readInt()
    }


    class Deserializer: ResponseDeserializable<ResponseModel> {
        override fun deserialize(content: String): ResponseModel? {
            return Gson().fromJson(content, ResponseModel::class.java)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(total_entries)
        parcel.writeInt(per_page)
        parcel.writeInt(current_page)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResponseModel> {
        override fun createFromParcel(parcel: Parcel): ResponseModel {
            return ResponseModel(parcel)
        }

        override fun newArray(size: Int): Array<ResponseModel?> {
            return arrayOfNulls(size)
        }
    }


}