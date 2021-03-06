package game;

import managers.GameManager;
import managers.Sounds;
import managers.Textures;
import utilities.*;

public class StoryInfoScene extends Scene {
	private int numOfScenes = Constants.NUMOFSTORYSCREENS, currScene;
	private double screenTime = 4.0, deltaTime = 1000/(1.0/screenTime), currTime, flipTime;	
	
	public StoryInfoScene(boolean pausable) { super(pausable); }
	
	public void setup() {
		Sounds.stopSFX();
		
		super.setup();
		currScene = 0;
		currTime = System.currentTimeMillis();
		flipTime = System.currentTimeMillis();
		
		Sounds.play(Sounds.storySceneMusic, AudioType.MUSIC);
		Sounds.play(Sounds.screenflip, AudioType.SFX);
	}

	protected void update() {
		currTime = System.currentTimeMillis();
		
		if (currTime - flipTime >= deltaTime) { 
			if (currScene < numOfScenes-1) {
				Sounds.play(Sounds.screenflip, AudioType.SFX);
				currScene++;
				flipTime = currTime;
			} else {
				GameManager.RunScene(3);
			}
		} 
	}

	protected void render() {
		Textures.render(Textures.storyScreens[currScene]);
	}
	
	public void clear() {  }
}
