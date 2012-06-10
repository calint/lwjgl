package samples;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GLContext;
public class vbotest3{
	public static class p3{
		float x,y,z;
	}
	public static class polh{
		public final p3 p=new p3();
		public final p3 a=new p3();
		public FloatBuffer vb;public int vbgl;
		public FloatBuffer cb;public int cbgl;
		public IntBuffer ib;public int ibgl;
		void init(){
			vbgl=glGenBuffers();
			vb=BufferUtils.createFloatBuffer(4*3);
			vb.put(new float[]{-1,-1,0,  1,-1,0,  1,1,0,  -1,1,0});
			vb.flip();
			glBindBuffer(GL_ARRAY_BUFFER,vbgl);
			glBufferData(GL_ARRAY_BUFFER,vb,GL_STATIC_DRAW);
			cbgl=glGenBuffers();
			final FloatBuffer bc=BufferUtils.createFloatBuffer(4*4);
			bc.put(new float[]{1,0,0,1,  1,0,0,1,  1,0,0,1,  1,0,0,1});
			bc.flip();
			glBindBuffer(GL_ARRAY_BUFFER,cbgl);
			glBufferData(GL_ARRAY_BUFFER,bc,GL_STATIC_DRAW);
			ibgl=glGenBuffers();
			ib=BufferUtils.createIntBuffer(4);
			ib.put(new int[]{0,1,2,3});
			ib.flip();
			glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibgl);
			glBufferData(GL_ELEMENT_ARRAY_BUFFER,ib,GL_STATIC_DRAW);
			glBindBuffer(GL_ARRAY_BUFFER,GL_NONE);
			glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,GL_NONE);
		}
		void upd(){
			a.z++;
			p.x+=.1;
			if(p.x>1)p.x-=1;
		}
		void rend(){
			glRotatef(a.x,1,0,0);
			glRotatef(a.y,0,1,0);
			glRotatef(a.z,0,0,1);
			glTranslatef(p.x,p.y,p.z);
			;
			glEnableClientState(GL_VERTEX_ARRAY);
			glBindBuffer(GL_ARRAY_BUFFER,vbgl);
			glVertexPointer(3,GL_FLOAT,0,0);
			glEnableClientState(GL_COLOR_ARRAY);
			glBindBuffer(GL_ARRAY_BUFFER,cbgl);
			glColorPointer(4,GL_FLOAT,0,0);
			glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibgl);
			glDrawElements(GL_QUADS,12,GL_UNSIGNED_INT,0);
		}
	}
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
		;
		;
		System.out.println(dm);
		Display.setDisplayMode(dm);
		Display.create();
		if(!GLContext.getCapabilities().GL_ARB_vertex_buffer_object)
			throw new Exception("nosupport GL_ARB_vertex_buffer_object");
		System.out.println("opengl");
		;
		;
		;
		;
		;
		;
		;
		;
		final polh o=new polh();
		o.init();
//		int bvgl=glGenBuffers();
//		final FloatBuffer bv=BufferUtils.createFloatBuffer(4*3);
//		bv.put(new float[]{-1,-1,0,  1,-1,0,  1,1,0,  -1,1,0});
//		bv.flip();
//		glBindBuffer(GL_ARRAY_BUFFER,bvgl);
//		glBufferData(GL_ARRAY_BUFFER,bv,GL_STATIC_DRAW);
//		int bcgl=glGenBuffers();
//		final FloatBuffer bc=BufferUtils.createFloatBuffer(4*4);
//		bc.put(new float[]{1,0,0,1,  1,0,0,1,  1,0,0,1,  1,0,0,1});
//		bc.flip();
//		glBindBuffer(GL_ARRAY_BUFFER,bcgl);
//		glBufferData(GL_ARRAY_BUFFER,bc,GL_STATIC_DRAW);
//		int bigl=glGenBuffers();
//		final IntBuffer bi=BufferUtils.createIntBuffer(4);
//		bi.put(new int[]{0,1,2,3});
//		bi.flip();
//		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,bigl);
//		glBufferData(GL_ELEMENT_ARRAY_BUFFER,bi,GL_STATIC_DRAW);
//		glBindBuffer(GL_ARRAY_BUFFER,GL_NONE);
//		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,GL_NONE);
		;
		;
		;
		;
		glViewport(0,0,wi,hi);
		while(true){
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			//			GLU.gluPerspective(70,1.0f*Display.getWidth()/Display.getHeight(),0.5f,100);
			//			glHint(GL_PERSPECTIVE_CORRECTION_HINT,GL_NICEST);
			glMatrixMode(GL_MODELVIEW);
			glLoadIdentity();
			//			GLU.gluLookAt(0,0,10,0,0,0,0,1,0);
			glClearColor(0.5f,0.5f,1.0f,1.0f);
			glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			;
			;
			o.rend();
			o.upd();
			;
//			glEnableClientState(GL_VERTEX_ARRAY);
//			glBindBuffer(GL_ARRAY_BUFFER,bvgl);
//			glVertexPointer(3,GL_FLOAT,0,0);
//			glEnableClientState(GL_COLOR_ARRAY);
//			glBindBuffer(GL_ARRAY_BUFFER,bcgl);
//			glColorPointer(4,GL_FLOAT,0,0);
//			glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,bigl);
//			glDrawElements(GL_QUADS,12,GL_UNSIGNED_INT,0);
			glDisableClientState(GL_VERTEX_ARRAY);
			glDisableClientState(GL_COLOR_ARRAY);
			Display.update();
			Display.sync(10);
		}
	}
	public static void main(final String[] a) throws Throwable{
		new vbotest3();
	}
}