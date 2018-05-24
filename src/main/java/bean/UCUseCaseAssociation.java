package bean;

/**
 * Created by ltaoj on 2018/05/24 10:09.
 *
 * @version : 1.0
 */
public class UCUseCaseAssociation extends PDObject {
    private UCUseCase useCase;

    private UCActor actor;

    public UCUseCaseAssociation(String id, String name, UCUseCase useCase, UCActor actor) {
        super(id, name);
        this.useCase = useCase;
        this.actor = actor;
    }

    public UCUseCase getUseCase() {
        return useCase;
    }

    public void setUseCase(UCUseCase useCase) {
        this.useCase = useCase;
    }

    public UCActor getActor() {
        return actor;
    }

    public void setActor(UCActor actor) {
        this.actor = actor;
    }
}
