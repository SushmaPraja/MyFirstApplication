package com.example.myfirstapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myfirstapplication.R;
import com.example.myfirstapplication.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyHolder> {

    List<Student> studentList;


    public StudentAdapter(List<Student> studentList) {

        this.studentList = studentList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_list_recyclerview, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        final Student student = studentList.get(position);
        holder.tName.setText(student.getName());
        holder.tEmail.setText(student.getEmail());
        holder.tPhone.setText(student.getPhone());
        holder.imageView.setImageResource(R.drawable.bird);
        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList.remove(position);
                notifyDataSetChanged();


            }
        });
        holder.buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tName, tEmail, tPhone;
        Button buttonEdit, buttonDelete;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            tName = itemView.findViewById(R.id.textName);
            tEmail = itemView.findViewById(R.id.textEmail);
            tPhone = itemView.findViewById(R.id.textPhone);
            buttonEdit = itemView.findViewById(R.id.btnEdit);
            buttonDelete = itemView.findViewById(R.id.btnDelete);

        }
    }

}