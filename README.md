# Transaction Service

This transaction service calculates the relative account balance for the given account id and time period.

## Getting Started

Checkout the Git Repository on `master`.

### Software Requirements

* JDK 1.8
* Apache Maven 3.6

### Installation

The program is packaged as an executable `JAR` file.

Code needs to be compiled and the `JAR` file created by running the maven install command at the project root.

```
mvn clean install
```

The program produces a JAR file in the `target` directory and the local `maven repo`.

### Running

The JAR file is executable and the program can be run by executing it. Use the command:
```
java -jar transactionservice-0.0.1-SNAPSHOT-jar-with-dependencies.jar <absolute-path-to-input-csv>
```
The service gets a CSV list of transactions as input. Once run, the service requests User Input:

- `accountID` - The account to calculate the balance for
- `fromDate` - The From Date to begin the calculation at. Input Format `dd/MM/yyyy HH:mm:ss`
- `toDate` - The To Date to begin the calculation at. Input Format `dd/MM/yyyy HH:mm:ss`

The service outputs the relative balance and number of transactions in the calculation as per the challenge requirements

### Running the tests

Tests with coverage reports can be obtained by running the below command on the project root

```
mvn clean test jacoco:report
```
