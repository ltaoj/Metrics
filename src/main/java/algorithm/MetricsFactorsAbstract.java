package algorithm;

import bean.Diagram;

/**
 * Created by ltaoj on 2018/05/25 00:59.
 *
 * @version : 1.0
 */
public abstract class MetricsFactorsAbstract<T extends Diagram> {

    protected T diagram;

    public MetricsFactorsAbstract() {
    }

    public MetricsFactorsAbstract(T diagram) {
        this.diagram = diagram;
    }

    public T getDiagram() {
        return diagram;
    }

    public void setDiagram(T diagram) {
        this.diagram = diagram;
    }

    protected void checkDiagram() {

    }
}
