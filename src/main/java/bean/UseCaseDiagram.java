package bean;

import java.util.List;

/**
 * Created by ltaoj on 2018/05/23 17:24.
 *
 * @version : 1.0
 */
public class UseCaseDiagram extends Diagram {

    private List<UCDependency> dependencies;

    private List<UCActor> actors;

    private List<UCUseCase> useCases;

    private List<UCUseCaseAssociation> useCaseAssociations;

    public UseCaseDiagram() {
    }

    public UseCaseDiagram(List<UCDependency> dependencies, List<UCActor> actors,
                          List<UCUseCase> useCases, List<UCUseCaseAssociation> useCaseAssociations) {
        this.dependencies = dependencies;
        this.actors = actors;
        this.useCases = useCases;
        this.useCaseAssociations = useCaseAssociations;
    }

    public List<UCDependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<UCDependency> dependencies) {
        this.dependencies = dependencies;
    }

    public List<UCActor> getActors() {
        return actors;
    }

    public void setActors(List<UCActor> actors) {
        this.actors = actors;
    }

    public List<UCUseCase> getUseCases() {
        return useCases;
    }

    public void setUseCases(List<UCUseCase> useCases) {
        this.useCases = useCases;
    }

    public List<UCUseCaseAssociation> getUseCaseAssociations() {
        return useCaseAssociations;
    }

    public void setUseCaseAssociations(List<UCUseCaseAssociation> useCaseAssociations) {
        this.useCaseAssociations = useCaseAssociations;
    }

    /**
     * 根据id查询UseCase
     * @param id
     * @return {@link UCUseCase} if find the useCase, otherwise return null
     */
    public UCUseCase getUseCase(String id) {
        if (useCases == null)
            throw new IllegalStateException("useCases hasn't been initialized.");

        for (int i = 0;i < useCases.size();i++) {
            if (useCases.get(i).getId().equals(id))
                return useCases.get(i);
        }

        return null;
    }

    /**
     * 根据id查询Actor
     * @param id
     * @return {@link UCActor} if find the actor, otherwise return null
     */
    public UCActor getActor(String id) {
        if (actors == null)
            throw new IllegalStateException("actors hasn't been initialized.");

        for (int i = 0;i < actors.size();i++) {
            if (actors.get(i).getId().equals(id))
                return actors.get(i);
        }

        return null;
    }

    @Override
    public String toString() {
        if (actors == null || useCases == null || dependencies == null || useCaseAssociations == null) {
            return super.toString();
        } else {
            return "actors size -> " + actors.size() + " ; useCases size -> " + useCases.size()
                    + " ; dependencies size -> " + dependencies.size()
                    + " ; useCaseAssociations size -> " + useCaseAssociations.size();
        }
    }
}
