package bean;

/**
 * Created by lenovo on 2018/5/24.
 */
public class CGeneralization extends  PDObject {


    private PDObject  object1;//父类对象
    private  PDObject  object2;//子类对象
    public CGeneralization(String id, String name, PDObject object1, PDObject object2) {
        super(id, name);
        this.object1 = object1;
        this.object2 =object2;
    }
    public PDObject getObject2() {
        return object2;
    }
    public PDObject getObject1() {
        return object1;
    }

    public void setObject1(PDObject object1) {
        this.object1 = object1;
    }
    public void setObject2(PDObject object2) {
        this.object2 = object2;
    }



}
