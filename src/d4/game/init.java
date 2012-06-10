package d4.game;
import d4.wld;
import d4.ob.objhous;
import d4.ph.vbos;
public class init{public init(final wld wd)throws Throwable{
	System.out.println("load");
	vbos.init();
	System.out.println("create");
	wd.chs().add(new objhous());
}}
