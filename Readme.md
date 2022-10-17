Following are the major considerations:

1. Balances are always computed from a log of transaction rather than mutating the balances directly. It's more accurate to store immutable transactions and calculate balances from those transactions.

2. Double Entry Accounting - Each entry in the ledger consist of atleast two entries, each representing the transactions for parties involved in the transaction, amount being credited vs debited.

3. application -> Main.java has the main method to run the program.

4. Input is provided using a file. Sample input file is testfile.txt.

