package d4;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import java.util.HashSet;
import java.util.Set;
public class obj extends p3{
//	protected final p3 p=new p3();
	protected final p3 a=new p3();
	protected final p3 l=new p3();
	protected polh ph;
	protected obj pt;
	protected final Set<obj>chs=new HashSet<obj>();
	;
	;
	public obj(final obj parent){
		if(parent==null)return;
		pt=parent;
		parent.chs.add(this);
	}
//	public final p3 pos(){return p;}
	public final p3 agl(){return a;}
	public final Set<obj>chs(){return chs;}
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
//		glTranslatef(p.x,p.y,p.z);
		glTranslatef(x,y,z);
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