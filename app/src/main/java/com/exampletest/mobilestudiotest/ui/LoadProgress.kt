package com.exampletest.mobilestudiotest.ui

import android.app.Activity
import android.app.Dialog
import android.widget.LinearLayout
import android.widget.ProgressBar

/**
 * A small "Opening..." dialog with a 0-100% bar, shown while a place or model file is read.
 * update() and dismiss() are safe to call from any thread.
 */
class LoadProgress(private val act: Activity, title: String) {
    private val bar = ProgressBar(act, null, android.R.attr.progressBarStyleHorizontal).apply { max = 100; progress = 0 }
    private val label = Ui.text(act, "0%", 13f, Ui.DIM)
    private var dlg: Dialog? = null
    @Volatile private var last = -1

    init {
        val box = LinearLayout(act).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(Ui.dp(act, 20f), Ui.dp(act, 12f), Ui.dp(act, 20f), Ui.dp(act, 8f))
        }
        box.addView(bar, Ui.lp(Ui.MATCH, Ui.WRAP))
        box.addView(label, Ui.lp(Ui.MATCH, Ui.WRAP))
        act.runOnUiThread {
            if (!act.isFinishing) {
                dlg = Dialogs.themed(act).setTitle(title).setView(box).setCancelable(false).create()
                dlg?.show()
            }
        }
    }

    fun update(percent: Int, text: String) {
        val p = percent.coerceIn(0, 100)
        if (p == last) return
        last = p
        act.runOnUiThread { bar.progress = p; label.text = "$p%  $text" }
    }

    fun dismiss() {
        act.runOnUiThread { try { dlg?.dismiss() } catch (_: Exception) {} }
    }
}
