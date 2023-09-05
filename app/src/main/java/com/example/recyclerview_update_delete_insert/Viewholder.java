package com.example.recyclerview_update_delete_insert;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Viewholder extends RecyclerView.Adapter<Viewholder.abcd> {

    Context cntx;
    AppCompatButton b1;
    EditText edn,ednb;
    TextView txt1;
    ArrayList<Contact_Structure> arr;

    Viewholder(Context Contact_Structure, ArrayList<Contact_Structure> arr){
        this.cntx = Contact_Structure;
        this.arr = arr;
    }


    @NonNull
    @Override
    public abcd onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cn = LayoutInflater.from(cntx).inflate(R.layout.contact_helping_layout, parent
        ,false);

         abcd vh = new abcd(cn);
         return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull abcd holder, int position) {

        holder.img.setImageResource(arr.get(position).img);
        holder.num.setText(arr.get(position).number);
        holder.nam.setText(arr.get(position).name);

//        code for Updating new element
//        ------------------------------------------------------------------------------------------------
        holder.edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog d = new Dialog(cntx);
                d.setContentView(R.layout.dailogbox);

                b1 = d.findViewById(R.id.add);
                edn = d.findViewById(R.id.edtnam);
                ednb = d.findViewById(R.id.edtnum);
                txt1 = d.findViewById(R.id.txtv1);



                txt1.setText("Edit Contact");
                b1.setText("Update");

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nama = "",numba = "";
                        if (!edn.getText().toString().equals("") && !ednb.getText().toString().equals("")) {
                            nama = edn.getText().toString();
                            numba = ednb.getText().toString();
                            arr.set(position,new Contact_Structure(arr.get(position).img, nama, numba));
                            notifyItemChanged(position);



                            d.dismiss();
                        }else if (edn.getText().toString().equals("") &&ednb.getText().toString().equals("")) {
                            Toast.makeText(cntx, "Name  & Numbermust not be empty", Toast.LENGTH_SHORT).show();}
                        else if(ednb.getText().toString().equals("")){
                            Toast.makeText(cntx, "Number must not be empty", Toast.LENGTH_SHORT).show();}
                        else{
                            Toast.makeText(cntx, "Name must not be empty", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
                d.show();


            }
        });
//---------------------------------------------------------------------------

//        Deletion of contact
//        -----------------------------------------------------------------------

        holder.ll.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder b = new AlertDialog.Builder(cntx)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure you want to delete")
                        .setIcon(R.drawable.delete)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            arr.remove(position);
                            notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

            b.show();  // builder class
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class holderView extends RecyclerView.ViewHolder {

        public holderView(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class abcd extends RecyclerView.ViewHolder {
        TextView num, nam;
        ImageView img;
        LinearLayout ll;

        AppCompatButton edt; // added for updation

        public abcd(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imgv);
            nam = itemView.findViewById(R.id.cnctnam);
            num = itemView.findViewById(R.id.cnctnum);
            edt = itemView.findViewById(R.id.edit);// added for updation
            ll = itemView.findViewById(R.id.ll); // added for deletion on holding the linear layout
        }
    }}
