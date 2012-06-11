package d4.game;

import static org.lwjgl.opengl.GL11.GL_QUADS;
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
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL14.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL21.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL31.*;
import static org.lwjgl.opengl.GL32.*;
import static org.lwjgl.opengl.GL33.*;
import static org.lwjgl.opengl.GL40.*;
import static org.lwjgl.opengl.GL41.*;
import static org.lwjgl.opengl.GL42.*;

public class dotph extends polh{
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
		cb.put(new float[]{1,1,1,1,  1,1,1,1,  1,1,1,1,  1,1,1,1});
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
	public void rend(){
		super.rend();
		glDrawElements(GL_QUADS,12,GL_UNSIGNED_INT,0);
	}
}