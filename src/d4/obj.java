package d4;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import java.util.HashSet;
import java.util.Set;
public class obj{
	public final p3 p=new p3();
	public final p3 a=new p3();
	public final Set<obj> chs=new HashSet<obj>();
	protected polh ph;
	public void upd(){
		for(final obj o:chs)
			o.upd();
	}
	public final void rend(){
		if(ph==null&&chs.isEmpty())
			return;
//		glRotatef(a.x,1,0,0);
//		glRotatef(a.y,0,1,0);
		glRotatef(a.z,0,0,1);
		glTranslatef(p.x,p.y,p.z);
		if(ph!=null)
			ph.rend();
		if(chs.isEmpty())
			return;
		for(final obj o:chs){
			if(o.ph==null&&o.chs.isEmpty())
				continue;
			glPushMatrix();
			o.rend();
			glPopMatrix();
		}
	}
}