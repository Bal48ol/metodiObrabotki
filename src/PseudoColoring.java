import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PseudoColoring {
    public static void pseudoColoring() throws IOException {
        BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\img.jpg"));
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Loop through each pixel in the image
        for(int x=0; x<width; x++) {
            for(int y=0; y<height; y++) {
                Color color = new Color(originalImage.getRGB(x, y));

                // Convert the RGB color to grayscale
                int grayValue = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                // Map the grayscale value to a color
                if(grayValue < 85) {
                    newImage.setRGB(x, y, Color.BLUE.getRGB());
                } else if(grayValue < 170) {
                    newImage.setRGB(x, y, Color.GREEN.getRGB());
                } else {
                    newImage.setRGB(x, y, Color.RED.getRGB());
                }
            }
        }

        ImageIO.write(newImage, "jpg", new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\PseudoColoring.jpg"));
    }
}
