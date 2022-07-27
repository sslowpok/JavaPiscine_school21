package app;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.awt.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ReflectionClasses {

    private Reflections reflections;
    private Class currentClass;
    private Object object;
    private Set<Class> classSet;

    public ReflectionClasses() {
        this.reflections = new Reflections("classes", new SubTypesScanner(false));
        this.currentClass = null;
        this.object = null;
    }

    public void showClasses() {

        System.out.println("Classes:");

        classSet = new HashSet<>(reflections.getSubTypesOf(Object.class));

        for (Class c : classSet) {
            System.out.println("\t- " + c.getSimpleName());
        }

    }

    public void showClassInfo() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter class name:\n-> ");

        String input = scanner.nextLine();
        currentClass = classSet.stream().filter(c -> c.getSimpleName().equals(input)).findFirst().orElse(null);

        if (currentClass == null) {
            System.err.println("Class " + input + " not found");
            System.exit(-1);
        }

        System.out.println("---------------------");
        System.out.println("fields:");



    }

}
