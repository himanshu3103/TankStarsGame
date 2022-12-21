package com.badlogic.drop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PauseScreen implements Screen {

    final TankStars game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    private Stage stage;
    public Button startGame;
    public Button loadGame;
    public Button exitGame;
    OrthographicCamera camera;
    protected Skin skin;
    private Viewport viewport;

    public PauseScreen(TankStars game) {
        this.game = game;
//        skin = new Skin(Gdx.files.internal("rusty-robot/skin/rusty-robot-ui.json"));
        skin = new Skin(Gdx.files.internal("star-soldier/skin/star-soldier-ui.json"));
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage = new Stage();
        backgroundImage = new Texture(Gdx.files.internal("tank_stars_bg1.png"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1200, 600);
    }

    @Override
    public void show() {
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera), game.batch);
        Gdx.input.setInputProcessor(stage);

        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.center();
        //mainTable.padRight(30);

        startGame = new TextButton("Resume", skin);
        loadGame = new TextButton("Load", skin);
        exitGame = new TextButton("Exit",skin);

        exitGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        mainTable.add(startGame);
        mainTable.row();
        mainTable.add(loadGame);
        mainTable.row();
        mainTable.add(exitGame);
        //Add table to stage
        stage.addActor(mainTable);
    }

    @Override
    public void render(float delta) {
//        ScreenUtils.clear(0, 0, 0, 0);
        stage.getBatch().begin();
        stage.getBatch().draw(backgroundTexture,200,100,400,350);
        stage.getBatch().end();
        stage.draw();
        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
