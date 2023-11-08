//BCT Practical 3: Smart contract for Bank 
pragma solidity ^0.8.0;

contract Bank {
    int private balance; 

    constructor() {
        balance = 0;  
    }

    function getBalance() public view returns (int) {
        return balance;
    }

    function deposit(int amount) public {
        require(amount > 0, "Amount must be greater than 0");
        balance += amount;
    }

    function withdraw(int amount) public {
        require(amount > 0, "Amount must be greater than 0");
        require(amount <= balance, "Insufficient balance");
        balance -= amount;
    }
}
