package bean;

/**
 * Created by lenovo on 2018/5/24.
 */
public class CParameter extends PDObject {

    private String dataType;

    // 可以为null
    private CClass objectDataType;

    public CParameter(String id, String name, String dataType, CClass objectDataType) {
        super(id, name);
        this.dataType = dataType;
        this.objectDataType = objectDataType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public CClass getObjectDataType() {
        return objectDataType;
    }

    public void setObjectDataType(CClass objectDataType) {
        this.objectDataType = objectDataType;
    }
}
