import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EvenSort {

  public static int evenSort(List<Integer> list) {
    int start = 0, end = list.size() - 1, count = 0;
    while (start < end) {
      if (list.get(start) % 2 == 0) ++start;
      else {
        while (list.get(end) % 2 != 0 && end > start) --end;
        Collections.swap(list, start, end);
        ++start;
        --end;
        ++count;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(7);
    list.add(9);
    list.add(4);
    list.add(6);
    list.add(0);
    list.add(3);
    list.add(2);
    list.add(1);
    list.add(9);
    list.add(2);
    list.add(4);
    list.add(6);
    System.out.println("Swap time is " + evenSort(list));
    for (int n : list) System.out.println(n);
  }

}
