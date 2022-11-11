package ml.pvstudio.sno.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ml.pvstudio.sno.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val url = "https://www.upload.ee/download/14658434/ab07c04497d81bf4be77/IMG_0080.JPG"
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(binding.imageView)



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


