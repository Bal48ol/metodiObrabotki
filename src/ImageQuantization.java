import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageQuantization {

    public static void imageQuantization() throws IOException {

        // Загрузить файл изображения
        BufferedImage img = ImageIO.read(new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\img.jpg"));

        // Установить количество бит на каждый цветовой канал (например, 4 бита)
        int numBits = 3;

        // Вычислить размер шага квантования на основе количества бит
        int stepSize = 255 / ((int) Math.pow(2, numBits) - 1);

        // Пройти через каждый пиксель в изображении
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {

                // Получить цвет пикселя
                Color color = new Color(img.getRGB(x, y));

                // Квантовать цвет, уменьшив значение цветовых каналов до ближайшего кратного размера шага
                int r = (color.getRed() / stepSize) * stepSize;
                int g = (color.getGreen() / stepSize) * stepSize;
                int b = (color.getBlue() / stepSize) * stepSize;

                // Создать новый объект Color с квантованными значениями цвета
                Color quantizedColor = new Color(r, g, b);

                // Установить новый цвет пикселя в изображении
                img.setRGB(x, y, quantizedColor.getRGB());
            }
        }

        // Сохранить квантованное изображение в файл
        ImageIO.write(img, "jpg", new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\imageQuantization.jpg"));
    }
}
