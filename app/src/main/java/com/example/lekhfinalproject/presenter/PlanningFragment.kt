package com.example.lekhfinalproject.presenter

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lekhfinalproject.R
import com.example.lekhfinalproject.data.Planning
import com.example.lekhfinalproject.databinding.FragmentPlanningBinding
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class PlanningFragment : Fragment(R.layout.fragment_planning) {
    private val args: PlanningFragmentArgs by navArgs()

    //private val planning : Planning? = args.planning
    private val binding: FragmentPlanningBinding by viewBinding()

    private val formatDate = SimpleDateFormat("dd.MM.yyyy", Locale.ROOT)

    private val viewModel: PlanningViewModel by lazy {
        ViewModelProvider(this).get(PlanningViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //передает текст из аргсов
        viewModel.quote.observe(viewLifecycleOwner) {
            if(it != null)
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
        binding.title.setText(args.planning?.title ?: "")
        binding.description.setText(args.planning?.description ?: "")
        binding.deadlineLabel.setText(R.string.dealine)
        binding.deadline.setText(args.planning?.deadlineTime ?: "Введите дату")
        binding.timeToDeadlineLabel.setText(R.string.rest_time)
        binding.timeToDeadline.setText(args.planning?.restTime ?: "")

        binding.deadline.setOnClickListener {
            val getDate: Calendar = Calendar.getInstance()
            val datePicker = DatePickerDialog(
                it.context,
                R.style.Theme_LekhFinalProject,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, i)
                    selectDate.set(Calendar.MONTH, i2)
                    selectDate.set(Calendar.DAY_OF_MONTH, i3)
                    val date = formatDate.format(selectDate.time)
                    binding.deadline.text = date

                    val daysBetween = TimeUnit.MILLISECONDS.toDays(
                        selectDate.timeInMillis - Calendar.getInstance().timeInMillis
                    )
                    if (daysBetween > 0) {
                        binding.timeToDeadline.text = daysBetween.toString()
                        binding.timeToDeadline.setTextColor(R.color.black)
                    } else {
                        binding.timeToDeadline.text = "Истекло"
                        binding.timeToDeadline.setTextColor(R.color.red)
                    }
                },
                getDate.get(Calendar.YEAR),
                getDate.get(Calendar.MONTH),
                getDate.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        //сюда запихать условие с проверкой на пустые строки
        binding.saveBtn.setOnClickListener {
            if (binding.title.text.toString() == "" ||
                binding.description.text.toString() == "" ||
                binding.deadline.text.toString() == "Введите дату" ||
                binding.timeToDeadline.text.toString() == ""
            ) {
                Toast.makeText(context, "Не все данные заполнены", Toast.LENGTH_SHORT).show()
            } else if (binding.timeToDeadline.text.toString() == "Истекло") {
                Toast.makeText(context, "Эта дата уже прошла. Выберите другую", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val planning = Planning(
                    title = binding.title.text.toString(),
                    description = binding.description.text.toString(),
                    deadlineTime = "Дедлайн:  " + binding.deadline.text.toString(),
                    restTime = "Осталось дней:  " + binding.timeToDeadline.text.toString()
                )
                viewModel.add(planning)
                findNavController().popBackStack()
            }
        }

        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.checkbox.setOnCheckedChangeListener (object: CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                if (p1) {
                    viewModel.getQuote()
                }
            }

        } )

    }

}