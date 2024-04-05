import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Your Name Here
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

 
  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sort(values, order, 0, values.length);
  }

  private static <T> void sort(T[] values, Comparator<? super T> order, int lb, int ub) {
    if (ub - lb < 2) {
      return;
    }
    int index = partition(values, order, lb, ub);
    sort(values, order, lb, index);
    sort(values, order, index, ub);
  }

  private static <T> int partition(T[] arr, Comparator<? super T> order, int lb, int ub) {
    int mid = (lb + ub) / 2;
    if (order.compare(arr[lb], arr[mid]) > 0){
      InsertionSort.swap(arr, lb, mid);
    }
    if (order.compare(arr[lb], arr[ub - 1]) > 0){
      InsertionSort.swap(arr, lb, ub - 1);
    }
    if (order.compare(arr[mid], arr[ub - 1]) > 0){
    InsertionSort.swap(arr, mid, ub - 1);
    }
    InsertionSort.swap(arr, lb, mid);
    T pivot = arr[lb];
    int small = lb + 1;
    int large = ub;
    while (small < large) {
      if (order.compare(arr[small], pivot) <= 0) {
        small++;
        continue;
      }
      if (order.compare(arr[large - 1], pivot) > 0) {
        large--;
        continue;
      }
      InsertionSort.swap(arr, small, large - 1);
    }
    InsertionSort.swap(arr, lb, small - 1);
    return small - 1;
  } // partition
} // class Quicksort