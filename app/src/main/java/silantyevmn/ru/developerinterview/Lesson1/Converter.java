package silantyevmn.ru.developerinterview.Lesson1;

/**
 * Created by silan on 23.11.2018.
 */

public class Converter {
    private float sourceValue; // Значение, которое надо сконвертировать
    private float destValue; // Сконвертированное значение

    public Converter(float sourceValue) {
        this.sourceValue = sourceValue;
    }

    public Converter Convert(ConvertTo convertTo) {
        this.destValue = convertTo.Do(sourceValue);
        return this;
    }

    public float getResult() {
        return destValue;
    }

}
