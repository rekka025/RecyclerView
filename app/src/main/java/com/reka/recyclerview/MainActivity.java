package com.reka.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<String> dataNama;
    private ArrayList<Integer> dataGambar;
    private String[] namaBuah = {"Alpukat",
                                 "Apel",
                                 "Ceri",
                                 "Durian",
                                 "Jambu Ait",
                                 "Manggis",
                                 "Strawberry"};
    private int[] gambar = {R.drawable.alpukat,
                            R.drawable.apel,
                            R.drawable.ceri,
                            R.drawable.durian,
                            R.drawable.jambuair,
                            R.drawable.manggis,
                            R.drawable.strawberry};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataNama = new ArrayList<>();
        dataGambar = new ArrayList<>();

        recyclerView = findViewById(R.id.rc_view);

        //menggunakan linierlayoutmanager rasakan bedanya memakai false dan true, 0 adalah mode horizontal dari linearlayoutmanager
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,0,false);
//        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(this,0,true);
          RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        //script di bawah untuk menggunakan Gridlayoutmanager (Pilih salah satu layout manager gridlayoutmanager atau linier layoutmanager)
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        //ganti di sini dari mulanya layoutManager jadi gridLayoutManager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //memasang adapter pada recycleview
        adapter = new rcAdapter(dataNama,dataGambar);
        recyclerView.setAdapter(adapter);
        //memanggil class daftarItem
        daftarItem();

    }
    //Mengambil data dari Varibale Gambar dan Judul, lalu memasangnya pada list yang terhubung dengan Class Adapter
    private void daftarItem() {
        for (int w = 0; w < namaBuah.length; w++){
            dataNama.add(namaBuah[w]);
            dataGambar.add(gambar[w]);
        }
    }
}
