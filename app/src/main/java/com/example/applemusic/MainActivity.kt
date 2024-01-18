package com.example.applemusic

import TrackAdapter
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applemusic.model.parseJson
import com.example.applemusic.service.ITunesApiService
import com.example.applemusic.ui.theme.AppleMusicTheme
import com.example.applemusic.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)

        // print in terminal the track list
        val jsonFile = assets.open("apple-music.json")
        val json = jsonFile.bufferedReader().use { it.readText() }

        val tracks = parseJson(json);

        tracks.forEach {
            Log.d("MainActivity", it.toString())
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = TrackAdapter(tracks)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }













    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppleMusicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }

                // print in terminal the track list
                val jsonFile = assets.open("apple-music.json")
                val json = jsonFile.bufferedReader().use { it.readText() }

                val tracks = parseJson(json);

                tracks.forEach {
                    Log.d("MainActivity", it.toString())
                }

                val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                val adapter = TrackAdapter(tracks)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter
            }
        }
    }*/

    /*val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = TrackAdapter(tracks)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter*/
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppleMusicTheme {
        Greeting("Android")
    }
}