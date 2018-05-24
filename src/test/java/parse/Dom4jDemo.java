package parse;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by ltaoj on 2018/05/23 16:05.
 *
 * @version : 1.0
 */
public class Dom4jDemo {

//    final String classpath = this.getClass().getResource("/").getPath().replaceFirst("/", "");

    final String classpath = this.getClass().getResource("/").getPath();

    final String METRICS2_OOM = classpath + "metrics2.oom";

    Logger logger = Logger.getLogger(Dom4jDemo.class);

    @Test
    public void readXMLDemo() throws Exception {
        SAXReader reader = new SAXReader();

        Document document = reader.read(new File(METRICS2_OOM));

        Element node = document.getRootElement();

        dfsNodeName(node, 0);
    }

    private void dfsNodeName(Element root, int level) {
        String prefix = "";
        for (int i = 0;i < level;i++) {
            prefix += "\t";
        }

//        logger.info(prefix + level + " -> " + root.getName());
        System.out.println(prefix + level + " -> " + root.getName());

        List<Element> children = root.elements();
        for (int i = 0; i< children.size();i++) {
            dfsNodeName(children.get(i), level+1);
        }
    }
}
