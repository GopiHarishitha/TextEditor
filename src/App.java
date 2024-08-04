import java.util.Scanner;

import notepad.Notepad;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        Notepad notepad = new Notepad(100);

        do{
            System.out.println("Choose your option");
            System.out.println("1. Display the text");
            System.out.println("2. Display the text from given lines");
            System.out.println("3. Insert");
            System.out.println("4. Delete");
            System.out.println("5. Delete from given Lines");
            System.out.println("6. Copy the text");
            System.out.println("7. Paste the text");
            System.out.println("8. Undo your action");
            System.out.println("9. Redo the Action");
            System.out.println("10. Exit");

            System.out.println("Enter the choice: ");
            int choice = scn.nextInt();
            switch (choice) {
                case 1:
                    notepad.display();
                    break;
                case 2:
                    System.out.println("Enter the start and end line numbers");
                    int start = scn.nextInt();
                    int end = scn.nextInt();
                    notepad.display(start,end);
                    break;
                case 3:
                    System.out.println("Enter the text");
                    String text = scn.next();
                    System.out.println("Enter the line number");
                    int lineNumber = Integer.parseInt(scn.next());
                    notepad.insertLine(lineNumber, text);
                    break;
                case 4:
                    System.out.println("Enter the line number:");
                    lineNumber = scn.nextInt();
                    notepad.delete(lineNumber);
                    break;
                case 5:
                    System.out.println("Enter start and end lines");
                    start = scn.nextInt();
                    end = scn.nextInt();
                    notepad.delete(start, end);
                    break;
                case 6:
                    System.out.println("Enter start and end line numbers");
                    start = scn.nextInt();
                    end = scn.nextInt();
                    notepad.copy(start, end);
                    break;
                case 7:
                    System.out.println("Enter the line number:");
                    lineNumber = scn.nextInt();
                    notepad.paste(lineNumber);
                    break;
                case 8:
                    notepad.undo();
                    break;
                case 9:
                    notepad.redo();
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }while(true);
    }
}
