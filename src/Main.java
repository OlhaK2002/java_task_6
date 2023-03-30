import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, FieldLengthLimitException, IncorrectSalaryException {
        BufferedReader reader_employee = new BufferedReader(new FileReader("./InputEmployeers.txt"));
        try {
            String s;
            ArrayList data = new ArrayList<ArrayList>();
            while ((s = reader_employee.readLine()) != null) {
                ArrayList<String> strList = new ArrayList<String>(Arrays.asList(s.split(", ")));
                data.add(strList);
            }
            for (int i = 0; i < data.size(); i++) {
                ArrayList employee_info = (ArrayList) data.get(i);
                String name = (String) employee_info.get(0);
                String surname = (String) employee_info.get(1);
                double salary = Double.parseDouble((String) employee_info.get(2));

                try {
                    if (name.length() >= 60 || surname.length() >= 60) {
                        throw new FieldLengthLimitException();
                    } else if (salary <= 0) {
                        throw new IncorrectSalaryException();
                    } else {
                        Employee employee = new Employee(name, surname, salary);
                        System.out.println(employee.successCreate());
                    }
                } catch (FieldLengthLimitException e) {
                    System.err.println("Name and surname length need to be less than 60");
                } catch (IncorrectSalaryException e) {
                    System.err.println("Salary must be more than 0");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader_employee != null)
                reader_employee.close();
        }
    }
}