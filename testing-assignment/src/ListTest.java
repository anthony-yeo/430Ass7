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
  
/*
 * Given multiple values of the same type, the Add operator does
 * one of two things, (1) takes in a value of the same type (or null)
 * and adds it to the end of the list, or (2) takes in an integer
 * value and a value of the same type (or null), and adds the value
 * to the list at the index specified by the integer value. In the second
 * case, the operator will shift all values after the index to the
 * right by one, that is, it will add 1 to their indices.
 * 
 * For both cases, if the list is immutable, then the operator will 
 * throw an exception. If the class type of the list does not match
 * the class of the element to be added, a ClassCastException will
 * be thrown. If the add operation is not supported by the list,
 * an UnsupportedOperationException will be thrown.
 * If the element to be added is null, and the list does not support
 * null elements, a NullPointerException will be thrown. If the list
 * is of a fixed size, and the list is already at its maximum capacity,
 * an IllegalStateException will be thrown. If some property of the
 * element to be added prevents it from being added to the list,
 * an IllegalArgumentException will be thrown.
 * 
 * (1) In the first case, the operator will return true to indicate
 * that the value was added to the list, otherwise it will return 
 * false if the value couldn't be added. 
 * (2) In the second case, if the element is successsfully added,
 * the operator will return void. If the index is out of bounds, 
 * then the operator will throw an IndexOutOfBounds exception.
 */

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
* Otherwise the operators continues until
* there are no more values to visit. If that
* is the case, then the operator returns 
* false to indicate that the passed value
* does not exist in the given values. 
*
* If the value that is passed is null and the list
* does not permit null values, then a
* NullPointerException will be thrown. If the type
* of the value that is passed is incompatible
* with the list, a ClassCastException will be
* thrown.
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

  @Test
  public void testContains4(){
    Integer[] ar = {3, 4, 5};
    List<Integer> l = makeList(ar);
    assertFalse(l.contains(null));
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
  *
  * If the index is less than 0, or greater than 
  * or equal to / greater than the size of the list,
  * then the operator will throw an IndexOutOfBounds
  * exception.
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
  * the given values in order, increasing its
  * count by 1 after each value it visits. If the
  * operator visits a value that is equivalent to
  * the value that was passed through, it will
  * return its current count. If it does not visit an 
  * equivalent value, then it will return -1 to
  * represent that it was unable to find the
  * specified value.
  *
  * If the value that is passed is null and the list
  * does not permit null values, then a NullPointerException
  * will be thrown. If the type of the value that is passed
  * is incompatible with the list, a ClassCastException will
  * be thrown.
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
 * Given multiple values of the same type, the remove operator 
 * takes in an integer value and starts a count at 0. It then
 * iterates through all the given values in order, increasing
 * the count by 1 after each value it visits. If the count is
 * equivalent to the integer value that was passed to the remove
 * function, then the operator will remove the value that it is 
 * currently visiting by shifting all the values after the
 * element to be removed to the left by 1 
 * (i.e. subtract 1 from their indices), and return that
 * removed element. If the count is not equivalent to the integer 
 * value that was passed to the remove function, then the operator 
 * will continue to iterate through the values. 
 * 
 * If the integer value that was passed to the remove function is
 * less than 0 or greater than or equal to the size of the list, 
 * then the operator will throw an IndexOutofBoundsException. 
 * If the remove function is not supported by the list, then the
 * operator will throw an UnsupportedOperationException.
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
  * to the end index value. The operator then returns
  * a list of all the values that it stored.
  *
  * If the start index or end index are less than 0, 
  * or greater than or equal to the size of the list, 
  * then the operator will throw an IndexOutOfBounds exception.
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
