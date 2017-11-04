import java.util.Scanner;

public class Second {

    public static void main(String[] args){
        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine());

        for (int test = 0; test < t; test++){
            String s = scanner.nextLine();

            if (checkLetter(s)){
                for (int i = 0; i < s.length(); i++){
                    String split = s.substring(i);

                    sum += getSimilarity(s, split);
                    System.out.println(getSimilarity(s, split));
                }

                System.out.println("\n" + "T is "+ t);
                System.out.println("Sum of similarity is " + sum);
            }else {
                System.out.println("you have to put lowercast letters");
            }
        }
        System.out.println("\n"+ t);

    }

    private static boolean checkLetter(String t){
        for (int i = 0; i < t.length(); i++){
            if (!Character.isLowerCase(t.charAt(i)))
                return false;
        }
        return true;
    }

    private static int getSimilarity(String a, String b){
        int i = 0;

        int count;
        if (a.length() > b.length()){
            count = b.length();
        }else {
            count = a.length();
        }
        while (i < count){
            if(a.charAt(i) != b.charAt(i))
                break;

            i++;
        }
        return i;
    }
}