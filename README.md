# EMS

## Overview
EMS is short for Employee Management System which an MVC-Architecture Web Application that manages basic CRUD operation for Employee system

## Architecture
![Helicopter View Architecture](./Architecture.jpeg)

## Features
### Create
Add a new Employee to the system, each represents a Table record with `ID(PK)(AI)`, `first_name`, `salary`, and `last_name`, that record is mapped to the `EmployeeEntity` in the Application using ORM
![add employee](./add.PNG)
### Read 
Reading a full table of Employees or searching for a specific one using a unique `ID`
![show all employees](./showall.PNG)
![search employee by id](./search.PNG)

### Update 
Update all the data for the employee or patch in certain fields.
![update employee](./update.PNG)
![patch employee ](./patch.PNG)

### Delete
Delete Employee with one particular `ID`
![add employee](./delete.PNG)

## Exception handling
### Create
Add a new Employee to the system but with missing data 
![](./exception_add.PNG)
### Read
serching for a specific one using a unique `ID` but the employee is not found
![](./exception_search.PNG)

### Update
Update/Patch employee with null `ID` field.
![](./exception_patch_update.PNG)


### Delete
Delete Employee with one particular `ID` but the employee is not found
![](./exception_delete.PNG)

## Design
our design is based on a Serenity Template
https://www.free-css.com/free-css-templates/page247/serenity

