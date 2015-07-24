import java.util.DoubleSummaryStatistics;

/**
 * Created by MHP on 22/07/2015.
 */
public class SuperSaiyan {
    private Inner inner;

    public SuperSaiyan() {
    }

    public SuperSaiyan(Saiyan saiyan) {
        this.inner = new Inner(new Ki(saiyan.getPower()), new Strength(saiyan.getPower()));
    }

    public Inner getInner() {
        return inner;
    }
}
