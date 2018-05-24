import bean.Diagram;
import bean.UseCaseDiagram;
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
                System.out.println("解析完成 -> " + data.toString());
            }
        };
        parser.parse(parser.METRICS2_OOM, listener);
    }
}
