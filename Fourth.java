import java.util.ArrayList;
import java.util.Scanner;

public class Fourth {

    private static String text;

    public static void main(String[] args){
        ArrayList<ArrayList> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        text = scanner.nextLine();

        ArrayList<Integer> order = numbers();

       for (int i = 0;  i < order.size(); i++){
           if (order.get(i) == 1) {
               list.add(startChecker(i, order));
           }
       }

       for (int i = 0; i < list.size(); i++){
           for (int q = list.size() - 1; q > 0; q--){
               if (list.size() > 1){
                   if(list.get(q).size() > list.get(i).size()){
                       list.remove(i);
                   }else {
                       list.remove(q);
                   }
               }
           }
       }

        for (int sizes = 0; sizes < list.size(); sizes++){
            System.out.println(list.get(sizes).size());
        }
    }

    private static ArrayList<Integer> startChecker(int index, ArrayList<Integer> order){
        ArrayList<Integer> subsequence = new ArrayList<>();
        subsequence.add(1);

        for (int i = index + 1; i < order.size(); i++){
            switch (order.get(i)) {
                case 1:
                    if (subsequence.get(subsequence.size() - 1) <= 1)
                        subsequence.add(1);
                    break;
                case 2:
                    if (subsequence.get(subsequence.size() - 1) <= 2)
                        subsequence.add(2);
                    break;
                case 3:
                    if (subsequence.get(subsequence.size() - 1) <= 3)
                        subsequence.add(3);
                    break;
                case 4:
                    if (subsequence.get(subsequence.size() - 1) <= 4)
                        subsequence.add(4);
                    break;
                case 5:
                    if (subsequence.get(subsequence.size() - 1) <= 5)
                        subsequence.add(5);
                    break;
            }
        }
        return subsequence;
    }

    private static ArrayList<Integer> numbers(){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < text.length(); i++){
            switch (text.charAt(i)) {
                case 'a':
                    numbers.add(1);
                    break;
                case 'e':
                    numbers.add(2);
                    break;
                case 'i':
                    numbers.add(3);
                    break;
                case 'o':
                    numbers.add(4);
                    break;
                case 'u':
                    numbers.add(5);
                    break;
            }
        }

        return numbers;
    }
}