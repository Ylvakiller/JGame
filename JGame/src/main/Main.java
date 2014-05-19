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
	private SaveFileMaker loadSave;
	byte[][] loadedLevel;
	public Main(){
		textureManager = new TextureManager();
		loadSave = new SaveFileMaker();
		try {
			Display.setDisplayMode(new DisplayMode(1280,1024));
			Display.setTitle("Hello LWJGL");
			Display.create();
		} catch (LWJGLException e){
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		this.MakeLevel(5);
		loadSave.SaveLevel(loadedLevel,"test");
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
	
	private void MakeLevel(int size){
		loadedLevel = new byte[(size*size)][];
		int i = 0;
		while (i<(size*size)){
			loadedLevel[i] = new byte[7];
			i++;
		}
		i = 0;
		int i1 = 0;
		int i2 = 0;
		
		while (i1<size){
			while(i2<size){
				loadedLevel[i][0]= (byte)((i1 >> 8) & 0xff);
				loadedLevel[i][1]= (byte)(i1 & 0xff);
				loadedLevel[i][2]= (byte)((i2 >> 8) & 0xff);
				loadedLevel[i][3]= (byte)(i2 & 0xff);
				loadedLevel[i][4]= 8;
				loadedLevel[i][5]= 0;
				loadedLevel[i][6]= 0;
				i2++;
				i++;
			}
			i2 = 0;
			i1++;
		}
		
		
		
	}

}
