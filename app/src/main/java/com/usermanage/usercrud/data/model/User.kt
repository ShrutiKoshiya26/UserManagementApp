package com.usermanage.usercrud.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "userTB"
)
@Parcelize
data class User(
    @PrimaryKey(
        autoGenerate = true
    )
    var id: Long = 0,
    val name: String,
    val email: String,
    val age: Int,
) : Parcelable
