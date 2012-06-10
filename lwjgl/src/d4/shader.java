package d4;
import static org.lwjgl.opengl.GL11.GL_BACK;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_POINTS;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_STRIP;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glCullFace;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glPointSize;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;
import org.lwjgl.util.glu.GLU;
public final class shader{
	private int rot=0;
	public String shdrpthvtx(){return "vertex.glsl";}
	public String shdrpthfrag(){return "fragment.glsl";}
	public void link(final int prog)throws Throwable{
	}
	public void init()throws Throwable{
		glClearColor(0,0,0,0);
		glEnable(GL_CULL_FACE);
		glCullFace(GL_BACK);
	}
	public void redim(final int x,final int y,final int w,final int h){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluPerspective(50f,(float)w/(h<=0?1:h),1,1000);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
	}
	public void rend() {
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
		glTranslatef(0,0,-4);

		glPointSize(10);
		glBegin(GL_POINTS);
		for(int i=0;i<360;i+=30)
			glVertex2f((float)Math.cos((float)i*Math.PI/180),(float)Math.sin((float)i*Math.PI/180));
		glEnd();
		glRotatef(rot,0,0,1);

		glBegin(GL_TRIANGLE_STRIP);
		glVertex2f(-1,-1);
		glVertex2f( 1,-1);
		glVertex2f(-1, 1);
//		g.glVertex2f( 1, 1);
		glEnd();

		glRotatef(rot,0,0,1);
		glBegin(GL_TRIANGLE_STRIP);
		glVertex2f(-1,-.1f);
		glVertex2f( 1,-.1f);
		glVertex2f(-1, .1f);
//		g.glVertex2f( 1, 1);
		glEnd();

		rot+=360/60;
	}
}