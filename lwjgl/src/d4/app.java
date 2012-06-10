package d4;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
public class app{
	public String init="d4.game.init";
	public app()throws Throwable{
		final int wi=1024;
		final int hi=512;
		Display.setDisplayMode(new DisplayMode(wi,hi));
		Display.setTitle("d4");
		p("display: ").p(Display.getDisplayMode().toString()).nl();
		Display.create();
		p("opengl ").p(Display.getAdapter()).p(" ").pl(Display.getVersion());
//		Class.forName(vbos).getMethod("load").invoke(null,(Object[])null);
		final wld wd=new wld(null);
		Class.forName(init).getConstructor(wld.class).newInstance(wd);
		final win wn=new win(wd,wi,hi);
		wn.z-=0;
//		wn.p.z-=0;
		glClearColor(.5f,.5f,1,1);
		long frame=0;
		pl("loop");
		while(true){
			final long t0=System.currentTimeMillis();
			frame++;
			if(Display.isCloseRequested())
				break;
			glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			wn.rendview();
			Display.update();
			wd.upd();
			final long t1=System.currentTimeMillis();
			final long dt=t1-t0;
//			System.out.format("frame=%05d   dt=%03d    z=%f\r",frame,dt,wn.p.z);
			System.out.format("frame=%05d   dt=%03d    z=%f\r",frame,dt,wn.z);
			Display.sync(24);
		}
		Display.destroy();
	}
	private app p(final Object o){System.out.print(o==null?"":o.toString());return this;}
	private app nl(){System.out.println();return this;}
	private app pl(final Object o){return p(o).nl();}
	public static void main(final String[]a)throws Throwable{new app();}
}