
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class WindowFunction extends JFrame implements WindowListener//just to automatically save and load laptops
{
    Home Home;
    public WindowFunction( Home t)
    {
        Home = t;
    }
    
    @Override
    public void windowClosing(WindowEvent we) 
    {
        Home.save();
        
    }

    //the rest is unecessary and is used for interface purposes
    @Override
    public void windowOpened(WindowEvent we) 
    {
        
    }
    @Override
    public void windowClosed(WindowEvent we) {
        
    }
    @Override
    public void windowIconified(WindowEvent we) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        
    }

    @Override
    public void windowActivated(WindowEvent we) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }
    
}