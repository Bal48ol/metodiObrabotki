import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ScaleImage {
    public static void scaleImage() throws IOException {
        // Масштабирование без интерполяции
        scaleImageWithoutInterpolation();

        // Масштабирование с интерполяцией
        scaleImageWithInterpolation();
    }

    private static void scaleImageWithoutInterpolation() throws IOException {
        // Входное изображение
        File input = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\img.jpg");
        BufferedImage image = ImageIO.read(input);

        // Новый размер изображения
        int newWidth = 2000;
        int newHeight = 1000;

        // Масштабирование изображения без интерполяции
        BufferedImage output = new BufferedImage(newWidth, newHeight, image.getType());
        Graphics2D g2d = output.createGraphics();
        g2d.drawImage(image, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        // Сохранение нового изображения
        File outputfile = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\scaleImage_Without_Interpolation.jpg");
        ImageIO.write(output, "jpg", outputfile);
    }

    private static void scaleImageWithInterpolation() throws IOException {
        // Входное изображение
        File input = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\img.jpg");
        BufferedImage image = ImageIO.read(input);

        // Новый размер изображения
        int newWidth = 2000;
        int newHeight = 1000;

        // Масштабирование изображения с интерполяцией
        BufferedImage output = new BufferedImage(newWidth, newHeight, image.getType());
        Graphics2D g2d = output.createGraphics();

        // Настройка параметров интерполяции
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // Вычисление коэффициентов масштабирования
        double scaleX = (double) newWidth / image.getWidth();
        double scaleY = (double) newHeight / image.getHeight();

        // Применение коэффициентов масштабирования с использованием AffineTransform
        AffineTransform transform = new AffineTransform();
        transform.scale(scaleX, scaleY);

        // Нанесение трансформации на изображение
        g2d.drawImage(image, transform, null);
        g2d.dispose();

        // Сохранение нового изображения
        File outputfile = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\scaleImage_With_Interpolation.jpg");
        ImageIO.write(output, "jpg", outputfile);
    }
}
