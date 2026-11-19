# 💰 Java Console Expense Tracker

A lightweight, command-line expense tracking application built in Java. This program allows users to set a starting wallet balance, record their daily expenses, categorize them, and monitor their remaining funds in real-time. 

## ✨ Features

* **Initialize Wallet:** Start the application by defining your current wallet balance.
* **Add Expenses:** Record new expenses with a description, amount, and category (e.g., Food, Bills, Entertainment). Automatically deducts the amount from your wallet.
* **Update Expenses:** Correct mistakes or update details of an existing expense using its unique ID. The wallet balance automatically recalculates to reflect the changes.
* **Delete Expenses:** Remove an expense by its ID and automatically refund the amount back to your wallet.
* **View All Expenses:** Display a formatted list of all recorded expenses along with your current remaining wallet balance.

## 🛠️ Tech Stack & Concepts Applied

* **Language:** Java
* **Data Structures:** `ArrayList` (used for dynamic storage of custom `Expense` objects).
* **Object-Oriented Programming (OOP):**
  * **Encapsulation:** Used private fields with getter and setter methods to protect data inside the `Expense`, `Wallet`, and `Account` classes.
  * **Inheritance:** The `Wallet` class extends a base `Account` class to inherit balance management features.
  * **Abstraction:** Defined abstract concepts for financial accounts to separate the internal logic from the main application flow.
* **Control Flow:** Utilized `while` loops and `switch-case` statements to build a continuous, interactive console menu.


