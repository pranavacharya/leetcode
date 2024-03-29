
public class SimpleBankSystem {

    private long[] balance;

    public SimpleBankSystem(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (withdraw(account1, money)) {
            if (deposit(account2, money)) {
                return true;
            } else {
                deposit(account1, money);
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean deposit(int account, long money) {
        if (account - 1 >= this.balance.length) {
            return false;
        }
        this.balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account - 1 >= this.balance.length) {
            return false;
        }
        if (money <= this.balance[account - 1]) {
            this.balance[account - 1] -= money;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        SimpleBankSystem bank = new SimpleBankSystem(new long[]{10, 100, 20, 50, 30});
        System.out.println(bank.withdraw(3, 10));    // return true, account 3 has a balance of $20, so it is valid to withdraw $10.
        // Account 3 has $20 - $10 = $10.
        System.out.println(bank.transfer(5, 1, 20)); // return true, account 5 has a balance of $30, so it is valid to transfer $20.
        // Account 5 has $30 - $20 = $10, and account 1 has $10 + $20 = $30.
        System.out.println(bank.deposit(5, 20));     // return true, it is valid to deposit $20 to account 5.
        // Account 5 has $10 + $20 = $30.
        System.out.println(bank.transfer(3, 4, 15)); // return false, the current balance of account 3 is $10,
        // so it is invalid to transfer $15 from it.
        System.out.println(bank.withdraw(10, 50));   // return false, it is invalid because account 10 does not exist.
    }
}
