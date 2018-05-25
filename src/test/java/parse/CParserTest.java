package parse;

import bean.ClassDiagram;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by ltaoj on 2018/05/25 14:32.
 *
 * @version : 1.0
 */
public class CParserTest {

    @Test
    public void parse1() throws ParseException {
        ClassParser classParser = new ClassParser();
        DiagramParser.DataListener<ClassDiagram> listener1 = new DiagramParser.DataListener<ClassDiagram>() {
            public void onComplete(ClassDiagram data) {
                Logger.getLogger(CParserTest.class).info("类图解析完成 -> " + data.toString());
            }
        };

        classParser.parse(classParser.METRICS5_OOM, listener1);
    }

    @Test
    public void parse2() throws ParseException {
        ClassParser classParser = new ClassParser();
        DiagramParser.DataListener<ClassDiagram> listener1 = new DiagramParser.DataListener<ClassDiagram>() {
            public void onComplete(ClassDiagram data) {
                Logger.getLogger(CParserTest.class).info("类图解析完成 -> " + data.toString());
            }
        };

        classParser.parse(classParser.METRICS6_OOM, listener1);
    }
}
