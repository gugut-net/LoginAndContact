package com.example.loginandcontacts.ui.music

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.loginandcontact.databinding.FragmentMusicBinding
import com.example.loginandcontacts.MusicService

class MusicFragment : Fragment() {

    private var _binding: FragmentMusicBinding? = null

    /**
     * This property is only valid between onCreateView and onDestroyView.
     */
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMusicBinding.inflate(inflater,
            container,
            false)

        val root: View = binding.root
        val mainActivity = activity as AppCompatActivity
        val intent = Intent(mainActivity, MusicService::class.java)

        binding.btnPlay.setOnClickListener {
            intent.action = "Play"
            mainActivity.stopService(intent)
            mainActivity.startService(intent)
        }
        binding.btnStop.setOnClickListener {
            intent.action = "Stop"
            mainActivity.stopService(intent)
        }
        return root
    }
}