package boardgame.timer;

import com.badlogic.gdx.graphics.Color;

public class Player {
    public  String name;
    public  int min;
    public int sec;
    public boolean timesUp=false;
    public static Color color;


    public Player(String name, int min, int sec) {
       // min=1;
        //sec=20;
    this.name = name;
    this.min = min;
    this.sec = sec;
    }
}
