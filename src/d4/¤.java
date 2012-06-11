package d4;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_FRONT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glReadBuffer;
import static org.lwjgl.opengl.GL11.glReadPixels;
import static org.lwjgl.opengl.GL11.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import d4.game.hudph;
import d4.ob.obhous;
public class ¤{
	public static void main(final String[] a) throws Throwable{
		try{
			new ¤();
		}catch(InvocationTargetException e){
			throw e.getCause();
		}
	}
	public String init="d4.game.¤";
	public boolean logatsec=true;
	public boolean logatframe=false;
	public String datetimefmt="--yyyy-MM-dd--HH-mm-ss-SSS--";
	public ¤() throws Throwable{
		int wi=1024;
		int hi=512;
		int fps=0;
		;
		;
		p("display ").p(Sys.getVersion());
		Display.setDisplayMode(new DisplayMode(wi,hi));
		Display.setResizable(true);
		Display.setFullscreen(true);
		Display.setTitle(getClass().getName());
		Display.create();
		p(" ").p(Display.getDisplayMode().toString());
		p(" opengl ").p(Display.getAdapter()).p(" ").p(Display.getVersion()).p(" ").p(fps).pl(" fps");
		;
		;
		glClearColor(.5f,.5f,1,1);
		//		glEnable(GL_CULL_FACE);
		;
		glEnable(GL_DEPTH_TEST);
		;
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		;
		final wld wd=new wld(null);
		Class.forName(init).getConstructor(wld.class).newInstance(wd);
		final win wn=new win(wd);
		wn.z=-1;
		;
		final hudph hud=new hudph();
		hud.init();
		;
		;
		long frame=0;
		long tt=0;
		long ttfrm=0;
		float fps_this_sec=0;
		int key=0;
		float obx=0;
		while(!Display.isCloseRequested()){
			final long t0=System.currentTimeMillis();
			wi=Display.getWidth();
			hi=Display.getHeight();
			;
			glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			;
			wn.dim(wi,hi);
			final long t_rend0=System.currentTimeMillis();
			wn.rendview();
			final long dt_rend=System.currentTimeMillis()-t_rend0;
			;
			glViewport(0,0,wi,hi);
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(0,wi,hi,0,1,-1);
			glMatrixMode(GL_MODELVIEW);
			glLoadIdentity();
			;
			hud.rend();
			;
			final long t_upd0=System.currentTimeMillis();
			wd.upd();
			final long dt_up=System.currentTimeMillis()-t_upd0;
			;
			Display.update();
			;
			final long t1=System.currentTimeMillis();
			final long dt=t1-t0;
			final StringBuilder sb=new StringBuilder(256);
			sb.append("#").append(frame).append("   ").append(dt).append("ms").append("   nobs:").append(obj.nobjs).append("   fps:").append(fps_this_sec).append("  dratime:").append(dt_rend).append("   fisix:").append(dt_up).append("   mous:").append(Mouse.getX()).append(",").append(Mouse.getY()).append("   key:").append(key);
			hud.str=sb.toString();
			final long dtt=t1-tt;
			if(dtt>1000){
				long df=frame-ttfrm;
				if(df!=0)
					df++;
				fps_this_sec=round((float)1000*df/dtt,10);
				ttfrm=frame;
				tt=t1;
				if(logatsec)
					p('\r').p(sb);
			}
			frame++;
			;
			;
			while(Keyboard.next()){
				key=Keyboard.getEventKey();
				//				p("key=").pl(key);
				if(key==59){//f1
					snapshot("snap"+new SimpleDateFormat(datetimefmt).format(new Date())+".jpg","jpg");//f1
				}else if(key==1){//esc
					Display.destroy();
					return;//break;
				}else if(key==60){//f2
					Display.setFullscreen(true);
				}else if(key==61){//f3
					Display.setFullscreen(false);
				}
			}
			if(Keyboard.isKeyDown(57)){//spc
				new obhous(wd).x+=obx;
				obx+=.3;
			}
			;
			;
			if(logatframe){
//				System.out.format("frame=%05d   dt=%03dms   fps=%3f  z=%f\r",frame,dt,fps_this_sec,wn.z);
//				p("mous(x=").p(Mouse.getX()).p(",y=").p(Mouse.getY()).p(",b=").pl(Mouse.isButtonDown(0));
//				p(sb);
			}
			if(fps!=0)
				Display.sync(fps);
		}
		;
		Display.destroy();
	}
	private float round(final float f,final int i){
		return ((float)(int)(f*i))/i;
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