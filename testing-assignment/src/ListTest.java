import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

  // ONLY USE THIS FUNCTION TO CONSTRUCT LISTS FOR TESTING...
  public <E> List<E>makeList(E[] array){
    return Arrays.asList(array);
  }
  

  // the length() method:

  // Specification:

  // This part should be a textual specification of
  // how the length method should behave...

  // Tests:


  /*
   * @Test public void testAdd(){
   * 
   * }
   */

    /*
     * Given multiple values of the same type, the
     * Contains operator, takes in a value of any
     * type. It then iterates through each value 
     * and compares each value that it visits to 
     * the value that it was passed. If they are
     * equivalent, the operator returns true.
     * Otherwise the operators continues until, 
     * there are no more values to visit. If that
     * is the case, then the operator returns 
     * false to indicate that the passed value
     * does not exist in the given values.
     */

   @Test
   public void testContains1(){
     Integer[] ar = {3, 4, 5};
     List<Integer> l = makeList(ar);
     assertTrue(l.contains(3));
   }

  @Test
  public void testContains2(){
    Integer[] ar = {3, 4, 5};
    List<Integer> l = makeList(ar);
    assertFalse(l.contains(1));
  }

  @Test
  public void testContains3(){
    Integer[] ar = {3, 4, 5};
    List<Integer> l = makeList(ar);
    assertFalse(l.contains("A"));
  }

  /*
   * Given multiple values of the same type, the
   * Get operator takes in an integer value, and
   * starts a count at 0. It will iterate through
   * each value in order, while increasing its
   * count after visting a value. Once count is
   * equivalent to interger value argument, the
   * operator will return the value that it is
   * currently visiting.
   */

   @Test
  public void testGet1(){
    Integer[] ar = {3, 4, 5};
    List<Integer> l = makeList(ar);
    assertEquals(l.get(0), 3);
  }

  /*
   * Given multiple values of the same type, the
   * IndexOf operator takes in a value and starts
   * a count at 0. It then iterates through all
   * the given values in order, increasing the its
   * count by 1 after each value it visits. If the
   * operator visits a value that is equivalent to
   * the value that was passed through, it will
   * return its count. If it does not see an 
   * equivalent value, then it will return -1 to
   * represent that it was unable to find the
   * specified value.
   */

  @Test
  public void testIndexOf1() {
    Integer[] ar = {3, 4, 5};
    List<Integer> l = makeList(ar);
    assertEquals(0, l.indexOf(3));
  }

  @Test
  public void testIndexOf2() {
    Integer[] ar = {3, 4, 5};
    List<Integer> l = makeList(ar);
    assertEquals(-1, l.indexOf(1));
  }

  /*
   * @Test
   * public void testRemove1(){
   * 
   * }
   */

  /*
   * Given multiple values of the same type, the size
   * operator starts a count at 0. It then iterates 
   * through each value and increases the count by 1 
   * for each value it visits. The final count is what 
   * is returned and represents the number of values 
   * that it was given.
   */

  @Test
  public void testLength1() {
    Integer[] ar = {3,4,5};
    List<Integer> l = makeList(ar);
    assertEquals(3, l.size());
  }

  /*
   * Given multiple values of the same type, the 
   * sublist operator takes in an integer representing
   * a start index and an integer representing an end
   * index. The operator iterates through the values
   * in the order it was given, and increases its
   * count by 1 for each value it visits. When the
   * count reaches the value equivalent to the start
   * index, it stores its respective value. It then
   * stores all values until the count is equivalent
   * to the end index value.
   */

  @Test
  public void testSublist1(){
    Integer[] ar = {3, 4, 5};
    Integer[] ar1 = {3};

    List<Integer> l = makeList(ar);
    List<Integer> l1 = makeList(ar1);

    assertEquals(l1, l.subList(0, 1));
  }

  
}
