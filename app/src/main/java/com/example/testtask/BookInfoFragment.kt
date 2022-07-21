package com.example.testtask

import android.graphics.ColorSpace
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.testtask.databinding.FragmentBookInfoBinding
import com.squareup.picasso.Picasso

class BookInfoFragment(private val bundle: Bundle) : Fragment() {

    private lateinit var binding: FragmentBookInfoBinding
    private val myViewModel = MyViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        myViewModel.onCreateBookInfo()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            title.text = bundle.getString("title")
            author.text = bundle.getString("author")
            ratingScore.text = bundle.getString("ratingScore")
            ratingAmount.text = "(${bundle.getString("ratingAmount")})"
            buy.text = "${bundle.getString("price")}€"
            Picasso.get().load(bundle.getString("image")).into(image)
            back.setOnClickListener {
                App.INSTANCE.router.backTo(Screens.booksList())
            }
        }
        myViewModel.bookSimilarLiveData.observe(viewLifecycleOwner) { image ->
            if (image == null) {
                Toast.makeText(
                    requireContext(),
                    "something went wrong check your internet connection",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                binding.recyclerView.adapter = SimilarAdapter(image)
            }
        }
    }

}