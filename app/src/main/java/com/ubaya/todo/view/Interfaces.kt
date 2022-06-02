package com.ubaya.todo.view

import android.view.View
import android.widget.CompoundButton
import com.ubaya.todo.model.Todo

interface TodoCheckedChangeListener{
    fun onCheckedChange(cb : CompoundButton, isChecked: Boolean, obj: Todo)
}

interface TodoEditClickListener{
    fun onTodoEditClick(view:View)
}

interface RadioButtonListener {
    fun onRadioClick(v:View, priority:Int, obj:Todo)
}
interface TodoSaveChangedClick {
    fun onSaveChangesClick(v: View, obj: Todo)
}
