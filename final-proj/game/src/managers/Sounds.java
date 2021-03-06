package managers;

import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import utilities.AudioType;

public class Sounds {
	
	// music
	public static Audio controlsScreenMusic, loseScreenMusic, mainMenuMusic, parkourLevelMusic, storySceneMusic, winScreenMusic;
	
	// SFX
	public static Audio burn, click, hover, jump, landOnBlock, lava, lost, screenflip, tada, walk, poison;
	
	private static ArrayList<Audio> SFX = new ArrayList<Audio>();
	
	public static Audio load(String sound, String type) throws IOException {
		return AudioLoader.getAudio(type, ResourceLoader.getResourceAsStream("res/audio/"+sound));
	}
	
	public static void init() {
		try { 
			// music
			controlsScreenMusic = load("background_music/controlscreenmusic.wav", "WAV");
			loseScreenMusic = load("background_music/losescreenmusic.wav", "WAV");
			mainMenuMusic = load("background_music/mainmenumusic.wav", "WAV");
			parkourLevelMusic = load("background_music/parkourlevelmusic.wav", "WAV");
			storySceneMusic = load("background_music/storyscenemusic.wav", "WAV");
			winScreenMusic = load("background_music/winscreenmusic.wav", "WAV");
			
			// SFX
			burn = load("SFX/burn.wav", "WAV");
			click = load("SFX/click.wav", "WAV");	// should continue resonating
			hover = load("SFX/hover.wav", "WAV");
			jump = load("SFX/jump.wav", "WAV");
			landOnBlock = load("SFX/landonblock.wav", "WAV");
			lava = load("SFX/lava.wav", "WAV");
			lost = load("SFX/lost.wav", "WAV");
			screenflip = load("SFX/screenflip.wav", "WAV");
			tada = load("SFX/tada.wav", "WAV");
			walk = load("SFX/walk.wav", "WAV");		
			poison = load("SFX/poison.wav", "WAV");
			
			SFX.add(burn);
			SFX.add(hover);
			SFX.add(jump);
			SFX.add(landOnBlock);
			SFX.add(lava);
			SFX.add(lost);
			SFX.add(screenflip);
			SFX.add(tada);
			SFX.add(walk);
			SFX.add(poison);
		} catch (IOException e) {
			System.out.println("Error in loading music and SFX.");
		}
	}
	
	public static void play(Audio audio, AudioType type) {
		if (type == AudioType.MUSIC) { audio.playAsMusic(1.0f, 1.0f, true); }
		else { audio.playAsSoundEffect(1.0f, 1.0f, false); }
	}
	
	public static void stopSound(Audio sound) { sound.stop(); }
	public static void stopSFX() {
		for (Audio sfx : SFX) { sfx.stop(); }
	}
}
