package com.exampletest.mobilestudiotest.ui

import android.app.Activity
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ScrollView

/**
 * The update log (File → Update Log, About → What's new). Opens by itself once after the app
 * is updated to a version with a new entry.
 */
object UpdateLog {
    class Section(val title: String, val items: List<String>)
    class Release(val version: String, val date: String, val headline: String, val sections: List<Section>)

    val RELEASES = listOf(
        Release("6.5", "November 2026", "Several fixes", listOf(
    Section("Api Key Section", listOf(
        "If you have a previously saved Api key, the Ui section when publishing to roblox will be different. And it's better and easier to use.",
    )),
)),
        Release("6.0", "November 2026", "Several fixes", listOf(
    Section("Compressed local files", listOf(
        "It's fixed. If you save where you want it, it will be compressed to a smaller size.",
    )),
)),
        Release("5.0", "November 2026", "New Progress Bar of loading Place or loading model", listOf(
    Section("New", listOf(
        "Added because wanted to notice the user to know that the loading is still didnt complete.",
        "New Bugs fixed when loading bigger Mb model can crash on mobile. (This might still not work on a few low end Mobile Ram.",
    )),
)),
        Release("2.5", "November 2026", "New Icons", listOf(
    Section("New", listOf(
        "Changed Iconic icons into amber icon.",
        "New Bugs fixed",
    )),
)),
        Release("2.0", "November 2026", "AI Assistant and MCP, terrain, new templates, lighting effects, icon themes, better avatars and animations, and lots of fixes", listOf(
            Section("Old", listOf(
                "AI Assistant (Home → AI → Assistant): chat with Claude to build in your place, like Roblox Studio's Assistant. It can create parts, models, terrain, lighting and GUIs, write scripts, and read the Explorer, your selection and the Output. Setup is 3 steps, all on your phone: open the Anthropic Console, copy a key, tap Paste (the key is checked for free and stored only on this device). \"Undo AI changes\" puts the place back.",
                "Connect an AI app (Assistant → Connect an AI app): an MCP server like Roblox Studio's, so other AI apps that support MCP can build in Studio. Apps on the same phone connect directly (no computer needed); a computer can connect over USB or Wi-Fi (optional). It's off until you turn it on and protected by a secret key.",
                "Smooth terrain: places with terrain now show it (grass, rock, sand, snow… with Roblox's colors), with water you can swim in, collisions, shadows, and terrain saved and published exactly like Roblox Studio.",
                "Terrain Editor (Home → Terrain → Editor): Generate maps with biomes (water, plains, hills, dunes, canyons, mountains, marsh, arctic, lavascape), caves, map size and seed; sculpt with Add, Subtract, Grow, Erode, Smooth, Flatten, Paint and Sea Level brushes. Each stroke can be undone.",
                "Terrain scripting: Terrain:FillBlock/FillBall/FillCylinder/FillWedge/FillRegion, ReadVoxels/WriteVoxels, ReplaceMaterial, Clear, CountCells and more; raycasts hit terrain and report its material.",
                "New templates, grouped like Studio's: Baseplate and Classic Baseplate, Flat Terrain, Empty, plus game templates Obby (checkpoints, moving and spinning platforms, kill bricks, a stage leaderboard), Team Arena (two teams, spawns, cover, a sword and a Kills/Deaths leaderboard), Island (generated terrain) and Village (houses with lamps, trees and a well).",
                "The Baseplate template now has Studio's modern lighting: Sky, Atmosphere, Bloom, Sun Rays and Depth of Field.",
                "Lighting effects: PointLights, SpotLights and SurfaceLights light up their surroundings, and Bloom, Blur, Color Correction and Sun Rays show in the editor and in playtests (Studio Settings → Lighting effects to turn them off on slower phones).",
                "Icon themes (Studio Settings → Icons): Colorful, Monochrome (like Studio's new UI), Accent, Vibrant, Soft, and Classic for an imported pack.",
                "New color picker, like the macOS one: a color wheel with brightness, sliders (RGB with hex, HSB, gray), the Roblox BrickColor palette with names, colored pencils, the original vs new color, and your own saved colors.",
                "Sharper terrain: smooth terrain has surface detail instead of flat, blurry colors (Studio Settings → Terrain detail).",
                "SpawnLocations in every template (and ones you insert) have Studio's spawn decal on top.",
                "Update log (this window), with a Copy button for the whole log. The version is now 2.0.",
            )),
            Section("Avatars & animation", listOf(
                "Animator:LoadAnimation now works (before, only Humanoid:LoadAnimation did, so most games' animations never played).",
                "Animation plugins: in edit mode Motor6D.Transform, C0 and C1 move the rig like Studio, Animator:StepAnimations previews animations, and KeyframeSequenceProvider gives temporary ids (RegisterKeyframeSequence) and downloads KeyframeSequences to edit.",
                "Animations from the newer Animation Editor (CurveAnimation) now play, as do animation packages and emotes that point to another animation.",
                "Characters get Roblox's Animate script with its animation IDs: games that change Animate.walk.WalkAnim.AnimationId (or disable Animate) now work, and custom IDs fall back to the default animation while they load.",
                "Animations that can't load now say why in the Output (for example when you're not signed in), and failed downloads are retried.",
                "R15 faces: the face is now projected onto mesh heads instead of floating in front of them, and classic heads show your face (or the default smile).",
                "R6 looks like Roblox's R6: slightly bevelled limbs and torso, with clothing wrapping over the edges.",
                "R6 body packages (like the Woman body) now show on R6 characters, wearing your shirt and pants.",
                "Dynamic heads on R6: your avatar's own head and face show on R6 characters (instead of the classic head with the default smile), like Roblox.",
                "R15 heads never go missing: while a head mesh is downloading (or if it can't be read) the character shows Roblox's head shape in your skin color.",
            )),
            Section("Playtest", listOf(
                "Shift lock no longer lags behind the camera: the character turns with it instantly.",
                "First person no longer shows your own face.",
                "Wallhops: like Roblox, a quick camera flick while jumping against a wall lets you jump again.",
                "Collisions use the character's real 2x1 body that turns with it (you can get as close to walls as on Roblox).",
                "Swimming in terrain water (hold jump to swim up, jump to climb out).",
                "The camera no longer lags behind when you jump or fall: it follows the character exactly, like Roblox.",
                "Roblox-style top bar: a capsule with the Roblox logo, a divider, then chat and more (leaderboard and emotes), and the player list starts closed on phones.",
                "The Roblox menu (tap the Roblox logo) looks like Roblox's: icon tabs with a white underline, an \"In this experience\" people list, ◀ ▶ selectors and 10-step bars for Volume and Graphics Quality, and dark Reset Character / Leave buttons with a white Resume.",
                "Emotes menu with Roblox's default emotes (wave, point, cheer, laugh, dance, dance 2, dance 3); /e commands still work.",
                "Teams and spawns: players are put on a team when a game has teams and spawn at their team's SpawnLocations (or a random neutral one), and Player.RespawnLocation is used.",
                "Terrain is drawn much farther away.",
            )),
            Section("Fixes", listOf(
                "Publishing places from files: parts no longer turn into balls or lose their shadows when the file left out their shape.",
                "Dragging models: Locked parts inside a model move with it, a second finger can't start a second drag that fights the first, and the model's pivot moves with it.",
                "Archimedes: Render / Render All now render every copy (plugins see Selection.SelectionChanged when a script changes the selection), and its angle dial draws correctly (sprite sheets use the real image size; UIGradient works on images).",
                "The edit-mode thumbstick no longer draws on top of plugin windows.",
                "Island template: you spawn on a flat grass clearing on top of the island instead of inside a hill (and falling through it).",
                "Characters that would spawn inside terrain are placed on top of it instead, like Roblox.",
                "Terrain had thin gaps along some chunk borders where clicks, the camera and spawn checks went straight through; fixed.",
            )),
        )),
        Release("1.1", "November 2026", "Studio start page, Creator Store prices, avatars and many fixes", listOf(
            Section("Highlights", listOf(
                "Start page with your experiences, shared games and groups.",
                "Toolbox prices and free/paid filters; Open Cloud publishing.",
                "R15 avatars with clothing, accessories and Roblox's default animations.",
            )),
        )),
        Release("1.0", "November 2026", "First release", listOf(
            Section("Highlights", listOf("Open, edit, script, playtest and publish Roblox places on Android.")),
        )),
    )

