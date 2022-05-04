package StacksAndQueues;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//Gladius	70
//Shamshir	80
//Katana	90
//Sabre	110

public class BlackSmith {
    private static final int GLADIUS = 70;
    private static final int  SHAMSHIR = 80;
    private static final int KATANA = 90;
    private static final int SABRE = 110;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> countElements = new HashMap<>();
        countElements.put("Gladius", 0);
        countElements.put("Shamshir", 0);
        countElements.put("Katana", 0);
        countElements.put("Sabre", 0);

        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> steels = new ArrayDeque<>();
        for (String token:tokens) {
            steels.offer(Integer.parseInt(token));
        }
        tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> carbons = new ArrayDeque<>();
        for (String token: tokens) {
            carbons.push(Integer.parseInt(token));
        }
        int totalForged = 0;
        while (!steels.isEmpty() && !carbons.isEmpty()){
        int firstIngredient = steels.poll();
        int secondIngredient = carbons.pop();
        int totalSum = firstIngredient + secondIngredient;


        switch (totalSum){
            case GLADIUS:
                int currentGladius = countElements.get("Gladius");
                currentGladius++;
                countElements.put("Gladius", currentGladius);
              totalForged++;
                break;
            case SHAMSHIR:
                int currentShamshir = countElements.get("Shamshir");
                currentShamshir++;
                countElements.put("Shamshir", currentShamshir);
                totalForged++;
                break;
            case KATANA:
                int currentKatana = countElements.get("Katana");
                currentKatana++;
                countElements.put("Katana", currentKatana);
                totalForged++;
                break;
            case SABRE:
                int currentSabre = countElements.get("Sabre");
                currentSabre++;
                countElements.put("Sabre", currentSabre);
                totalForged++;
                break;
            default:
               steels.poll();

                secondIngredient += 5;
                carbons.push(secondIngredient);
                break;

        }



        }
        if (totalForged > 0){
            System.out.printf("You have forged %d swords.%n", totalForged);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (!steels.isEmpty()){
            System.out.println("steel left: " + steels.toString().replaceAll("[\\[\\]]", " "));
        } else System.out.println("steel left: none" );

        if (!carbons.isEmpty()){
            System.out.println("Carbon left: " + carbons.toString().replaceAll("[\\[\\]]", " "));
        } else {
             System.out.println("Carbon left: none" );
        }
        if (countElements.get("Gladius") != 0){
            System.out.println("Gladius: " + countElements.get("Gladius"));

        }
        if (countElements.get("Katana") != 0){
            System.out.println("Katana: " + countElements.get("Katana"));

        }
        if (countElements.get("Sabre") != 0){
            System.out.println("Sabre: " + countElements.get("Sabre"));


        }
        if (countElements.get("Shamshir") != 0){
            System.out.println("Shamshir: " + countElements.get("Shamshir"));


    }
    }
}

