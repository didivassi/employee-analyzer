package academy.mindswap;

import academy.mindswap.employee.Employee;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeAnalyzer {

    public int countEmployeesByWorkAgeMoreThan(@NotNull List<Employee> department, int tillYear, int numberOfYears){
        return (int) department
                .stream()
                .filter(employee -> tillYear - employee.getStartingYear() > numberOfYears)
                .count();
    }

    public List<String> getEmployeesNameBySalaryAboveOrEqual(@NotNull List<Employee> department, int salaryFrom){
        return department
                .stream()
                .filter(employee -> employee.getSalary() >= salaryFrom)
                .map(employee ->  employee.getFirstName()  + " " + employee.getLastname())
                .collect(Collectors.toList());
    }

    public List<Employee> getOldestNEmployees(@NotNull List<Employee> department, int n){
        return department
                .stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public Optional<Employee> getFirstEmployeeOlderThan(@NotNull List<Employee> department, int age){
       return department
               .stream()
               //.sorted(Comparator.comparingInt(Employee::getAge))
               .filter(employee -> employee.getAge() > age)
               .findFirst();
    }

    public double getAverageSalary(@NotNull List<Employee> department){
        return department
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(Double.NaN);
    }

    public Set<String> findCommonNamesInDepartments(@NotNull List<Employee> department, @NotNull List<Employee> department2){
        Set<String> department2Names=department2.stream().map(Employee::getFirstName).collect(Collectors.toSet());
        return department
                .stream()
                .map(Employee::getFirstName)
                .filter(department2Names::contains)
                .collect(Collectors.toSet());

    }

}
