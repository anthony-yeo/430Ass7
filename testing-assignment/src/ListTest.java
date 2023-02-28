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

  @Test
  public void testLength1() {
    Integer[] ar = {3,4,5};
    List<Integer> l = makeList(ar);
    assertEquals(3, l.size());
  }

  @Test
  public void testIndexOf1() {
    Integer[] ar = {3, 4, 5};
    List<Integer> l = makeList(ar);
    assertEquals(0, l.indexOf(3));
  }

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

}
