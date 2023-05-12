import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class MetodSdvigRaznost {
    public static void metodSdvigRaznost() {
        try {
            // Загрузка изображения
            BufferedImage inputImage = ImageIO.read(new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\img.jpg"));

            // Получение ширины и высоты изображения
            int width = inputImage.getWidth();
            int height = inputImage.getHeight();

            // Создание нового изображения для вывода результата обработки
            BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // Метод сдвига и разности (простой метод усиления края)
            for (int y = 0; y < height - 1; y++) {
                for (int x = 0; x < width - 1; x++) {
                    // Получение значений цвета для текущего пикселя и его соседей
                    int colorTopLeft = inputImage.getRGB(x, y);
                    int colorTopRight = inputImage.getRGB(x + 1, y);
                    int colorBottomLeft = inputImage.getRGB(x, y + 1);
                    int colorBottomRight = inputImage.getRGB(x + 1, y + 1);

                    // Расчет разности цветов для горизонтальной и вертикальной линий
                    int diffHorizontal = Math.abs(colorTopLeft - colorTopRight);
                    int diffVertical = Math.abs(colorTopLeft - colorBottomLeft);

                    // Выбор наибольшей разности цветов как нового значения для текущего пикселя
                    int maxDiff = Math.max(diffHorizontal, diffVertical);

                    // Установка нового значения цвета для текущего пикселя в выходное изображение
                    outputImage.setRGB(x, y, maxDiff);
                }
            }

            // Сохранение результата обработки в файл
            ImageIO.write(outputImage, "png", new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\MetodSdvigRaznost.jpg"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
