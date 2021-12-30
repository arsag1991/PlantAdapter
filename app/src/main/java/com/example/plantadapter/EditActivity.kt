package com.example.plantadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantadapter.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.flower1
    private val flowerIdList = listOf(
        R.drawable.flower1,
        R.drawable.flower2,
        R.drawable.flower3,
        R.drawable.flower4,
        R.drawable.flower5)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons ()
    }
    private fun initButtons () = with(binding){
        bNext.setOnClickListener {
            indexImage++
            if (indexImage > flowerIdList.size - 1) indexImage = 0
            imageId = flowerIdList[indexImage]
            imageView.setImageResource(imageId)
        }
        bDone.setOnClickListener {
            var flower = Flower (imageId, edTitle.text.toString(), edDesc.text.toString())
            var editIntent = Intent().apply {
                putExtra("flower", flower)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }



}