import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee {
    String name;
    double baseSalary;
    int yearsOfService;

    public Employee(String name, double baseSalary, int yearsOfService) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.yearsOfService = yearsOfService;
    }

    public double calculateAnnualSalary() {
        return baseSalary + (baseSalary * 0.05 * yearsOfService);
    }
}


public class EmployeeSalaryProcessor {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        String inputFilePath = "C:/Users/HANIFF/OneDrive/Documents/employeeSalaries.txt";
        String outputFilePath = "C:/Users/HANIFF/OneDrive/Documents/employeeData.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split("\\|");
                    String name = parts[0].trim();
                    double baseSalary = Double.parseDouble(parts[1].trim());
                    int yearsOfService = Integer.parseInt(parts[2].trim());
                    employees.add(new Employee(name, baseSalary, yearsOfService));
                } catch (Exception e) {
                    System.out.println("Skipping invalid record: " + line);
                }
            }

            Employee topPerformer = null;
            Employee leastExperienced = null;

            for (Employee emp : employees) {
                if (topPerformer == null || emp.calculateAnnualSalary() > topPerformer.calculateAnnualSalary()) {
                    topPerformer = emp;
                }
                if (leastExperienced == null || emp.yearsOfService < leastExperienced.yearsOfService) {
                    leastExperienced = emp;
                }
                writer.println(emp.name + " | " + emp.calculateAnnualSalary() + " | " + emp.yearsOfService);
            }

            // Creatively display the top performer and least experienced employee details
            if (topPerformer != null) {
                writer.println("\n--- Top Performer ---");
                writer.println("Name: " + topPerformer.name);
                writer.println("Annual Salary: " + topPerformer.calculateAnnualSalary());
                writer.println("Years of Service: " + topPerformer.yearsOfService);
            }

            if (leastExperienced != null) {
                writer.println("\n--- Employee with Least Years of Service ---");
                writer.println("Name: " + leastExperienced.name);
                writer.println("Annual Salary: " + leastExperienced.calculateAnnualSalary());
                writer.println("Years of Service: " + leastExperienced.yearsOfService);
            }

            System.out.println("Processing complete. Check " + outputFilePath + " for details.");

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}