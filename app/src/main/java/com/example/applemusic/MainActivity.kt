package com.example.applemusic

import TrackAdapter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applemusic.configuration.ApiConfig
import com.example.applemusic.model.ApiResponse
import com.example.applemusic.model.JsonTrack
import com.example.applemusic.ui.theme.AppleMusicTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    private lateinit var tracks: List<JsonTrack>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)

        // get the tracks from the API
        getTracks()
    }

    fun getTracks() {
        val client = ApiConfig.getApiService().getTracks()

        client.enqueue(object : Callback<ApiResponse> {

            // if the request is successful, get the tracks from the response
            override fun onResponse(
                call: Call<ApiResponse>,
                response: Response<ApiResponse>
            ) {
                val responseBody = response.body()
                if (!response.isSuccessful || responseBody == null) {
                    return
                }


                // get the tracks from the response
                tracks = responseBody.feed.tracks

                // display the tracks in the UI
                renderUI();
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

    fun renderUI() {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // create the adapter with the tracks
        val adapter = TrackAdapter(tracks)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // set the adapter to the recycler view
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