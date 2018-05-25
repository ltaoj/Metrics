package parse;

import algorithm.UCMetricsFactors;
import algorithm.UCMetricsFactorsimpl;
import bean.UseCaseDiagram;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by ltaoj on 2018/05/25 14:30.
 *
 * @version : 1.0
 */
public class UCParserTest {

    @Test
    public void parse1() throws ParseException {
        UseCaseParser parser = new UseCaseParser();
        DiagramParser.DataListener<UseCaseDiagram> listener = new DiagramParser.DataListener<UseCaseDiagram>() {
            public void onComplete(UseCaseDiagram data) {
                Logger.getLogger(UCParserTest.class).info("解析完成 -> " + data.toString());
                Logger.getLogger(UCParserTest.class).info("开始计算用例图度量因子");
                UCMetricsFactors ucMetricsFactors = new UCMetricsFactorsimpl(data);
                Logger.getLogger(UCParserTest.class).info("UC1 -> " + ucMetricsFactors.getUC1());
                Logger.getLogger(UCParserTest.class).info("UC2 -> " + ucMetricsFactors.getUC2());
                Logger.getLogger(UCParserTest.class).info("UC3 -> " + ucMetricsFactors.getUC3());
                Logger.getLogger(UCParserTest.class).info("UC4 -> " + ucMetricsFactors.getUC4());
                Logger.getLogger(UCParserTest.class).info("NA -> " + ucMetricsFactors.getNA());
                Logger.getLogger(UCParserTest.class).info("NOD -> " + ucMetricsFactors.getNOD());
                Logger.getLogger(UCParserTest.class).info("用例图度量因子计算完成");
            }
        };
        parser.parse(parser.METRICS2_OOM, listener);
    }

    @Test
    public void parse2() throws ParseException {
        UseCaseParser parser = new UseCaseParser();
        DiagramParser.DataListener<UseCaseDiagram> listener = new DiagramParser.DataListener<UseCaseDiagram>() {
            public void onComplete(UseCaseDiagram data) {
                Logger.getLogger(UCParserTest.class).info("解析完成 -> " + data.toString());
                Logger.getLogger(UCParserTest.class).info("开始计算用例图度量因子");
                UCMetricsFactors ucMetricsFactors = new UCMetricsFactorsimpl(data);
                Logger.getLogger(UCParserTest.class).info("UC1 -> " + ucMetricsFactors.getUC1());
                Logger.getLogger(UCParserTest.class).info("UC2 -> " + ucMetricsFactors.getUC2());
                Logger.getLogger(UCParserTest.class).info("UC3 -> " + ucMetricsFactors.getUC3());
                Logger.getLogger(UCParserTest.class).info("UC4 -> " + ucMetricsFactors.getUC4());
                Logger.getLogger(UCParserTest.class).info("NA -> " + ucMetricsFactors.getNA());
                Logger.getLogger(UCParserTest.class).info("NOD -> " + ucMetricsFactors.getNOD());
                Logger.getLogger(UCParserTest.class).info("用例图度量因子计算完成");
            }
        };
        parser.parse(parser.METRICS3_OOM, listener);
    }
}
