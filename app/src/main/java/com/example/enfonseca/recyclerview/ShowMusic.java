package com.example.enfonseca.recyclerview;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by enfonseca on 4/18/16.
 */
public class ShowMusic extends AppCompatActivity {

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

    int[] audios ={R.raw.maria_di_lida,
            R.raw.largam_da_mon,
            R.raw.mindel_dnovas,
            R.raw.nha_pretinha,
            R.raw.sabim,
            R.raw.triste_eh_sabe,
            R.raw.nos_tradison,
            R.raw.lebam_ku_bo,
            R.raw.ilha_de_santiago,
            R.raw.strela_cadente};

    String [] Titulos;
    String [] Artistas;
    Button play;
    boolean bplay=false;
    SeekBar sb;
    TextView tvsb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_music);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int p=getIntent().getExtras().getInt("position");

        ImageView myImage= (ImageView) findViewById(R.id.imageView2);
        TextView myMusica= (TextView) findViewById(R.id.Musica);
        TextView  myArtista= (TextView) findViewById(R.id.Artista);




        myImage.setImageResource(images[p]);
        Resources res = getResources();
        Titulos=res.getStringArray(R.array.titulos);
        Artistas=res.getStringArray(R.array.artistas);
        myMusica.setText(Titulos[p]);
        myArtista.setText(Artistas[p]);

        play= (Button) findViewById(R.id.play);
        //bplay=false;

        final MediaPlayer mp = MediaPlayer.create(this, audios[p]);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!bplay){
                            mp.start();
                            play.setText("Pause");
                            bplay=true;
                          }
                else      {
                            mp.pause();
                            play.setText("Play");
                            bplay=false;
                          }

            }
        });



    }


    public  void seekbar(){
        sb= (SeekBar) findViewById(R.id.seekBar);
        tvsb= (TextView) findViewById(R.id.seekBarTv);
        tvsb.setText("SeekBar PROGRESS "+sb.getProgress());

    }

}
