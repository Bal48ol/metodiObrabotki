import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class NegativeImage {
    public static void negativeImage() throws IOException {

        // Загрузка изображения
        File file = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\img.jpg");
        BufferedImage image = ImageIO.read(file);

        // Получение ширины и высоты изображения
        int width = image.getWidth();
        int height = image.getHeight();

        // Проход по каждому пикселю изображения
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){

                // Получение текущего значения пикселя
                int pixel = image.getRGB(x, y);

                // Извлечение компонент RGB
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;

                // Вычисление инвертированного значения пикселя для негатива
                int invertedPixel = (alpha << 24) | ((255 - red) << 16) | ((255 - green) << 8) | (255 - blue);

                // Запись инвертированного значения пикселя в изображение для негатива
                image.setRGB(x, y, invertedPixel);


                // Пороговое значение
                int threshold = 128;

                // Вычисление инвертированного значения пикселя для негатива с порогом
                int invertedPixelThreshold;
                if ((red + green + blue) / 3 > threshold) {
                    invertedPixelThreshold = invertedPixel;
                } else {
                    int invertedRed = 255 - red;
                    int invertedGreen = 255 - green;
                    int invertedBlue = 255 - blue;
                    invertedPixelThreshold = (alpha << 24) | (invertedRed << 16) | (invertedGreen << 8) | invertedBlue;
                }

                // Запись инвертированного значения пикселя в изображение для негатива с порогом
                image.setRGB(x, y, invertedPixelThreshold);
            }
        }

        // Сохранение полученных изображений
        File outputNegative = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\negative_image.jpg");
        ImageIO.write(image, "jpg", outputNegative);

        File outputNegativeThreshold = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\negative_threshold_image.jpg");
        ImageIO.write(image, "jpg", outputNegativeThreshold);
    }
}
