package silantyevmn.ru.developerinterview.Lesson2.report;

import java.util.List;

/**
 * Created by silan on 25.11.2018.
 */

public class PrintReport implements OutputReport {

    public void output(List<ReportItem> items) {
        System.out.println("Output to printer");
        for (ReportItem item : items) {
            System.out.format("printer %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }
}
