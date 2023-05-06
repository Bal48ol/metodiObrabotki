import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PorogPreobraz {
    public static void porogPreobraz() throws IOException {

        // Загрузка изображения
        File file = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\img.jpg");
        BufferedImage image = ImageIO.read(file);

        // Пороговое значение
        int threshold = 128;

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

                // Применение порогового преобразования
                int gray = (red + green + blue) / 3;
                if(gray > threshold){
                    red = green = blue = 255;
                } else {
                    red = green = blue = 0;
                }

                // Создание нового значения пикселя с измененными RGB компонентами
                int newPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;

                // Запись нового значения пикселя в изображение
                image.setRGB(x, y, newPixel);
            }
        }

        // Сохранение полученного изображения
        File output = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\PorogPreobraz.jpg");
        ImageIO.write(image, "jpg", output);
    }
}
