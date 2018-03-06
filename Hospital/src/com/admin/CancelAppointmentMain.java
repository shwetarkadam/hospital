package com.admin;


import com.model.Account;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class CancelAppointmentMain extends JFrame{

    
       // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    public CancelAppointmentMain() {
     addComponents();
          setVisible(true);
          setSize(700,500);
    
    }
      private void addComponents() {
           jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
         jLabel6 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("    CANCEL PATIENT APPOINTMENT");

        jLabel2.setText("Name:");

        jLabel3.setText("Select Doctor:");

        jLabel4.setText("Select Date:");

        jLabel5.setText("Select Time:");

        jTextField1.setText("jTextField1");
  jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select Doctor--", "Dr. Hemangini Bush", "Dr. Aryan Kadam", "Dr. Pandya" }));
        jComboBox1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              String dname=(String)jComboBox1.getSelectedItem();
              if(dname.equals("Dr. Hemangini Bush")){
                  jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00 AM - 1:00 PM", "5:00 PM-9:00PM" }));

            }
              if(dname.equals("Dr. Aryan Kadam")){
                  jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11:00 AM - 1:30 PM ", "4:30PM- 8:30PM" }));

            }
              if(dname.equals("Dr. Pandya")){
                  jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00 AM - 1:00 PM", "4:30PM- 9:30PM" }));

            }
              
        
            }
        });

   DateFormat df= DateFormat.getDateInstance();
        String d=df.format(new Date());//tpday's date
        Calendar c=Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 1);
        Date d1=c.getTime();//tomorrows date
        String d2=df.format(d1);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { d,d2 }));




        jButton1.setText("Cancel Appointment");
        jButton1.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e) {
                  String name=jTextField1.getText();
                  String dname=(String) jComboBox1.getSelectedItem();
                  String date=(String) jComboBox2.getSelectedItem();
                  String time=(String) jComboBox3.getSelectedItem();
                  Account a=new Account();
                  boolean status = false;
                   try {
                      try {
                          status = a.deletePatientAppointment(name,dname,date,time);
                      } catch (SQLException ex) {
                          Logger.getLogger(CancelAppointmentMain.class.getName()).log(Level.SEVERE, null, ex);
                      }
                   } catch (ClassNotFoundException ex) {
                   }
                   
                    
                  if(status== true){
                      jLabel6.setText("Cancelled Appmt Successully !!");
                  }
                  else{
                       jLabel6.setText("Appointment Cancel Failed");
                  }
               }
        
        
        });
       
  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(71, 71, 71)
                                .addComponent(jButton2))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(40, Short.MAX_VALUE))
        );

          
      }
}
