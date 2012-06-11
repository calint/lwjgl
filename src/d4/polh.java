package d4;
import static org.lwjgl.opengl.GL11.GL_COLOR_ARRAY;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_VERTEX_ARRAY;
import static org.lwjgl.opengl.GL11.glColorPointer;
import static org.lwjgl.opengl.GL11.glEnableClientState;
import static org.lwjgl.opengl.GL11.glVertexPointer;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
public class polh{
	protected FloatBuffer vb;
	protected int vbgl;
	protected FloatBuffer cb;
	protected int cbgl;
	protected IntBuffer ib;
	protected int ibgl;
	public void init()throws Throwable{}
	public void rend()throws Throwable{
		glEnableClientState(GL_VERTEX_ARRAY);
		glBindBuffer(GL_ARRAY_BUFFER,vbgl);
		glVertexPointer(2,GL_FLOAT,0,0);
		;
		glEnableClientState(GL_COLOR_ARRAY);
		glBindBuffer(GL_ARRAY_BUFFER,cbgl);
		glColorPointer(4,GL_FLOAT,0,0);
		;
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibgl);
//		glDrawElements(GL_QUADS,12,GL_UNSIGNED_INT,0);
	}
}