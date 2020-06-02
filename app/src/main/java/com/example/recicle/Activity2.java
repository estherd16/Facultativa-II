package com.example.recicle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Intent;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity {
    TextView mTitleView, mDescriptionView,mProfesorView,mDiaView,mHoraView,mFechaentView;
    ImageView mImageView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);

        ActionBar actionBar=getSupportActionBar();

        mTitleView=findViewById(R.id.titleview);
        mDescriptionView=findViewById(R.id.descripcionview);
        mImageView=findViewById(R.id.imageview);
        mProfesorView=findViewById(R.id.profesorview);
        mDiaView=findViewById(R.id.diaview);
        mHoraView=findViewById(R.id.horaview);
        mFechaentView=findViewById(R.id.fechaentregaview);

        Intent intent=getIntent();
        String mTitle=intent.getStringExtra("iTitle");
        String mDes=intent.getStringExtra("iDesc");
        String mProf=intent.getStringExtra("iProfesor");
        String mDia=intent.getStringExtra("iDia");
        String mHora=intent.getStringExtra("iHora");
        String mFecha=intent.getStringExtra("iFechentrega");

        byte[] mBytes=getIntent().getByteArrayExtra("iImage");
        Bitmap bitmap=BitmapFactory.decodeByteArray(mBytes,0,mBytes.length);

        actionBar.setTitle(mTitle);
        mTitleView.setText(mTitle);
        mDescriptionView.setText(mDes);
        mImageView.setImageBitmap(bitmap);
        mProfesorView.setText(mProf);
        mDiaView.setText(mDia);
        mHoraView.setText(mHora);
        mFechaentView.setText(mFecha);


    }

}
