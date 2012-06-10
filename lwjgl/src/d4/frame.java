package d4;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glViewport;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;
import d4.ob.objhous;
public class frame{
	final int wi=1024;
	final int hi=512;
//	private shader shd=new shader();
	public frame() throws Throwable{
		Display.setDisplayMode(new DisplayMode(wi,hi));
		p("lwjgl display ").p(Display.getDisplayMode().toString()).nl();
		Display.setTitle("d4");
		Display.create();
		if(!GLContext.getCapabilities().GL_ARB_vertex_buffer_object)
			throw new Exception("nosupport GL_ARB_vertex_buffer_object");
		p("opengl");
//		final int shdrvtx=glCreateShader(GL_VERTEX_SHADER);
//		final int prog=glCreateProgram();

		glViewport(0,0,wi,hi);
		glMatrixMode(GL_PROJECTION);
//		glLoadIdentity();
		//eyex,eyey,eyez,centerx,centery,centerz,upx,upy,upz
		//GLU.gluLookAt(0,0,-100, 0,0,0, 0,1,0);
		GLU.gluPerspective(45,(float)wi/hi,0,10000);
		;
		;
		;
		for(final polh p:files.polhs)
			p.init();
		;
		;
		final obj o=new objhous();
		glClearColor(0.5f,0.5f,1.0f,1.0f);
		;
		;
		final p3 p=new p3();
		p.z=10;
		;
		;
		while(true){
			if(Display.isCloseRequested())break;
			glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			glMatrixMode(GL_MODELVIEW);
			glLoadIdentity();
			glTranslatef(-p.x,-p.y,-p.z);
			glPushMatrix();
			o.rend();
			o.upd();
			glPopMatrix();
			Display.update();
			Display.sync(24);
			; 
			;
			p.z-=.1f;if(p.z<0)p.z=10;	
		}
		Display.destroy();
	}
	public frame p(final Object o){System.out.print(o==null?"":o.toString());return this;}
	public frame nl(){System.out.println();return this;}
	public static void main(final String[] a) throws Throwable{
		new frame();
	}
}