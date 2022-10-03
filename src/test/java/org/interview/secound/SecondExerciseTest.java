package org.interview.secound;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class SecondExerciseTest {

    BufferedReader reader;

    @Before
    public void setUp() {
        String fileName = "data.json";
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        InputStreamReader streamReader = new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
        reader = new BufferedReader(streamReader);
    }

    @Test
    public void shouldReturnCountries() {
        int expected = 5;
        Assert.assertEquals(expected, new SecondExercise(reader).countCountries());
    }

    @Test
    public void shouldReturnCountryWithMostLanguages() {
        String expected = "BE";
        Assert.assertEquals(expected, new SecondExercise(reader).mostOfficialFiltered());
    }

    @Test
    public void shouldReturnAllLanguages() {
        int expected = 6;
        Assert.assertEquals(expected, new SecondExercise(reader).countLanguages());
    }

    @Test
    public void shouldReturnCountryHighestLanguage() {
        String expected = "BE";
        Assert.assertEquals(expected, new SecondExercise(reader).highestLanguages());
    }

    @Test
    public void shouldReturnMostCommonLanguage() {
        String expected = "de,nl";
        Assert.assertEquals(expected, new SecondExercise(reader).mostCommonLanguage());
    }
}