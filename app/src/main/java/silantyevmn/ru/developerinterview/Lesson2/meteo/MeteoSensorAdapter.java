package silantyevmn.ru.developerinterview.Lesson2.meteo;

import java.time.LocalDateTime;

/**
 * Created by silan on 25.11.2018.
 */

public class MeteoSensorAdapter implements MeteoSensor {

    private SensorTemperature sensorTemperature;

    public MeteoSensorAdapter(SensorTemperature sensorTemperature) {
        this.sensorTemperature = sensorTemperature;
    }

    @Override
    public int getId() {
        return sensorTemperature.identifier()+100;
    }

    @Override
    public Float getTemperature() {
        return (float) sensorTemperature.temperature();
    }

    @Override
    public Float getHumidity() {
        return null;
    }

    @Override
    public Float getPressure() {
        return null;
    }

    @Override
    public LocalDateTime getDateTime() {
        return LocalDateTime.of(sensorTemperature.year(), 1, 1, 0, 0, 0)
                .plusDays(sensorTemperature.day()-1)
                .plusSeconds(sensorTemperature.second());
    }
}
