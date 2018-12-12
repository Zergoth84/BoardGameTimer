package boardgame.timer.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;


import boardgame.timer.GUI;
import boardgame.timer.Player;

public class PlayState extends State {
    private Skin skin;
    private static Stage stage = null;
    private Table table;
    private static Button playButton;
    private static Button stopButton;
    private static Boolean played=false;
    public static Array<Player> players;
    private static boolean countUp = false;
    private static boolean countDown = true;
    private static boolean sumCountDown = true;
    int min =0;
    int sec =0;
    int milisec=0;
    int iplayer=0;
    private static Stack stack;



    public PlayState(GameStateManager gsm) {
        super(gsm);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin = GUI.skin;

        players = new Array<Player>();
        players.add(new Player("Player1",1,20));
        players.add(new Player("Player2",2,1));
        players.add(new Player("Player3", 0,45));

       // players.get(0).name="Playerss";
       // GUI.playerName.setText(players.get(0).name);



        table = new Table();
        table.setBackground(skin.getDrawable("background"));
        stack = new Stack();

        table.top();
        table.setFillParent(true);
        playButton = new Button(GUI.startButtonIcon);
        stopButton = new Button(GUI.stopButtonIcon);
        stopButton.setVisible(false);
        stack.add(playButton);
        stack.add(stopButton);
        table.add(stack);
        table.row();
        table.add(GUI.playerName).padTop(30);
        table.row();
        table.add(GUI.timer).padTop(30);
        stage.addActor(table);
        initialize();

    }


    private void initialize(){
        if (countDown==true){
            min=players.get(0).min;
            sec=players.get(0).sec;
            updateTimer();
        }
    }

    private void updateTimer(){
        if (min>9&&sec>9){
            GUI.timer.setText(min+":"+sec);
        }if (min>9&&sec<10){
            GUI.timer.setText(min+":0"+sec);
        }if (min<10&&sec>9){
            GUI.timer.setText("0"+min+":"+sec);
        }
        if (min<10&&sec<10){
            GUI.timer.setText("0"+min+":0"+sec);
        }
    }


    private  void countdown(){
        if (countDown==true){
            GUI.playerName.setText(players.get(iplayer).name);
            if (played){
                if (sec<2&&min<1){
                    sec--;
                    System.out.println("STOP");
                    players.get(iplayer).timesUp=true;
                   // GUI.timer.setText("00:00");
                    played=false;
                }else {
                    milisec--;
                    if (milisec<1){
                        sec--;
                        milisec=60;
                    }
                    if (sec<1){
                        min--
                        ;
                        sec=59;
                    }


                }
                updateTimer();
            }
        }

    }

    private void countup(){
        if (countUp==true){
            GUI.playerName.setText(players.get(iplayer).name);
            if (played){
                milisec++;
                if(milisec==60){
                    sec++;
                    milisec=0;
                }
                if(sec==60){
                    min++;
                    sec=0;
                }
                updateTimer();

            }
        }


    }







    @Override
    protected void handleInput() {
//
       if  (playButton.isPressed()){
           if (countDown==true){
               min = players.get(iplayer).min;
               sec = players.get(iplayer).sec;
               milisec=60;
           }


           playButton.setVisible(false);
           if (played==false){
               stopButton.setVisible(true);

               played=true;
           }



       }
       if  (played&&stopButton.isPressed()||players.get(iplayer).timesUp&&stopButton.isPressed()){
           stopButton.setVisible(false);
           if (sumCountDown==true){
               players.get(iplayer).min=min;
               players.get(iplayer).sec=sec;
           }
               if(iplayer<players.size-1){
                   iplayer++;
               }else{
                   iplayer=0;
               }
           if (countDown==true){

               min=players.get(iplayer).min;
               sec=players.get(iplayer).sec;
               updateTimer();
           }

               if (countUp==true){
                   GUI.timer.setText("00:00");
                   sec=0;
                   min=0;
               }




               playButton.setVisible(true);
               played=false;


           }



        }


    @Override
    public void update(float dt) {
        handleInput();
        countup();
        countdown();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        stage.draw();
        sb.end();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
