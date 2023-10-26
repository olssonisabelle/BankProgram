package Handelsakademin.bankprogram;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        Account account1 = new Account("Isabelle Olsson",1234, 20000, 1231);
        Account account2 = new Account("Isabelle Olsson",5678, 100000, 1232);
        Account account3 = new Account("Isabelle Olsson",9123, 500, 1233);

        do {
            System.out.println("Välkommen! Välj ett av alternativen: ");
            System.out.println("1. Sätt i ditt kort. ");
            System.out.println("2. Lämna. ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ange din kod: ");
                    int userCode = scanner.nextInt();
                    Account selectedAccount = null;
                    if (userCode == account1.getPin()) {
                        selectedAccount = account1;
                    } else if (userCode == account2.getPin()) {
                        selectedAccount = account2;
                    } else if (userCode == account3.getPin()) {
                        selectedAccount = account3;
                    }

                    if (selectedAccount != null) {
                        System.out.println("Inloggning lyckades för " + selectedAccount.getAccountHolder());
                      do {
                          System.out.println("Välj vad du vill göra: ");
                          System.out.println("1. Sätt in pengar. ");
                          System.out.println("2. Ta ut pengar. ");
                          System.out.println("3. Visa saldo. ");
                          System.out.println("4. Lämna. ");

                          int choice2 = scanner.nextInt();

                          switch (choice2) {
                              case 1:
                                  System.out.println("Välj hur många av varje sedel/mynt du vill sätta in:");
                                  System.out.print("Antal 1000-lappar: ");
                                  int tusenlappar = scanner.nextInt();
                                  System.out.print("Antal 500-lappar: ");
                                  int femhundralappar = scanner.nextInt();
                                  System.out.print("Antal 100-lappar: ");
                                  int tvahundralappar = scanner.nextInt();
                                  System.out.print("Antal 200-lappar: ");
                                  int hundralappar = scanner.nextInt();
                                  System.out.print("Antal 50-lappar: ");
                                  int femtiolappar = scanner.nextInt();
                                  System.out.print("Antal 20-lappar: ");
                                  int tjugolappar = scanner.nextInt();
                                  System.out.print("Antal 10-kronor: ");
                                  int tior = scanner.nextInt();
                                  System.out.print("Antal 5-kronor: ");
                                  int femmor = scanner.nextInt();
                                  System.out.print("Antal 1-kronor: ");
                                  int enkronor = scanner.nextInt();

                                  double total = tusenlappar * 1000 + femhundralappar * 500 + tvahundralappar * 200 +
                                  hundralappar * 100 + femtiolappar * 50 + tjugolappar * 20 + tior * 10 + femmor * 5 + enkronor;
                                  selectedAccount.deposit(total);
                                  System.out.println("Du har satt in " + total + " kronor.");
                                  System.out.println("Aktuellt saldo: " + selectedAccount.getBalance());
                                  break;
                              case 2:
                                  System.out.print("Ange önskat belopp att ta ut: ");
                                  double uttagsBelopp = scanner.nextDouble();

                                  if (uttagsBelopp > selectedAccount.getBalance()) {
                                      System.out.println("Otillräckligt belopp för uttag.");
                                  } else {
                                      selectedAccount.withdraw(uttagsBelopp);
                                      System.out.println("Du har tagit ut " + uttagsBelopp + " kr. Du får följande sedlar och mynt:");

                                      int[] values = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
                                      String[] valörer = {"Tusenlappar", "Femhundralappar", "Tvåhundralappar", "Hundralappar", "Femtiolappar", "Tjugolappar", "Tior", "Femmor", "Enkronor"};
                                      int[] antal = new int[values.length];

                                      for (int i = 0; i < values.length; i++) {
                                          antal[i] = (int) (uttagsBelopp / values[i]);
                                          uttagsBelopp %= values[i];
                                          if (antal[i] > 0) {
                                              System.out.println(valörer[i] + ": " + antal[i]);
                                          }
                                      }
                                  }
                                  break;
                              case 3:
                                  System.out.println("Aktuellt saldo: " + selectedAccount.getBalance());
                                  break;
                              case 4:
                                  System.out.println("Du har valt att lämna.");
                                  running = false;
                                  break;
                              default:
                                  System.out.println("Ogiltigt val. Försök igen.");
                          }
                      } while (running);
                    } else {
                        System.out.println("Fel kod. Försök igen.");
                    }
                    break;
                case 2:
                    running = false;
                    System.out.println("Du har valt att lämna.");
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
                    break;
            }
        } while (running);
    }
}
