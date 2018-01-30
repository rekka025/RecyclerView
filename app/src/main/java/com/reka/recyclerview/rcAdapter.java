package com.reka.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by reka on 1/27/18.
 */
//class adapter ini digunakan untuk mengatur bagaimana data akan ditampilkan
public class rcAdapter extends RecyclerView.Adapter<rcAdapter.ViewHolder> {

    private ArrayList<String> arrayList; //untuk nama buah
    private ArrayList<Integer> buahList; //untuk gambar

    //membuat konstruktor pada class recycleviewadapter
    public rcAdapter(ArrayList<String> arrayList , ArrayList<Integer> buahList){
        this.arrayList = arrayList;
        this.buahList = buahList;
    }
    //viewholder digunakan untuk menyimpan refrensi dari view-view
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView namaBuah,subBuah;
        private ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            //mendifinisikan view-view yang telah dibuat di rc_view
            namaBuah = itemView.findViewById(R.id.tv_buah);
            subBuah = itemView.findViewById(R.id.tv_sub_buah);
            imageView = itemView.findViewById(R.id.img_buah);
        }
    }


    //untuk membuat view untuk menyiapkan dan memasang layout yang akan di gunakan pada recycleview
    @Override
    public rcAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //memasukan nilai/value pada view-view yang telah dibuat
    @Override
    public void onBindViewHolder(rcAdapter.ViewHolder holder, int position) {
        //Mengambil data sesuai dengan posisi yang telah ditentukan
        final String nama = arrayList.get(position);
        holder.namaBuah.setText(nama);
        holder.subBuah.setText("Gambar Buah Ke : "+position);
        //mengambil gambar
        holder.imageView.setImageResource(buahList.get(position));


    }
    //menghitung ukuran/jumlah data yang akan ditampilkan pada recycleview
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
