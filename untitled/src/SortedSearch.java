public class SortedSearch {
  public static int countNumbers(int[] sortedArray, int lessThan) {
    if (sortedArray.length == 0) return 0;
    int start = 0, end = sortedArray.length - 1;
    if (sortedArray[0] > lessThan) return 0;
    if (sortedArray[end] < lessThan) return end + 1;
    while (start < end) {
      int mid = (start + end) / 2;
      if (sortedArray[mid] == lessThan) return mid;
      else if (sortedArray[mid] > lessThan) end = --mid;
      else {
        if (mid == sortedArray.length - 1) {
          return ++mid;
        } else if (sortedArray[mid + 1] > lessThan) return ++mid;
        else start = ++mid;
      }
    }
    return start;
  }

  public static void main(String[] args) {
    System.out.println(SortedSearch.countNumbers(new int[]{1, 3, 5, 7}, 2));
  }
}