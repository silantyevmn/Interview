package silantyevmn.ru.developerinterview;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import silantyevmn.ru.developerinterview.Lesson1.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ConverterTest {
    private static float sourceValue = 5;


    @Test
    public void Converter_Convert_UnitTest() throws Exception {
        // Создаем mock-объект по интерфейсу ConvertTo
        ConvertTo convertTo = mock(ConvertTo.class);
        Converter converter = new Converter(sourceValue);
        // Подставляем mock-объект в качестве реализации в метод конвертера
        converter.Convert(convertTo);
        // Нам интересно то, что метод Do интерфейса ConvertTo был вызван
        verify(convertTo).Do(sourceValue);
    }

    @Test
    public void Converter_GetResult_UnitTest() throws Exception {
        Converter converter = new Converter(sourceValue);
        float actual = converter.getResult(); // Получим результат
        // assertThat использует матчеры (is – это матчер)
        assertThat(actual, is(0f)); // Тип float по умолчанию имеет значение 0
    }

    @Test
    public void ConvertToCelsius_Do_UnitTest() throws Exception {
        ConvertTo convertTo = new ConvertToCelsius();
        float actual = convertTo.Do(sourceValue);
        assertThat(actual, is(-15f));
    }

    @Test
    public void ConvertToFahrenheit_Do_UnitTest() throws Exception {
        ConvertTo convertTo = new ConvertToFahrenheit();
        float actual = convertTo.Do(sourceValue);
        assertThat(actual, is(41f));
    }

    @Test
    public void ConvertToMile_Do_UnitTest() throws Exception {
        ConvertTo convertTo = new ConvertToMile();
        float actual = convertTo.Do(sourceValue);
        assertThat(actual, is(3.10685f));
    }

    @Test
    public void ConvertToKilometrs_Do_UnitTest() throws Exception {
        ConvertTo convertTo = new ConvertToKilometers();
        float actual = convertTo.Do(sourceValue);
        assertThat(actual, is(8f));
    }

    // Интеграционнай тест. Проверяем взаимодействие объекта Converter и ConvertToFahrenheit
    @Test
    public void Converter_IntegrationTest() throws Exception {
        Converter converter = new Converter(sourceValue);
        // Вместо mock-объекта используем реальный
        float actual = converter.Convert(new ConvertToFahrenheit()).getResult();
        assertThat(actual, is(41f));
    }

}
