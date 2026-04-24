package com.shivam.monocept.arrays.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvSources;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import com.shivam.monocept.arrays.ArraysFunction;

class ArraysFunctionsTest {
ArraysFunction array=new ArraysFunction();
@ParameterizedTest
@MethodSource("arrayProvider")
void shouldBeArraysOperation(int[] actual, int[] expected) {
    assertArrayEquals(expected, array.reverseArray(actual));
}

static Stream<Arguments> arrayProvider() {
    return Stream.of(
        Arguments.of(new int[]{1,2,3,4}, new int[]{4,3,2,1}),
        Arguments.of(new int[]{}, new int[]{}),
        Arguments.of(new int[]{5}, new int[]{5}),
        Arguments.of(null,null)
    );
}
/*@ParameterizedTest
@CsvSource({
	"new int[]{1,2,3,4},new int[]{4,3,2,1}",
	"new int[]{},{}",
	"new int[]{5},{5}"
})
void shouldBeArraysoperastion(int[] actual,int[] expected)
{
	assertArrayEquals(expected,array.reverseArray(actual));
	}

@Test
void ReverseNormalArray() {
    assertArrayEquals(new int[] {4, 3, 2, 1}, array.reverseArray(new int[] {1, 2, 3, 4}));
}

@Test
void ReverseSingleElement() {
    assertArrayEquals(new int[] {5}, array.reverseArray(new int[] {5}));
}
 
@Test
void ReverseEmptyArray() {
    assertArrayEquals(new int[] {}, array.reverseArray(new int[] {}));
}


@Test
void ArrayReverseNull() {
    assertNull(array.reverseArray(null));
}*/
}