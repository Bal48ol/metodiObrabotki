import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class MedianFilter {
    public static void medianFilter() throws IOException {
        // чтение изображения из файла
        BufferedImage image = ImageIO.read(new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\img.jpg"));

        // применение медианного фильтра
        int size = 3; // размер окна
        int offset = size / 2; // смещение от края изображения
        for (int x = offset; x < image.getWidth() - offset; x++) {
            for (int y = offset; y < image.getHeight() - offset; y++) {
                int[] values = new int[size * size];
                int counter = 0;
                for (int i = x - offset; i <= x + offset; i++) {
                    for (int j = y - offset; j <= y + offset; j++) {
                        values[counter] = image.getRGB(i, j);
                        counter++;
                    }
                }
                int median = getMedian(values);
                image.setRGB(x, y, median);
            }
        }

        // сохранение измененного изображения
        File output = new File("C:\\Users\\dayof\\IdeaProjects\\metodiObrabotki\\img\\MedianFilter.jpg");
        ImageIO.write(image, "jpg", output);
    }

    // получение медианы из массива значений
    private static int getMedian(int[] values) {
        int length = values.length;
        int[] sortedValues = new int[length];
        System.arraycopy(values, 0, sortedValues, 0, length);
        Arrays.sort(sortedValues);
        int medianIndex = length / 2;
        return sortedValues[medianIndex];
    }
}
