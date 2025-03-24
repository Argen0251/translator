package com.example.translator.view

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.translator.databinding.FragmentTranslateBinding
import com.example.translator.viewmodel.TranslateViewModel

class TranslateFragment : Fragment() {

    private lateinit var binding: FragmentTranslateBinding
    private val viewModel: TranslateViewModel by viewModels()

    private var src = "en"
    private var dsk = "ru"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTranslateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setulistener()
        viewModel.translateResponse.observe(viewLifecycleOwner) { response ->
            val translation = response.firstOrNull()?.translations?.firstOrNull()?.text
            binding.txtTranslate.text = translation
        }
    }

    private fun setulistener() {
        binding.translateBtn.setOnClickListener {
            val query = binding.inputText.text.toString()
            viewModel.translate(query, src, dsk)

        }
        binding.switchBtn.setOnClickListener {
            //анимация кнопки изменение
            binding.switchBtn.animate()
                .rotationBy(180f)
                .setDuration(300)
                .start()

            val tempLang = src
            src = dsk
            dsk = tempLang

            val tempText = binding.src.text
            binding.src.text = binding.dst.text
            binding.dst.text = tempText
        }
        binding.copyBtn.setOnClickListener {
            val text = binding.txtTranslate.text.toString()
            if (text.isNotBlank()) {
                val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("Текст", text)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(context, "Скопировано", Toast.LENGTH_SHORT).show()
            }
        }

    }






}
