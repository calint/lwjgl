package d4.game;
import d4.wld;
import d4.ob.objhous;
public class init{
	public init(final wld wd){
		System.out.println("init");
		wd.chs.add(new objhous());
	}
}
