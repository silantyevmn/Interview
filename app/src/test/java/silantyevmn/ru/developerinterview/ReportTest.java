package silantyevmn.ru.developerinterview;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import silantyevmn.ru.developerinterview.Lesson2.report.DisplayReport;
import silantyevmn.ru.developerinterview.Lesson2.report.OutputReport;
import silantyevmn.ru.developerinterview.Lesson2.report.PrintReport;
import silantyevmn.ru.developerinterview.Lesson2.report.Programm;
import silantyevmn.ru.developerinterview.Lesson2.report.Report;
import silantyevmn.ru.developerinterview.Lesson2.report.ReportItem;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReportTest {

    @Test
    public void ReportItem_UnitTest() throws Exception {
        ReportItem reportItem = new ReportItem("1", 1);
        assertThat(reportItem.getDescription(), is("1"));
        assertThat(reportItem.getAmount(), is(1f));
    }

    @Test
    public void Report_UnitTest() throws Exception {
        OutputReport outputReport = mock(OutputReport.class);
        Report report = new Report(outputReport);
        report.calculate();
        //проверим значения item
        List<ReportItem> items = report.getItems();
        assertThat(items.get(0).getDescription(), is("First"));
        assertThat(items.get(0).getAmount(), is(5f));
        assertThat(items.get(1).getDescription(), is("Second"));
        assertThat(items.get(1).getAmount(), is(6f));

        report.output();
        verify(outputReport).output(items);
    }

    @Test
    public void ReportSetOutput_UnitTest() throws Exception {
        Report report = mock(Report.class);
        report.setOutputReport(null);
        verify(report).setOutputReport(null);
    }

    @Test
    public void DisplayReport_UnitTest() throws Exception {
        Report report = new Report(new DisplayReport());
        report.calculate();
        report.output();
        assertThat(report.getItems().size(), is(2));
    }

    @Test
    public void PrintReport_UnitTest() throws Exception {
        Report report = new Report(new PrintReport());
        report.calculate();
        report.output();
        assertThat(report.getItems().size(), is(2));
    }

    @Test
    public void Programm_UnitTest() throws Exception {
        Programm programm = new Programm();
        programm.main(null);
    }
}
