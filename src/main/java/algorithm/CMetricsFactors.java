package algorithm;

import bean.CClass;
import bean.COperation;
import bean.ClassDiagram;

import java.util.List;
import java.util.Map;

public abstract class CMetricsFactors extends MetricsFactorsAbstract<ClassDiagram>{

    public CMetricsFactors(){

    }

    public CMetricsFactors(ClassDiagram diagram){
        super(diagram);
    }

    public abstract List<CClass> classs();

    public abstract void getDIT();

    public abstract void getCBO();

    //获得度量因子PIM 类中公有实例方法
    public abstract void getPIM();

    /**获得度量因子NIM 为类实例定义的⽅法的总数**/
    public abstract void getNIM();

    //获得度量因子NCM 类的全部⽅法数
    public abstract Map<CClass, List<COperation>> getNCM();

    //获得度量因子NCV 类的全部属性数
    public abstract void getNCV();

    //获得度量因子APPM APPM=全部⽅法的参数个数/全部⽅法
    //数
    public abstract void getAPPM();

    //获得度量因子NMO 某个类被其⼦类覆盖的⽅法总数
    public abstract void getNMO();

    //获得度量因子NMA ⼀个⼦类中定义的⽅法总数
    public abstract void getNMA();

    //获得度量因子NOC 某个类直接派⽣的⼦类个数
    public abstract void getNOC();
}
