package d4;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.*;
import java.util.Iterator;
import org.lwjgl.util.glu.GLU;
public class win extends obj{
	final private wld wd;
	private int wi;
	private int hi;
	public win(final wld w,final int wi,final int hi){
		w.chs.add(this);
		this.wd=w;
		this.wi=wi;
		this.hi=hi;
	}
	public void rendview(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glViewport(0,0,wi,hi);
		GLU.gluPerspective(90,(float)wi/hi,0,10000);
		GLU.gluLookAt(p.x,p.y,p.z, 0,0,0, 0,1,0);
//		glTranslatef(-p.x,-p.y,-p.z);
		;
		final Iterator<obj>i=wd.all();
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		while(i.hasNext()){
			i.next().rend();
			glLoadIdentity();
		}
	}
	public void upd(){
		p.x+=.1f;if(p.x>5)p.x=-5;
		p.z-=.1f;if(p.z<0)p.z=20;
	}
}
