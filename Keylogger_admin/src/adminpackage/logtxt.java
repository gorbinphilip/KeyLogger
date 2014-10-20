/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpackage;

import java.awt.Container;
import java.io.DataInputStream;
import java.io.FileInputStream;
import javax.swing.*;
/**
 *
 * @author gorbinphilip
 */
public class logtxt extends JFrame {
    logtxt()
    {
        Container txtcon = getContentPane();
        txtcon.setLayout(null);
        txtcon.setSize(800, 600);
        JTextArea logtxtarea=new JTextArea();
        logtxtarea.setBounds(0,0,800,600);
        JScrollPane sp=new JScrollPane();
        logtxtarea.append(gettext());
        txtcon.add(logtxtarea);
        sp.setViewportView(logtxtarea);
        txtcon.add(sp);
        sp.setBounds(0, 0, 794, 570);
        logtxtarea.setEditable(false);
    }
    String gettext() {
        String msg ="";
        try
      {
          int n;
         DataInputStream din=new DataInputStream(new FileInputStream("D:\\keylogger\\keylogs.txt"));
         while((n=din.read())!=-1)
         {
             msg+=(char)n;
         }
      }
      catch(Exception e)
          
      {
          System.out.println("Error "+e);
      }
        return msg;
    }
}
