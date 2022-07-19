package com.cybertek.day5;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

public class HamcrestMatchersIntro {

@Test
    public void simpleTest1(){
    assertThat(5+5, is(10));
    List<Integer> list= Arrays.asList(10,20,35,45,55);
    assertThat(list,everyItem(greaterThanOrEqualTo(10)));



}

}
