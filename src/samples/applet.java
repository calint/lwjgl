package samples;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
/// from http://www.lwjgl.org/wiki/index.php?title=Basic_LWJGL_Applet
public class applet extends Applet{
	Canvas display_parent;
	public void startLWJGL(){
		try{
			Display.setParent(display_parent);
			Display.create();
		}catch(LWJGLException e){
			e.printStackTrace();
		}
	}
	private void stopLWJGL(){
		Display.destroy();
	}
	public void start(){}
	public void stop(){}
	public void destroy(){
		remove(display_parent);
		super.destroy();
	}
	public void init(){
		setLayout(new BorderLayout());
		try{
			display_parent=new Canvas(){
				public final void addNotify(){
					super.addNotify();
					startLWJGL();
				}
				public final void removeNotify(){
					stopLWJGL();
					super.removeNotify();
				}
			};
			display_parent.setSize(getWidth(),getHeight());
			add(display_parent);
			display_parent.setFocusable(true);
			display_parent.requestFocus();
			display_parent.setIgnoreRepaint(true);
			setVisible(true);
		}catch(Exception e){
			System.err.println(e);
			throw new RuntimeException("Unable to create display");
		}
	}
}