package d4;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import d4.game.hudph;
public class ¤{
	public String init="d4.game.¤";
	public boolean logatsec=true;
	public boolean logatframe=false;
	public String datetimefmt="--yyyy-MM-dd--HH-mm-ss-SSS--";
	public ¤() throws Throwable{
		final int wi=1024;
		final int hi=512;
		int fps=24;
		p("display ").p(Display.getDisplayMode().toString());
		Display.setTitle(getClass().getName());
		Display.setDisplayMode(new DisplayMode(wi,hi));
		Display.create();
		p(" opengl ").p(Display.getAdapter()).p(" ").p(Display.getVersion()).p(" ").p(fps).pl(" fps");
		;
		;
		final wld wd=new wld(null);
		Class.forName(init).getConstructor(wld.class).newInstance(wd);
		final win wn=new win(wd,wi,hi);
		wn.z-=0;
		;
		;
		glClearColor(.5f,.5f,1,1);
//		glEnable(GL_CULL_FACE);
		;
		glViewport(0,0,wi,hi);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,wi,hi,0,1,-1);
//		glClearColor(0,0,0,0);
		int y=0;
		;
		final hudph hud=new hudph();
		hud.init();
		;
		float fontsize=24;
		final boolean antialias=true;
		final InputStream is=getClass().getResourceAsStream("slkscr.ttf");
		p(is);
		if(is==null)throw new Error("cannot find resource slkscr.ttf");
		final Font fntbase=Font.createFont(Font.TRUETYPE_FONT,is);
		final Font fnt=fntbase.deriveFont(fontsize);
		final TrueTypeFont ttf=new TrueTypeFont(fnt,antialias);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		int w=wi;
		int h=hi;
		long frame=0;
		long tt=0;
		long ttfrm=0;
		float fps_this_sec=0;
		final long t00=System.currentTimeMillis();
		int key=0;
		do{
			final long t0=System.currentTimeMillis();
			if(Display.isCloseRequested())
				break;
			glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			;
			glViewport(0,0,wi,hi);
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(0,w,h,0,1,-1);
			glEnable(GL_BLEND);
			hud.drw(ttf);
			glDisable(GL_BLEND);
			;
			;
			wn.rendview();
			;
			Display.update();
			wd.upd();
			final long t1=System.currentTimeMillis();
			final long dt=t1-t0;
			final long dtt=t1-tt;
			if(dtt>1000){
				long df=frame-ttfrm;
				if(df!=0)
					df++;
				fps_this_sec=(float)1000*df/dt;
				ttfrm=frame;
				tt=t1;
				if(logatsec)
					p("\rfps=").p(fps).p("   t=").p(t1-t00).p("ms   frame=#").p(frame);
			}
			frame++;
			;
			;
			while(Keyboard.next()){
				key=Keyboard.getEventKey();
				p("key=").pl(key);
				if(key==59)
					snapshot("snap"+new SimpleDateFormat(datetimefmt).format(new Date())+".jpg","jpg");//f1
				else if(key==1){
					Display.destroy();
					return;//break;//esc
				}
			}
			;
			;
			final StringBuilder sb=new StringBuilder(256);
			sb.append("#").append(frame).append("   fps:").append(fps).append("   mous:").append(Mouse.getX()).append(",").append(Mouse.getY()).append("   keyb:").append(key);
			hud.str=sb.toString();
			if(logatframe){
				System.out.format("frame=%05d   dt=%03dms   fps=%3f  z=%f\r",frame,dt,fps_this_sec,wn.z);
				p("mous(x=").p(Mouse.getX()).p(",y=").p(Mouse.getY()).p(",b=").pl(Mouse.isButtonDown(0));
			}
			Display.sync(fps);
		}while(true);
		Display.destroy();
	}
	private ¤ p(final Object o){
		System.out.print(o==null?"":o.toString());
		return this;
	}
	private ¤ nl(){
		System.out.println();
		return this;
	}
	private ¤ pl(final Object o){
		return p(o).nl();
	}
	public static void main(final String[] a) throws Throwable{
		try{new ¤();}catch(InvocationTargetException e){throw e.getCause();}
	}
	private void snapshot(final String filenm,final String fmt) throws Throwable{
		final DisplayMode dm=Display.getDisplayMode();
		final int w=dm.getWidth();
		final int h=dm.getHeight();
		final int bypp=4;
		;
		final ByteBuffer bb=ByteBuffer.allocateDirect(w*h*bypp);
		glReadBuffer(GL_FRONT);
		glReadPixels(0,0,w,h,GL_RGBA,GL_UNSIGNED_BYTE,bb);
		;
		final File f=new File(filenm);
		final BufferedImage bimg=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		//? perf
		for(int x=0;x<w;x++)
			for(int y=0;y<h;y++){
				int i=(x+(w*y))*bypp;
				int r=bb.get(i)&0xFF;
				int g=bb.get(i+1)&0xFF;
				int b=bb.get(i+2)&0xFF;
				bimg.setRGB(x,h-(y+1),(0xFF<<24)|(r<<16)|(g<<8)|b);
//				final int rgba=bb.getInt(i);
//				final int argb=((rgba&0xff)<<24)|(rgba>>8);
//				bimg.setRGB(x,h-(y+1),rgba);
			}
		ImageIO.write(bimg,fmt,f);
	}
}