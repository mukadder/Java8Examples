import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        SuperSaiyan goku = new SuperSaiyan(Saiyan.SUPER_SAIYA_3);
        SuperSaiyan krilin = new SuperSaiyan();
        SuperSaiyan najor = null;

        System.out.println(goku.getInner().getKi().getPower());

        // of
        Optional.of(goku);

        //ofNullable
        Optional.ofNullable(null);

        // map
        Optional.of(goku)
                .map(SuperSaiyan::getInner)
                .map(Inner::getKi)
                .map(Ki::getPower)
                .orElse("No more ki");

        // flatMap(::Optional)
        Optional.of(krilin)
                .map(SuperSaiyan::getInner)
                .map(Inner::getStrength)
                .flatMap(Strength::getLevel)
                .ifPresent(System.out::println);

        // orElse
        Optional.of(krilin)
                .map(SuperSaiyan::getInner)
                .map(Inner::getKi)
                .map(Ki::getPower)
                .orElse("No inner Ki: YOU ARE A FAKE　　");

        // ofNullable
        Optional.ofNullable(najor)
                .map(SuperSaiyan::getInner)
                .map(Inner::getKi)
                .map(Ki::getPower)
                .orElse("No inner Ki: YOU ARE A FAKE　　");

        // ifPresent: lambda, functional programming
        Optional.of(goku)
                .map(SuperSaiyan::getInner)
                .map(Inner::getKi)
                .map(Ki::getPower)
                .ifPresent(System.out::println);

        Optional.ofNullable(najor)
                .map(SuperSaiyan::getInner)
                .orElseGet(goku::getInner);

    }
}
