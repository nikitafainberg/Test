import java.util.Scanner;

public class First {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        if (text.contains("@") && Character.isLowerCase(text.charAt(0)) && text.length() < 1000){
            int underscore = checkLetter(text);
            if(underscore != 0){
                if (checkUnderscore(text, underscore))
                    underscore++;

                char simb = '@';
                int chekeNumbers = checkForNumbers(text, underscore);
                if (text.charAt(chekeNumbers) == simb){
                    int start = ++chekeNumbers;
                    int end = start + 14;

                    String domain;
                    try {
                        domain = text.substring(start, end);
                        if (domain.equals("hackerrank.com")){
                            System.out.print("email is done");
                        }else {
                            System.out.print("your domain is wrong");
                        }
                    } catch (Exception e){
                        System.out.print("your domain is wrong");
                    }

                }else {
                    System.out.print("your email is wrong");
                }
            }


        }else {
            System.out.print("your email should start from lowercase letter and contain '@'");
        }
    }

    private static boolean checkUnderscore(String text, int i){
        char underscore = '_';
        if (text.charAt(i) == underscore)
            return true;
        else
            return false;
    }

    private static int checkLetter(String text){
        int i = 0;
        while (i < 6){
            i++;
            if(!Character.isLowerCase(text.charAt(i)))
                break;
        }
        return i;
    }

    private static int checkForNumbers(String text, int underscore){
        int last = underscore + 4;

        while (underscore < last){
            if (!Character.isDigit(text.charAt(underscore)))
                break;
            underscore++;
        }
        return underscore;
    }
}