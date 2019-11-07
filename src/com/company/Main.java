// banko sistema su vartotoju funkcija///
// susikuriame pakage users//klase User//
//susikuriam vartotojus
//perziureti vartotojus

package com.company;

import com.company.transactions.Transaction;
import com.company.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        // susikuriame lista generic type///<E> reiskia generic tipa ir kur tokio reikes visur galima naudoti "E"
        //
        List<User> users = new ArrayList<User>();
        do {
            printMenu();
            choice = scanner.nextInt();
            //switch yra kaip "if"
            switch (choice) {
                case 1:
                    System.out.println("Iveskite savo varda:");
                    String name = scanner.next();

                    System.out.println("Iveskite savo balansa");
                    double balance = scanner.nextDouble();

                    User user = new User(name, balance);
                    users.add(user);
                    break;
                case 2:
                    printUsers(users);
                    // si kodas haidintas nes mes pasidareme atskira metoda printusers
//                    int i = 0;
//                    for (User u : users) {
//                        System.out.println(i + ". " + u.toString());
//                        i++;
//                    }
                    break;
                case 3:
                    int vartotojoNumeris;
                    System.out.println("Iveskite vartotojo numeri");
                    vartotojoNumeris = scanner.nextInt();
                    users.remove(vartotojoNumeris);
                    break;
                case 4:
                    printUsers(users);
                    System.out.println("Iveskite saskaitos numeri is kurio darysi pavedima");
                    String accountFrom = scanner.next();
                    System.out.println("Iveskite saskaitos numeri i kuri darysi pavedima");
                    String accountTo = scanner.next();
                    System.out.println("Iveskite suma kuria noresite pervesti");
                    double amount = scanner.nextDouble();
                    User from = null;
                    User to = null;

                    for (User u : users) {
                        if (u.getAccountNumber().equals(accountFrom)) {
                            from = u;
                        }
                        if (u.getAccountNumber().equals(accountTo)) {
                            to = u;
                        }

                    }
                    users.remove(from);
                    users.remove(to);


                    Transaction transaction = new Transaction(from, to, amount);
                    List<User> transactedUsers = transaction.execute().stream()
                            .filter(u -> u != null)
                            .collect(Collectors.toList());

                    users.addAll(transactedUsers);
                    printUsers(users);
                    break;
                case 5:
                    printUsers(users);
                    System.out.println("Iveskite pildomos saskaitos numeri");
                    String topUpAccount = scanner.next();
                    System.out.println("Iveskite pildoma suma");
                    double topUp = scanner.nextDouble();

                    for (User u : users) {
                        if (u.getAccountNumber().equals(topUpAccount)) {
                            double balanceAccount = u.getBalance() + topUp;
                            u.setBalance(balanceAccount);
                        }
                    }
                    printUsers(users);
                    break;

                case 0:
                    System.out.println("Baigiame darba");
                    break;
                default:
                    System.out.println("Bloga ivestis");
            }
        } while (choice != 0);
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("_____________________________");
        System.out.println("1. Sukurti vartotoja         I");
        System.out.println("2. Perziureti vartotojus     I");
        System.out.println("3. Istrinti vartotojus       I");
        System.out.println("4. Daryti pavedima           I");
        System.out.println("5. Papildyti saskaita        I");
        System.out.println("_____________________________I");
        System.out.println("       O. Baigti");
    }

    //Galima susikurti nauja metoda kad visa 2 casa naudotu, nes nereikia kartototi kodo kas karta kai reikia printinti
    // useriu lista///

    public static void printUsers(List<User> users) {
        int i = 0;
        for (User u : users) {
            System.out.println(i + ". " + u.toString());
            i++;
        }

    }

    public static void printUser(User u) {
        System.out.println("Varotojas " + u.toString());
    }

}
