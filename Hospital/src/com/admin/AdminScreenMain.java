/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

import com.model.Account;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author HP
 */
public class AdminScreenMain extends JFrame {

    // Variables declaration - do not modify                     
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
        private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public AdminScreenMain() {
        addComponents();
        setTitle("Hospital Management System");
        
          setVisible(true);
          setSize(800,600);
    }

    private void addComponents() {
    jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();  
         jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
                
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      
        jMenu1.setText("File");

        jMenuItem1.setText("Book Patient Appointment");
        jMenu1.add(jMenuItem1);
        jMenuItem1.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
        BookAppointmentMain bam=new BookAppointmentMain(); 
        bam=null;
        }
        });
        
        jMenuItem2.setText("Cancel Patient Appointment");
        jMenu1.add(jMenuItem2);
        jMenuItem2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           CancelAppointmentMain  cam=new CancelAppointmentMain ();
           cam=null;
           
        }
        });
        

        jMenuItem3.setText("Search Patient Info");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reports");

        jMenuItem4.setText("View Today's  Appointments");
         jMenu2.add(jMenuItem4);
         jMenuItem4.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            try {    
                fetchPatient();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminScreenMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminScreenMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         
         });
         
        
        jMenuItem5.setText("View Tomorrow's Appointments");
        jMenu2.add(jMenuItem5);
        jMenuItem5.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                fetchPatientTomorrow();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminScreenMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminScreenMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        });
        
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

    }
    
     private void fetchPatient() throws ClassNotFoundException, SQLException{
         Account a=new Account();
         ResultSet rst;
        rst = a.fetchPatient();
         jTable1.setModel(DbUtils.resultSetToTableModel(rst));
        }
     
     private void  fetchPatientTomorrow() throws ClassNotFoundException, SQLException{
          Account a=new Account();
         ResultSet rst;
        rst = a.fetchPatientTomorrow();
         jTable1.setModel(DbUtils.resultSetToTableModel(rst));
     }

}
