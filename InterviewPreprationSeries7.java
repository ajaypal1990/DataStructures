package com.ajay.concepts;

import java.util.*;
import java.util.stream.Collectors;

public class InterviewPreprationSeries7 {
    public static void main(String[] args) {
        // Creating some Transaction objects
        Transaction t1 = new Transaction(1, 100.0);
        Transaction t2 = new Transaction(2, 200.0);
        Transaction t3 = new Transaction(3, 300.0);
        Transaction t4 = new Transaction(4, 400.0);
        Transaction t5 = new Transaction(5, 500.0);

        // Creating some Account objects with transactions
        Account a1 = new Account(101, 5000.0, "Savings", Arrays.asList(t1, t2));
        Account a2 = new Account(102, 3000.0, "Checking", Collections.singletonList(t3));
        Account a3 = new Account(103, 7000.0, "Savings", Arrays.asList(t4, t5));
        Account a4 = new Account(104, 2000.0, "Checking", Collections.emptyList());
        Account a5 = new Account(105, 1500.0, "Investment", Collections.singletonList(t1));

        // Creating some Person objects with multiple accounts
        Person p1 = new Person(1, "Ajay", 30, Arrays.asList(a1, a2));
        Person p2 = new Person(2, "Anshu", 25, Collections.singletonList(a3));
        Person p3 = new Person(3, "Jiya", 35, Arrays.asList(a4, a5));
        // Creating a Map<Person, List<Account>>
        Map<Person, List<Account>> personAccountMap = new HashMap<>();

        personAccountMap.put(p1, p1.getAccounts());
        personAccountMap.put(p2, p2.getAccounts());
        personAccountMap.put(p3, p3.getAccounts());

        // 1. Find all unique account types across all people
        List<String> uniqueAccounts = personAccountMap.values().stream().flatMap(List::stream)
             .map(acc->acc.getType()).distinct().collect(Collectors.toList());

        System.out.println(uniqueAccounts);
        // 2. Generate a list of account balances for each person

        Map<String,List<Integer>> map= personAccountMap.entrySet().stream()
                .collect(Collectors.toMap(entry->entry.getKey().getName(), entry->entry.getValue().stream()
                        .map(acc->(int)acc.getBalance()).collect(Collectors.toList())));

        System.out.println(map);

        // 3. Find the total balance for each person
        //{ajay= [70000], Anshu=8999}

        Map<String, Double> totalBalanceByPerson =  personAccountMap.entrySet().stream()
                .collect(Collectors.toMap(entry->entry.getKey().getName(), entry->entry.getValue().stream()
                        .mapToDouble(acc->acc.getBalance()).sum()));
        System.out.println("Account balances by person: " + totalBalanceByPerson);

        // 5. Identify the person with the maximum number of accounts

        Optional<Person> person = personAccountMap.entrySet().stream().max(Comparator.comparing(personListEntry -> personListEntry.getValue().size()))
                .map(personListEntry -> personListEntry.getKey());

        person.ifPresent(System.out::println);
    }
}
class Person {
    private int id;
    private String name;
    private int age;
    private List<Account> accounts;

    // Constructor
    public Person(int id, String name, int age, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.accounts = accounts;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "', age=" + age + ", accounts=" + accounts + '}';
    }
}

class Account {
    private int accountId;
    private double balance;
    private String type;
    private List<Transaction> transactions;

    // Constructor
    public Account(int accountId, double balance, String type) {
        this.accountId = accountId;
        this.balance = balance;
        this.type = type;
        this.transactions = new ArrayList<>();
    }

    // Additional constructor for transactions
    public Account(int accountId, double balance, String type, List<Transaction> transactions) {
        this.accountId = accountId;
        this.balance = balance;
        this.type = type;
        this.transactions = transactions;
    }

    // Getters
    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Account{accountId=" + accountId + ", balance=" + balance + ", type='" + type + "'}";
    }
}

class Transaction {
    private int transactionId;
    private double amount;

    // Constructor
    public Transaction(int transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    // Getters
    public int getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{transactionId=" + transactionId + ", amount=" + amount + '}';
    }
}