package d4;
public class bvol{
	public final static bvol bvoid=new bvol(null);
	protected obj obj;
	public bvol(final obj o){this.obj=o;}
	public final static boolean isincollision(final bvol a,final bvol b){return a.isincol(b)||b.isincol(a);}
	protected boolean isincol(final bvol bv){return false;}
}
