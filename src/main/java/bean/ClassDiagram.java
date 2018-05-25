package bean;

import java.util.List;

/**
 * Created by ltaoj on 2018/05/23 17:24.
 *
 * @version : 1.0
 */
public class ClassDiagram extends Diagram {
    private List<CAssociation> associations;

    private List<CClass> classes;

    private List<CDependency> dependencies;

    private List<CGeneralization> generalizations;

    private List<COperation> operations;
    private List<CParameter> parameters;


    public ClassDiagram() {
    }

    public ClassDiagram(List<CAssociation> associations, List<CClass> classes, List<CDependency> dependencies, List<CGeneralization> generalizations, List<COperation> operations, List<CParameter> parameters) {
        this.associations = associations;
        this.classes = classes;
        this.dependencies = dependencies;
        this.generalizations = generalizations;
        this.operations = operations;
        this.parameters = parameters;
    }

    public List<CAssociation> getAssociations() {
        return associations;
    }

    public void setAssociations(List<CAssociation> associations) {
        this.associations = associations;
    }

    public List<CClass> getClasses() {
        return classes;
    }

    public void setClasses(List<CClass> classes) {
        this.classes = classes;
    }

    public List<CDependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<CDependency> dependencies) {
        this.dependencies = dependencies;
    }

    public List<CGeneralization> getGeneralizations() {
        return generalizations;
    }

    public void setGeneralizations(List<CGeneralization> generalizations) {
        this.generalizations = generalizations;
    }

    public List<COperation> getOperations() {
        return operations;
    }

    public void setOperations(List<COperation> operations) {
        this.operations = operations;
    }

    public List<CParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<CParameter> parameters) {
        this.parameters = parameters;
    }

//根据id查询Class

    public CClass getClass(String id) {
        if (classes == null)
            throw new IllegalStateException("classes hasn't been initialized.");

        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getId().equals(id))
                return classes.get(i);
        }

        return null;
    }

    @Override
    public String toString() {
        String toString = "";
        toString += classes == null ? "classes null ; " : "classes size -> " + classes.size() + " ; ";
        toString += associations == null ? "associations null ; " : "associations size -> " + associations.size() + " ; ";
        toString += generalizations == null ? "generalizations null ; " : "generalizations size -> " + generalizations.size() + " ; ";
        toString += dependencies == null ? "dependencies null ; " : "dependencies size -> " + dependencies.size() + " ; ";
        return toString;
    }
}