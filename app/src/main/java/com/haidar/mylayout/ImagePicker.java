package com.haidar.mylayout;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ImagePicker extends AppCompatActivity {

    ImageView  imgPick;
    Button btnCamera, btnGallery;
    int CODE_CAMERA = 1;
    int CODE_GALLERY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imgPick = findViewById(R.id.img1);
        btnCamera = findViewById(R.id.btnCam);
        btnGallery = findViewById(R.id.btnGal);

        btnCamera.setOnClickListener(view -> {
            Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(camera, CODE_CAMERA);
        });

        btnGallery.setOnClickListener(view -> {
            Intent gallery = new Intent();
            gallery.setType("image/*");
            gallery.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(
                    Intent.createChooser(gallery, "Pilih Gambar"),
                    CODE_GALLERY
            );
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODE_CAMERA){
            assert data != null;
            Bitmap bmp = (Bitmap) data.getExtras().get("data");
            imgPick.setImageBitmap(bmp);
        }else if(requestCode == CODE_GALLERY){
            try {
                Uri uri = data.getData();
                InputStream imgStream = getContentResolver().openInputStream(uri);
                Bitmap img = BitmapFactory.decodeStream(imgStream);
                imgPick.setImageBitmap(img);
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }else{
            // kondisi yang tidak diinginkan != 1 atau 2
            Toast.makeText(this, "Something went wrong...",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}