package algorithm;

import bean.UseCaseDiagram;

/**
 * Created by ltaoj on 2018/05/25 01:02.
 *
 * @version : 1.0
 */
public abstract class UCMetricsFactors extends MetricsFactorsAbstract<UseCaseDiagram> {

    public UCMetricsFactors() {
    }

    public UCMetricsFactors(UseCaseDiagram diagram) {
        super(diagram);
    }

    /**
     * 获得用例的数量
     * @return 度量因子：UC1
     */
    public abstract int getUC1();

    /**
     * @return 度量因子UC2
     */
    public abstract int getUC2();

    /**
     *
     * @return 度量因子：UC3
     */
    public abstract double getUC3();

    /**
     * 可以预估系统全局的⼀个复杂度
     * @return 度量因子：UC4
     */
    public abstract double getUC4();

    /**
     * 获得执行者的数量
     * @return 度量因子：NA
     */
    public abstract int getNA();

    /**
     * 获得依赖关系的数量
     * @return 度量因子：NOD（Number of Dependency）
     */
    public abstract int getNOD();
}
