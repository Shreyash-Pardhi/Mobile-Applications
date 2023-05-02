package com.example.todoapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.todoapp.Model.ToDoModel;
import com.example.todoapp.Utils.DataBaseHelper;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddNewTask extends BottomSheetDialogFragment {

    public static final String TAG = "AddNewTask";

    //widget
    private EditText medittxt;
    private Button svbtn;
    private DataBaseHelper myDB;

    public static AddNewTask newInstance(){
        return new AddNewTask();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_task, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        medittxt = view.findViewById(R.id.edittext);
        svbtn = view.findViewById(R.id.saveBtn);

        myDB = new DataBaseHelper(getActivity());

        boolean isUpdate = false;

        final Bundle bundle = getArguments();
        if(bundle!=null){
            isUpdate = true;
            String task = bundle.getString("task");
            medittxt.setText(task);
            if(task.length()<0){
                svbtn.setEnabled(false);
            }
        }
        medittxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    svbtn.setEnabled(false);
                    svbtn.setBackgroundColor(Color.GRAY);
                }else {
                    svbtn.setEnabled(true);
                    svbtn.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        final boolean finalIsUpdate = isUpdate;
        svbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = medittxt.getText().toString();
                if(finalIsUpdate){
                    myDB.updateTask(bundle.getInt("id"), text);
                }else{
                    ToDoModel item = new ToDoModel();
                    item.setTask(text);
                    item.setStatus(0);
                    myDB.insertTask(item);
                }
                dismiss();
            }
        });
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Activity activity = getActivity();
        if(activity instanceof OnDialogCloseListner){
            ((OnDialogCloseListner)activity).onDialogClose(dialog);
        }
    }
}
