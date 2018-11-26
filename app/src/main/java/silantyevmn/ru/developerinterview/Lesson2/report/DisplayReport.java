package silantyevmn.ru.developerinterview.Lesson2.report;

import java.util.List;

/**
 * Created by silan on 25.11.2018.
 */

public class DisplayReport implements OutputReport{

    @Override
    public void output(List<ReportItem> items) {
        System.out.println("Output to display");
        for(ReportItem item : items){
            System.out.format("display %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }
}
