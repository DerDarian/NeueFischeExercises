package org.example.OOP.einfuehrung;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;
import java.io.File;
import java.io.InputStream;

public class MusicPlayer implements Playlable{
    private static final int BUFFER_SIZE = 4096;
    String song = "";

    public void setSong(String song){ this.song = song; }

    @Override
    public void play(){
        System.out.println("Playing "+song);
    }
}
