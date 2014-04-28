package com.dropofrational.moonlander;

import java.io.IOException;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

public class Main extends BaseGameActivity{

    private static final float WIDTH = 800;
	private static final float HEIGHT = 480;
	private Camera mCamera;
	private Scene mScene;
	
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		mCamera = new Camera(0, 0, WIDTH, HEIGHT);
		
		EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(), mCamera);
		
		//Screen on while game running
		engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
		
		//Requires music and sound
		engineOptions.getAudioOptions().setNeedsMusic(true);
		engineOptions.getAudioOptions().setNeedsSound(true);
		
		return engineOptions;
	}

	@Override
	public void onCreateResources(
			OnCreateResourcesCallback pOnCreateResourcesCallback)
			throws IOException {
		
		//Set base asset paths
		SoundFactory.setAssetBasePath("sfx");
		MusicFactory.setAssetBasePath("sfx");
		
		//load sound
		Sound sound = SoundFactory.createSoundFromAsset(getSoundManager(), this, "sound.mp3");
		
		
		//load music
		Music music = MusicFactory.createMusicFromAsset(getMusicManager(), this, "music.mp3");
		
		//DO LAST
		pOnCreateResourcesCallback.onCreateResourcesFinished();
		
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
			throws IOException {
		mScene = new Scene();
		
		//DO LAST
		pOnCreateSceneCallback.onCreateSceneFinished(mScene);
		
	}

	@Override
	public void onPopulateScene(Scene pScene,
			OnPopulateSceneCallback pOnPopulateSceneCallback)
			throws IOException {
		//DO LAST
		pOnPopulateSceneCallback.onPopulateSceneFinished();
		
	}
	
	//Allows us to return customized engine object
	@Override
	public Engine onCreateEngine(EngineOptions pEngineOptions) {
		// TODO Auto-generated method stub
		return new LimitedFPSEngine(pEngineOptions, 60);
	}
}
