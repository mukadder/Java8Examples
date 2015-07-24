/**
 * Created by MHP on 24/07/2015.
 */
public enum Saiyan {
    SUPER_SAIYAN,
    SUPER_SAIYA_2,
    SUPER_SAIYA_3,
    SUPER_SAIYA_GOD,
    GOLDER_GREAT_APE;


    public Double getPower() {
        if (this == SUPER_SAIYA_3)
            return 100.0;
        return 0.0;
    }
}
