
import java.util.Random;
import java.util.Scanner;

public class Sus {

    public static void main(String[] args) {
        char LetterArray[] = {'�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�'};

        Scanner in = new Scanner(System.in);
        System.out.print("������� ���������� ��������� ���� n: ");

        boolean kindaSus = false;
        int parsedNum = 0;
        String unparsedString;
        
        do {
        	kindaSus = false;
            unparsedString = in.nextLine();
            for (int i = 0; i<= unparsedString.length()-1; i++) {
            	if (Character.isDigit(unparsedString.charAt(i)) == false) {
            		kindaSus = true;
            		break;
            	}
            }
        } while (kindaSus == true);

        try {
            parsedNum = Integer.parseInt(unparsedString);
        } catch (ArrayIndexOutOfBoundsException arre) {
            System.out.println("���������� ��������� ����: " + unparsedString);
        }

        Random rand = new Random();

        for (int i = 0; i < parsedNum; i++) {
            System.out.print(" " + LetterArray[rand.nextInt(LetterArray.length)]);
        }

    }
}