package samples;
import java.awt.Font;
import java.io.InputStream;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL14.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL21.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL31.*;
import static org.lwjgl.opengl.GL32.*;
import static org.lwjgl.opengl.GL33.*;
import static org.lwjgl.opengl.GL40.*;
import static org.lwjgl.opengl.GL41.*;
import static org.lwjgl.opengl.GL42.*;
public class truetype{
	public static void main(final String[]a) throws Throwable{new truetype();}
	truetype()throws Throwable{
		final int wi=800;
		final int hi=600;
		float fontsize=24;
		final boolean antialias=true;
		final String[]ls=new String[]{"true type fonts","abcd123"};
		;
		final InputStream is=getClass().getResourceAsStream("slkscr.ttf");
		final Font fntbase=Font.createFont(Font.TRUETYPE_FONT,is);
		final Font fnt=fntbase.deriveFont(fontsize);
		;
		Display.setDisplayMode(new DisplayMode(wi,hi));
		Display.create();
		;
		final TrueTypeFont ttf=new TrueTypeFont(fnt,antialias);
		;
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		glViewport(0,0,wi,hi);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,wi,hi,0,1,-1);
		glClearColor(0,0,0,0);
		int y=0;
		while(!Display.isCloseRequested()){
			glClear(GL_COLOR_BUFFER_BIT);
			Color.white.bind();
			for(final String s:ls)
				ttf.drawString(0,y+=fontsize,s,Color.white);
			if(y>hi)y=0;
			Display.update();
			Display.sync(1);
		}
		Display.destroy();
	}
}