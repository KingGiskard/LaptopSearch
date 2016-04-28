    import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;



 

public class SearchView extends JPanel implements ListSelectionListener 
{
    private JList list;
    private DefaultListModel listModel;
    private static final String selectString = "Select";
    private JButton selectButton;
    private ArrayList<Laptop> Storage;
    private Home Home;
 
    public SearchView(ArrayList<Laptop> l, Home t) 
    {
        super(new BorderLayout());
 
        listModel = new DefaultListModel();
        Home =t;
        Storage = l;
 
        //Create the list and put it in a scroll pane.
        list = new JList(listModel );
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(11);
        JScrollPane listScrollPane = new JScrollPane(list);
        list.setFont(new Font("Arial",Font.BOLD,25));
 
        selectButton = new JButton("Select");
        selectButton.setEnabled(false);
        selectButton.setFont(new java.awt.Font("Tahoma", 1, 24));
        selectButton.setActionCommand(selectString);
        selectButton.addActionListener(new SelectListener());
 

        JPanel buttonPane = new JPanel();
        buttonPane.add(selectButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
 
        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }
    
    
    
    public void repaintList(ArrayList<Laptop> result)
    {
            int index = 0; //get selected index
          listModel.clear();
            if(Storage.isEmpty())
            {
              listModel.addElement("NO Laptops In Search");
              list.setSelectedIndex(index);
              selectButton.setEnabled(false);
            }
          
            else if(!result.isEmpty())
          {
            for(int i =0; i< result.size();i++)
            {
                Laptop l = result.get(i);
                
                listModel.addElement(l);
                
                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
                index++;
                
            }
          }
          else
          {
              listModel.addElement("NO Laptops Met Your Search");
              list.setSelectedIndex(index);
              selectButton.setEnabled(false);
          }
             
    }
 
    class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) 
        {
            Laptop l =(Laptop)list.getSelectedValue();        
            Speks LaptopInfo = new Speks(l,Home);
            LaptopInfo.getSpeks(l,Home);   
        }
    }
    
    
 
  
 
    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
 
            if (list.getSelectedIndex() == -1) {
            //No selection, disable selection button.
                selectButton.setEnabled(false);
 
            } else {
            //Selection, enable the selection button.
                selectButton.setEnabled(true);
            }
        }
    }
 
    
 
     
}

