package d4.game;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glIsEnabled;
import java.awt.Font;
import java.io.InputStream;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import d4.polh;
public class hudph extends polh{
	public static TrueTypeFont ttf;
	public void init()throws Throwable{
		final int fontsize=8;
		final boolean antialias=true;
		final InputStream is=getClass().getResourceAsStream("rc/slkscr.ttf");
		final Font fntbase=Font.createFont(Font.TRUETYPE_FONT,is);
		final Font fnt=fntbase.deriveFont(fontsize);
		ttf=new TrueTypeFont(fnt,antialias);
	}
	public void rend()throws Throwable{//? defunc
		Color.white.bind();
		//? pushState(enabled,blendfunc)
		final boolean e=glIsEnabled(GL_BLEND);
		if(!e)
			glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		ttf.drawString(0,0,"hello",Color.white);
		if(!e)
			glDisable(GL_BLEND);
	}
}
