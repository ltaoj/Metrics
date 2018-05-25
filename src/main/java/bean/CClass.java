package bean;

import java.util.List;

/**
 * Created by lenovo on 2018/5/24.
 */
public class CClass extends  PDObject{
    private boolean isAbstract;
    private List<COperation> operations;

    public CClass(String id, String name, boolean isAbstract, List<COperation> operations) {
        super(id, name);
        this.isAbstract = isAbstract;
        this.operations = operations;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(boolean anAbstract) {
        isAbstract = anAbstract;
    }

    public List<COperation> getOperations() {
        return operations;
    }

    public void setOperations(List<COperation> operations) {
        this.operations = operations;
    }
}
