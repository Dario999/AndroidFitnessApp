package com.example.fitnessapp.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.CategoriesActivity;
import com.example.fitnessapp.R;
import com.example.fitnessapp.model.Category;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {

    private StorageReference storageReference;
    private Context context;
    private ArrayList<Category> categories;

    public CategoriesAdapter(Context context, ArrayList<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.category_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.MyViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.textViewName.setText(category.getName());


        /*if(position == 0){
            storageReference = FirebaseStorage.getInstance().getReference("images/chest.jpg");
        }else if(position == 1){
            storageReference = FirebaseStorage.getInstance().getReference("images/abs.jpg");
        }else{
            storageReference = null;
        }

        if(storageReference != null) {
            try {
                File file = File.createTempFile("tempFile", ".jpg");
                storageReference.getFile(file)
                        .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                                holder.imageView.setImageBitmap(bitmap);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Toast.makeText(CategoriesAdapter.this,"Failed to load image",Toast.LENGTH_LONG).show();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        //holder.imageView.setImageBitmap(bitmap);
        if(position == 0){
            //holder.imageView.setImageResource(R.drawable.chest);
            holder.linearLayout.setBackgroundResource(R.drawable.chest);
        }else if(position == 1){
            //holder.imageView.setImageResource(R.drawable.abs);
            holder.linearLayout.setBackgroundResource(R.drawable.abs);
        }else{
            holder.linearLayout.setBackgroundResource(R.drawable.abs);
        }
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        ImageView imageView;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.category_name);
            //imageView = itemView.findViewById(R.id.image_category);
            linearLayout = itemView.findViewById(R.id.category_item_ll);
        }

    }

}
