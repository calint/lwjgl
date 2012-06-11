package d4;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import java.util.Collection;
import java.util.LinkedList;
public class obj extends p3{
	public static long nobjs;
//	protected final p3 p=new p3();
	protected obj pt;
	protected final p3 a=new p3();
	protected polh ph;
	protected bvol bvol;
	protected final Collection<obj>chs=new LinkedList<obj>();
	;
	;
	public obj(final obj parent){
		nobjs++;
		if(parent==null)return;
		pt=parent;
		parent.chs.add(this);//? sync
	}
//	public final p3 pos(){return p;}
	public final p3 agl(){return a;}
	public final Collection<obj>chs(){return chs;}
	public void upd(){
		for(final obj o:chs)
			o.upd();
	}
	public final void rend()throws Throwable{
		if(ph==null&&chs.isEmpty())
			return;
		glRotatef(a.z,0,0,1);
		glRotatef(a.x,1,0,0);
		glRotatef(a.y,0,1,0);
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