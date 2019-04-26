//
//package task2;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
///**
// * @author Marwa N. Jarada
// *
// */
//public class DescendingSort {
//
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FileInputStream file = new FileInputStream("Objects file.ser");
//        ObjectInputStream objectInputStream=new ObjectInputStream(file);
//        Account object=(Account) objectInputStream.readObject();
//        objectArray.add(object);
//        objectArray.stream().sorted(Comparator.comparing(Account::getAccBalance)).forEach(System.out::println);
//
//        Collections.sort(objectArray, new Comparator<Account>() {
//            @Override
//            public int compare(Account account, Account t1) {
//                if (t1.getAccBalance()>account.getAccBalance()){
//                    return 1;
//                }else if(t1.getAccBalance()<account.getAccBalance()){
//                    return -1;
//                }else{
//                    return 0;
//                }
//            }
//        });
//
//        objectArray.stream().forEach(System.out::println);
//
//    }
//
//}
