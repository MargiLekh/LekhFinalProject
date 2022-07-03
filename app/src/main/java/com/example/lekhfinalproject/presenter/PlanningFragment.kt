package com.example.lekhfinalproject.presenter

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
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
    private val binding: FragmentPlanningBinding by viewBinding()

    private val formatDate = SimpleDateFormat("dd.MM.yyyy", Locale.ROOT)

    private val viewModel: PlanningViewModel by lazy {
        ViewModelProvider(this).get(PlanningViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.quote.observe(viewLifecycleOwner) {
            if (it != null) {
                val dialogBuilder = AlertDialog.Builder(requireContext())
                dialogBuilder.setMessage(it)
                    .setCancelable(false)
                    .setPositiveButton("ОК", DialogInterface.OnClickListener { dialog, id ->
                        dialog.dismiss()
                    })
                val alert = dialogBuilder.create()
                alert.setTitle("Так держать!")
                alert.show()
            }
        }
        with(binding) {
            title.setText(args.planning?.title ?: "")
            description.setText(args.planning?.description ?: "")
            deadlineLabel.setText(R.string.dealine)
            deadline.setText(
                args.planning?.deadlineTime ?: resources.getString(R.string.enter_date)
            )
            timeToDeadlineLabel.setText(R.string.rest_time)
            timeToDeadline.setText(args.planning?.restTime ?: "")

            deadline.setOnClickListener {
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
                        deadline.text = date

                        val daysBetween = TimeUnit.MILLISECONDS.toDays(
                            selectDate.timeInMillis - Calendar.getInstance().timeInMillis
                        )
                        if (daysBetween > 0) {
                            timeToDeadline.text = daysBetween.toString()
                            timeToDeadline.setTextColor(R.color.black)
                        } else {
                            timeToDeadline.text = "Истекло"
                            timeToDeadline.setTextColor(R.color.red)
                        }
                    },
                    getDate.get(Calendar.YEAR),
                    getDate.get(Calendar.MONTH),
                    getDate.get(Calendar.DAY_OF_MONTH)
                )
                datePicker.show()
            }

            //сюда запихать условие с проверкой на пустые строки
            saveBtn.setOnClickListener {
                if (title.text.toString() == "" ||
                    description.text.toString() == "" ||
                    deadline.text.toString() == "Введите дату" ||
                    timeToDeadline.text.toString() == ""
                ) {
                    Toast.makeText(context, "Не все данные заполнены", Toast.LENGTH_SHORT).show()
                } else if (timeToDeadline.text.toString() == "Истекло") {
                    Toast.makeText(
                        context,
                        "Эта дата уже прошла. Выберите другую",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    val planning = Planning(
                        title = title.text.toString(),
                        description = description.text.toString(),
                        deadlineTime = deadline.text.toString(),
                        restTime = timeToDeadline.text.toString()
                    )
                    viewModel.add(planning)
                    findNavController().popBackStack()
                }
            }

            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }

            checkbox.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
                override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                    if (p1) {
                        viewModel.getQuote()
                    }
                }

            })
        }


    }

}