package com.example;

import com.example.ironman.Iron;
import com.example.ironman.IronMan;
import com.example.superhero.Avenger;
import com.example.superhero.Avengers;
import com.example.superhero.Batman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by najor on 7/10/15.
 */
public class LambdaExample {

    public static void main(String[] args) {

        // Listener in GUI
        TextField field = new TextField();

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("myAction".equals(e.getActionCommand())) {
                    System.out.println(e.getActionCommand());
                }
            }
        });

        field.addActionListener(e -> {
            if ("myAction".equals(e.getActionCommand())) {
                System.out.println(e.getActionCommand());
            }
        });

        // Custom Interface
        Person bruceWayne = new Person("Bruce");
        destroyBatman(new Batman() {
            @Override
            public Person getIdentity() {
                return bruceWayne;
            }
        });

        destroyBatman(() -> bruceWayne);

        Avengers avengers = new Avengers(() -> bruceWayne);

        // Method Reference
        revealBatmanIdentity(avengers::getBatman);
        findIronMan(IronMan::new);

        Batman batman = avengers.getBatman();

        IronMan ironMan = new IronMan();
        IronMan machineWar = new IronMan();

        // Supplier<T>
        findIronMan(() -> ironMan);
        findIronMan(() -> {
            if (avengers.availableIronMan())
                return avengers.getIronMan();
            return machineWar;
        });

        findIronMan(IronMan::new);

        Person anonymous = new Person("Tony Stark");

        // Function<T,R>
        transformPersonToAvenger(
                anonymous,
                person ->
                        person.getName().equals("Bruce Wayne") ?
                                avengers.getBatman() :
                                avengers.getAquaman());

        // Consumer<T>
        attackAvenger(
                ironMan,
                avenger -> {
                    punch(avenger);
                    kick(avenger);
                });

        java.util.ArrayList persons = new ArrayList<Person>();
        persons.add(anonymous);

        // Predicate<T>
        filterSuperHero(persons, person -> isAvenger(person));

        // Runnable
        callBatman(() -> System.out.println("calling " + batman));
    }

    private static void callBatman(Runnable call) {
        call.run();
    }

    private static boolean isAvenger(Person person) {
        return true;
    }

    private static List<Person> filterSuperHero(List<Person> person, Predicate<Person> check) {
        return person.stream().filter(p -> check.test(p)).collect(Collectors.toList());
    }

    private static void kick(Avenger avenger) {
        System.out.println("Kicking " + avenger);
    }

    private static void punch(Avenger avenger) {
        System.out.println("Punching " + avenger);
    }

    private static void attackAvenger(Avenger avenger, Consumer<Avenger> attack) {
        attack.accept(avenger);
    }

    private static void transformPersonToAvenger(Person person, Function<Person, Avenger> transformation) {
        System.out.println(person.toString() + " - transform to -" + transformation.apply(person));
    }

    private static void revealBatmanIdentity(Supplier<Batman> supplier) {
        System.out.println("Batman is: " + supplier.get().getIdentity());
    }

    public static void destroyBatman(Batman batman) {
        System.out.println("You are dead " + batman.getIdentity() + "¡¡¡¡");
    }

    public static void findIronMan(Supplier<IronMan> ironManFinder) {
        System.out.println(" I found you IronMan - " + ironManFinder.get().toString());
    }
}
