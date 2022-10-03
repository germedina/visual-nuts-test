package org.interview;

import org.interview.first.FirstExercise;
import org.interview.secound.SecondExercise;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("First exercise");
        new FirstExercise().printValues();

        System.out.println("===============");
        System.out.println("Second exercise");

        BufferedReader fileReader;
        if (args.length > 0) {
            File file = new File(args[0]);
            fileReader = new BufferedReader(new FileReader(file));
            System.out.println("Reading file from args: " + args[0]);
        } else {
            String fileName = "data.json";
            ClassLoader classLoader = App.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(fileName);
            InputStreamReader streamReader = new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
            fileReader = new BufferedReader(streamReader);
            System.out.println("Reading file from resources: " + fileName);
        }

        SecondExercise secondExercise = new SecondExercise(fileReader);
        System.out.println(" - number of countries in the world: " +
                secondExercise.countCountries());
        System.out.println(" - country with the most official languages, where they officially speak German (de): " +
                secondExercise.mostOfficialFiltered());
        System.out.println(" - counts all the official languages spoken in the listed countries:" +
                secondExercise.countLanguages());
        System.out.println(" - the country with the highest number of official languages:" +
                secondExercise.highestLanguages());
        System.out.println(" - the most common official language(s), of all countries:" +
                secondExercise.mostCommonLanguage());
    }
}
