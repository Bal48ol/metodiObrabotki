import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RotationImage {
    public static void rotationImage() throws IOException {
        // Загрузка исходного изображения
        File input = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\img.jpg");
        BufferedImage image = ImageIO.read(input);

        // Угол поворота в градусах
        double angle = 180;

        // Рассчитываем размеры нового изображения после поворота
        int width = image.getWidth();
        int height = image.getHeight();
        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads));
        double cos = Math.abs(Math.cos(rads));
        int newWidth = (int) Math.floor(width * cos + height * sin);
        int newHeight = (int) Math.floor(height * cos + width * sin);

        // Создаем новое изображение с прозрачным фоном
        BufferedImage rotatedImage = new BufferedImage(newWidth, newHeight, image.getType());
        Graphics2D g2d = rotatedImage.createGraphics();
        g2d.dispose();
        g2d = rotatedImage.createGraphics();

        // Настраиваем параметры рендеринга для сглаживания краев при повороте
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Вычисляем координаты центра изображения
        int centerX = newWidth / 2;
        int centerY = newHeight / 2;

        // Создаем объект AffineTransform для поворота изображения
        AffineTransform transform = new AffineTransform();
        transform.translate(centerX, centerY);
        transform.rotate(rads);
        transform.translate(-width / 2, -height / 2);

        // Выполняем поворот изображения с использованием AffineTransform
        g2d.drawImage(image, transform, null);
        g2d.dispose();

        // Сохраняем полученное изображение в файл
        File output = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\RotationImage.jpg");
        ImageIO.write(rotatedImage, "jpg", output);
    }
}
