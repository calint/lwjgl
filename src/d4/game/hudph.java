package d4.game;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import java.awt.Font;
import java.io.InputStream;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import d4.polh;
public class hudph extends polh{
	public String str="hello";
	private TrueTypeFont tf;
	public String[]lines;
	private float fontsize=8;
	public void init()throws Throwable{
		fontsize=24;
		final boolean antialias=true;
		final InputStream is=getClass().getResourceAsStream("/d4/game/rc/slkscr.ttf");
		if(is==null)throw new Error("cannot find resource slkscr.ttf");
		final Font fntbase=Font.createFont(Font.TRUETYPE_FONT,is);
		final Font fnt=fntbase.deriveFont(fontsize);
		tf=new TrueTypeFont(fnt,antialias);
	}
	public void rend()throws Throwable{
		glEnable(GL_BLEND);//? pushpop
		if(str!=null)
			tf.drawString(0,0,str,Color.yellow);
		float y=0;
		float dy=fontsize;
		if(lines!=null)for(final String s:lines){
			tf.drawString(0,y+=dy,s,Color.yellow);
		}
		glDisable(GL_BLEND);
	}
}
