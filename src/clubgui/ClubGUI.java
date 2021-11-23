/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.border.Border;


/**
 *
 * @author winrosekisilu
 */
public class ClubGUI extends JFrame implements ActionListener{
     JLabel l1, rname, remail, rpass1, rpass2, rcountry, rstate, rphone;  
    JTextField txtrname, txtremail, txtrcountry, txtrstate, txtrphone;  
    JButton btnsubmit, btnclear;  
    JPasswordField txtrpass1, p2;
    
    JFrame frame1,frame2,fmem,freg,fanx,ftig,fang,fdiets;
    JPanel panel1,panelyellow,panel3,panel4,panel5,panel6,panel7,panel8,panel9,panel10,r,panelfeel,panelbutton,panellabel,panelp1;
    JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,memberid,name,rank,contact;
    JButton next,previous,close,members,nextmem,prevmem,register;
    JTextField tid,tname,trank,tcon;
    JComboBox feeling;
    Font f,x,y,z,a,t;
    Connection con;
    Statement st;
    ResultSet rs;
    
    
    ClubGUI()
    {
        
        //fonts
         z=new Font("Bradley Hand",Font.BOLD,30);
         y=new Font("Skia",Font.BOLD,30);
         a=new Font("Herculanum",Font.BOLD,16);
         t=new Font("Comic Sans MS",Font.BOLD,20);
         
         //combobox
        label9=new JLabel("Signs of depression:");
        label9.setFont(z);
        String[] feel={"Anxiety","Fatigue","Irritability","Diet changes"}; 
        feeling=new JComboBox(feel);
        feeling.setBounds(50, 100,90,20);
        feeling.addActionListener(this);
        feeling.getItemAt(feeling.getSelectedIndex());
        feeling.setPreferredSize(new Dimension(10,20));
        
        //labels
        
            label1=new JLabel("WELCOME TO THE MENTAL HEALTH AWARENESS CLUB",JLabel.CENTER);

            //font style for labels
            f=new Font("Chalkduster",Font.BOLD,34);
            label1.setFont(f);
            //alignment of label
            label1.setHorizontalAlignment(JLabel.CENTER);
            label1.setVerticalAlignment(JLabel.CENTER);

            //color of label text
            label1.setForeground(Color.MAGENTA);

            //border for label
            //Border border = BorderFactory.createLineBorder(Color.BLACK);
            //label1.setBorder(border);
        
        
            label2=new JLabel("Our club is geared towards educating people on the various types of mental health.\n\n\n\n\n\n\n\n\n\n");
            x=new Font("Rockwell",Font.PLAIN,20);
            label2.setFont(z);
        
            
            label3=new JLabel("Positive mental health allows people to:");
            label3.setFont(z);
            
            label4=new JLabel("->Realize their full potential");
            label4.setFont(z);
            
            label5=new JLabel("->Cope with the stresses of life");
            label5.setFont(z);
            
            label6=new JLabel("->Work productively");
            label6.setFont(z);
            
            label7=new JLabel("->Make meaningful contributions to their communities");
            label7.setFont(z);
            
            label8=new JLabel("We are here to help and listen,you are not alone....");
            label8.setFont(z);
            
            
            
        //database labels
        memberid=new JLabel("Member id:");
        memberid.setFont(a);
        name=new JLabel("Name:");
        name.setFont(a);
        rank=new JLabel("Rank:");
        rank.setFont(a);
        contact=new JLabel("Contact:");
        contact.setFont(a);
        
        //database textboxes
        tid=new JTextField(5);
        tid.setFont(a);
        tname=new JTextField(10);
        tname.setFont(a);
        trank=new JTextField(15);
        trank.setFont(a);
        tcon=new JTextField(15);
        tcon.setFont(a);
        
        //images
        ImageIcon img=new ImageIcon("peace.png");
        //resizing the image
        Image myimage=img.getImage();
        Image modIm=myimage.getScaledInstance(500, 200, java.awt.Image.SCALE_SMOOTH);
        img=new ImageIcon(modIm);
        JLabel imglabel=new JLabel(img);
        
        
        ImageIcon anxim=new ImageIcon("anx2.gif");
        JLabel anxlabel=new JLabel(anxim);
        
        //buttons
        next=new JButton("Next Page");
        next.setFont(y);
        next.setForeground(Color.orange);
        next.addActionListener(this);
        next.setActionCommand("next");
        
        previous=new JButton("Previous page");
        previous.setFont(y);
        previous.setForeground(Color.red);
        previous.addActionListener(this);
        previous.setActionCommand("prev");
        
        close=new JButton("Close");
        close.setFont(y);
        close.setForeground(Color.BLUE);
        close.addActionListener(this);
        close.setActionCommand("close");
        
        members=new JButton("Club officials");
        members.setFont(y);
        members.setForeground(Color.ORANGE);
        members.addActionListener(this);
        members.setActionCommand("mem");
        
        nextmem=new JButton("Next Member");
        nextmem.addActionListener(this);
        nextmem.setActionCommand("nmem");
        
        prevmem=new JButton("Previous Member");
        prevmem.addActionListener(this);
        prevmem.setActionCommand("pmem");
        
        register=new JButton("Registration");
        register.setFont(y);
        register.setForeground(Color.green);
        register.addActionListener(this);
        register.setActionCommand("reg");
        
        
        //panels
        panel1=new JPanel();
        r=new JPanel();
        panelyellow=new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();
        panel5=new JPanel();
        panel6=new JPanel();
        panel7=new JPanel();
        panel8=new JPanel();
        panel9=new JPanel();
        panel10=new JPanel();
        panelfeel=new JPanel();
        panelbutton=new JPanel();
        panellabel=new JPanel();
        panelp1=new JPanel();
        
        //panel 1
        
        panel1.add(imglabel);
        panel1.setBackground(Color.CYAN);
        
        //panel yellow
        panelyellow.setBackground(Color.YELLOW);
        panelyellow.add(label1);
        //panelyellow.add(Box.createHorizontalStrut(1));
        panelyellow.add(label2);
        panelyellow.add(label3);
        panelyellow.add(label4);
        panelyellow.add(label5);
        panelyellow.add(label6);
        panelyellow.add(label7);
        panelp1.add(members);
        panelp1.add(next);
        panelp1.setBackground(Color.WHITE);
        panelyellow.add(panelp1);
        panelyellow.setLayout(new BoxLayout(panelyellow, BoxLayout.Y_AXIS));
    
        
        //panel 3
        ImageIcon img2=new ImageIcon("y.png");
       
        
        Image myim=img2.getImage();
        Image modImage=myim.getScaledInstance(500, 200, java.awt.Image.SCALE_SMOOTH);
        img2=new ImageIcon(modImage);
        JLabel iml=new JLabel(img2);
        panel3.add(iml);
        panellabel.add(label8);
        panellabel.setBackground(Color.GREEN);
        panel3.add(panellabel);
        panelfeel.add(label9);
        panelfeel.add(feeling);
        panelfeel.setLayout(new BoxLayout(panelfeel, BoxLayout.Y_AXIS));
        panelfeel.setBackground(Color.CYAN);
        panel3.add(panelfeel);
        panelbutton.add(register);
        panelbutton.add(previous);
        panelbutton.add(close);
        panelbutton.setBackground(Color.magenta);
        panel3.add(panelbutton);
        panel3.setBackground(Color.WHITE);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        
        //panel 5
        
        panel5.add(nextmem);
        panel5.add(prevmem);
        panel5.setBackground(Color.green);
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));

        //panel 4
        panel4.add(memberid);
        panel4.add(tid);
        panel4.add(name);
        panel4.add(tname);
        panel4.add(rank);
        panel4.add(trank);
        panel4.add(contact);
        panel4.add(tcon);
        panel4.add(panel5);
        panel4.setBackground(Color.green);
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        
        //panel 6
         panel6.add(anxlabel);
 
        //panel7
        ImageIcon fim=new ImageIcon("f2.gif");
        JLabel flabel=new JLabel(fim);
        panel7.add(flabel);
        
        //panel8
        ImageIcon fanger=new ImageIcon("anger.gif");
        JLabel fanglabel=new JLabel(fanger);
        panel8.add(fanglabel);
        
        //panel9
        ImageIcon feat=new ImageIcon("hungry.gif");
        JLabel featlabel=new JLabel(feat);
        panel9.add(featlabel);
        
        
         
  
    }
    
    //Database connection
    public void myConnection() {
        try {
            //database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            String database = "jdbc:mysql://localhost:3306/clubs";
            con = DriverManager.getConnection(database, "yourusername", "yourpassword");
            
        }
        catch (Exception ex) {
            System.out.println("Error. " + ex);
        }
    }
    //Intro frame
    public void frame(){
        frame1=new JFrame();
        frame1.setSize(900,600);
        frame1.setTitle("Intro Page");
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame1.setResizable(true);
        frame1.add(panel1, BorderLayout.NORTH);
        frame1.add(panelyellow, BorderLayout.CENTER);
        
        
       
    
    }
    
    //Interaction frame
    public void frame2(){
    
        frame2=new JFrame();
        frame2.setSize(900,600);
        frame1.setTitle("Interaction Page");
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame2.setResizable(true);
        frame2.add(panel3);
        
        
    }
    
    //FRame for data members in the DB
     public void framemem(){
    
        fmem=new JFrame();
        frame1.setTitle("CLUB MEMBERS");
        fmem.setSize(500,500);
        fmem.setVisible(true);
        //fmem.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fmem.setResizable(true);
        fmem.add(panel4);
    }
     public void anx(){
     
        fanx=new JFrame();
        fanx.setSize(270,200);
        fanx.setVisible(true);
        fanx.setResizable(false);
        fanx.add(panel6);   
     }
     
      public void fatigue(){
     
        ftig=new JFrame();
        ftig.setSize(500,320);
        ftig.setVisible(true);
        ftig.setResizable(false);
        ftig.add(panel7);   
     }
      
       public void firritable(){
     
        fang=new JFrame();
        fang.setSize(250,140);
        fang.setVisible(true);
        fang.setResizable(false);
        fang.add(panel8);   
     }
       
       public void fdiet(){
     
        fdiets=new JFrame();
        fdiets.setSize(400,400);
        fdiets.setVisible(true);
        fdiets.setResizable(false);
        fdiets.add(panel9);   
     }
        public void fregister(){
     
         
      
        
        rname = new JLabel("Name:");  
        rname.setFont(t);
        
        remail = new JLabel("Email-ID:"); 
        remail.setFont(t);
        
        rpass1 = new JLabel("Create Password:");  
        rpass1.setFont(t);
        
        rpass2 = new JLabel("Confirm Password:");
        rpass2.setFont(t);
        
        rcountry = new JLabel("Country:"); 
        rcountry.setFont(t);
        
        rstate = new JLabel("City/County/State:"); 
        rstate.setFont(t);
        
        rphone = new JLabel("Phone No:");
        rphone.setFont(t);
        
        txtrname = new JTextField(); 
        txtrname.setFont(t);
        
        txtremail = new JTextField(); 
        txtremail.setFont(t);
        
        txtrpass1 = new JPasswordField();  
        p2 = new JPasswordField();  
        
        txtrcountry = new JTextField();
        txtrcountry.setFont(t);
        
        txtrstate = new JTextField(); 
        txtrstate.setFont(t);
        
        txtrphone = new JTextField();  
        txtrphone.setFont(t);
         
        btnsubmit = new JButton("Submit");  
        btnclear = new JButton("Clear");  
        btnsubmit.addActionListener(this);  
        btnsubmit.setActionCommand("submit");
        btnclear.addActionListener(this); 
        btnclear.setActionCommand("clear");
       
        rname.setBounds(80, 70, 200, 30);  
        remail.setBounds(80, 110, 200, 30);  
        rpass1.setBounds(80, 150, 200, 30);  
        rpass2.setBounds(80, 190, 200, 30);  
        rcountry.setBounds(80, 230, 200, 30);  
        rstate.setBounds(80, 270, 200, 30);  
        rphone.setBounds(80, 310, 200, 30);  
        txtrname.setBounds(300, 70, 200, 30);  
        txtremail.setBounds(300, 110, 200, 30);  
        txtrpass1.setBounds(300, 150, 200, 30);  
        p2.setBounds(300, 190, 200, 30);  
        txtrcountry.setBounds(300, 230, 200, 30);  
        txtrstate.setBounds(300, 270, 200, 30);  
        txtrphone.setBounds(300, 310, 200, 30);  
        btnsubmit.setBounds(50, 350, 100, 30);  
        btnclear.setBounds(170, 350, 100, 30);  
        
        r.setBackground(Color.PINK);
        r.add(rname);  
        r.add(txtrname);  
        r.add(remail);  
        r.add(txtremail);  
        r.add(rpass1);  
        r.add(txtrpass1);  
        r.add(rpass2);  
        r.add(p2);  
        r.add(rcountry);  
        r.add(txtrcountry);  
        r.add(rstate);  
        r.add(txtrstate);  
        r.add(rphone);  
        r.add(txtrphone);  
        r.add(btnsubmit);  
        r.add(btnclear); 
        r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));
        
        freg=new JFrame();
        freg.setSize(700,700);
        freg.setVisible(true);
        freg.setResizable(false);
        freg.add(r);
        freg.setTitle("Registration Form "); 
        
     }
       
    
   
    
    
    @Override
    public void actionPerformed(ActionEvent evt){
        
        //Action Event for mebers button
  
         if(evt.getActionCommand().equals("mem")){
          
        try {
                  
                    
                    myConnection();

                    st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    String selTable = "SELECT * FROM officials";
                    st.executeQuery(selTable);
                    rs = st.getResultSet();
                    rs.next();
                    tid.setText(rs.getString(1));
                    tname.setText(rs.getString(2));
                    trank.setText(rs.getString(4));
                    tcon.setText(rs.getString(3));
                    framemem();
                }
                catch (Exception ex) {
                    System.out.println("Error. " + ex);
                    JOptionPane.showMessageDialog(null, "Error!");
                }
                
                
        
        }
        
         else if(evt.getActionCommand().equals("nmem")){
            try {
            if (rs.next()) {
                tid.setText(rs.getString(1));
                  tname.setText(rs.getString(2));
                    trank.setText(rs.getString(4));
                    tcon.setText(rs.getString(3));
            
            } else {
                rs.previous();
                JOptionPane.showMessageDialog(null, "End of file reached!");
            }
        }
        catch (Exception ex) {
            System.out.println("Error. " + ex);
            JOptionPane.showMessageDialog(null, "Error!");
          
        }
    } 
        //Action event for get previous member from database
        else if(evt.getActionCommand().equals("pmem")){
            try {
            if (rs.previous()) {
                tid.setText(rs.getString(1));
                tname.setText(rs.getString(2));
                trank.setText(rs.getString(4));
                 tcon.setText(rs.getString(3));
            
            } else {
                rs.next();
                JOptionPane.showMessageDialog(null, "Beginning of file!");
            }
        }
        catch (Exception ex) {
            System.out.println("Error. " + ex);
            JOptionPane.showMessageDialog(null, "Error!");
          
        }
         
    }  
        
           
         
        else if(evt.getActionCommand().equals("reg")){
        fregister();
        
        }
        else if (evt.getActionCommand().equals("submit"))  
         {  
              
            String sname = txtrname.getText();  
            String smail = txtremail.getText();  
            char[] s3 = txtrpass1.getPassword();  
            char[] s4 = p2.getPassword();   
            String spass = new String(s3);  
            String s9 = new String(s4);  
            String scountry = txtrcountry.getText();  
            String state = txtrstate.getText();  
            String sphone = txtrphone.getText();  
            if (spass.equals(s9))  
            {  
                try  
                {  
                     st.close();
                     con.close();
                    Class.forName("com.mysql.cj.jdbc.Driver");  
                    String database="jdbc:mysql://localhost:3306/clubs";
                    con=DriverManager.getConnection(database,"root","Rideordie2");  
                    String newRow="insert into register (name,email,createpass,country,county_state,phoneno) values(?,?,?,?,?,?)";
                    PreparedStatement p = con.prepareStatement(newRow);  
                    p.setString(1, sname);  
                    p.setString(2, smail);  
                    p.setString(3, spass);  
                    p.setString(4, scountry);  
                    p.setString(5, state);  
                    p.setString(6, sphone);  
                    int updateRows = p.executeUpdate();  
                    
                    if (updateRows > 0)   
                    {  
                        JOptionPane.showMessageDialog(null,"Data Saved Successfully.Welcome to the club!Our next meeting is this wednesday at the auditorium.Please join us");  
                    }  
                    
                    else  
            {  
                JOptionPane.showMessageDialog(null, "Password Does Not Match"); 
                    st.close();
                    con.close();
              
            }  
                }  
                catch (Exception ex)   
                {  
                    System.out.println(ex);  
                }  
            }  
             
          } 
         
         
         else if (evt.getActionCommand().equals("clear")){
            txtrname.setText(null);  
            txtremail.setText(null);  
            txtrpass1.setText(null);  
            p2.setText(null);  
            txtrcountry.setText(null);  
            txtrstate.setText(null);  
            txtrphone.setText(null); 
         
         }
         
        else if(feeling.getSelectedIndex()==0){
            
        anx();
        
        }
        
        else if(feeling.getSelectedIndex()==1){
        fatigue();
        
        }
         
          else if(feeling.getSelectedIndex()==2){
         firritable();
        
        }
         
         else if(feeling.getSelectedIndex()==3){
         fdiet();
        
        }
        
         //Action event for get next member from database
         
       
        //Action event for all other buttons
        
        switch(evt.getActionCommand())
        {
            case "next":
                frame1.setVisible(false);
                frame2();
                break;
                
             case "prev":
                frame2.setVisible(false);
                frame();
                break;
                
             case "close":
                System.exit(0);
                break;
       
                
        }
        
        
        
        
        
    
    }
    public static void main(String[] args) {
     //Calling the introduction frame 
     ClubGUI x=new ClubGUI();
     x.frame();
      
      
    }
    
}
