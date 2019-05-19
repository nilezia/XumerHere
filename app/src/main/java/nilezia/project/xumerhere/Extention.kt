package nilezia.project.xumerhere

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast


fun ProgressBar.visible() {

    this.visibility = View.VISIBLE
}

fun ProgressBar.inVisible() {

    this.visibility = View.INVISIBLE
}

fun ProgressBar.gone() {

    this.visibility = View.GONE
}

fun Context.toas(msg: String, duration: Int = Toast.LENGTH_LONG) {

    Toast.makeText(this, msg, duration).show()
}