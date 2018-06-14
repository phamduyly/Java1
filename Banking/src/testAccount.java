
import javax.swing.*;

public class testAccount {
    public static void main(String args[]) {
        int y;
        boolean loged = false;

            /*com.codebind.App.Account mum = new com.codebind.App.Account("s123","Mercy Brown",1000.0);
            com.codebind.App.Account dad = new com.codebind.App.Account("s124","Mercy Bro1n",2000.0);
            */
        Account[] accountArray = new Account[3];
        accountArray[0] = new Account("0", "000", "Mercy Brown", 1000.0);
        accountArray[1] = new Account("1", "111", "Mercy Bro1n", 2000.0);

        //Step1: ask how much

        int choice1 = Integer.parseInt(JOptionPane.showInputDialog("1. if you have account - 2. if you want register"));
        if (choice1 == 2) {

            //Creat new account
            for (int x = 0; x < 3; x++) {
                String accId = JOptionPane.showInputDialog("ID");
                String accPass = JOptionPane.showInputDialog("Pass");
                String accName = JOptionPane.showInputDialog("Name");
                double accAmount = Double.parseDouble(JOptionPane.showInputDialog("Amount"));
                accountArray[x] = new Account(accId, accPass, accName, accAmount);
                JOptionPane.showMessageDialog(null, "Done" + "You information is " + " " + accountArray[x].getName() + " " + accountArray[x].getID() + " " + accountArray[x].getBalance());
                //Todo: after done, loop back to step 1 OR go inside the program - Possible reason, scope.
            }
        } else {

            String id = JOptionPane.showInputDialog("id");
            String pass = JOptionPane.showInputDialog("Input your password");

            for (int i = 0; i < 2; i++) {
                y = i;
                while (id.contains(accountArray[i].getID()) && pass.contains(accountArray[i].getPass())) {
                    JOptionPane.showMessageDialog(null, "Loged In");

                    int choice = Integer.parseInt(JOptionPane.showInputDialog("Choose you option: 0.Deposit 1.withdraw 2.Transfer 3.Payment 4.Balance 5.See information 9.Cancel"));
                    //9: cancel

// Todo: not loop yet
                    //while done loop - procedd loop when the condition is satisfied.
                    while (choice != 9) {
                        //Deposit
                        if (choice == 0) {
                            double amount = accountArray[y].getAmount();
                            accountArray[y].deposit(amount);
                            JOptionPane.showMessageDialog(null, "Succesully. Balance:" + accountArray[y].getBalance());

                            //Withdraw
                        } else if (choice == 1) {
                            double amount = accountArray[y].getAmount();
                            if (accountArray[y].withdraw(amount))
                                JOptionPane.showMessageDialog(null, accountArray[y].getName() + "withdraw DONE");
                            else JOptionPane.showMessageDialog(null, "Insufficient funds");

                            //transfer
                        } else if (choice == 2) {
                            double amount = accountArray[y].getAmount();
                            int m = Integer.parseInt(JOptionPane.showInputDialog("input ID of the person that you wish to transfer to"));

                            if (accountArray[y].transfer(accountArray[m], amount))
                                JOptionPane.showMessageDialog(null, accountArray[y].getName() + "transfer to " + accountArray[m].getName() + "DONE");
                                //This else work because if have no ; at the bottom.
                            else JOptionPane.showMessageDialog(null, "Insufficient funds");

                            //Payment - bull
                        } else if (choice == 3) {
                            double amount = accountArray[y].getAmount();
                            if (accountArray[y].withdraw(amount))
                                JOptionPane.showMessageDialog(null, accountArray[y].getName() + "payment DONE");
                            else JOptionPane.showMessageDialog(null, "Insufficient funds");
                            //balance
                        } else if (choice == 4) {

                            JOptionPane.showMessageDialog(null, "Balance of " + accountArray[y].getName() + " is " + accountArray[y].getBalance());

                            //See information
                        } else if (choice == 5) {
                            JOptionPane.showMessageDialog(null, "You information is " + " " + accountArray[y].getName() + " " + accountArray[y].getID() + " " + accountArray[y].getBalance());

                        } else {
                            choice = Integer.parseInt(JOptionPane.showInputDialog("Choose you option: 0.Deposit 1.withdraw 2.Transfer 3.Payment 4.Balance 5.See information 9.Cancel"));
                        }
                    }
                        JOptionPane.showInputDialog("thank you!");
                        break;


                }

            }
            // Fixe this latter
            if (loged = false)
                //This not working
                for (int k = 0; k < 2; ) {
                    id = JOptionPane.showInputDialog("Re-input id");
                    pass = JOptionPane.showInputDialog("Re-input password");
                }
            JOptionPane.showMessageDialog(null, "you reached 3 times max");
        }
    }
}
