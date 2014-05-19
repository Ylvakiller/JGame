package main;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;
import org.lwjgl.*;
@SuppressWarnings("unused")
public class Main {

	public Main(){
		try {
			Display.setDisplayMode(new DisplayMode(640,480));
			Display.setTitle("Hello LWJGL");
			Display.create();
		} catch (LWJGLException e){
			e.printStackTrace();
		}
		
		
		// Initialization code OpenGl
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 640, 480, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		
		
		while (!Display.isCloseRequested()){
			//render
			glClear(GL_COLOR_BUFFER_BIT);
			
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				Display.destroy();System.exit(0);
			}
			
			//Mouse.get
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
		
	}
	
	public static void main(String[] args) {
		new Main();

	}

}
