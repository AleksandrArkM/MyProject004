package com.example.myproject003

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.DrawableRes
import com.example.myproject003.databinding.ActivityMainBinding
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    @SuppressLint("StringFormatInvalid", "StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        var likeStatus = 0
        val countStringLikes = binding.likesNumber.text.toString()
        var counterL: Double = countStringLikes.toDouble()

        setContentView(binding.root)

        binding.likesButton.setOnClickListener {

            if (likeStatus == 0) {
                binding.likesButton.setImageResource(R.drawable.ic_liked_24)
                likeStatus = 1
                counterL++

                if ((Math.abs(counterL) >= 0) && Math.abs(counterL) < 1000) {
                    binding.likesNumber.text = getString(R.string.app_likes, (counterL).toInt(), "")
                } else if ((Math.abs(counterL / 1_000) >= 1) && (Math.abs(counterL / 1_000) < 10)) {
                    val counterLrounded =
                        (counterL / 1_000).toBigDecimal().setScale(1, RoundingMode.HALF_EVEN).toDouble()
                    binding.likesNumber.text =
                        getString(R.string.app_likes, (counterLrounded).toString(), "k")
                } else if ((Math.abs(counterL / 1_000) >= 10) && (Math.abs(counterL / 1_000) < 1000)) {
                    val counterLrounded =
                        (counterL / 1_000).toBigDecimal().setScale(1, RoundingMode.HALF_EVEN).toDouble()
                    binding.likesNumber.text =
                        getString(R.string.app_likes, (counterLrounded).toInt(), "k")
                } else if (Math.abs(counterL)>= 1_000_000) {
                    val counterLrounded =
                        (counterL / 1_000_000).toBigDecimal().setScale(1, RoundingMode.HALF_EVEN)
                            .toDouble()
                    binding.likesNumber.text =
                        getString(R.string.app_likes, (counterLrounded).toString(), "m")
                }

            } else {
                if (likeStatus == 1)  {
                    binding.likesButton.setImageResource(R.drawable.ic_baseline_favorite_24)
                    likeStatus = 0
                    counterL--

                    if ((Math.abs(counterL) >= 0) && Math.abs(counterL) < 1000) {
                        binding.likesNumber.text =
                            getString(R.string.app_likes, (counterL).toInt(), "")
                    } else if (Math.abs(counterL / 1_000) >= 1 && (Math.abs(counterL) < 9999)) {
                        counterL--
                        val counterLrounded =
                            (counterL / 1_000).toBigDecimal().setScale(1, RoundingMode.HALF_EVEN).toDouble()
                        binding.likesNumber.text =
                            getString(R.string.app_likes, (counterLrounded).toString(), "k")
                    } else if (Math.abs(counterL) >= 9999 && (Math.abs(counterL / 1000) < 1000)) {
                        counterL--
                        val counterLrounded =
                        (counterL / 1_000).toBigDecimal().setScale(1, RoundingMode.HALF_EVEN).toDouble()
                        binding.likesNumber.text =
                        getString(R.string.app_likes, (counterLrounded).toInt(), "k")
                    } else if (Math.abs(counterL) >= 1_000_000) {
                        counterL--
                        val counterLrounded =
                        (counterL / 1_000_000).toBigDecimal().setScale(1, RoundingMode.HALF_DOWN)
                            .toDouble()
                        binding.likesNumber.text =
                        getString(R.string.app_likes, (counterLrounded).toString(), "m")
                    }
                }
            }
        }

        binding.shareButton.setOnClickListener {


            val countStringReposts = binding.sharesCount.text.toString()
            var counterR: Int = Integer.parseInt(countStringReposts)
            counterR++
            binding.sharesCount.text = counterR.toString()


        }
    }

}