package com.example.animelist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : AppCompatActivity() {

    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnLogout = findViewById(R.id.btnLogout)

        val dummyAnimeList = listOf(
            Anime(
                "Naruto",
                "Ninja muda dengan cita-cita menjadi Hokage.",
                "https://primaprint.co.id/uploads/abdu/naruto.jpg",
                "https://myanimelist.net/anime/20/Naruto"
            ),
            Anime(
                "One Piece",
                "Petualangan Luffy menjadi Raja Bajak Laut.",
                "https://primaprint.co.id/uploads/abdu/one-piece.jpeg",
                "https://myanimelist.net/anime/21/One_Piece?cat=anime"
            ),
            Anime(
                "Attack on Titan",
                "Manusia melawan Titan untuk bertahan hidup.",
                "https://primaprint.co.id/uploads/abdu/aot.jpeg",
                "https://myanimelist.net/anime/16498/Shingeki_no_Kyojin"
            ),
            Anime(
                "Demon Slayer",
                "Tanjiro membasmi iblis demi menyelamatkan adiknya.",
                "https://primaprint.co.id/uploads/abdu/kimetsu.jpg",
                "https://myanimelist.net/anime/16498/Shingeki_no_Kyojin"
            ),
            Anime(
                "Jujutsu Kaisen",
                "Yuji memakan jari kutukan dan menjadi penyihir jujutsu.",
                "https://primaprint.co.id/uploads/abdu/jujutsu.jpg",
                "https://myanimelist.net/anime/40748/Jujutsu_Kaisen"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rvAnime)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = AnimeAdapter(dummyAnimeList) { anime ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(anime.url)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        btnLogout.setOnClickListener {
            val prefs = getSharedPreferences("APP_PREFS", MODE_PRIVATE)
            prefs.edit().putBoolean("IS_LOGGED_IN", false).apply()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish() // supaya tidak bisa kembali ke Home pakai tombol Back
        }
    }
}