package main;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;
import org.lwjgl.*;
import org.newdawn.slick.opengl.Texture;
@SuppressWarnings("unused")
public class Main {

	private Texture grass;
	private TextureManager textureManager;
	
	public Main(){
		textureManager = new TextureManager();
		try {
			Display.setDisplayMode(new DisplayMode(640,480));
			Display.setTitle("Hello LWJGL");
			Display.create();
		} catch (LWJGLException e){
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		
		
		grass = textureManager.getTexture("grass");
		
		// Initialization code OpenGl
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 640, 480, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		
		
		while (!Display.isCloseRequested()){
			//render
			glClear(GL_COLOR_BUFFER_BIT);
			
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				Display.destroy();System.exit(0);
			}
			grass.bind();
			glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2i(400,400);
			glTexCoord2f(0, 1);
			glVertex2i(400,450);
			glTexCoord2f(1, 1);
			glVertex2i(450,450);
			glTexCoord2f(1, 0);
			glVertex2i(450,400);
			glEnd();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
		
	}
	
	public static void main(String[] args) {
		new Main();

	}

}
