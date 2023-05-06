import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        /* Черно-белое изображение из цветного. используется формула, которая переводит цветное изображение в черно-белое, используя требуемые коэффициенты для каждого цветового канала.
        Эти коэффициенты были получены экспериментально и дают наилучший результат при конвертации в черно-белое. */
        ConvertToGrayscale.convertToGrayscale();

        /* Гистограмма яркости. Для создания гистограммы программа проходит по всем пикселям изображения и подсчитывает количество пикселей с каждой возможной яркостью.
        Затем она рисует прямоугольники на новом изображении (размером 256x256), соответствующие значениям яркости из гистограммы. */
        BrightnessHistogram.brightnessHistogram();

        /* Негатив. В этом коде мы загружаем изображение из файла "input_image.jpg" и проходим по каждому пикселю.
        Для каждого пикселя мы вычисляем инвертированное значение для негатива и инвертированное значение с порогом яркости.
        Для негатива мы просто инвертируем значения компонент RGB. Для негатива с порогом мы определяем пороговое значение яркости и, если яркость пикселя больше этого порога,
        то оставляем его без изменений. В противном случае мы инвертируем значения компонент RGB для получения негатива с порогом.
        Затем мы записываем полученные изображения в файлы "negative_image.jpg" и "negative_threshold_image.jpg". */
        NegativeImage.negativeImage();

        /* Пороговое преобразование. проходим по каждому пикселю. Для каждого пикселя мы вычисляем значение яркости путем среднего арифметического значений компонент RGB.
        Затем мы сравниваем значение яркости с пороговым значением. Если оно больше порога, то устанавливаем значения компонент RGB равными 255 (белый цвет),
        иначе - равными 0 (черный цвет). Затем мы создаем новое значение пикселя на основе измененных значений компонент RGB и записываем его в изображение.
        Наконец, мы сохраняем полученное преобразованное изображение в файл. */
        PorogPreobraz.porogPreobraz();

        /* Повышение и понижение контраста. Здесь мы просто добавили метод adjustContrast в класс и вызываем его дважды с разными значениями коэффициента контрастности для увеличения и
        уменьшения контрастности изображения соответственно. */
        ImageContrast.imageContrast();

        /* Гамма-преобразование. Здесь мы определяем метод adjustGamma, который принимает изображение и коэффициент гаммы.
        Затем мы проходим по каждому пикселю на изображении, получаем цвет в формате RGB и изменяем яркость каждого канала отдельно,
        используя формулу Math.pow(color / 255.0f, gamma) * 255.0f. Наконец, мы создаем новый цвет с измененными значениями каналов и
        устанавливаем его для соответствующего пикселя на изображении. В main методе мы вызываем метод adjustGamma дважды с разными значениями коэффициента гаммы для
        преобразования изображения. */
        ImageGamma.imageGamma();

        /* Квантизация изображений (уменьшение цветов изображения). Здесь мы загружаем изображение из файла "img.jpg" и задаем количество бит на каждый цветовой канал (в данном случае 3).
        Затем мы вычисляем размер шага квантования на основе количества бит. Затем мы проходим через каждый пиксель в изображении, квантуем его цвет и
        устанавливаем новое значение цвета для этого пикселя в изображении. Наконец, мы сохраняем измененное изображение в файл "imageQuantization.jpg". */
        ImageQuantization.imageQuantization();

        /* Псевдораскрашивание изображения. Этот код читает изображение в формате JPEG и создает новое изображение, в котором каждый пиксел заменяется цветом на основе его яркости.
        Сначала каждый пиксель конвертируется в оттенки серого, затем значение яркости преобразуется в цвет. В этом примере мы используем синий, зеленый и красный цвета для
        представления темных, средних и светлых областей изображения соответственно. */
        PseudoColoring.pseudoColoring();

        /*Соляризация изображения. Этот код реализует алгоритм соляризации изображения. Алгоритм проходит через каждый пиксель входного изображения, применяет к нему соляризацию и
        устанавливает новый цвет пикселя в выходном изображении.*/
        SolarizeImage.solarizeImage();
    }
}