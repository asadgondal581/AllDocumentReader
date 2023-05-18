package com.example.alldocumentreader.view

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.alldocumentreader.R
import com.example.alldocumentreader.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog



class HomeFragment : Fragment() {

   private var binding:FragmentHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentHomeBinding.inflate(LayoutInflater.from(requireContext()),container,false)

        val dialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.permission_bottom_sheet_dialog, null)
        dialog.setCancelable(false)
        dialog.setContentView(view)
        dialog.show()
        val btnAllow = view.findViewById<Button>(R.id.idBtnDismiss)
      val imagView = view.findViewById<ImageView>(R.id.imageViewDismiss)
        btnAllow.setOnClickListener {
            dialog.dismiss()
            requestPermissions()
        }
        imagView.setOnClickListener {
            dialog.dismiss()
        }
        return binding?.root
    }
    companion object{
        const val PERMISSION_REQUEST_CODE = 100
    }
    private fun requestPermissions() {
        val permissions = arrayOf(
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, PERMISSION_REQUEST_CODE)
        }
    }
}