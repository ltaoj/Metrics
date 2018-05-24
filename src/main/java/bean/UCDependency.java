package bean;

/**
 * Created by ltaoj on 2018/05/24 10:08.
 *
 * @version : 1.0
 */
public class UCDependency extends PDObject {

    // 依赖类型，分为include、extend
    private String stereotype;

    // 箭头指向
    private UCUseCase object1;

    // 箭头开始
    private UCUseCase object2;

    public UCDependency(String id, String name, String stereotype, UCUseCase object1, UCUseCase object2) {
        super(id, name);
        checkStereotype(stereotype);
        this.stereotype = stereotype;
        this.object1 = object1;
        this.object2 = object2;
    }

    public String getStereotype() {
        return stereotype;
    }

    public void setStereotype(String stereotype) {
        checkStereotype(stereotype);
        this.stereotype = stereotype;
    }

    public UCUseCase getObject1() {
        return object1;
    }

    public void setObject1(UCUseCase object1) {
        this.object1 = object1;
    }

    public UCUseCase getObject2() {
        return object2;
    }

    public void setObject2(UCUseCase object2) {
        this.object2 = object2;
    }

    private void checkStereotype(String stereotype) {
        if (stereotype == null || (!stereotype.equals(Stereotype.INCLUDE) && !stereotype.equals(Stereotype.EXTEND)))
            throw new IllegalArgumentException("stereotype must not be null, and value is either include or extend");
    }

    public interface Stereotype {
        String INCLUDE = "include";
        String EXTEND = "extend";
    }
}
