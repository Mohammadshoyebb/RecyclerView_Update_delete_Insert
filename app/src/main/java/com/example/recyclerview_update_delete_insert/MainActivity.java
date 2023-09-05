package com.example.recyclerview_update_delete_insert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView number;
    String name;
    ImageView img;
    AppCompatButton next;

    FloatingActionButton btn;
    AppCompatButton b1;
    TextView  txt1;
    EditText edn,ednb;

    RecyclerView rv;
    String nama = "",numba = "";

    ArrayList<Contact_Structure> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recv = findViewById(R.id.RV);
        recv.setLayoutManager(new LinearLayoutManager(this));

        btn = findViewById(R.id.fab);
        rv = findViewById(R.id.RV);
        rv.setLayoutManager(new LinearLayoutManager(this));

        adding();

        Viewholder adt = new Viewholder(this,arr);
        rv.setAdapter(adt);

//        code for adding new item in contact using dialog box

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog d = new Dialog(MainActivity.this);
                d.setContentView(R.layout.dailogbox);



                b1 = d.findViewById(R.id.add);
                edn = d.findViewById(R.id.edtnum);
                ednb = d.findViewById(R.id.edtnam);
                txt1 = d.findViewById(R.id.txtv1);

                txt1.setText("Add Contact");

                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (!edn.getText().toString().equals("") && !ednb.getText().toString().equals("")) {
                                    nama = edn.getText().toString();
                                    numba = ednb.getText().toString();
                                    arr.add(new Contact_Structure(R.drawable.l,numba, nama));

                                    adt.notifyItemInserted(arr.size()-1);

                                    recv.scrollToPosition(arr.size()-1);

                                    d.dismiss();
                                }else if (edn.getText().toString().equals("") &&ednb.getText().toString().equals("")) {
                                    Toast.makeText(MainActivity.this, "Name  & Numbermust not be empty", Toast.LENGTH_SHORT).show();}
                                else if(ednb.getText().toString().equals("")){
                                    Toast.makeText(MainActivity.this, "Number must not be empty", Toast.LENGTH_SHORT).show();}
else{
                                    Toast.makeText(MainActivity.this, "Name must not be empty", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        d.show();
            }
        });


//-----------------------------------------------------------------------------------
//        Updating Contacts










    }

    public void adding(){
        arr.add(new Contact_Structure(R.drawable.a, "Mohammad Arman", "8679465090"));
        arr.add(new Contact_Structure(R.drawable.b, "Mohammad Ali", "8964907613"));
        arr.add(new Contact_Structure(R.drawable.c, "Mohammad Sameer", "967890790"));
        arr.add(new Contact_Structure(R.drawable.d, "Mohammad Arif", "8679465090"));
        arr.add(new Contact_Structure(R.drawable.e, "Mohammad Rehab", "8984509970"));
        arr.add(new Contact_Structure(R.drawable.f, "Mohammad Razique", "9434765643"));
        arr.add(new Contact_Structure(R.drawable.g, "Mohammad Ahmad", "7968780989"));
        arr.add(new Contact_Structure(R.drawable.h, "Mohammad Daiyan", "9668978978"));
        arr.add(new Contact_Structure(R.drawable.i, "Mohammad Imran", "8675980902"));
        arr.add(new Contact_Structure(R.drawable.j, "Mohammad Maaz", "7275986790"));
        arr.add(new Contact_Structure(R.drawable.k, "Ayushman Singh", "7378765487"));
        arr.add(new Contact_Structure(R.drawable.l, "Abhishek Yadav", "6393567898"));
        arr.add(new Contact_Structure(R.drawable.m, "Ravins Katiyar", "9275873412"));
        arr.add(new Contact_Structure(R.drawable.n, "Prince Singh", "8967435490"));
        arr.add(new Contact_Structure(R.drawable.o, "Dev Dixit", "8796780498"));
        arr.add(new Contact_Structure(R.drawable.p, "Udit Tyagi", "9678432680"));
        arr.add(new Contact_Structure(R.drawable.q, "Sushant pratap", "9870484950"));
    }
}