package silantyevmn.ru.developerinterview.Lesson2.meteo;

/**
 * Created by silan on 25.11.2018.
 */

public class MeteoStation{
    public static void main(String[] args){
        MeteoStore meteoDb = new MeteoStore();

        MeteoSensor ms200_1 = new MS200(1);
        meteoDb.save(ms200_1);

        // Здесь надо вызвать метод getData у класса ST500Info. Полученные данные отправить в метод save объекта meteoDb
        MeteoSensor st500_2=new MeteoSensorAdapter(new ST500Info().getData());
        meteoDb.save(st500_2);
    }
}
