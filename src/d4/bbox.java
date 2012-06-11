package d4;
public class bbox extends bvol{
	private final p3 dim=new p3();
	public bbox(final obj o,final p3 corner){
		super(o);
		dim.set(corner);
	}
}
