package com.example.imagepicker

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCamera.setOnClickListener {
            callCameraAciton()
        }
    }

    private fun callCameraAciton() {


        ImagePicker.with(this)
            .compress(1024)
            .maxResultSize(1080, 1080)
            .start { resultCode, data ->
                if (resultCode == Activity.RESULT_OK) {
                    //Image Uri will not be null for RESULT_OK
                    val fileUri = data?.data
                    //You can get File object from intent
                    val file: File? = ImagePicker.getFile(data)
                    //You can also get File Path from intent
                    val filePath: String? = ImagePicker.getFilePath(data)

                    Log.e("File", "$file")


                } else if (resultCode == ImagePicker.RESULT_ERROR) {
                    Log.e("TAG", "${ImagePicker.getError(data)}")
                } else {
                    Log.e("TAG", "Task cancelled")
                }
            }

    }


}