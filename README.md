# accounts-service

### Introduction
Sprint Boot Application to get Account details and Transaction Details

Import the project in any ide
Run SpringBoot App class - AccountsApplication.java


##End point Details
get All accounts - http://localhost:8080/api/v1/accounts

get single account Details - http://localhost:8080/api/v1/accounts/<accountId>

get Transactions - http://localhost:8080/api/v1/accounts/<accountId>/transactions

##Assmutions: 
Currently application will not connect to any DB to get the account/transaction details. data is hardcoded from AccountDao

DAO class can be used to connect to DB and get the account/transactions Details

Data can be read from File for testing purpose