    private const val PREFS = "update_log"

    /** The whole log as plain text (the Copy button), e.g. to paste into a post or a video description. */
    fun asText(): String = buildString {
        for (r in RELEASES) {
            appendLine("Mobile Studio ${r.version} (${r.date}): ${r.headline}")
            for (s in r.sections) {
                appendLine()
                appendLine(s.title)
                for (i in s.items) appendLine("- $i")
            }
            appendLine()
        }
    }.trimEnd() + "\n"

    /** Shows the log once per new version (call when the editor opens). */
    fun showIfNew(act: Activity) {
        val (ver, _) = AboutDialog.version(act)
        val p = act.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val seen = p.getString("seen", null)
        if (seen == ver) return
        p.edit().putString("seen", ver).apply()
        // A fresh install doesn't need the log; an update from an older version does.
        if (seen == null && !p.getBoolean("installedBefore", false)) {
            p.edit().putBoolean("installedBefore", true).apply()
            if (act.getSharedPreferences("studio_settings", Context.MODE_PRIVATE).all.isEmpty()) return
        }
        if (RELEASES.any { it.version == ver }) show(act)
    }

    fun show(act: Activity) {
        fun dp(v: Float) = Ui.dp(act, v)
        val box = LinearLayout(act).apply { orientation = LinearLayout.VERTICAL; setPadding(dp(20f), dp(16f), dp(20f), dp(8f)) }
        box.addView(Ui.text(act, "Update Log", 20f, Ui.TEXT, true))
        box.addView(Ui.text(act, "What changed in each version of Mobile Studio", 12.5f, Ui.DIM).apply { setPadding(0, dp(2f), 0, dp(6f)) })
        for ((i, r) in RELEASES.withIndex()) {
            val card = LinearLayout(act).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(dp(14f), dp(12f), dp(14f), dp(10f))
                background = GradientDrawable().apply { setColor(Ui.CARD); cornerRadius = dp(10f).toFloat() }
            }
            val head = LinearLayout(act).apply { orientation = LinearLayout.HORIZONTAL; gravity = Gravity.CENTER_VERTICAL }
            head.addView(Ui.text(act, "Version ${r.version}", 16f, Ui.TEXT, true), Ui.lp(0, Ui.WRAP, 1f))
            if (i == 0) head.addView(Ui.text(act, "NEW", 10.5f, 0xFFFFFFFF.toInt(), true).apply {
                setPadding(dp(7f), dp(2f), dp(7f), dp(2f))
                background = GradientDrawable().apply { setColor(Ui.ACCENT); cornerRadius = dp(8f).toFloat() }
            })
            card.addView(head)
            card.addView(Ui.text(act, "${r.date} · ${r.headline}", 12f, Ui.DIM).apply { isSingleLine = false; setPadding(0, dp(2f), 0, dp(4f)) })
            for (s in r.sections) {
                card.addView(Ui.text(act, s.title.uppercase(), 11f, Ui.DIM, true).apply { letterSpacing = 0.08f; setPadding(0, dp(10f), 0, dp(4f)) })
                for (item in s.items) {
                    val row = LinearLayout(act).apply { orientation = LinearLayout.HORIZONTAL; setPadding(0, dp(2f), 0, dp(3f)) }
                    row.addView(Ui.text(act, "•", 13f, Ui.ACCENT, true).apply { setPadding(0, 0, dp(8f), 0) })
                    row.addView(Ui.text(act, item, 13f, Ui.TEXT).apply { isSingleLine = false; setTextIsSelectable(true) }, Ui.lp(0, Ui.WRAP, 1f))
                    card.addView(row)
                }
            }
            box.addView(card, Ui.lp(Ui.MATCH, Ui.WRAP).apply { topMargin = dp(10f) })
        }
        Dialogs.themed(act).setView(ScrollView(act).apply { addView(box) })
            .setNeutralButton("Copy") { _, _ ->
                val cm = act.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
                cm.setPrimaryClip(android.content.ClipData.newPlainText("Update log", asText()))
                android.widget.Toast.makeText(act, "Update log copied", android.widget.Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Close", null).show()
    }
}
