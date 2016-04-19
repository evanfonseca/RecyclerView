package com.example.enfonseca.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String [] Titulos;
    String [] Artistas;
    String [] Album;
    int [] images ={R.drawable.lura,
                    R.drawable.jeniffer,
                    R.drawable.ceuzany,
                    R.drawable.tito,
                    R.drawable.grace,
                    R.drawable.dany,
                    R.drawable.dino,
                    R.drawable.elida,
                    R.drawable.mayra,
                    R.drawable.jhumberto};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


       Resources res = getResources();
        Titulos=res.getStringArray(R.array.titulos);
        Artistas=res.getStringArray(R.array.artistas);
        list= (ListView) findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this,Titulos,images,Artistas);
        list.setAdapter(adapter);

        // ListView on item selected listener.
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(MainActivity.this,ShowMusic.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        int [] images;
        String [] titulosArray;
        String [] artistasArray;
        MyAdapter(Context c, String[] Titulos, int [] imgs, String[] Artistas){
            super(c, R.layout.item_list,R.id.musica,Titulos);
            this.context=c;
            this.images=imgs;
            this.titulosArray=Titulos;
            this.artistasArray=Artistas;
        }
    /*
    *
    *
    *
    *

       @Override
        public View getView(int position,View ConvertView, ViewGroup parent){
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           View row=inflater.inflate(R.layout.item_list,parent,false);

           ImageView myImage= (ImageView) row.findViewById(R.id.imageView);
           TextView  myMusica= (TextView) row.findViewById(R.id.musica);
           TextView  myArtista= (TextView) row.findViewById(R.id.artista);
           TextView  myAlbum= (TextView) row.findViewById(R.id.album);

           myImage.setImageResource(images[position]);
           myMusica.setText(titulosArray[position]);
           myArtista.setText(artistasArray[position]);

           return row;
       }

        */


        @Override
        public View getView(int position,View ConvertView, ViewGroup parent){

            View row=ConvertView;
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if(row==null){
                row=inflater.inflate(R.layout.item_list,parent,false);
            }


            ImageView myImage= (ImageView) row.findViewById(R.id.imageView);
            TextView  myMusica= (TextView) row.findViewById(R.id.musica);
            TextView  myArtista= (TextView) row.findViewById(R.id.artista);
            TextView  myAlbum= (TextView) row.findViewById(R.id.album);

            myImage.setImageResource(images[position]);
            myMusica.setText(titulosArray[position]);
            myArtista.setText(artistasArray[position]);

            return row;
        }

    }
}
