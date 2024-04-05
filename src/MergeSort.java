import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Hanmo Jing
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sort(values, 0, values.length, order);
  } // sort(T[] values, Comparator<? super T> order) {

  static <T> void sort(T[] values, int lo, int hi, Comparator<? super T> order) {
    if (hi - lo <= 1) {
      return;
    }
    int mid = (lo + hi) / 2;
    sort(values, lo, mid, order);
    sort(values, mid, hi, order);
    merge(values, lo, mid, hi, order); 
  } // sort(T[] values, int lo, int hi, Comparator<? super T> order) 

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] values, int lo, int mid, int hi, Comparator<? super T> comparator) {
    T[] helper = Arrays.copyOfRange(values, lo, hi);
    int i = 0;
    //left half
    int j = 0; 
    //right half
    int k = mid - lo; 
    while (j < mid - lo && k < hi - lo) {
      if (comparator.compare(helper[j], helper[k]) < 0) {
        values[i + lo] = helper[j];
        i++;
        j++;
      } else {
        values[i + lo] = helper[k];
        i++;
        k++;
      }
    }

    while (j < mid - lo) {
      values[i + lo] = helper[j];
      i++;
      j++;
    }

    while (k < hi - lo) {
      values[i + lo] = helper[k];
      i++;
      k++;
    }
  } // merge(T[] values, int lo, int mid, int hi, Comparator<? super T> comparator) 
}