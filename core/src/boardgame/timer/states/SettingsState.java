package boardgame.timer.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Array;


import boardgame.timer.GUI;
import boardgame.timer.Player;

public class SettingsState extends State {
    private Skin uiSkin;
    private Skin skin;
    private static Stage stage = null;
    private Table table;
    public static TextField minField;
    public static TextField secField;
    public static TextField playerField;
    private boolean pressed=false;
    public static Array<Player> players;
    private static int playersCount=0;




    public SettingsState(GameStateManager gsm) {
        super(gsm);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin = GUI.skin;
        uiSkin = GUI.uiSkin;
        table = new Table();
        table.setFillParent(true);
        table.setBackground(skin.getDrawable("background"));
        stage.addActor(table);
        players = new Array<Player>();



        GUI.mainFont.getData().setScale(0.60f);
        minField = new TextField("",uiSkin);
        secField = new TextField("",uiSkin);
        playerField = new TextField("",uiSkin);


        table.add(GUI.playerLabel).padRight(20);
        table.add(GUI.minLabel).padRight(20);
        table.add(GUI.secLabel);
        table.row().padTop(5);
        table.add(playerField).padRight(20);
        table.add(minField).padRight(20);
        table.add(secField).padRight(20);
        table.add(GUI.ok);

    }


    public static int getMin(){
        int min=Integer.parseInt(minField.getText());
        return min;
    }

    public static int getSec(){
        int sec=Integer.parseInt(secField.getText());
        return sec;
    }


    public void keyReleased(){
        //boolean released=false;
        if (GUI.ok.isPressed()&&pressed==false){
            pressed=true;
        }
        if (GUI.ok.isPressed()==false&&pressed==true){
            addPlayer();
            pressed=false;
        }else{
        }
    }


    protected void addPlayer() {

            if (pressed == true && GUI.ok.isPressed() == false) {
                if (!minField.getText().isEmpty() && !secField.getText().isEmpty() && !playerField.getText().isEmpty()) {
                    players.add(new Player(playerField.getText(), getMin(), getSec()));


                }
//            if (playerField&&Integer.parseInt(minField.getText())=>0&&secField>-1){
                for (int i = 0; i < players.size; i++) {
                    System.out.println(players.get(i).name);
                    System.out.println(players.get(i).min);
                    System.out.println(players.get(i).sec);
                }
                System.out.println(players.size);
              //  pressed = false;
            }

        //}
    }





    @Override
    protected void handleInput() {
        keyReleased();
      //  addPlayer();
    }

    @Override
    public void update(float dt) {
        handleInput();
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
