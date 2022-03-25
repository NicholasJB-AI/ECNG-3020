package com.gadget.gadgetboxv3

import Node.LinkedList
import Node.LookUp
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import org.opencv.android.OpenCVLoader
import org.opencv.android.Utils
import org.opencv.core.*
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgproc.Imgproc
import java.io.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private val CAMERA_PERMISSION_CODE = 42
    private val STORAGE_PERMISSION_CODE = 52
    private lateinit var photoFile: File
    private lateinit var codeFile: File
    lateinit var currentPhotoPath: String
    lateinit var currentCodePath: String
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creating variables to handle navigation calls
        val generate = findViewById<Button>(R.id.Generate)
        val display = findViewById<Button>(R.id.DisplayImage)
        val capture_image = findViewById<Button>(R.id.CaptureImage)

        //Checking if OpenCV loaded successfully
        Log.d("TAG", "OpenCV Loading Status: ${OpenCVLoader.initDebug()}")
        Toast.makeText(this, "OpenCV Loading Status: ${OpenCVLoader.initDebug()}", Toast.LENGTH_LONG).show()

        //Function call for creating and generating the python code
        generate.setOnClickListener{
            //Getting Storage Permissions
            checkPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE)
            checkPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE)

            //val file = "code.txt"
            //var path = getExternalFilesDir("Python Code")
            //var fileOut = File(path, file)
            //fileOut.delete()
            //val fileOutputStream: FileOutputStream
            //Creating LinkedList object
            val list: MutableCollection<String> = LinkedList()
            //Adding the Opcodes to the linkedlist
            list.add("SS;")
            list.add("BN(=X=5);")
            list.add("BN(=Y=7);")
            list.add("CS0507(=Y);")
            list.add("BG(=X=Y)Y;")
            list.add("BL(=A=360);")
            list.add("BL(=B=360);")
            list.add("CQ(=5000);")
            list.add("CG(=A);")
            list.add("CG(=B);")
            list.add("XX;")
            try
            {
                //Creating the python file

                //fileOut.createNewFile()

                //codeFile = createCodeFile()
                //codeFile.setWritable(true)
                //val writer = FileWriter(codeFile)
                //val uriCode = FileProvider.getUriForFile(this, "com.gadget.gadgetboxv3.fileprovider", codeFile)
                //fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                //Incrementing through the list and writing to the file

                val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
                File(applicationContext.getExternalFilesDir("Python Code"), "Code${timeStamp}.py").printWriter().use {
                    out ->
                    for(item in list)
                    {
                        //Creating LookUp object
                        val opcode = LookUp()
                        var code: String = ""
                        //Function call to match Opcodes from linkedlist
                        code = opcode.match(item)

                        out.print(code)
                        //Writing python code to file
                        //fileOut.writeText(code)
                        //writer.write(code)
                        //writer.flush()
                        //writer.close()
                        //fileOutputStream.write(code.toByteArray())
                        //PrintWriter(openFileOutput(file, Context.MODE_PRIVATE)).use{
                        //it.println("Hello World")
                        //}
                    }
                }

            }
            //Catching any file errors that could occur
            catch(e: FileNotFoundException)
            {
                e.printStackTrace()
            }
            catch(e:NumberFormatException)
            {
                e.printStackTrace()
            }
            catch(e: IOException)
            {
                e.printStackTrace()
            }
            catch(e:Exception)
            {
                e.printStackTrace()
            }
            //Creating display message when generating the code
            Toast.makeText(this, "Generating", Toast.LENGTH_SHORT).show()

        }

        //Function call to navigate to the display screen activity
        display.setOnClickListener {
            //Creating an intent to navigate to the other screen
            val intent: Intent = Intent(this, DisplayImage::class.java)
            //Navigating to the other screen on function call
            startActivity(intent)
        }

        //Function call to navigate to the capture image screen activity
        capture_image.setOnClickListener {
            //Checking Permissions
            checkPermissions(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)
            //Creating an intent to navigate to the other screen
            //val cameraIntent: Intent = Intent(this, CaptureImage::class.java)
            //Navigating to the other screen on function call
            //startActivity(cameraIntent)
            takePicture()
        }

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

    private fun createCodeFile(): File
    {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        return File.createTempFile("Code_${timeStamp}_", ".py", storageDir).apply {
            currentCodePath = absolutePath
        }
    }

    private fun checkPermissions(permission:String, requestCode:Int)
    {
        if(ContextCompat.checkSelfPermission(this@MainActivity, permission)==PackageManager.PERMISSION_DENIED)
        {
            //Get Permission
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), requestCode)

        }
        else
        {
            Toast.makeText(this@MainActivity, "Permission Already Granted", Toast.LENGTH_LONG)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode==CAMERA_PERMISSION_CODE)
        {
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this@MainActivity, "Camera Permission Granted", Toast.LENGTH_SHORT)
            }
            else
            {
                Toast.makeText(this@MainActivity, "Camera Permission Denied", Toast.LENGTH_SHORT)
            }
        }
        else if (requestCode==STORAGE_PERMISSION_CODE)
        {
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this@MainActivity, "Storage Permission Granted", Toast.LENGTH_SHORT)
            }
            else
            {
                Toast.makeText(this@MainActivity, "Storage Permission Denied", Toast.LENGTH_SHORT)
            }
        }
    }
}

fun View.fromBitmap(): Bitmap {
    val spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    this.measure(spec, spec)
    this.layout(0, 0, this.measuredWidth, this.measuredHeight)
    val b = Bitmap.createBitmap(this.measuredWidth, this.measuredHeight,
        Bitmap.Config.ARGB_8888)
    val mPaintSquare: Paint
    mPaintSquare = Paint(Paint.ANTI_ALIAS_FLAG)
    mPaintSquare.setColor(Color.RED)
    mPaintSquare.textSize = 40f
    val c = Canvas(b)
    c.drawText("TextoTest",10f,45f,mPaintSquare);
    c.translate((-this.scrollX).toFloat(), (-this.scrollY).toFloat())
    this.draw(c)
    return b
}