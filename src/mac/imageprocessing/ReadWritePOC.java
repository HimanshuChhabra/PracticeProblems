package mac.imageprocessing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ReadWritePOC {

	public static void main(String[] args) throws Exception {
		File input = new File("/Users/himanshuchhabra/Desktop/imgres.png");
		BufferedImage image = ImageIO.read(input);//new BufferedImage(95,95,BufferedImage.TYPE_INT_ARGB);
		BufferedImage image1 = new BufferedImage(image.getHeight(),image.getWidth(),BufferedImage.TYPE_INT_ARGB);
		//Color clr = new Color(image.getRGB(50, 50));
		Color color1 = null;
		Color color2 = null;
		//System.out.println(color1.getRGB());
		//int rb=color1.getRGB();
		for(int i = 0 ;i<image.getHeight();i++){
			for(int j = 0;j<image.getWidth();j++){
				color2 = new Color(image.getRGB(i, j));
				//System.out.println(color2.getRed() +" "+ color2.getBlue()+" "+color2.getGreen());
				color1 = new Color(198,90,145);
				image1.setRGB(i, j, color1.getRGB());
			}
		}

		System.out.println(new Color(image1.getRGB(0, 0)).getBlue());
		
//		int rgb = image.getRGB(5, 5);
//		Color color = new Color(rgb);
//		System.out.println(color.getRed()+","+color.getGreen()+","+color.getBlue());
//		int alpha = color.getAlpha();
//		color = new Color(0,190,0,alpha);
//	
//		int setrgb = color.getRGB();
//		System.out.println(setrgb);
//		for(int i = 0 ;i<image.getHeight();i++){
//			for(int j = 0;j<image.getWidth();j++){
//				image.setRGB(i, j, setrgb);
//			}
//		}
//		
		File output = new File("/Users/himanshuchhabra/Desktop/search1.png");
		ImageIO.write(image1, "png", output);
		Color t = new Color(image1.getRGB(0, 0));
		System.out.println(image1.getHeight()+",,,"+ t.getBlue()+" "+t.getGreen()+" "+t.getRed());
	}

	public static void maxMin(int[] count)
	  {
	    int max = 0;int maxIndex = 0;
	    int min = 32768;int minIndex = 0;
	    
	    //int length = input.length();
	    for (int i = 0; i < count.length; i++)
	    {
	      if (count[i] > max)
	      {
	        max = count[i];
	        maxIndex = i;
	      }
	      if (count[i] < min)
	      {
	        min = count[i];
	        minIndex = i;
	      }
	    }
	    System.out.println(maxIndex + " and number of pixels: " + count[maxIndex]);
	    System.out.println(minIndex + " and number of pixels: " + count[minIndex]);
	  }
}
