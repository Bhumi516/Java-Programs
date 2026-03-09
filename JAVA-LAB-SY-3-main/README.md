# ☕ Java Programming Lab

**Name:** Atharv Kate  
**Roll No:** 15  
**Subject:** Java Programming Lab  

---

## 📁 Repository Structure

```
Java-Lab/
│
├── Experiment-1/    — Implementation of a problem statement using class and object
│
├── Experiment-2/    — Design and develop programs for different types of inheritance
│   ├── EmployeeTest.java
│   ├── areaCalculator.java
│   ├── StaticDemo.java
│   └── SortNames.java
│
├── Experiment-3/    — Design and develop programs for different types of inheritance
│   ├── BankAccountDemo.java
│   ├── Company.java
│   ├── ShapeDemo.java
│   └── MultilevelInheritance.java
│
├── Experiment-4/    — Implementation of stack/queue operations using Interface
│   ├── StackQueueDemo.java
│   ├── StackInterfaceDemo.java
│   ├── ShapeInterfaceDemo.java
│   └── StudentResult.java
│
├── Experiment-5/    — Implement a program for creation of user defined packages
│   ├── LibraryManagement/
│   │   ├── Book.java
│   │   └── Member.java
│   ├── LibrarySystem.java
│   ├── Ecommerce/
│   │   ├── Product.java
│   │   ├── Customer.java
│   │   └── Order.java
│   ├── EcommerceApp.java
│   ├── MathOperations/
│   │   └── MathFunctions.java
│   ├── MathApp.java
│   ├── mypackage/
│   │   └── MathUtils.java
│   └── PackageDemo.java
│
├── Experiment-6/    — Implementation of a program for Exception Handling
│   ├── ExceptionDemo.java
│   ├── BankAccountDemo.java
│   ├── OddNumberDemo.java
│   ├── ExceptionHandlingDemo/
│   │   ├── DivisionException.java
│   │   └── Calculator.java
│   └── CalculatorApp.java
│
└── Experiment-7/    — Implementation of different I/O operations using I/O Streams
    ├── IOStreamsDemo.java
    ├── ReadExternalFile.java
    ├── StudentDataStream.java
    └── FileAnalyzer.java
```

---

## 📋 List of Experiments

| No. | Name of Experiment |
|-----|--------------------|
| 1 | Implementation of a problem statement using class and object |
| 2 | Design and develop programs for different types of inheritance |
| 3 | Design and develop programs for different types of inheritance |
| 4 | Implementation of stack/queue operations using Interface |
| 5 | Implement a program for creation of user defined packages and its use |
| 6 | Implementation of a program for Exception Handling |
| 7 | Implementation of different I/O operations using I/O Streams |

---

## 📘 Experiment 1 — Class and Object
> *(Done by yourself)*

---

## 📗 Experiment 2 — Classes and Objects / Fundamental Programs

| File | Description |
|------|-------------|
| `EmployeeTest.java` | Employee class with first name, last name, monthly salary. Demonstrates constructors, getters/setters, and yearly salary with 10% raise |
| `areaCalculator.java` | Area class with `setDim()` and `getArea()` methods. Reads length and breadth from keyboard |
| `StaticDemo.java` | Demonstrates static variables, static methods, and static initializer blocks |
| `SortNames.java` | Takes 10 names as input and sorts them in alphabetical order using bubble sort |

---

## 📗 Experiment 3 — Inheritance

| File | Description |
|------|-------------|
| `BankAccountDemo.java` | Single Inheritance — `BankAccount` → `SavingsAccount`. Overrides `withdraw()` to prevent balance below Rs.100 |
| `Company.java` | Hierarchical Inheritance — `Employee` → `Manager`, `Developer`, `Programmer`. Each overrides `calculateBonus()` |
| `ShapeDemo.java` | Abstract class — `Shape` → `Rectangle`, `Triangle`. Demonstrates abstract method `area()` |
| `MultilevelInheritance.java` | Multilevel Inheritance — `Student` → `Test` → `Result`. Calculates total, percentage, and pass/fail |

