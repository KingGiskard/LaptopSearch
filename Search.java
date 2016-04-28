
import java.util.ArrayList;

public class Search
{
    ArrayList <Laptop> Storage;
    ArrayList<Laptop> searchList = new ArrayList();
    public Search(ArrayList <Laptop> a)
    {
        Storage =a;
    }
    
   public void reset()
   {
       searchList.clear();
       for(int i =0; i <Storage.size();i++)
        searchList.add(Storage.get(i)); 
       
       
   }
   
   public void setStorage(ArrayList<Laptop> a)
   {
       Storage = a;
   }
   
   
   public ArrayList<Laptop> USBSearch(int u)
   {
       for(int i =0; i<searchList.size();i++)
       {
           Laptop l = searchList.get(i);
           if(l.USBSection()!=u)
           {
               searchList.remove(i);
               i--;
           }
           
       }
       return searchList;
   }
   
   public ArrayList<Laptop> RamSearch(int r)
   {
       for(int i =0; i<searchList.size();i++)
       {
           Laptop l = searchList.get(i);
           if(l.getRAMSection()!=r)
           {
               searchList.remove(i);
               i--;
           }
       }
       return searchList;
   }
   
   public ArrayList<Laptop> MediaSearch(String m)
   {
        for(int i =0; i<searchList.size();i++)
        {
           Laptop l = searchList.get(i); 
           if(!m.equals(l.getMediaPlayer()))
           {
              searchList.remove(i);
              i--;
           }    
        }
        
        return searchList;
   }
   
   public ArrayList<Laptop> OutputSearch(String o)
   {
        for(int i =0; i<searchList.size();i++)
        {
           Laptop l = searchList.get(i); 
           if(!o.equals(l.getOutput()))
           {
              searchList.remove(i);
              i--;
           }    
        }
        
        return searchList;
   }
   
   public ArrayList<Laptop> AvailableSearch(boolean a)
   {
        for(int i =0; i<searchList.size();i++)
        {
           Laptop l = searchList.get(i); 
           if( l.checkAvailablity()!=a )
           {
              searchList.remove(i);
              i--;
           }    
        }
        
        return searchList;
   }
   
   
   public ArrayList <Laptop> getStorage()
   {
       return Storage;
   }
   
   public ArrayList<Laptop> getSearchList()
   {
       return searchList;
   }
    
   public void addLaptop(Laptop l)
   {
       
       boolean complete = false;
       int num =1;
       
       if(Storage.isEmpty())
       {
           num=1;    
       }
       
       else
       {
           num=1;
           boolean repeat = true;
           boolean available = true;
           
           while(repeat)
           {
            for(int i =0; i<Storage.size();i++)
            {  
                if(Storage.get(i).getNumber()==num)
                {
                    available = false;
                }  
            }
                if(!available)
                {
                    num++;
                    available = true;
                    repeat = true;
                }
                else
                    repeat = false;
          }
       }
       Storage.add(l);
       l.setLaptopNumber(num);
       putInOrder();
   }
   
   private void putInOrder()
   {
       ArrayList<Laptop> temporary = new ArrayList();
       
       for(int i =0;i<Storage.size();i++)
       {
           temporary.add(Storage.get(i));
       }
       
       Storage.clear();
       
       Storage.add(temporary.get(0));
       
       int index =1;
       boolean placed = false;
       int location =0;
       
       while(index<temporary.size())
       {
           location =0;
           placed = false;
           while(!placed)
           {
               if(location !=Storage.size() && temporary.get(index).getNumber()<Storage.get(location).getNumber())
               {
                   Storage.add(location,temporary.get(index));
                   placed = true;
               }
               else if(location ==Storage.size())
               {
                   Storage.add(temporary.get(index));
                   placed = true;
               }  
               else
                   location++;
           }
           index++;
       }
       
       
       
   }
   
   
   public void delete(Laptop l)
   {
       for(int i =0;i<Storage.size();i++)
       {
           if(l.getNumber()==Storage.get(i).getNumber())
               Storage.remove(i);
       }
       reset();
   }
      
}