import algorithm.CMetricsFactors;
import algorithm.CMetricsFactorsimpl;
import algorithm.UCMetricsFactors;
import algorithm.UCMetricsFactorsimpl;
import bean.CClass;
import bean.ClassDiagram;
import bean.UseCaseDiagram;
import org.apache.log4j.Logger;
import parse.ClassParser;
import parse.DiagramParser;
import parse.ParseException;
import parse.UseCaseParser;

/**
 * Created by ltaoj on 2018/05/24 14:16.
 *
 * @version : 1.0
 */
public class Main {

    public static void main(String[] args) throws ParseException {

        UseCaseParser parser = new UseCaseParser();
        DiagramParser.DataListener<UseCaseDiagram> listener = new DiagramParser.DataListener<UseCaseDiagram>() {
            public void onComplete(UseCaseDiagram data) {
                Logger.getLogger(Main.class).info("解析完成 -> " + data.toString());
                Logger.getLogger(Main.class).info("开始计算用例图度量因子");
                UCMetricsFactors ucMetricsFactors = new UCMetricsFactorsimpl(data);
                Logger.getLogger(Main.class).info("UC1 -> " + ucMetricsFactors.getUC1());
                Logger.getLogger(Main.class).info("UC2 -> " + ucMetricsFactors.getUC2());
                Logger.getLogger(Main.class).info("UC3 -> " + ucMetricsFactors.getUC3());
                Logger.getLogger(Main.class).info("UC4 -> " + ucMetricsFactors.getUC4());
                Logger.getLogger(Main.class).info("NA -> " + ucMetricsFactors.getNA());
                Logger.getLogger(Main.class).info("NOD -> " + ucMetricsFactors.getNOD());
                Logger.getLogger(Main.class).info("用例图度量因子计算完成");
            }
        };
        parser.parse(parser.METRICS2_OOM, listener);


        ClassParser classParser = new ClassParser();
        DiagramParser.DataListener<ClassDiagram> listener1 = new DiagramParser.DataListener<ClassDiagram>() {
            public void onComplete(ClassDiagram data) {
                Logger.getLogger(Main.class).info("类图解析完成 -> " + data.toString());
                Logger.getLogger(Main.class).info("开始计算类图度量因子");
                CMetricsFactors cMetricsFactors = new CMetricsFactorsimpl(data);
                Logger.getLogger(Main.class).info("DIT -> ");
                cMetricsFactors.getDIT();
                Logger.getLogger(Main.class).info("NIM -> ");
                cMetricsFactors.getNIM();
                Logger.getLogger(Main.class).info("APPM -> ");
                cMetricsFactors.getAPPM();
                Logger.getLogger(Main.class).info("NMO -> ");
                cMetricsFactors.getNMO();
                Logger.getLogger(Main.class).info("NMA -> ");
                cMetricsFactors.getNMA();
                Logger.getLogger(Main.class).info("NOC -> ");
                cMetricsFactors.getNOC();
                Logger.getLogger(Main.class).info("CBO -> ");
                cMetricsFactors.getCBO();
                Logger.getLogger(Main.class).info("NCM -> ");
                for(int i=0;i<cMetricsFactors.classs().size();i++){
                    CClass cClass = cMetricsFactors.classs().get(i);
                    System.out.println(cClass.getName()+":"+cMetricsFactors.getNCM().get(cClass).size());
                }
                Logger.getLogger(Main.class).info("PIM -> ");
                cMetricsFactors.getPIM();
                Logger.getLogger(Main.class).info("NCV -> ");
                cMetricsFactors.getNCV();
            }
        };

        classParser.parse(parser.METRICS5_OOM, listener1);
    }
}
