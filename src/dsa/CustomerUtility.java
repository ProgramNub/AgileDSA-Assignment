/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Corporate;
import Entities.Consumer;
import Entities.LinkedList;
import Interfaces.ListInterface;
import java.util.Scanner;

/**
 *
 * @author Desmond Chooi
 */
public class CustomerUtility {

    private static Scanner sc = new Scanner(System.in);

    //Method for View Consumer/Corporate Menu
    public static void displayCustomer(ListInterface<Consumer> Consumer, ListInterface<Corporate> Corporate) {
        String choice = "";
        while (true) {
            System.out.println("======Display Customer List======\n"
                    + "1. View Consumer List\n"
                    + "2. View Corporate List\n"
                    + "3. Exit");
            System.out.print("Please enter 1-3 only:");
            choice = sc.nextLine();
            if (choice.matches("^[1-3]$")) {
                break;
            }
            System.out.println("Invalid choice! Please select only from 1-3!");
        }

        //Method for menu of displaying Consumer/Corporate
        if (choice.equals("1")) {
            DisplayList.displayConsumerList(Consumer);
        } else if (choice.equals("2")) {
            DisplayList.displayCorporateList(Corporate);
        }
    }

    
    

    //Method for Add New Consumer/Corporate Menu
    public static void registerNewCustomer(ListInterface<Consumer> Consumer, ListInterface<Corporate> Corporate) {
        String choice = "";
        while (true) {
            System.out.println("======Registration of New Customer======\n"
                    + "1. Register New Consumer\n"
                    + "2. Register New Corporate\n"
                    + "3. Exit");
            System.out.print("Please enter 1-3 only:");
            choice = sc.nextLine();
            if (choice.matches("^[1-3]$")) {
                break;
            }
            System.out.println("Invalid choice! Please select only from 1-3!");
        }

        //Method for menu of adding new Consumer/Corporate
        if (choice.equals("1")) {
            CustomerUtility.AddConsumer(Consumer);
        } else if (choice.equals("2")) {
            CustomerUtility.AddCorporate(Corporate);
        }
    }

    //Method to add new Consumer
    public static void AddConsumer(ListInterface<Consumer> consumerList) {
        String conName;
        String conType;
        String conAddress;
        String conContact;

        System.out.print("Please enter consumer name: ");
        conName = sc.nextLine();
        while (!conName.matches("[a-zA-Z, ]+")) {
            System.out.println("Please do not leave this space blank!");
            System.out.print("Please enter consumer name: ");
            conName = sc.nextLine();
        }

        System.out.print("Please enter customer type(I = Individual or C = Corporate):");
        conType = sc.nextLine();

        System.out.print("Please enter consumer address: ");
        conAddress = sc.nextLine();
        while (!conAddress.matches("^[A-z0-9\\,\\@\\-\\. ]+$")) {
            System.out.println("Please do not leave this space blank!");
            System.out.print("Please enter consumer address: ");
            conAddress = sc.nextLine();
        }

        System.out.print("Please enter consumer contact number: ");
        conContact = sc.nextLine();
        while (!conContact.matches("\\d{3}-\\d{7}")) {
            System.out.println("Contact number must be in the form XXX-XXXXXXX");
            System.out.print("Please enter consumer contact number: ");
            conContact = sc.nextLine();
        }

        Consumer newConsumer = new Consumer(String.format("CR%04d", consumerList.size() + 1), conName, conType.charAt(0), conAddress, conContact);
        consumerList.add(newConsumer);

    }

    //Method for add new Corporate
    public static void AddCorporate(ListInterface<Corporate> corporateList) {
        String corporateName;
        String corporateType;
        String corporateAddress;
        String corporateContact;
        String corporateCredit;

        System.out.print("Please enter corporate name: ");
        corporateName = sc.nextLine();
        while (!corporateName.matches("^[A-z0-9\\-\\@\\. ]+$")) {
            System.out.println("Please do not leave this space blank!");
            System.out.print("Please enter corporate name: ");
            corporateName = sc.nextLine();
        }

        System.out.print("Please enter corporate type(I = Individual or C = Corporate)");
        corporateType = sc.nextLine();

        System.out.print("Please enter corporate address: ");
        corporateAddress = sc.nextLine();
        while (!corporateAddress.matches("^[A-z0-9\\,\\@\\-\\. ]+$")) {
            System.out.println("Please do not leave this space blank!");
            System.out.print("Please enter corporate address: ");
            corporateAddress = sc.nextLine();
        }

        System.out.print("Please enter customer contact number: ");
        corporateContact = sc.nextLine();
        while (!corporateContact.matches("^\\d{8,20}$")) {
            System.out.println("Invalid Format!Please enter the correct format!");
            System.out.print("Please enter customer contact number: ");
            corporateContact = sc.nextLine();
        }

        System.out.print("Please enter corporate credit limit: ");
        corporateCredit = sc.nextLine();
        while (!corporateCredit.matches("^\\d+\\.?\\d+$")) {
            System.out.println("Invalid Format Used! Please try only with floating digits only!");
            System.out.print("Please enter corporate credit limit: ");
            corporateCredit = sc.nextLine();
        }

        Corporate newCorporate = new Corporate(String.format("CP%04d", corporateList.size() + 1), corporateName, corporateType.charAt(0), corporateAddress, corporateContact, Double.parseDouble(corporateCredit));
        corporateList.add(newCorporate);
    }

