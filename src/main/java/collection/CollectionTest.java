package collection;

import java.util.List;
import java.util.stream.Collectors;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    List <Double> result = input.stream().map(x -> Math.pow (((x * 2) + 3), 5)).collect(Collectors.toList());
    return result;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {

    if (!input.isEmpty()) {
      List<String> result = input.stream().map(str -> (capitalize(str).concat(capitalize(str)))).collect(
          Collectors.toList());
      return result;
    }
    return input;

  }

  /**
   * Methode qui permet de mettre la premiere lettre d'un mot en lettre capital.
   * @param str String
   * @return String
   */
  public static String capitalize(String str) {
    if(str == null || str.isEmpty()) {
      return str;
    }
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }

}
