package bean;

import java.util.List;

/**
 * Created by lenovo on 2018/5/24.
 */
public class CClass extends  PDObject{
    private boolean isAbstract;
    private boolean isFinal;

    private List<COperation> operations;

    private List<CAttribute> attributes;

    public CClass(String id, String name, boolean isAbstract, List<COperation> operations) {
        super(id, name);
        this.isAbstract = isAbstract;
        this.operations = operations;
    }

    public CClass(String id, String name, boolean isAbstract, boolean isFinal,
                  List<COperation> operations, List<CAttribute> attributes) {
        super(id, name);
        this.isAbstract = isAbstract;
        this.isFinal = isFinal;
        this.operations = operations;
        this.attributes = attributes;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(boolean anAbstract) {
        isAbstract = anAbstract;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public List<COperation> getOperations() {
        return operations;
    }

    public void setOperations(List<COperation> operations) {
        this.operations = operations;
    }

    public List<CAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<CAttribute> attributes) {
        this.attributes = attributes;
    }
}
