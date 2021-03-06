/*
 * Some code taken from http://ninjacave.com/slickutil1
 */

package game;

import java.io.IOException;
import utilities.*;
//import org.lwjgl.LWJGLException;
//import org.lwjgl.opengl.Display;
//import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
 
public class Textures {
	
	public static String IMAGE1 = "trans_rights.png";
 
	/** The texture that will hold the image details */
	
	public static Texture hatsune;
	public static Texture sky;
	public static Texture bee;
	public static Texture grass;
	
	private static String[] playerWLNames = { "steve/steve_WL_0.png","steve/steve_WL_1.png","steve/steve_WL_2.png","steve/steve_WL_3.png","steve/steve_WL_4.png" };
	public static Texture[] playerWLFrames;	
	
	private static String[] playerWRNames = { "steve/steve_WR_0.png","steve/steve_WR_1.png","steve/steve_WR_2.png","steve/steve_WR_3.png","steve/steve_WR_4.png" };
	public static Texture[] playerWRFrames;
	
	private static String[] playerJNames = { "steve/steve_J_0.png","steve/steve_J_1.png","steve/steve_J_2.png","steve/steve_J_3.png","steve/steve_J_4.png" };
	public static Texture[] playerJFrames;
	
	private static String[] playerFNames = { "steve/steve_F_0.png","steve/steve_F_1.png","steve/steve_F_2.png","steve/steve_F_3.png","steve/steve_F_4.png" };
	public static Texture[] playerFFrames;
	
	private static String[] livesNames = { "lives_active.png", "lives_inactive.png" };
	public static Texture[] livesFrames;
	
	private static String[] lavaNames = { "lava/lava_still_0.png","lava/lava_still_1.png","lava/lava_still_2.png","lava/lava_still_3.png","lava/lava_still_4.png","lava/lava_still_5.png" };
	public static Texture[] lava;
	
	public static Texture mainMenuBackground;
	
	private static String[] storyScreenNames = { "story_screen_1.png","story_screen_2.png","story_screen_3.png" };
	public static Texture[] storyScreens;
	
	public static Texture nether_background;
	
	public static Texture winScreen, loseScreen;
	
	public static Texture netherrack;
	public static Texture portal;
	public static Texture endportal;
 
	/**
	 * Initialise the GL display
	 * 
	 * @param width The width of the display
	 * @param height The height of the display
	 */
	public static void initGL(int width, int height) {
		GL11.glEnable(GL11.GL_TEXTURE_2D);               
 
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);          
 
        	// enable alpha blending
        	GL11.glEnable(GL11.GL_BLEND);
        	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
 
        	GL11.glViewport(0,0,width,height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
 
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}
 
	/**
	 * Initialise resources
	 */
	public static Texture load(String img, String type) throws IOException {
		Texture texture;
			texture = TextureLoader.getTexture(type, ResourceLoader.getResourceAsStream("res/" + img));
			System.out.println("Texture loaded: "+ texture);
//			System.out.println(">> Image width: "+texture.getImageWidth());
//			System.out.println(">> Image height: "+texture.getImageHeight());
//			System.out.println(">> Texture width: "+texture.getTextureWidth());
//			System.out.println(">> Texture height: "+texture.getTextureHeight());
//			System.out.println(">> Texture ID: "+texture.getTextureID());
		return texture;
	}
	
	public static void init() {
		try {
			sky = load("sky.png", "PNG");
			bee = load("bee_and_puppycat.png", "PNG");
			hatsune = load("trans_rights.png", "PNG");
			grass = load("grass.png", "PNG");
			
			playerWLFrames = Spritesheet.spliceLoad(playerWLNames, "PNG");
			playerWRFrames = Spritesheet.spliceLoad(playerWRNames, "PNG");
			playerJFrames = Spritesheet.spliceLoad(playerJNames, "PNG");
			playerFFrames = Spritesheet.spliceLoad(playerFNames, "PNG");
			
			livesFrames = Spritesheet.spliceLoad(livesNames, "PNG");
			
			lava = Spritesheet.spliceLoad(lavaNames, "PNG");
			
			mainMenuBackground = load("main_menu_screen.png", "PNG");
			
			storyScreens = Spritesheet.spliceLoad(storyScreenNames, "PNG");
			
			winScreen = load("win_screen.png", "PNG");
			loseScreen = load("lose_screen.png", "PNG");
			
			nether_background = load("nether_background.png", "PNG");
			
			netherrack = load("netherrack.png", "PNG");
			portal = load("portal.png", "PNG");
			endportal = load("portal2.png", "PNG");
		}
		catch(IOException e) {
			System.out.println("Error in loading");
		}
		
	}
 
	/**
	 * draw a quad with the image on it
	 */
	
	public static void render(Texture texture, int x, int y, int w, int h) {
		Color.white.bind();
		texture.bind(); // or GL11.glBind(texture.getTextureID());
 
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(x, y);
//			System.out.println("First vertex: " + x + " " + y);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(x + w,y);
//			System.out.println("Second vertex: " + (x + w) + " " + y);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(x + w, y + h);
//			System.out.println("Third vertex: " + (x + w) + " " + (y + h));
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(x, y + h);
//			System.out.println("Fourth vertex: " + x + " " + (y + h));
			//System.out.println(texture.getTextureWidth() + " " + texture.getTextureWidth());
		GL11.glEnd();
	}
	
	public static void render(Texture texture, int x, int y) {
		Color.white.bind();
		texture.bind(); // or GL11.glBind(texture.getTextureID());
 
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(x, y);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(x + texture.getTextureWidth(),y);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(x + texture.getTextureWidth(), y + texture.getTextureHeight());
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(x, y + texture.getTextureHeight());
		GL11.glEnd();
	}
	
	public static void render(Texture texture) {
		render(texture, 0, 0);
	}
}