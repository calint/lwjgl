package d4.ob;
import d4.obj;
public class objhous extends obj{
	public objhous(){
		final obj s=new objsq();
		s.pos().y=.1f;
		chs.add(s);
		;
		final obj r=new objtri();
		r.pos().y=-.1f;
		chs.add(r);
	}
	public void upd(){
		super.upd();
//		p.x+=.001;
	}
}