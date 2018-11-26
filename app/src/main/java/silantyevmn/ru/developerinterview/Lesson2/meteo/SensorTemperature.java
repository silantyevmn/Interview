package silantyevmn.ru.developerinterview.Lesson2.meteo;

/**
 * Created by silan on 25.11.2018.
 */

public interface SensorTemperature {
    int identifier(); // идентификатор датчика

    double temperature(); // температура датчика

    int year();          // Год

    int day();           // День года

    int second();        // Секунда дня
}
