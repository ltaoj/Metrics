package parse;

import bean.ClassDiagram;
import org.apache.log4j.Logger;

/**
 * Created by ltaoj on 2018/05/23 17:36.
 *
 * @version : 1.0
 */
public class ClassParser extends DiagramParser<ClassDiagram> {

    Logger logger = Logger.getLogger(ClassParser.class);

    public void parse(String file, DataListener<ClassDiagram> listener) {

    }
}
