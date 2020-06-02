package com.example.recicle;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<MyHolder> {
    Context c;
    ArrayList<Model> models;

    public Adapter(Context c,ArrayList<Model>models){
        this.c=c;
        this.models=models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {
        holder.mTitle.setText(models.get(position).getTitle());
        holder.mDescription.setText(models.get(position).getDescripcion());
        holder.mImageView.setImageResource(models.get(position).getImage());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                try {
                    String hTitle = models.get(position).getTitle();
                    String hDesc = models.get(position).getDescripcion();
                    String hProfesor=models.get(position).getProfesor();
                    String hDia=models.get(position).getDia();
                    String hHora=models.get(position).getHora();
                    String hFechaentrega=models.get(position).getFechaentrega();

                    BitmapDrawable bitmapDrawable = (BitmapDrawable) holder.mImageView.getDrawable();
                    Bitmap bitmap = bitmapDrawable.getBitmap();

                    ByteArrayOutputStream stream = new ByteArrayOutputStream();

                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] bytes = stream.toByteArray();

                    Intent intent = new Intent(c, Activity2.class);

                    intent.putExtra("iTitle", hTitle);
                    intent.putExtra("iDesc", hDesc);
                    intent.putExtra("iImage", bytes);
                    intent.putExtra("iProfesor",hProfesor);
                    intent.putExtra("iDia",hDia);
                    intent.putExtra("iHora",hHora);
                    intent.putExtra("iFehaentrega",hFechaentrega);
                    c.startActivity(intent);
                }
                catch (Exception e){
                    Toast.makeText(c, "Error: " + e.getMessage().toString(), Toast.LENGTH_LONG).show();
                }

            }

        });
    }
    @Override
    public int getItemCount() {
        return models.size();
    }
}

