package parse;

import bean.Diagram;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * Created by ltaoj on 2018/05/23 17:08.
 *
 * @version : 1.0
 */
public abstract class DiagramParser<T extends Diagram> {

    public final String CLASSPATH;
    public final String METRICS2_OOM;
    public final String METRICS3_OOM;
    public final String METRICS5_OOM;
    public final String METRICS6_OOM;
    public final String METRICS_TEST_OOM;

    public DiagramParser() {
        CLASSPATH = getClass().getResource("").getPath().replace(this.getClass().getPackage().getName()+"/", "");
        METRICS2_OOM = CLASSPATH + "metrics2.oom";
        METRICS3_OOM = CLASSPATH + "metrics3.oom";
        METRICS5_OOM = CLASSPATH + "metrics5.oom";
        METRICS6_OOM = CLASSPATH + "metrics6.oom";
        METRICS_TEST_OOM = CLASSPATH + "test_class.oom";
    }

    // 解析成功数据响应接口
    public interface DataListener<T> {
        void onComplete(T data);
    }

    /**
     * 类图解析
     * @param file oom文件路径
     * @param listener 解析数据监听
     * @throws ParseException
     */
    public abstract void parse(String file, DataListener<T> listener) throws ParseException;

    /**
     * 将xml格式的文件读取为{@link Document}对象
     * @param filePath oom文件绝对路径
     * @return {@link Document} if read successfully, otherwise return null
     */
    protected Document readXml(String filePath) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            File oomFile = new File(filePath);
            document = reader.read(oomFile);
        } catch (DocumentException e) {
            Logger.getLogger(DiagramParser.class).error("文件不存在，读取失败!!!");
        }
        return document;
    }
}
