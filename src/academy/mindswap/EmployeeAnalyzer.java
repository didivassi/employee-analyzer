package academy.mindswap;

import academy.mindswap.employee.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeAnalyzer {

    public int countEmployeesByWorkAge(List<Employee> department, int tillYear, int numberOfYears){
        return (int) department
                .stream()
                .filter(employee -> tillYear-employee.getStartingYear()>= numberOfYears)
                .count();
    }

    public List<String> getEmployeesNameBySalaryAboveOrEqual(List<Employee> department, int salaryFrom){
        return department
                .stream()
                .filter(employee -> employee.getSalary()>= salaryFrom)
                .map(employee ->  employee.getFirstName()  + " " + employee.getLastname())
                .collect(Collectors.toList());
    }

    public List<Employee> getOldestNEmployees(List<Employee> department, int n){
        return department
                .stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public Optional<Employee> getFirstEmployeeOlderThan(List<Employee> department, int age){
       return department
               .stream()
               //.sorted(Comparator.comparingInt(Employee::getAge))
               .filter(employee -> employee.getAge()>= age)
               .findFirst();
    }

    public double getAverageSalary(List<Employee> department){
        return department
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(Double.NaN);
    }

    public Set<String> findCommonNamesInDepartments(List<Employee> department, List<Employee> department2){
        Set<String> department2Names=department2.stream().map(Employee::getFirstName).collect(Collectors.toSet());
        return department
                .stream()
                .map(Employee::getFirstName)
                .filter(employee ->  department2Names.contains(employee))
                .collect(Collectors.toSet());

    }

}
