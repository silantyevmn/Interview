package silantyevmn.ru.developerinterview.Lesson2.report;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silan on 25.11.2018.
 */

public class Report {
    private List<ReportItem> items; // Отчетные данные
    private OutputReport outputReport;

    public Report(OutputReport outputReport) {
        this.outputReport = outputReport;
    }

    // расчет отчетных данных
    public void calculate() {
        items = new ArrayList<ReportItem>();
        items.add(new ReportItem("First", (float) 5));
        items.add(new ReportItem("Second", (float) 6));
    }

    public void output() {
        outputReport.output(items);
    }

    public void setOutputReport(OutputReport outputReport) {
        this.outputReport = outputReport;
    }
}
