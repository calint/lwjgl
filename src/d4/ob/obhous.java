package d4.ob;
import d4.obj;
public class obhous extends obj{
	public obhous(final obj pt){
		super(pt);
		final obj s=new obsq(this);
//		s.pos().y=.1f;
		s.y=.1f;
		;
		final obj r=new obtri(this);
//		r.pos().y=-.1f;
		r.y=-.1f;
	}
	public void upd(){
		super.upd();
//		p.x+=.001;
	}
}