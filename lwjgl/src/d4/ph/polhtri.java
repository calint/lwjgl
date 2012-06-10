package d4.ph;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import org.lwjgl.BufferUtils;
import d4.polh;

public class polhtri extends polh{
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
	public void rend(){
		super.rend();
		glDrawElements(GL_LINES,12,GL_UNSIGNED_INT,0);
	}

}