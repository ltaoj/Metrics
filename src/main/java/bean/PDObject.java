package bean;

/**
 * Created by ltaoj on 2018/05/24 10:04.
 *
 * @version : 1.0
 */
public abstract class PDObject {

    private String id;

    private String name;

    public PDObject() {
    }

    public PDObject(String id) {
        this.id = id;
    }

    public PDObject(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
