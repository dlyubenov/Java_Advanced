package ExamPrep_02_01;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] armory = new String[size][size];
        int currentRow = 0;
        int currentCol = 0;

        int firstMirrorRow = 0;
        int firstMirrorCol = 0;

        int secondMirrorRow = 0;
        int secondMirrorCol = 0;

        boolean weFoundFirstMirror = false;
        boolean outOfTrack = false;

        for (int row = 0; row < size; row++){
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < size;col++){
             armory[row][col] = input[col];

                if (armory[row][col].equals("A")) {
                    currentCol = col;
                    currentRow = row;
                }
                if (armory[row][col].equals("M") && !weFoundFirstMirror){
                   firstMirrorCol = col;
                   firstMirrorRow = row;
                   weFoundFirstMirror = true;
                }
                if (armory[row][col].equals("M") && weFoundFirstMirror){
                    secondMirrorCol = col;
                    secondMirrorRow = row;
                }
            }
        }
        int coins = 0;
        while (coins < 65){
            String command = scanner.nextLine();

            int oldRow = currentRow;
            int oldCol = currentCol;

            switch (command){
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }

            if (currentCol < 0 || currentRow < 0 || currentCol >= size || currentRow >= size){
                outOfTrack = true;
                armory[oldRow][oldCol] = "-";
                break;
            }
            if (currentCol == firstMirrorCol && currentRow == firstMirrorRow){
                currentCol = secondMirrorCol;
                currentRow = secondMirrorRow;
                armory[oldRow][oldCol] = "-";
                armory[firstMirrorRow][firstMirrorCol] = "-";
                armory[currentRow][currentCol] = "A";
            } else if (currentCol == secondMirrorCol && currentRow == secondMirrorRow){
                currentCol = firstMirrorCol;
                currentRow = firstMirrorRow;
                armory[oldRow][oldCol] = "-";
                armory[secondMirrorRow][secondMirrorCol] = "-";
                armory[currentRow][currentCol] = "A";
            } else if (armory[currentRow][currentCol].equals("-")){
                armory[oldRow][oldCol] = "-";
                armory[currentRow][currentCol] = "A";
            } else {
                coins += Integer.parseInt(armory[currentRow][currentCol]);
                armory[oldRow][oldCol] = "-";
                armory[currentRow][currentCol] = "A";
            }
        }
        if (outOfTrack){
            System.out.println("I do not need more swords!");
           
        } else if (coins >= 65){
            System.out.println("Very nice swords, I will come back for more!");
           
        }
        System.out.printf("The king paid %d gold coins.%n", coins);

        for (int row = 0; row < size; row++){
            for (int col = 0; col < size; col++){
                System.out.print(armory[row][col]);
            }
            System.out.println();
        }
    }
}
