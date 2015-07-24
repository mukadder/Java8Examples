/**
 * Created by MHP on 22/07/2015.
 */
public class Inner {

    private Ki ki;
    private Strength strength;

    public Inner(Ki ki, Strength strength) {
        this.ki = ki;
        this.strength = strength;
    }

    public Ki getKi() {
        return ki;
    }

    public void setKi(Ki ki) {
        this.ki = ki;
    }

    public Strength getStrength() {
        return strength;
    }

    public void setStrength(Strength strength) {
        this.strength = strength;
    }
}
