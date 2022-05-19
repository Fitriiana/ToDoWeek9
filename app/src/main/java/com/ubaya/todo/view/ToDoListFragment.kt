package com.ubaya.todo.view

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.todo.R
import com.ubaya.todo.model.Todo
import com.ubaya.todo.viewModel.ListTodoViewModel
import kotlinx.android.synthetic.main.fragment_to_do_list.*
import kotlinx.android.synthetic.main.todo_item_layout.*


class ToDoListFragment : Fragment() {
    private lateinit var viewModel: ListTodoViewModel
    private val todoListAdapter  = TodoListAdapter(arrayListOf()) {
        viewModel.updateTask(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListTodoViewModel::class.java)
        viewModel.refresh()
        recViewToDo.layoutManager = LinearLayoutManager(context)
        recViewToDo.adapter = todoListAdapter

        floatingActionButton.setOnClickListener {
            val action = ToDoListFragmentDirections.actionCreateTodo()
            Navigation.findNavController(it).navigate(action)
        }
        observeViewModel()
    }

     private fun observeViewModel() {
        viewModel.todoLD.observe(viewLifecycleOwner, Observer {
            todoListAdapter.updateTodoList(it)
            if(it.isEmpty()) {
                txtEmpty.visibility = View.VISIBLE
            } else {
                txtEmpty.visibility = View.GONE
            }
        })
    }
}