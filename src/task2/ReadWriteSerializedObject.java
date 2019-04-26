package task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Marwa N. Jarada
 */

public class ReadWriteSerializedObject extends JFrame{
    JPanel mainPanel;
    JPanel printBtnPanel;

    ArrayList<Account> objectArray=new ArrayList<>();
    JLabel accountNameLabel;
    JLabel accountNumLabel;
    JLabel accountBalanceLabel;

    JTextField nametxt;
    JTextField numtxt;
    JTextField balancrtxt;
    JButton decsendingPrintBtn;
    JButton writeBtn;
    JButton readlBtn;

    // Classes we will use to read/write our objects from/into file:
    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;
    FileInputStream fileInputStream;
    ObjectInputStream objectInputStream;

    public static void main(String[] args) throws FileNotFoundException {
        ReadWriteSerializedObject readWriteSerializedObject=new ReadWriteSerializedObject();

    }


    public ReadWriteSerializedObject(){
        setLocationRelativeTo(null);
        setSize(300,200);
        setLayout(new FlowLayout());
        mainPanel=new JPanel(new GridLayout(4,2,6,0));
        printBtnPanel=new JPanel(new FlowLayout());
        accountNameLabel=new JLabel("Enter Account Name:");
        accountNumLabel=new JLabel("Enter Account Number :");
        accountBalanceLabel=new JLabel("Enter Balance Number :");
        nametxt=new JTextField();
        numtxt=new JTextField();
        balancrtxt=new JTextField();
        writeBtn=new JButton("Write");
        readlBtn=new JButton("Read");
        decsendingPrintBtn=new JButton("Print After descening Order");
        mainPanel.add(accountNameLabel);
        mainPanel.add(nametxt);
        mainPanel.add(accountNumLabel);
        mainPanel.add(numtxt);
        mainPanel.add(accountBalanceLabel);
        mainPanel.add(balancrtxt);
        mainPanel.add(writeBtn);
        mainPanel.add(readlBtn);
        mainPanel.add(decsendingPrintBtn,8);
        printBtnPanel.add(decsendingPrintBtn);
        add(mainPanel);
        add(printBtnPanel);
        ActionListener actionListener=new ActionListener();
        writeBtn.addActionListener(actionListener);
        readlBtn.addActionListener(actionListener);
        decsendingPrintBtn.addActionListener(actionListener);
        setVisible(true);

    }

    public class ActionListener implements java.awt.event.ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String myAction = actionEvent.getActionCommand().toLowerCase();
            switch (myAction){
                case "write":
                    writeAccountObject();
                    break;
                case "read":
                    try {
                        readAccountObject();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case ("print after descening order"):
                    decsendingOrder();
                    break;
            }
        }
    }

    public void writeAccountObject(){
        try {
            fileOutputStream=new FileOutputStream("D:\\4thSemester\\" +
                    "Programming3\\GenericCollection\\Objects file" +
                    ".ser");
            objectOutputStream=new ObjectOutputStream(fileOutputStream);

            Account myAccount=new Account(nametxt.getText(),
                    Double.parseDouble(balancrtxt.getText()),
                    Integer.parseInt(numtxt.getText()));
            objectArray.add(myAccount);

            objectOutputStream.writeObject(myAccount);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readAccountObject() throws IOException {
        try {
            fileInputStream=new FileInputStream("D:\\4thSemester\\" +
                    "Programming3\\file\\Objects file" +
                    ".ser");
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object myObject = objectInputStream.readObject();
            System.out.println(myObject);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            fileInputStream.close();
            objectInputStream.close();
        }
    }

    public void decsendingOrder(){
        Collections.sort(objectArray, (account, t1) -> {
            if (t1.getAccBalance()>account.getAccBalance()){
                return 1;
            }else if(t1.getAccBalance()<account.getAccBalance()){
                return -1;
            }else{
                return 0;
            }
        });

        objectArray.stream().forEach(System.out::println);
    }


    }