---

## 📘 Experiment 4 — Interface

| File | Description |
|------|-------------|
| `StackQueueDemo.java` | Stack and Queue implementation using Java built-in collections |
| `StackInterfaceDemo.java` | Stack interface with `push()`, `pop()`, `display()`, `overflow()`, `underflow()`. Implemented by `IntegerStack` |
| `ShapeInterfaceDemo.java` | `Shape` interface → `Rectangle` and `Triangle` implement `area()`. Includes polymorphism demo |
| `StudentResult.java` | `Student` → `Test` → `Result` + `Sports` interface. Displays total marks and result |

---

## 📙 Experiment 5 — Packages

| Package / File | Description |
|----------------|-------------|
| `LibraryManagement/` | `Book` (title, author, ISBN) and `Member` (borrowBook, returnBook) |
| `LibrarySystem.java` | Main app — creates books and members, demonstrates borrow and return |
| `Ecommerce/` | `Product`, `Customer`, `Order` with `placeOrder()`, `calculateTotal()`, `displayOrder()` |
| `EcommerceApp.java` | Main app — places orders, shows stock updates and order summary |
| `MathOperations/` | `MathFunctions` with `floor()`, `ceil()`, `round()`, `sqrt()`, `power()`, `absolute()` |
| `MathApp.java` | Main app — applies math functions on a list of numbers |
| `mypackage/` | Basic `MathUtils` with add, subtract, multiply, divide |
| `PackageDemo.java` | Main app — demonstrates `mypackage` usage |

---

## 📕 Experiment 6 — Exception Handling

| File | Description |
|------|-------------|
| `ExceptionDemo.java` | Built-in exceptions — `ArithmeticException`, `ArrayIndexOutOfBoundsException`, `NumberFormatException` |
| `BankAccountDemo.java` | User-defined `LowBalanceException` and `NegativeNumberException` with `deposit()` and `withdraw()` |
| `OddNumberDemo.java` | Custom `OddNumberException` — thrown when an odd number is passed to `checkEven()` |
| `ExceptionHandlingDemo/` | Package with `DivisionException` and `Calculator` class |
| `CalculatorApp.java` | Main app — demonstrates `divide()` with `DivisionException` handling |

---

## 📒 Experiment 7 — I/O Streams

| File | Description |
|------|-------------|
| `IOStreamsDemo.java` | Basic file read/write using `FileInputStream`, `FileOutputStream`, `BufferedReader`, `BufferedWriter` |
| `ReadExternalFile.java` | Reads a file from outside the program directory using `FileInputStream` and `BufferedReader` |
| `StudentDataStream.java` | Stores student info (name, age, weight, height, city, phone) using `DataOutputStream` and retrieves using `DataInputStream` |
| `FileAnalyzer.java` | Reads a text file and counts total vowels, total words, and occurrences of character `'a'` |

---

## 🚀 How to Compile and Run

```bash
# General
javac FileName.java
java ClassName

# For packages (Experiment 5)
javac -d . PackageName/ClassName.java
javac MainFile.java
java MainFile

# For Experiment 6 package
javac -d . ExceptionHandlingDemo/DivisionException.java
javac -d . ExceptionHandlingDemo/Calculator.java
javac CalculatorApp.java
java CalculatorApp
```

---

## 🔑 Key Concepts Covered

- **OOP** — Classes, Objects, Constructors, Encapsulation, `this` keyword
- **Inheritance** — Single, Hierarchical, Multilevel, Abstract classes, Method Overriding
- **Interfaces** — Defining and implementing interfaces, runtime polymorphism
- **Packages** — Creating, importing and using user-defined packages
- **Exception Handling** — try-catch-finally, custom exceptions, `throw` and `throws`
- **I/O Streams** — FileInputStream, FileOutputStream, DataInputStream, DataOutputStream, BufferedReader, BufferedWriter
- **Static Members** — Static variables, static methods, static blocks
