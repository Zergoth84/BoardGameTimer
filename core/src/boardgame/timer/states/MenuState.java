package boardgame.timer.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import boardgame.timer.GUI;


public class MenuState extends State{
    private static Stage stage;
    private static Skin skin;





    public MenuState(GameStateManager gsm) {
        super(gsm);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
       skin = GUI.skin;
        Table table = new Table();
         table.setBackground(skin.getDrawable("background"));


        table.center();
        table.setFillParent(true);
        table.add(GUI.startButton);
        table.row();
        table.add(GUI.settingsButton);
        stage.addActor(table);

    }

    @Override
    public void handleInput() {
        if (GUI.startButton.isPressed()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
        if (GUI.settingsButton.isPressed()){
            gsm.set(new SettingsState(gsm));
            dispose();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {

        stage.draw();


    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
