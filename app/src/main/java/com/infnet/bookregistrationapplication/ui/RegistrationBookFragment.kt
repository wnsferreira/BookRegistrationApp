package com.infnet.bookregistrationapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.infnet.bookregistrationapplication.R
import kotlinx.android.synthetic.main.fragment_registration_book.*

class RegistrationBookFragment : Fragment() {

    private lateinit var bookViewModel: BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var bookViewModelFactory = BookViewModelFactory()
        var viewModelProvider = ViewModelProvider(requireActivity(), bookViewModelFactory)

        bookViewModel = viewModelProvider.get(BookViewModel::class.java)

        bookViewModel.quantityBook
            .observe(viewLifecycleOwner
            ) {
                textViewTotalBooks.text = it.toString()
            }

        btnRegistrationBook.setOnClickListener {
            var nameBook = editTextNameBook.text.toString()
            var yearRelease = editTextYearBook.text.toString()

            if (!nameBook.isNullOrEmpty() && !yearRelease.isNullOrEmpty()) {
                bookViewModel.saveBook(nameBook, yearRelease)

                Toast.makeText(
                    requireContext(),
                    "Livro Cadastrado com Sucesso!",
                    Toast.LENGTH_LONG
                ).show()

                bookViewModel.addBook()

                findNavController().navigate(R.id.action_registrationBookFragment_to_listBookFragment)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Preencha todos os campos",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

    }
}