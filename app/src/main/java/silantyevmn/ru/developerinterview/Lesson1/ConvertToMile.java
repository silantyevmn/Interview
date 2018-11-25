package silantyevmn.ru.developerinterview.Lesson1;

/**
 * Created by silan on 23.11.2018.
 */

public class ConvertToMile implements ConvertTo {
    @Override
    public float Do(float sourceValue) {
        return (float)(sourceValue * 0.62137);
    }
}
