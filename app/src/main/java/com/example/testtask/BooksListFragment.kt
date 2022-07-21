package com.example.testtask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.testtask.databinding.FragmentBooksListBinding

class BooksListFragment : Fragment() {

    private val myViewModel = MyViewModel()

    private lateinit var binding: FragmentBooksListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        myViewModel.onCreateBookList()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentBooksListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myViewModel.bookImagesLiveData.observe(viewLifecycleOwner) { images ->
            if (images == null) {
                Toast.makeText(
                    requireContext(),
                    "something went wrong check your internet connection",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                binding.carousel.adapter = ImagesAdapter(images)
            }
        }
        myViewModel.booksLiveData.observe(viewLifecycleOwner) { books ->
            if (books == null) {
                Toast.makeText(
                    requireContext(),
                    "something went wrong check your internet connection",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                binding.recyclerView.adapter = BooksAdapter(books)
            }
        }
    }

}