package bean;

import java.util.List;

/**
 * Created by lenovo on 2018/5/24.
 */
public class COperation extends PDObject {
    private String retureType;

    private List<CParameter> parameters;

    // 方法为实现还是重写
    private String stereotype;

    // 方法的可见性
    private String visibility;

    // 如果是实现或者重写，相关的方法的引用
    private COperation influentObject;

    // 方法是否为静态
    private boolean isStatic;

    // 方法是否为final
    private boolean isFinal;

    // 猜测可能代表pd自动生成的方法标志
    private boolean isAutomatic;

    // 方法是否为抽象
    private boolean isAbstract;

    public COperation(String id, String name, String retureType, List<CParameter> parameters, String stereotype,
                      String visibility, COperation influentObject, boolean isStatic, boolean isFinal,
                      boolean isAutomatic, boolean isAbstract) {
        super(id, name);
        this.retureType = retureType;
        this.parameters = parameters;
        this.stereotype = stereotype == null ? STEREOTYPE.NONE : stereotype;
        this.visibility = visibility == null ? VISIBILITY.PUBLIC : visibility;
        this.influentObject = influentObject;
        this.isStatic = isStatic;
        this.isFinal = isFinal;
        this.isAutomatic = isAutomatic;
        this.isAbstract = isAbstract;
    }

    public String getRetureType() {
        return retureType;
    }

    public void setRetureType(String retureType) {
        this.retureType = retureType;
    }

    public List<CParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<CParameter> parameters) {
        this.parameters = parameters;
    }

    public String getStereotype() {
        return stereotype;
    }

    public void setStereotype(String stereotype) {
        this.stereotype = stereotype == null ? STEREOTYPE.NONE : stereotype;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility == null ? VISIBILITY.PUBLIC : visibility;
    }

    public COperation getInfluentObject() {
        return influentObject;
    }

    public void setInfluentObject(COperation influentObject) {
        this.influentObject = influentObject;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(boolean anAbstract) {
        isAbstract = anAbstract;
    }

    public interface STEREOTYPE {
        String NONE = "";
        String OVERRIDE = "Override";
        String IMPLEMENT = "Implement";
        String CONSTRUCTOR = "Constructor";
    }

    public interface VISIBILITY {
        String PUBLIC = "";
        String PROTECTED = "#";
        String PRIVATE = "-";
    }
}
