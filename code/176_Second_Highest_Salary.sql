select max(Salary) SecondHighestSalary
    from Employee
    where Salary < (Select max(Salary) from Employee);

# or

select ifnull((select distinct
               Salary from Employee
               order by Salary desc
               limit 1,1),null) as SecondHighestSalary;



