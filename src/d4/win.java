package d4;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;
import java.util.Iterator;
public final class win extends obj{
	final private wld wd;
	final private p3 lookat=new p3();

	private int wi;
	private int hi;
	public win(final wld w){
		super(w);
		this.wd=w;
	}
	public void dim(final int w,final int h){
		wi=w;hi=h;
	}
	public void rendview()throws Throwable{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glViewport(0,0,wi,hi);
		gluPerspective(90,(float)wi/hi,.01f,10000);
//		gluLookAt(p.x,p.y,p.z, 0,0,0, 0,1,0);
		;
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		gluLookAt(x,y,z, lookat.x,lookat.y,lookat.z, 0,1,0);
		final Iterator<obj>i=wd.all();
		while(i.hasNext()){
			glPushMatrix();
			i.next().rend();
			glPopMatrix();
		}
	}
	public void upd(){
//		p.x+=.1f;if(p.x>5)p.x=-5;
//		p.z+=-.1f;if(p.z<-17)p.z=0;
//		z+=-.1f;if(z<-17)z=0;
	}
}
