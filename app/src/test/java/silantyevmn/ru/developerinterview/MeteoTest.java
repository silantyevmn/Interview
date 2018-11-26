package silantyevmn.ru.developerinterview;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;

import silantyevmn.ru.developerinterview.Lesson2.meteo.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MeteoTest {

    @Test
    public void MS200_UnitTest() throws Exception {
        MeteoSensor ms200 = new MS200(1);
        assertThat(ms200.getId(), is(1));
        assertThat(ms200.getHumidity(), is(60f));
        assertThat(ms200.getPressure(), is(752.4f));
        assertThat(ms200.getTemperature(), is(20f));
        assertNotNull(ms200.getDateTime());
    }

    @Test
    public void ST500Info_UnitTest() throws Exception {
        SensorTemperature sensor = new ST500Info().getData();
        assertThat(sensor.identifier(), is(1));
        assertNotNull(sensor.temperature());
        assertThat(sensor.year(), is(LocalDateTime.now().getYear()));
        assertThat(sensor.day(), is(LocalDateTime.now().getDayOfYear()));
        assertNotNull(sensor.second());
    }

    @Test
    public void MeteoStore_UnitTest() throws Exception {
        MeteoSensor sensor = mock(MeteoSensor.class);
        MeteoStore store = new MeteoStore();
        assertTrue(store.save(sensor));
    }

    @Test
    public void MeteoSensorAdapter_UnitTest() throws Exception {
        SensorTemperature sensorTemperature = mock(SensorTemperature.class);
        MeteoSensor meteoSensor = new MeteoSensorAdapter(sensorTemperature);
        assertThat(meteoSensor.getId(), is(100));
        assertThat(meteoSensor.getTemperature(), is(0f));
        assertNull(meteoSensor.getHumidity());
        assertNull(meteoSensor.getPressure());
        assertNotNull(meteoSensor.getDateTime());
    }

    @Test
    public void MeteoStation_UnitTest() throws Exception {
        MeteoStation meteoStation = new MeteoStation();
        meteoStation.main(null);
    }
}
