package com.gadget.gadgetboxv3

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


private const val REQUEST_CODE = 42
class CaptureImage : AppCompatActivity() {

    private var pictureIV: ImageView? = null
    private lateinit var photoFile: File
    lateinit var currentPhotoPath: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capture_image)

        takePicture()

        pictureIV = findViewById(R.id.imageView)
        val uriDisplay = FileProvider.getUriForFile(this, "com.gadget.gadgetboxv3.fileprovider", photoFile )
        pictureIV!!.setImageURI(uriDisplay)

    }

    private fun takePicture()
    {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        photoFile = createImageFile()
        if(takePictureIntent.resolveActivity(this.packageManager)!=null)
        {
            val uri = FileProvider.getUriForFile(this, "com.gadget.gadgetboxv3.fileprovider", photoFile)
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
            startActivity(takePictureIntent)
        }
        else
        {
            Toast.makeText(applicationContext, "Unable To Open Camera", Toast.LENGTH_SHORT).show()
        }
    }

    private fun createImageFile(): File
    {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir).apply {
            currentPhotoPath = absolutePath
        }
    }

}