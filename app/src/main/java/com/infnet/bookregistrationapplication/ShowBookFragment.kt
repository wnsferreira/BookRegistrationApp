package com.infnet.bookregistrationapplication

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.infnet.bookregistrationapplication.model.Book
import kotlinx.android.synthetic.main.fragment_show_book.*


class ShowBookFragment : Fragment() {

    private lateinit var fullViewModel: FullViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_show_book, container, false)

        fullViewModel =
            ViewModelProvider(requireActivity())
                .get(FullViewModel::class.java)

        fullViewModel.book
            .observe(viewLifecycleOwner){
                updateUI(it)
            }

        return view
    }

    private fun updateUI(book: Book) {
        textViewNameBook.text = book.nameBook
        textViewYearRelease.text = book.yearRelease
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btnIntent.setOnClickListener {

            val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                putExtra(SearchManager.QUERY, fullViewModel.book.value?.nameBook)
            }
            if (intent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}
