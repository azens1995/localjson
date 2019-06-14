package com.azens1995.localjsontest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.azens1995.localjsontest.databinding.ListstudentBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azens Eklak on 2019-06-13.
 * Ishani Technology Pvt. Ltc
 * azens1995@gmail.com
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<PersonModel> personList = new ArrayList<>();
    private PersonClick personClick;

    public PersonAdapter(List<PersonModel> personList, PersonClick click) {
        this.personList = personList;
        this.personClick = click;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(parent.getContext());
        ListstudentBinding liststudentBinding = DataBindingUtil.inflate(layoutInflater, R.layout.liststudent, parent, false);
        return new ViewHolder(liststudentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(personList.get(position), personClick);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListstudentBinding studentBinding;
        public ViewHolder(ListstudentBinding liststudentBinding) {
            super(liststudentBinding.getRoot());
            this.studentBinding = liststudentBinding;
        }

        public void  bind(final PersonModel personModel, final PersonClick personClick){
            studentBinding.setStudent(personModel);
            studentBinding.getRoot().setOnClickListener(view->{
                personClick.onClick(studentBinding.getRoot(),personModel);
            });
        }
    }
}
