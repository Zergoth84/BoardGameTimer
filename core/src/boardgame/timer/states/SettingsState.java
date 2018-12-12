package boardgame.timer.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;


import boardgame.timer.GUI;

public class SettingsState extends State {
    private Skin uiSkin;
    private Skin skin;
    private static Stage stage = null;
    private Table table;
    public static TextField minField;
    public static TextField secField;
    public static TextField playerField;




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






    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

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
