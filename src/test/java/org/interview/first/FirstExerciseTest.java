package org.interview.first;

import org.junit.Assert;
import org.junit.Test;

public class FirstExerciseTest {

    @Test
    public void shouldReturnValuesFor10() {
        String[] expected = {"1", "2", "Visual", "4", "Nuts", "Visual", "7", "8", "Visual", "Nuts"};
        FirstExercise firstExercise = new FirstExercise(10);
        Assert.assertArrayEquals(expected, firstExercise.getValues());
    }

    @Test
    public void shouldReturnFor100Elements() {
        int expected = 100;
        FirstExercise firstExercise = new FirstExercise();
        Assert.assertEquals(expected, firstExercise.getValues().length);
    }

}