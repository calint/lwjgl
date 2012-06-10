package d4;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
public class frame{
	final int wi=1024;
	final int hi=512;
//	private shader shd=new shader();
	final wld wd=new wld();
	final win wn=new win(wd,wi,hi);
	public frame() throws Throwable{
		Display.setDisplayMode(new DisplayMode(wi,hi));
		Display.setTitle("d4");
		p("display: ").p(Display.getDisplayMode().toString()).nl();
		Display.create();
//		if(!GLContext.getCapabilities().GL_ARB_vertex_buffer_object)
//			throw new Exception("nosupport GL_ARB_vertex_buffer_object");
		p("opengl");
		;
		vbos.load();
		;
//		final int shdrvtx=glCreateShader(GL_VERTEX_SHADER);
//		final int prog=glCreateProgram();
		;
		wn.p.z-=10;
		glClearColor(0.5f,0.5f,1.0f,1.0f);
		long frame=0;
		while(true){
			long t0=System.currentTimeMillis();
			frame++;
			if(Display.isCloseRequested())break;
			;
			glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			;
			wn.rendview();
			;
			wd.upd();
			;
			Display.update();
			final long t1=System.currentTimeMillis();
			;
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