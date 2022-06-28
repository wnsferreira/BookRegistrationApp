package com.infnet.bookregistrationapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.infnet.bookregistrationapplication.FullViewModel
import com.infnet.bookregistrationapplication.R
import com.infnet.bookregistrationapplication.adapter.BookRecyclerAdapter
import com.infnet.bookregistrationapplication.model.Book
import kotlinx.android.synthetic.main.fragment_list_book.*


class ListBookFragment : Fragment() {

    private lateinit var listBookViewModel: BookViewModel
    private lateinit var fullViewModel: FullViewModel

    var quantityBooks = MutableLiveData<Int>()

    init {
        quantityBooks.value = 2
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_book, container, false)

        fullViewModel =
            ViewModelProvider(requireActivity())
                .get(FullViewModel::class.java)

        listBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        listBookViewModel
            .status
            .observe(viewLifecycleOwner) {

            }

        listBookViewModel
            .msg
            .observe(viewLifecycleOwner) {
                showSnackbar(it)
            }

        listBookViewModel
            .books
            .observe(viewLifecycleOwner) { books ->
                val bookRecyclerAdapter = BookRecyclerAdapter(books, this::actionClick)
                listViewBook.adapter = bookRecyclerAdapter
                listViewBook.layoutManager = LinearLayoutManager(requireContext())
            }

        return view
    }

    private fun showSnackbar(msg: String) {
        Snackbar.make(
            list_book_layout_root,
            msg,
            Snackbar.LENGTH_LONG
        ).show()
    }

    fun actionClick(book : Book){
        fullViewModel.selectBook(book)
        findNavController().navigate(R.id.showBookFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabListBookRegistration.setOnClickListener {
            findNavController().navigate(R.id.action_listBookFragment_to_registrationBookFragment)
        }
    }
}