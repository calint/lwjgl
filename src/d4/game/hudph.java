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
	final int fontsize=8;
	public static TrueTypeFont ttf;
	public String str="hello";
	public void init()throws Throwable{
		final boolean antialias=true;
		final InputStream is=getClass().getResourceAsStream("rc/slkscr.ttf");
		final Font fntbase=Font.createFont(Font.TRUETYPE_FONT,is);
		final Font fnt=fntbase.deriveFont(fontsize);
		ttf=new TrueTypeFont(fnt,antialias);
	}
	public void rend()throws Throwable{//? defunc
		ttf.drawString(0,0,str,Color.white);
	}
	public void drw(TrueTypeFont ttf2){
		ttf2.drawString(0,0,str,Color.white);
	}
}
