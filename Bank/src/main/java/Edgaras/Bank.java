package Edgaras;

import java.util.ArrayList;
import java.util.List;
import static Edgaras.Currency.*;


public class Bank {
    private List<BankAccount> list = new ArrayList<BankAccount>();

    public void createBankAccount(Currency currency, Person person){
        list.add(new BankAccount(currency, person));
    }

    public double getPersonsAccountBalance(Person person){
        try {
            return getPersonsBankAccount(person).getBalance();
        }
        catch(AccountNotFoundException e){
            return 0.0;
        }
    }

    private BankAccount getPersonsBankAccount(Person person) throws AccountNotFoundException{
        return list.stream()
                .filter(bankAccount -> bankAccount.getUser().equals(person))
                .findFirst()
                .orElseThrow(AccountNotFoundException::new);
    }

    public void transfer(Person sender, Person recipient, double amount, Currency currency){
        try {
            BankAccount senderAccount = getPersonsBankAccount(sender);
            BankAccount recipientAccount = getPersonsBankAccount(recipient);

            amount *= currency.getRate();

            recipientAccount.add(amount / recipientAccount.getCurrency().getRate());
            senderAccount.charge(amount / recipientAccount.getCurrency().getRate());
        }
        catch(AccountNotFoundException e){
            System.out.println("Account not found!");
        }

    }
}
