import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask; 
import javax.imageio.ImageIO;
/**
 *
 * @author 999
 */
class MyTask extends TimerTask
{
    @Override
    public void run() 
    {
      try
      {
            System.out.println("Caught U!!...");
            Robot robot = new Robot();
            Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
            int width = (int) d.getWidth();
            int height = (int) d.getHeight();

            Image image = robot.createScreenCapture(new Rectangle(0, 0, width,
            height));

            BufferedImage bi = new BufferedImage(width, height,
            BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.createGraphics();
            g.drawImage(image, 0, 0, width, height, null);

            String fileNameToSaveTo = "C:/temp/screenCapture_"+ createTimeStampStr() + ".PNG";
            writeImage(bi, fileNameToSaveTo, "PNG");

            System.out.println("Screen Captured Successfully and Saved to:\n"+fileNameToSaveTo);
      }
      catch(Exception er)
      {
        System.out.println("Error: "+er);
      }
    }
     public static void writeImage(BufferedImage img, String fileLocation,
            String extension) {
        try {
            BufferedImage bi = img;
            File outputfile = new File(fileLocation);
            ImageIO.write(bi, extension, outputfile);
        } catch (IOException e) {
            System.out.println("Error at write image: "+e);
        }
    }
  
  public static String createTimeStampStr() throws Exception
  {
        Calendar mycalendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String timeStamp = formatter.format(mycalendar.getTime());
        System.out.println("timestamp=="+timeStamp);
        return timeStamp;
 
    }
}
