package boardgame.timer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.awt.Color;

public class GUI {
        private static TextureAtlas atlas;
        public static Skin skin;
        public static Skin uiSkin;
        public static Button startButton;
        public static Button playButton;
        public static Button stopButton;
        public static Button settingsButton;
        public static Button.ButtonStyle startButtonIcon;
        public static Button.ButtonStyle stopButtonIcon;
        public static Label timer;
        public static Label playerName;

        public static Label minLabel;
        public static Label secLabel;
        public static Label playerLabel;
        public static BitmapFont mainFont;
        public static TextButton ok;




    public static void GUI() {

        atlas = new TextureAtlas("BoardGameTimer.pack");
        skin = new Skin(atlas);
        uiSkin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        //Fonts
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Arcon-Rounded-Regular.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size =55;

        mainFont = generator.generateFont(parameter);



        startButtonIcon = new Button.ButtonStyle();
        startButtonIcon.up = skin.getDrawable("startButtonUp");
        startButtonIcon.down = skin.getDrawable("startButtonDown");
        startButton = new Button(startButtonIcon);

        playButton = new Button(startButtonIcon);

        Button.ButtonStyle settingsButtonIcon = new Button.ButtonStyle();
        settingsButtonIcon.up = skin.getDrawable("settingsUp");
        settingsButtonIcon.down = skin.getDrawable("settingsDown");
        settingsButton = new Button(settingsButtonIcon);

        //SettingsState UI

        ok = new TextButton("OK", uiSkin);
        minLabel = new Label("Min:", new Label.LabelStyle(mainFont, com.badlogic.gdx.graphics.Color.GRAY));
        secLabel = new Label("Sec:", new Label.LabelStyle(mainFont, com.badlogic.gdx.graphics.Color.GRAY));
        playerLabel = new Label("Name:", new Label.LabelStyle(mainFont, com.badlogic.gdx.graphics.Color.GRAY));


        //mainFont.getData().setScale(1);



        //PlayState UI
        stopButtonIcon = new Button.ButtonStyle();
        stopButtonIcon.up = skin.getDrawable("stopButtonUp");
        stopButtonIcon.down = skin.getDrawable("stopButtonDown");
        stopButton = new Button(stopButtonIcon);
        playerName = new Label("XX", new Label.LabelStyle(mainFont, com.badlogic.gdx.graphics.Color.GRAY));
        timer = new Label("00:00", new Label.LabelStyle(mainFont, com.badlogic.gdx.graphics.Color.GRAY));
       // timer.scaleBy(10);




    }


    private static void initFonts() {


    }



}
