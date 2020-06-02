package com.example.recicle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.DoubleBuffer;


public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView mImageView;
    TextView mTitle,mDescription;
    ItemClickListener itemClickListener;

    MyHolder(@NonNull View itemView) {
        super(itemView);
        this.mImageView = itemView.findViewById(R.id.imagelv);
        this.mDescription = itemView.findViewById(R.id.descripcion);
        this.mTitle = itemView.findViewById(R.id.title);


        itemView.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v, getLayoutPosition());
    }

    public void setItemClickListener (ItemClickListener ic){
        this.itemClickListener = ic;
    }


}


