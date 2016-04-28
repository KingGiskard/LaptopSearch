import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Laptop implements Serializable
{
    private boolean available;
    private int numUSB;
    private String MediaPlayer;
    private int RAM;
    private String user;
    private String date;
    private int laptopNumber;
    private String location;
    private String output;
    
    
    public Laptop(int u, String m, int r, String o)
    {
         numUSB = u;
         MediaPlayer = m;
         RAM=r;
         output =o;  
    }
    
    public void checkOut(String s , String d, String loc)
    {
        available = false;
        user = s;
        date = d;
        location = loc;
        
    }
    
    public String getDate()
    {
        return date;
    }
    
    public String getLocation()
    {
        return location;
    }
  
    public void checkIn()
    {
        available = true;
        String user = null;
        String date = null;
    }
    
    public int getUSB()
    {
        return numUSB;
    }
    
    public String getOutput()
    {
        return output;
    }
    
    public String getUser()
    {
        if(user == null)
        {
            return "Laptop is currently Available";
        }
        else
            return user;
    }
    
    public boolean checkAvailablity()
    {
        return available;
    }
    
    public int getRAMSection()
    {
        if(RAM<4)
            return 0;
        else if(RAM>=4&&RAM<=8)
            return 6;
        else 
            return 10;
    }
    
    public String getMediaPlayer()
    {
        if(MediaPlayer.equals("Blu-Ray"))
            return "Blu-Ray";
        if(MediaPlayer.equals(""))
            return "None";
        return MediaPlayer;
    }
    
    public int USBSection()
    {
        if(numUSB<=2)
            return 2;
        else 
            return 3;
    }
    
    public int getNumber()
    {
        return laptopNumber;
    }
    
    
    public void setLaptopNumber(int i)
    {
        laptopNumber =i;
        available = true;
    }
    
    public int getRam()
    {
        return RAM;
    }
    
    public String toString()
    {
        return "Laptop #"+laptopNumber;
    }
    
}