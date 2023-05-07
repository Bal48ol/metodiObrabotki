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

        // Создание объектов для двух новых изображений
        BufferedImage negativeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

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
                negativeImage.setRGB(x, y, invertedPixel);
            }
        }

        // Сохранение полученных изображений
        File outputNegative = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\negative_image.jpg");
        ImageIO.write(negativeImage, "jpg", outputNegative);
    }
}
