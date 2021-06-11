package academy.mindswap;

import academy.mindswap.db.DB;
import academy.mindswap.employee.Employee;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        EmployeeAnalyzer analyzer = new EmployeeAnalyzer();
        //7
        System.out.println(analyzer.countEmployeesByWorkAge(DB.getHrDepartment(), 2021, 4));
        //Reina Hopkins
        System.out.println(analyzer.getEmployeesNameBySalaryAboveOrEqual(DB.getHrDepartment(), 1500));
        //Reina,Brian,Frank
        System.out.println(analyzer.getOldestNEmployees(DB.getHrDepartment(), 3));
        //Edna Heller
        System.out.println(analyzer.getFirstEmployeeOlderThan(DB.getHrDepartment(), 24));

        System.out.println(analyzer.getAverageSalary(DB.getHrDepartment()));
        //Mary,James
        System.out.println(analyzer.findCommonNamesInDepartments(DB.getHrDepartment(), DB.getSalesDepartment()));
    }
}
