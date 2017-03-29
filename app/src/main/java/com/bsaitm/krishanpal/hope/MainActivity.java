package com.bsaitm.krishanpal.hope;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

import static com.bsaitm.krishanpal.hope.R.id.submit;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static String EXTRA_MESSAGE="com.example.myfirstapp.MESSAGE";
    public static String EXTRA_MESSAGE3="com.example.myfirstapp.MESSAGE3";
    public static String EXTRA_MESSAGE2="com.example.myfirstapp.MESSAGE2";
    public static String EXTRA_MESSAGE1="com.example.myfirstapp.MESSAGE1";
    public static String EXTRA_MESSAGE4="com.example.myfirstapp.MESSAGE4";
    private static final int PICK_IMAGE_REQUEST = 1;
    Button choose,submit;
    Uri filepath;
    private StorageReference mStorageRef;
    DatabaseReference databaseUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        choose =(Button) findViewById(R.id.choose);
        submit=(Button) findViewById(R.id.submit);
        choose.setOnClickListener(this);
        submit.setOnClickListener(this);
        databaseUsers= FirebaseDatabase.getInstance().getReference("users");

    }





    private void imagechooser(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select an image"),PICK_IMAGE_REQUEST);

    }
    private void uploadfile(){

        if(filepath!=null) {
            final ProgressDialog progressDialog=new ProgressDialog(this);
            progressDialog.setTitle("submitting..");
            progressDialog.show();

            StorageReference riversRef = mStorageRef.child("images/message.jpg");

            riversRef.putFile(filepath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // Get a URL to the uploaded content
                              progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),"submitted with photo",Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            // Handle unsuccessful uploads
                            // ...
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
                        }
                    })
            .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress=(100.0* taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                    progressDialog.setMessage(((int)progress)+"% submitted");
                }
            })



            ;
        }else{
              Toast.makeText(getApplicationContext(),"choose photo",Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(this, Main2Activity.class);
        EditText editText2=(EditText) findViewById(R.id.editText5);
        EditText editText3=(EditText) findViewById(R.id.editText4);
        EditText editText4=(EditText) findViewById(R.id.editText3);
        EditText editText5=(EditText) findViewById(R.id.editText);
        EditText editText = (EditText) findViewById(R.id.editText6);
        String message3 = editText4.getText().toString().trim();
        String message2 = editText3.getText().toString().trim();
        String message1 = editText2.getText().toString().trim();
        String message = editText.getText().toString().trim();
        String message4=editText5.getText().toString().trim();
        if(!TextUtils.isEmpty(message)){
          String  id=databaseUsers.push().getKey();
            Users user =new Users(id,message,message1,message3,message2,message4);
           databaseUsers.child(id).setValue(user) ;
            Toast.makeText(this,"User added",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"you should enter name",Toast.LENGTH_LONG).show();
        }
        intent.putExtra(EXTRA_MESSAGE3,message3);
        intent.putExtra(EXTRA_MESSAGE2,message2);
        intent.putExtra(EXTRA_MESSAGE1,message1);
        intent.putExtra(EXTRA_MESSAGE,message);
        intent.putExtra(EXTRA_MESSAGE4,message4);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode== RESULT_OK && requestCode==PICK_IMAGE_REQUEST && data!=null &&data.getData()!=null){
            filepath=data.getData();


        }


    }

    @Override
    public void onClick(View view){
    if(view==choose){
            imagechooser();}
        else if (view == submit){
        uploadfile();
    }
    }

}
