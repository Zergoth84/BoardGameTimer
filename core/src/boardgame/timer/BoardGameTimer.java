package boardgame.timer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import boardgame.timer.states.GameStateManager;
import boardgame.timer.states.MenuState;

public class BoardGameTimer extends ApplicationAdapter {
	public static final int WIDTH = 1920/2;
	public static final int HEIGHT = 1080/2;
	public static final String TITLE ="Board game Timer";
	private GameStateManager gsm;
	//private TextureAtlas atlas;
	//public static Skin skin;

	private SpriteBatch batch;

	//Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		GUI.GUI();
		//atlas = new TextureAtlas("BoardGameTimer.pack");
		//skin = new Skin(atlas);
		//Gdx.gl.glClearColor(1,0,0,1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
