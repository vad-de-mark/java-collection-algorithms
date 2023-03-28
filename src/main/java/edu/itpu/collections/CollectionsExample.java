package edu.itpu.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CollectionsExample {

  public static void main(String[] args) {
    
  }

  //region Frequency example
  private static void frequencyExample() {
    var rnd = new Random(784928L);
    var list = IntStream.generate(() -> rnd.nextInt(10))
        .limit(10)
        .sorted()
        .boxed()
        .toList();
    System.out.println("Original");
    System.out.print(list.toString().indent(2));
    
    for (int i = 0; i < 10; ++i) {
      System.out.println("Frequency of " + i + " = " + Collections.frequency(list, i));
    }
  }
  //endregion

  //region Shuffle example
  private static void shuffleExample() {
    var list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    System.out.println(list);
    Collections.shuffle(list);
    System.out.println(list);
  }
  //endregion

  //region Rotate example
  private static void rotateExample(int rotateBegin, int rotateEnd) {
    var list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    if (rotateBegin == rotateEnd) {
      rotateAndPrint(list, rotateBegin);
      return;
    }
    int diff = (rotateEnd - rotateBegin) / Math.abs(rotateEnd - rotateBegin);
    for (int rotate = rotateBegin; Integer.compare(rotate, rotateEnd) * diff <= 0; rotate += diff) {
      rotateAndPrint(list, rotate);
    }
  }

  private static void rotateAndPrint(List<?> list, int rotate) {
    ArrayList<?> mutableList = new ArrayList<>(list);
    System.out.println("Rotate = " + rotate);
    Collections.rotate(mutableList, rotate);
    System.out.print(list.toString().indent(2));
    System.out.println(mutableList.toString().indent(2));
  }
  //endregion
}
