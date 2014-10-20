/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author gorbinphilip
 */
public class loginframe extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JButton b1,b2;
    JTextField t1;
    JPasswordField p1;
    String usr,psd;
    loginframe()
    {
        Container c=getContentPane();
        c.setLayout(null);
        Color co1=new Color(252,251,251);
        Color co2=new Color(153,153,153);
        Color co3=new Color(0,0,0);
        Font fo1=new Font("Curlz MT",Font.BOLD,35);
        Font fo2=new Font("Tahoma",Font.BOLD,14);
        Font fo3=new Font("Tahoma",Font.PLAIN,12);
        
        l1=new JLabel("LOGIN");
        l1.setFont(fo1);
        c.add(l1);
        l1.setBounds(130,30,200,30);
        l1.setForeground(co1);
        
        l2=new JLabel("Username");
        c.add(l2);
        l2.setBounds(130,100,100,30);
        l2.setForeground(co1);
        l2.setFont(fo2);
        
        l3=new JLabel("Password");
        c.add(l3);
        l3.setBounds(130,150,100,30);
        l3.setForeground(co1);
        l3.setFont(fo2);
        
        t1=new JTextField();
        t1.setBounds(250,100,120,25);
        c.add(t1);
        t1.setBackground(co2);
        t1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        t1.setForeground(co3);
        t1.setFont(fo3);
        
        p1=new JPasswordField();
        p1.setBounds(250,150,120,25);
        c.add(p1);
        p1.setBackground(co2);
        p1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        b1=new JButton("Login");
        b1.setBounds(140,220,70,30);
        b1.addActionListener(this);
        c.add(b1);
        
        b2=new JButton("Exit");
        b2.setBounds(270,220,70,30);
        b2.addActionListener(this);
        c.add(b2);
        
        l4=new JLabel("");
        c.add(l4);
        l4.setBounds(0, 0, 464, 409);
        l4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginpackage/locked2_1.jpg")));      
        
    }
    @Override
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource()==b1)
        {
            usr=t1.getText();
            psd=p1.getText();
            if((usr.equals("admin"))&&(psd.equals("admin")))
            {
                JOptionPane.showMessageDialog((Component)null,"Access Granted","Authentication",JOptionPane.OK_CANCEL_OPTION);
            }
            else
            {
                    JOptionPane.showMessageDialog((Component)null,"Enter a valid Username and Password","Login Error",JOptionPane.OK_CANCEL_OPTION);
            }
        }
        if(event.getSource()==b2)
        {
            System.exit(0);
        }
    }
    public static void main(String args[])
    {
        loginframe lf=new loginframe();
        lf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lf.setSize(470,435);
        lf.setTitle("Login Please...");
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension f=lf.getSize();
        lf.setLocation((d.width-f.width)/2,(d.height-f.height)/2);
        lf.setVisible(true);
        lf.setResizable(false);
    }
}