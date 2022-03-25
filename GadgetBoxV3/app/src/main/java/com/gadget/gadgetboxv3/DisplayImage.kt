package com.gadget.gadgetboxv3

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.opencv.android.Utils
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.core.Point
import org.opencv.core.Scalar
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgproc.Imgproc


class DisplayImage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_image)

        //Create bar for the page redirection
        val actionBar = supportActionBar

        //Creating variables to handle navigation calls
        val selectImage = findViewById<Button>(R.id.SelectImage)
        val showImage = findViewById<ImageView>(R.id.ShowBitmap)

        //Create variables for OpenCV function
        val img = Mat(600,600, CvType.CV_8UC1)
        var im: Mat
        val point1 = Point(100.0, 200.0)
        val point2 = Point(500.0, 400.0)
        val color1 = Scalar(255.0,255.0,255.0)
        val thickness = 10

        //Creating Bitmap to display image
        val bmap: Bitmap = Bitmap.createBitmap(null, 600, 600, Bitmap.Config.ARGB_8888, false)

        //Setting the title on the action bar
        actionBar!!.title = "Display Image"

        //Enabling back button on the action bar
        actionBar.setDisplayHomeAsUpEnabled(true)

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
                result -> if(result.resultCode == Activity.RESULT_OK)
                {
                    val data: Intent? = result.data
                    val path = data?.data
                    val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(contentResolver, path)
                    im = Mat(bitmap.width, bitmap.height, CvType.CV_8UC1)
                    Utils.bitmapToMat(bitmap, im)
                    Imgproc.rectangle(im, point1, point2, color1, thickness)
                    Utils.matToBitmap(im, bitmap)
                    showImage.setImageBitmap(bitmap)
                    //showImage.setImageURI(path)
                }
        }

        fun pickImageGallery()
        {
            val intent: Intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            resultLauncher.launch(intent)
        }

        selectImage.setOnClickListener {
            pickImageGallery()
            //Calling OpenCv function to draw rectangle
            //Imgproc.rectangle(im, point1, point2, color1, thickness)

            //Converting the OpenCV image to a bitmap
            //Utils.matToBitmap(im, bmap)

            //Function call to display image
            //showImage.setImageBitmap(bmap)
        }

    }

}