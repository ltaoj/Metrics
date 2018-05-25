package bean;

/**
 * Created by lenovo on 2018/5/24.
 */
public class CAssociation extends  PDObject {

    // 箭头指向
    private CClass object1;
    // 箭头开始
    private CClass object2;

    public CAssociation(String id, String name, CClass object1, CClass object2) {
        super(id, name);
        this.object1 = object1;
        this.object2 = object2;
    }

    public CClass getObject1() {
        return object1;
    }

    public void setObject1(CClass object1) {
        this.object1 = object1;
    }

    public CClass getObject2() {
        return object2;
    }

    public void setObject2(CClass object2) {
        this.object2 = object2;
    }
}
