public class DoubleCheck extends javax.swing.JFrame
{
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    
    
    CheckOut use;
    private boolean returnLaptop=false;
    private boolean deleteLaptop = false;
    UserInfo info;
    private boolean checkOut = false;
    Laptop deleteMachine;
    DeleteLaptop goodbye;
    
    
    public DoubleCheck(CheckOut c) {
        use = c;
        checkOut = true;
        initComponents();
    }
    public DoubleCheck(DeleteLaptop d, Laptop l)
    {
        deleteLaptop = true;
        deleteMachine = l;
        goodbye =d;
        initComponents();
    }
    
    public DoubleCheck(boolean b, UserInfo a)
    {
        info =a;
        returnLaptop =b;
        initComponents();
    }
    
    private void initComponents() 
    {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        if(returnLaptop)
        {
             jLabel1.setText("Are You 100% SURE This is the correct Laptop and User?");
             jButton2.setText("No");
        }
        
        else if(deleteLaptop)
        {
           jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
           jLabel1.setText("Are You 100% SURE? This is irreversible");
           jButton1.setText("Delete");
           jButton2.setText("No"); 
        }
        
        else
        {
          jLabel1.setText("Are You Sure all Inforamtion was inputed correctly?");
          jButton2.setText("Edit");
        }
        if(!deleteLaptop)
        jButton1.setText("Yes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton1)
                        .addGap(48, 48, 48)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        
        if(returnLaptop)
            setLocation(410+20,15+35);
        else if(checkOut)
            setLocation(use.getX()+20,use.getY()+20);
        else if(deleteLaptop)
            setLocation(goodbye.getX()+20 , goodbye.getY()+20);
        
            
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) // yes key
         {
             String a;
             if(returnLaptop)
             {
                info.returnLaptop();
                info.close(); 
             }
             else if (deleteLaptop)
             {
                 goodbye.destroyLaptop(deleteMachine);
                 goodbye.dispose();
             }
             else
                use.use();
            
             dispose();
         }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//no key 
         {
             
             if(returnLaptop)
             {
                 info.close(true);//only close info page and speks page not laptop return page
                 info.fixButton();
             }
             else if (deleteLaptop)
             {
                 goodbye.dispose();
             }
                 
             else
                use.edit();
             
             
             dispose();
         }
     public void DoubleCheck(final CheckOut c) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoubleCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoubleCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoubleCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoubleCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoubleCheck(c).setVisible(true);
            }
        });
    }
     
     public void DoubleCheck(final DeleteLaptop d, final Laptop l) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoubleCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoubleCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoubleCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoubleCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoubleCheck(d,l).setVisible(true);
            }
        });
    }
     
     public void DoubleCheck(final boolean b, final UserInfo a)
     {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoubleCheck(b,a).setVisible(true);
            }
        });
     }

    
}