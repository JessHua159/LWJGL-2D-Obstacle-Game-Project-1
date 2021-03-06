package managers;

import game.*;

public class LevelManager {
	public static int numScenes;
	
	private int currScene;
	private final Scene[] scenes = { new MainMenuScene(false), new ControlsScene(false), new StoryInfoScene(false), new ParkourLevel(true), new WinScene(false), new LoseScene(false), new OutOfTimeScene(false) };
	
	public LevelManager() { numScenes = scenes.length; }
	
	public void playScene(int scene) {
		if (currScene != scene) { scenes[currScene].clear(); }
		currScene = scene;
		scenes[scene].setup();
		scenes[scene].run();
	}
	
	// getters/setters
	public boolean isScenePaused() { return scenes[currScene].isPaused(); }
	public void toggleScenePause() { scenes[currScene].togglePause(); }
	public boolean isWinTransition() { return scenes[currScene].isWinTransition(); }
	public boolean isLostLifeOrLostTransition() { return scenes[currScene].isLostLifeOrLostTransition(); }
	public boolean isOutOfTimeTransition() { return scenes[currScene].isOutOfTimeTransition(); }
}