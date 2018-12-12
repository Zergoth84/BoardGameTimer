package boardgame.timer.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import boardgame.timer.BoardGameTimer;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = BoardGameTimer.WIDTH;
		config.height=BoardGameTimer.HEIGHT;
		config.title=BoardGameTimer.TITLE;
		new LwjglApplication(new BoardGameTimer(), config);
	}
}
