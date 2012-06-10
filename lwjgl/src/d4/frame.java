package d4;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
public class frame{
	public frame()throws Throwable{
		final int wi=1024;
		final int hi=512;
		Display.setDisplayMode(new DisplayMode(wi,hi));
		Display.setTitle("d4");
		p("display: ").p(Display.getDisplayMode().toString()).nl();
		Display.create();
		p("opengl");
		vbos.load();
		final wld wd=new wld();
		final win wn=new win(wd,wi,hi);
		wn.p.z-=0;
		glClearColor(.5f,.5f,1,1);
		long frame=0;
		while(true){
			long t0=System.currentTimeMillis();
			frame++;
			if(Display.isCloseRequested())break;
			glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			wn.rendview();
			wd.upd();
			Display.update();
			final long t1=System.currentTimeMillis();
			final long dt=t1-t0;
			System.out.format("frame=%05d  dt=%03d    z=%f\n",frame,dt,wn.p.z);
			Display.sync(24);
		}
		Display.destroy();
	}
	public frame p(final Object o){System.out.print(o==null?"":o.toString());return this;}
	public frame nl(){System.out.println();return this;}
	public static void main(final String[] a) throws Throwable{new frame();}
}