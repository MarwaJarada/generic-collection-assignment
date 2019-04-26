package task1;

import java.util.*;
/**
 * @author Marwa N. Jarada
 * Using generic collection to get the sum and average of random numbers in a linked list
 */
public class Task1 {
    public static void main(String[] args) {
        Random random=new Random();
        LinkedList<Integer> randomNumbers=new LinkedList<Integer>();
        for (int x=0 ; x<25 ; x++){
            randomNumbers.add(random.nextInt(101));
        }
        int sumOfNumbersInLinkedlist = randomNumbers.stream().mapToInt(Integer::intValue).sum();
        Double averageOfRandomNumbersInLinkedlist =  randomNumbers.stream().mapToDouble
                (Integer::doubleValue).average().getAsDouble();
        System.out.println("Before ordering the linked list"+randomNumbers);
        Collections.sort(randomNumbers);
        System.out.println("After ordering the linked list"+randomNumbers);
        System.out.println("The sum :"+ sumOfNumbersInLinkedlist);
        System.out.println("The average :"+ averageOfRandomNumbersInLinkedlist);



    }
}
