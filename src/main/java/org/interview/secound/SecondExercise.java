package org.interview.secound;

import com.google.gson.Gson;

import java.io.Reader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondExercise {

    private final HashMap<String, List<String>> countries = new HashMap<>();
    private final String LANGUAGE_FILTER = "de";
    private final Reader FILE_READER;

    public SecondExercise(Reader fileReader) {
        this.FILE_READER = fileReader;
        readJson();
    }

    private void readJson() {
        Gson gson = new Gson();
        for (Country country : gson.fromJson(FILE_READER, Country[].class)) {
            countries.put(country.getCountry(), country.getLanguages());
        }
    }

    public int countCountries() {
        return countries.keySet().size();
    }

    public String mostOfficialFiltered() {
        OptionalInt maxVal = countries.values().stream().mapToInt(List::size).max();
        return countries.entrySet().stream()
                .filter(v -> v.getValue().contains(LANGUAGE_FILTER) && v.getValue().size() == maxVal.getAsInt())
                .findFirst().get().getKey();
    }

    public int countLanguages() {
        Set<String> languages = countries.entrySet().stream().flatMap(x -> x.getValue().stream()).collect(Collectors.toSet());
        return languages.size();
    }

    public String highestLanguages() {
        OptionalInt maxVal = countries.values().stream().mapToInt(List::size).max();
        return countries.entrySet().stream()
                .filter(v -> v.getValue().size() == maxVal.getAsInt())
                .findFirst().get().getKey();
    }

    public String mostCommonLanguage() {
        List<String> languages = countries.entrySet().stream().flatMap(x -> x.getValue().stream()).collect(Collectors.toList());
        Map<String, Long> frequency = languages.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        OptionalInt maxVal = frequency.values().stream().mapToInt(Long::intValue).max();
        Map<String, Long> commonLanguages = frequency.entrySet().stream()
                .filter(v -> v.getValue() == maxVal.getAsInt())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return String.join(",", commonLanguages.keySet());
    }
}

