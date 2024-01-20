import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.applemusic.R
import com.example.applemusic.model.JsonTrack

class TrackAdapter(private val tracks: List<JsonTrack>) : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    inner class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val trackName: TextView = itemView.findViewById(R.id.trackName)
        private val artistName: TextView = itemView.findViewById(R.id.artistName)
        private val category: TextView = itemView.findViewById(R.id.category)
        private val trackImage: ImageView = itemView.findViewById(R.id.trackImage)

        fun bind(track: JsonTrack) {
            trackName.text = track.name.toString()
            artistName.text = track.artist.label
            category.text = track.category.attributes.label

            // Use Glide or any other image loading library to load the image
            Glide.with(itemView.context)
                .load(track.images[track.images.size - 1].label)
                .into(trackImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_track, parent, false)
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(tracks[position])
    }

    override fun getItemCount(): Int {
        return tracks.size
    }
}
