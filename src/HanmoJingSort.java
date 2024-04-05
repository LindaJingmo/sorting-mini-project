import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using desined by my own with the help of ChatGPT.
 *
 * @author Hanmo Jing
 */

public class HanmoJingSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new HanmoJingSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  HanmoJingSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  private static final int MIN = 32;

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values.length <= 1) {
      return;
    }
    int length = values.length;

    for (int i = 0; i < length; i += MIN) {
      int left = i;
      int right = Math.min(i + MIN - 1, length - 1);
      InsertionSort(values, order, left, right);
    }

    for (int size = MIN; size < length; size = 2 * size) {
      for (int left = 0; left < length; left += 2 * size) {
        int mid = Math.min(left + size - 1, length - 1);
        int right = Math.min(left + 2 * size - 1, length - 1);
        merge(values, order, left, mid, right);
      }
    }
  }

  private <T> void InsertionSort(T[] values, Comparator<? super T> order, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
      T key = values[i];
      int j = i - 1;
      while (j >= left && order.compare(values[j], key) > 0) {
        values[j + 1] = values[j];
        j--;
      }
      values[j + 1] = key;
    }
  }

  private <T> void merge(T[] values, Comparator<? super T> order, int left, int mid, int right) {
    if (order.compare(values[mid], values[mid + 1]) <= 0) {
      return; 
    }

    int leftSize = mid - left + 1;
    int rightSize = right - mid;

    T[] leftArray = Arrays.copyOfRange(values, left, mid + 1);
    T[] rightArray = Arrays.copyOfRange(values, mid + 1, right + 1);

    int i = 0;
    int j = 0;
    int k = left;
    while (i < leftSize && j < rightSize) {
      if (order.compare(leftArray[i], rightArray[j]) <= 0) {
        values[k] = leftArray[i];
        i++;
      } else {
        values[k] = rightArray[j];
        j++;
      }
      k++;
    }

    while (i < leftSize) {
      values[k] = leftArray[i];
      i++;
      k++;
    }

    while (j < rightSize) {
      values[k] = rightArray[j];
      j++;
      k++;
    }
  }// sort(T[], Comparator<? super T>
} // class AnotherSort