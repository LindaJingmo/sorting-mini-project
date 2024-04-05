import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author HanmoJing
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    for (int i = 0; i < values.length; i++) {
      int pointer = i;
      for (int prev = i - 1; prev >= 0 && order.compare(values[pointer], values[prev]) < 0; prev--) {
        swap(values, pointer, prev);
        pointer = prev;
      }
    }
  } // sort(T[], Comparator<? super T>

  public static <T> void swap(T[] values, int i, int j) {
    T temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  }
} // class InsertionSort
