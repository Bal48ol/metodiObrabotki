import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageGamma {

    public static void imageGamma() {
        try {
            // Загружаем изображение
            File input = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\img.jpg");
            BufferedImage image = ImageIO.read(input);

            // Преобразуем изображение с гаммой 0.5
            adjustGamma(image, 0.5f);

            // Сохраняем измененный файл изображения
            File output = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\img_gamma_01.jpg");
            ImageIO.write(image, "jpg", output);

            // Преобразуем изображение с гаммой 10.0
            adjustGamma(image, 10.0f);

            // Сохраняем измененный файл изображения
            output = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\img_gamma_10.jpg");
            ImageIO.write(image, "jpg", output);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void adjustGamma(BufferedImage image, float gamma) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Изменяем яркость пикселей
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(image.getRGB(x, y));
                float red = (float) Math.pow(color.getRed() / 255.0f, gamma) * 255.0f;
                float green = (float) Math.pow(color.getGreen() / 255.0f, gamma) * 255.0f;
                float blue = (float) Math.pow(color.getBlue() / 255.0f, gamma) * 255.0f;
                int newRed = (int) Math.max(0, Math.min(255, red));
                int newGreen = (int) Math.max(0, Math.min(255, green));
                int newBlue = (int) Math.max(0, Math.min(255, blue));
                Color newColor = new Color(newRed, newGreen, newBlue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
    }
}
