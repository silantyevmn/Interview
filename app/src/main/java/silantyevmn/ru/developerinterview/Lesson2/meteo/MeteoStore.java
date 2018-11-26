package silantyevmn.ru.developerinterview.Lesson2.meteo;

/**
 * Created by silan on 25.11.2018.
 */

public class MeteoStore { // сохранение данных в базу
    public boolean save(MeteoSensor meteoSensor) {
        System.out.format("Saving data from sensor [%d] at %s%n temperature - %f ; humidity - %f ; pressure - %f \n\r", meteoSensor.getId(), meteoSensor.getDateTime(), meteoSensor.getTemperature(), meteoSensor.getHumidity(), meteoSensor.getPressure());
        return true;
    }
}
