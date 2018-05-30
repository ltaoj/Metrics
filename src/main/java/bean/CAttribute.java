package bean;

/**
 * Created by ltaoj on 2018/05/31 00:10.
 *
 * @version : 1.0
 */
public class CAttribute extends PDObject {

    private String dataType;

    private String visibility;

    private boolean isStatic;

    public CAttribute(String id, String name, String dataType, String visibility, boolean isStatic) {
        super(id, name);
        this.dataType = dataType;
        this.visibility = visibility == null ? VISIBILITY.PRIVATE : visibility;
        this.isStatic = isStatic;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility == null ? VISIBILITY.PRIVATE : visibility;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    public interface VISIBILITY {
        String PUBLIC = "";
        String PROTECTED = "#";
        String PRIVATE = "-";
    }
}