    //Method for Update Consumer/Corporate Menu
    public static void updateCustomer(ListInterface<Consumer> Consumer, ListInterface<Corporate> Corporate) {
        String choice = "";
        while (true) {
            System.out.println("======Update Customer Details======\n"
                    + "1. Update Consumer Details\n"
                    + "2. Update Corporate Details\n"
                    + "3. Exit");
            System.out.print("Please enter 1-3 only:");
            choice = sc.nextLine();
            if (choice.matches("^[1-3]$")) {
                break;
            }
            System.out.println("Invalid choice! Please select only from 1-3!");
        }

        //Method for menu of updating Consumer/Corporate
        if (choice.equals("1")) {
            CustomerUtility.updateConsumer(Consumer);
        } else if (choice.equals("2")) {
            CustomerUtility.updateCorporate(Corporate);
        }
    }

    //Method for update Consumer
    public static void updateConsumer(ListInterface<Consumer> cons) {
        String choice = "";
        String conName;
        String conAddress;
        String conContact;
        boolean consumerFound = false;
        Consumer consumer = null;

        DisplayList.displayConsumerList(cons);
        System.out.println("Select the consumer by entering the Consumer ID!");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextLine();

        for (int i = 0; i < cons.size(); i++) {
            if (cons.get(i).getCustID().equals(choice)) {
                consumer = cons.get(i);
                consumerFound = true;
                break;

            }

        }

        if (consumerFound) {

            System.out.println("Please enter consumer name:");
            conName = scanner.nextLine();
            while (!conName.matches("[a-zA-Z, ]+")) {
                System.out.println("Please do not leave this space blank!");
                System.out.print("Please enter consumer name: ");
                conName = sc.nextLine();
            }

            System.out.println("Please enter consumer address:");
            conAddress = scanner.nextLine();
            while (!conAddress.matches("^[A-z0-9\\,\\@\\-\\. ]+$")) {
                System.out.println("Please do not leave this space blank!");
                System.out.print("Please enter consumer address: ");
                conAddress = sc.nextLine();
            }

            System.out.println("Enter Consumer Contact Number:");
            conContact = scanner.nextLine();
            while (!conContact.matches("\\d{3}-\\d{7}")) {
                System.out.println("Contact number must be in the form XXX-XXXXXXX");
                System.out.print("Please enter consumer contact number: ");
                conContact = sc.nextLine();
            }

            //Update Consumer Details
            consumer.setConsumerName(conName);
            consumer.setCustAddress(conAddress);
            consumer.setCustContact(conContact);
        } else {
            System.out.println("No Consumer ID matched with the ones in the list!");
        }
    }

    //Method for update Corporate
    public static void updateCorporate(ListInterface<Corporate> corp) {
        String choice = "";
        String corpName;
        String corpAddress;
        String corpContact;
        String corpCreditLimit;
        boolean corpFound = false;
        Corporate corporate = null;

        DisplayList.displayCorporateList(corp);
        System.out.println("Select the corporate by entering the Corporate ID!");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextLine();

        for (int i = 0; i < corp.size(); i++) {
            if (corp.get(i).getCustID().equals(choice)) {
                corporate = corp.get(i);
                corpFound = true;
                break;

            }

        }

        if (corpFound) {

            System.out.print("Please enter Corporate Name:");
            corpName = sc.nextLine();
            while (!corpName.matches("^[A-z0-9\\-\\@\\. ]+$")) {
                System.out.println("Please do not leave this space blank!");
                System.out.print("Please enter corporate name: ");
                corpName = sc.nextLine();
            }

            System.out.print("Please enter Corporate Address:");
            corpAddress = sc.nextLine();
            while (!corpAddress.matches("^[A-z0-9\\,\\@\\-\\. ]+$")) {
                System.out.println("Please do not leave this space blank!");
                System.out.print("Please enter corporate address: ");
                corpAddress = sc.nextLine();
            }

            System.out.print("Please enter Corporate Contact Number:");
            corpContact = sc.nextLine();
            while (!corpContact.matches("^\\d{8,20}$")) {
                System.out.println("Invalid Format!Please enter the correct format!");
                System.out.print("Please enter corporate contact number: ");
                corpContact = sc.nextLine();
            }

            System.out.print("Corporate Credit Limit:");
            corpCreditLimit = sc.nextLine();
            while (!corpCreditLimit.matches("^\\d+\\.?\\d+$")) {
                System.out.println("Invalid Format Used! Please try only with floating digits only!");
                System.out.print("Please enter corporate credit limit: ");
                corpCreditLimit = sc.nextLine();
            }

            //Update Consumer Details
            corporate.setCorporateName(corpName);
            corporate.setCustAddress(corpAddress);
            corporate.setCustContact(corpContact);
            corporate.setCreditLimit(Double.parseDouble(corpCreditLimit));

        } else {
            System.out.println("No Corporate ID matched with the ones in the list!");
        }
    }
}
