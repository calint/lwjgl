package samples;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.Set;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GLContext;
public class vbotest3{
	public static class p3{
		float x,y,z;
	}
	public static class obj{
		protected final p3 p=new p3();
		protected final p3 a=new p3();
		protected polh ph;
		public Set<obj>ch;
		public void upd(){}
		public final void rend(){
			if(ph==null&&(ch==null||ch.isEmpty()))
				return;
			glTranslatef(p.x,p.y,p.z);
			glRotatef(a.x,1,0,0);
			glRotatef(a.y,0,1,0);
			glRotatef(a.z,0,0,1);
			if(ph!=null)
				ph.rend();
			if(ch==null||ch.isEmpty())
				return;
			for(final obj o:ch){
				glPushMatrix();
				o.rend();
				glPopMatrix();
			}
		}
	}
	public static class polh{
		protected FloatBuffer vb;
		protected int vbgl;
		protected FloatBuffer cb;
		protected int cbgl;
		protected IntBuffer ib;
		protected int ibgl;
		public void init(){}
		public void rend(){
			glEnableClientState(GL_VERTEX_ARRAY);
			glBindBuffer(GL_ARRAY_BUFFER,vbgl);
			glVertexPointer(2,GL_FLOAT,0,0);
			;
			glEnableClientState(GL_COLOR_ARRAY);
			glBindBuffer(GL_ARRAY_BUFFER,cbgl);
			glColorPointer(4,GL_FLOAT,0,0);
			;
			glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibgl);
			glDrawElements(GL_QUADS,12,GL_UNSIGNED_INT,0);
		}
	}
	;
	;
	;
	;
	;
	public static class polhsq extends polh{
		public void init(){
			vbgl=glGenBuffers();
			vb=BufferUtils.createFloatBuffer(4*2);
			vb.put(new float[]{-.1f,-.1f,  .1f,-.1f,  .1f,.1f,  -.1f,.1f});
			vb.flip();
			glBindBuffer(GL_ARRAY_BUFFER,vbgl);
			glBufferData(GL_ARRAY_BUFFER,vb,GL_STATIC_DRAW);
			;
			cbgl=glGenBuffers();
			cb=BufferUtils.createFloatBuffer(4*4);
			cb.put(new float[]{1,0,0,1,  1,0,0,1,  1,0,0,1,  1,0,0,1});
			cb.flip();
			glBindBuffer(GL_ARRAY_BUFFER,cbgl);
			glBufferData(GL_ARRAY_BUFFER,cb,GL_STATIC_DRAW);
			;
			ibgl=glGenBuffers();
			ib=BufferUtils.createIntBuffer(4);
			ib.put(new int[]{0,1,2,3});
			ib.flip();
			glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibgl);
			glBufferData(GL_ELEMENT_ARRAY_BUFFER,ib,GL_STATIC_DRAW);
		}
	}
	public static class polhtri extends polh{
		public void init(){
			vbgl=glGenBuffers();
			vb=BufferUtils.createFloatBuffer(3*2);
			vb.put(new float[]{-.1f,-.1f,  .1f,-.1f,  .1f,.1f});
			vb.flip();
			glBindBuffer(GL_ARRAY_BUFFER,vbgl);
			glBufferData(GL_ARRAY_BUFFER,vb,GL_STATIC_DRAW);
			;
			cbgl=glGenBuffers();
			cb=BufferUtils.createFloatBuffer(3*4);
			cb.put(new float[]{0,1,0,1,  0,1,0,1,  0,1,0,1});
			cb.flip();
			glBindBuffer(GL_ARRAY_BUFFER,cbgl);
			glBufferData(GL_ARRAY_BUFFER,cb,GL_STATIC_DRAW);
			;
			ibgl=glGenBuffers();
			ib=BufferUtils.createIntBuffer(3);
			ib.put(new int[]{0,1,2});
			ib.flip();
			glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibgl);
			glBufferData(GL_ELEMENT_ARRAY_BUFFER,ib,GL_STATIC_DRAW);
		}
	}
	;
	;
	;
	private final polh[]polhs=new polh[]{new polhsq(),new polhtri()};
	;
	class objsq extends obj{public objsq(){ph=polhs[0];}}
	class objtri extends obj{public objtri(){ph=polhs[1];}
		public void upd(){
			super.upd();
			a.z+=2;
		}
	}
	class objhous extends obj{
		objhous(){
			ch=new HashSet<vbotest3.obj>();
			;
			final obj s=new objsq();
			s.p.y=.1f;
			ch.add(s);
			;
			final obj r=new objtri();
			r.p.y=-.1f;
			ch.add(r);
		}
		public void upd(){
			p.x+=.001;a.z+=5;
			if(ch==null||ch.size()==0)
				return;
			for(final obj o:ch){
				o.upd();
			}
		}
	}
	;
	;
	;
	;
	public vbotest3() throws Throwable{
		final int wi=640;
		final int hi=480;
		final int bpp=32;
		DisplayMode dm=null;
		for(final DisplayMode d:Display.getAvailableDisplayModes()){
			if(d.getWidth()==wi&&d.getHeight()==hi&&d.getBitsPerPixel()==bpp){
				dm=d;
				break;
			}
		}
		if(dm==null)
			throw new Exception("cannotfinddisplaymode "+wi+"x"+hi+"x"+bpp+"b");
		;
		System.out.println(dm);
		Display.setDisplayMode(dm);
		Display.create();
		if(!GLContext.getCapabilities().GL_ARB_vertex_buffer_object)
			throw new Exception("nosupport GL_ARB_vertex_buffer_object");
		System.out.println("opengl");
		;
		glViewport(0,0,wi,hi);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		;
		;
		;
		for(final polh p:polhs)
			p.init();
		;
		;
		final obj o=new objhous();
		glClearColor(0.5f,0.5f,1.0f,1.0f);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		while(true){
			glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			glPushMatrix();
			o.rend();
			glPopMatrix();
			o.upd();
			Display.update();
			Display.sync(24);
		}
	}
	public static void main(final String[] a) throws Throwable{
		new vbotest3();
	}
}