# Credit Card number validation

Java based program to validate credit card numbers using The Luhn Algorithm. 

## Description

The Luhn Algorithm formula verifies a number against its included check-digit.

The account number must pass the following test: 

Counting from the check digit, which is the rightmost, and moving left, double the value
of every second digit. Sum the digits of the products together with the un-doubled digits
from the original number.

If the total ends in 0 (the total modulo 10 is congruent to 0), then the number
is valid according to the Luhn formula; else it is not valid.

## Getting Started

### Dependencies

* Java 11
* Junit
* Maven

### Installing

* Clone the GitHub Repo

### Executing program

* Execute Test cases by running:
```
mvn test
```
