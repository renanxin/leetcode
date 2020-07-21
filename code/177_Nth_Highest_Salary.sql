CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
      declare n1 int;
      set n1 = N-1;
  RETURN (
      # Write your MySQL query statement below.
      
      select ifnull((select distinct Salary from Employee order by Salary desc limit n1,1),null) as getNthHighestSalary
  );
END
