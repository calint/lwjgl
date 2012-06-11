package d4;
public class bsphr extends bvol{
	private float r;
	public bsphr(final obj o,final float radius){
		super(o);
		r=radius;
	}
	protected boolean isincol(final bvol bv){
		if(bv instanceof bsphr){
			final bsphr bs=(bsphr)bv;
			final p3 v=p3.vec(obj,bv.obj);
			final float dist=v.magn();
			return (r+bs.r)>dist;
		}
		return false;
	}
}
