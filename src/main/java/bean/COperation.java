package bean;

import java.util.List;

/**
 * Created by lenovo on 2018/5/24.
 */
public class COperation extends PDObject {
    private String retureType;

    private List<CParameter> parameters;


    public COperation(String id, String name, String retureType, List<CParameter> parameters) {
        super(id, name);
        this.retureType = retureType;
        this.parameters = parameters;
    }

    public String getRetureType() {
        return retureType;
    }

    public void setRetureType(String retureType) {
        this.retureType = retureType;
    }

    public List<CParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<CParameter> parameters) {
        this.parameters = parameters;
    }
}
