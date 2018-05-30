package bean;

import java.util.List;

/**
 * Created by ltaoj on 2018/05/31 00:01.
 *
 * @version : 1.0
 */
public class CInterface extends PDObject {

    private boolean isAbstract = true;

    private List<COperation> operations;

    public CInterface(String id, String name, boolean isAbstract, List<COperation> operations) {
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
