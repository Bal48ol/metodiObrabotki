import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OperatorTisnenia {

    public static void operatorTisnenia() {
        try {
            // Загружаем изображение
            BufferedImage image = ImageIO.read(new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\img.jpg"));

            // Создаем пустое изображение с такими же размерами как и оригинальное
            BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

            // Проходимся по каждому пикселю и применяем оператор тиснения
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                    Color color = new Color(pixel);

                    // Вычисляем яркость пикселя
                    int brightness = (int) (0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue());

                    // Устанавливаем новый цвет пикселя
                    if (brightness < 128) {
                        result.setRGB(x, y, Color.BLACK.getRGB());
                    } else {
                        result.setRGB(x, y, Color.WHITE.getRGB());
                    }
                }
            }

            // Сохраняем результат
            ImageIO.write(result, "png", new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\OperatorTisnenia.jpg"));
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
