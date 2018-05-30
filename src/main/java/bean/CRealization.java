package bean;

/**
 * Created by ltaoj on 2018/05/31 01:51.
 *
 * @version : 1.0
 */
public class CRealization extends PDObject {

    private CInterface object1;

    private CClass object2;

    public CRealization(String id, String name, CInterface object1, CClass object2) {
        super(id, name);
        this.object1 = object1;
        this.object2 = object2;
    }

    public CInterface getObject1() {
        return object1;
    }

    public void setObject1(CInterface object1) {
        this.object1 = object1;
    }

    public CClass getObject2() {
        return object2;
    }

    public void setObject2(CClass object2) {
        this.object2 = object2;
    }
}
