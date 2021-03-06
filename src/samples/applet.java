/// from http://www.lwjgl.org/wiki/index.php?title=Basic_LWJGL_Applet
package samples;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
public class applet extends Applet{
	Canvas display_parent;
	Thread gameThread;
	boolean running=false;
	public void startLWJGL(){
		gameThread=new Thread(){
			public void run(){
				running=true;
				try{
					Display.setParent(display_parent);
					Display.create();
					initGL();
				}catch(LWJGLException e){
					e.printStackTrace();
					return;
				}
				gameLoop();
			}
		};
		gameThread.start();
	}
	/**
	 * Tell game loop to stop running, after which the LWJGL Display will 
	 * be destoryed. The main thread will wait for the Display.destroy().
	 */
	private void stopLWJGL(){
		running=false;
		try{
			gameThread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	public void start(){}
	public void stop(){}
	/**
	 * Applet Destroy method will remove the canvas, 
	 * before canvas is destroyed it will notify stopLWJGL()
	 * to stop the main game loop and to destroy the Display
	 */
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
	protected void initGL(){}
	public void gameLoop(){
		//		float r=0,g=0,b=0,a=0;
		while(running){
			//			GL11.glClearColor(r,g,b,a);
			//			r+=.1f;
			Display.sync(60);
			Display.update();
		}
		Display.destroy();
	}
}