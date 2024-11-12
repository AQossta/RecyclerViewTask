package com.example.recyclerviewtask

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recyclerviewtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listOfProducts = listOf<Product>(
            Product("Parrot", 100),
            Product("Apple", 200),
            Product("Cherry", 300),
            Product("Banana", 400),
            Product("Orange", 500),
            Product("Pear", 600),
            Product("Pineapple", 700),
            Product("Strawberry", 800),
            Product("Blueberry", 900),
            Product("Kiwi", 1000),
            Product("Mango", 1100),
            Product("Peach", 1200),
            Product("Watermelon", 1300),
            Product("Grape", 1400),
            Product("Lemon", 1500),
            Product("Lime", 1600),
            Product("Pomegranate", 1700),
            Product("Plum", 1800),
            Product("Raspberry", 1900),
            Product("Avocado", 2000)
        )

        val adapter = ExampleRecyclerAdapter()
        binding.rcProducts.adapter = adapter
        adapter.submitList(listOfProducts)

        val fragment1 = ExampleFirstFragment()
        binding.btnShowFragmentFirst.setOnClickListener {
            supportFragmentManager.beginTransaction().add(binding.tvPlaceForFragment.id, fragment1).commit()
        }

        val fragment2 = ExampleSecondFragment()
        binding.btnShowFragmentSecond.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(binding.tvPlaceForFragment.id, fragment2).commit()
        }

        binding.btnRemoveFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().remove(fragment1).commit()
            supportFragmentManager.beginTransaction().remove(fragment2).commit()
        }
    }
}