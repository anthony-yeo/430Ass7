import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

  // ONLY USE THIS FUNCTION TO CONSTRUCT LISTS FOR TESTING...
  public <E> List<E>makeList(E[] array){
    return Arrays.asList(array);
  }

  public <E> ArrayList<E>makeArraylist(E[] array){
    return new ArrayList<>(Arrays.asList(array));
  }
  

  @Test
  public void testAdd1(){
    Integer[] ar1 = {3, 4, 5};
    Integer[] ar2 = {3, 4, 5, 6};
    List<Integer> l1 = makeArraylist(ar1);
    List<Integer> l2 = makeArraylist(ar2);
    l1.add(6);
    assertEquals(l1, l2);
  }

  @Test
  public void testAdd2(){
    Integer[] ar1 = {3, 4, 5};
    Integer[] ar2 = {2, 3, 4, 5};
    List<Integer> l1 = makeArraylist(ar1);
    List<Integer> l2 = makeArraylist(ar2);
    l1.add(0, 2);
    assertEquals(l1, l2);
  }

  
  @Test
  public void testAdd3(){
    Integer[] ar1 = {3, 4, 5};
    List<Integer> l1 = makeArraylist(ar1);
    assertTrue(l1.add(0));
  }

  @Test
  public void testAdd4(){
    Integer[] ar1 = {3, 4, 5};
    Integer[] ar2 = {2, 3, 4, 5};
    List<Integer> l1 = makeArraylist(ar1);
    List<Integer> l2 = makeArraylist(ar2);

    IndexOutOfBoundsException thrown = assertThrows(
           IndexOutOfBoundsException.class,
           () -> l1.add(10, 6));
  }

  @Test
  public void testAdd5(){
    Integer[] ar1 = {3, 4, 5};
    List<Integer> l1 = makeList(ar1);

    UnsupportedOperationException thrown = assertThrows(
              UnsupportedOperationException.class, 
              () -> l1.add(1));
  }

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

  @Test
  public void testGet2(){
    Integer[] ar = {3, 4, 5};
    List<Integer> l = makeList(ar);
    
  assertThrows(
              ArrayIndexOutOfBoundsException.class, 
              () -> l.get(10));
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
 * 
 */

  @Test
  public void testRemove1(){
    Integer[] ar = {3, 4, 5};
    List<Integer> l = makeArraylist(ar);
    assertEquals(l.remove(0), 3);
  }

  
  @Test 
  public void testRemove2(){
    String[] ar = {"a", "b", "c"};
    List<String> l = makeArraylist(ar);
    assertTrue(l.remove("a"));
  }

  @Test 
  public void testRemove3(){
    String[] ar = {"a", "b", "c"};
    String[] ar1 = {"b", "c"};
    List<String> l = makeArraylist(ar);
    List<String> l1 = makeArraylist(ar1);

    l.remove("a");
    assertEquals(l1, l);
  }

  @Test 
  public void testRemove4(){
    String[] ar = {"a", "b", "c"};
    String[] ar1 = {"a", "b", "c"};
    List<String> l = makeArraylist(ar);
    List<String> l1 = makeArraylist(ar1);

    l.remove("d");
    assertEquals(l1, l);
  }

  @Test
  public void testRemove5(){
    Integer[] ar = {1, 2, 3};
    List<Integer> l = makeList(ar);

    assertThrows(
              UnsupportedOperationException.class, 
              () -> l.remove(10));
  }


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
