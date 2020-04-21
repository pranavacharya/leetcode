
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class EmployeeImportance {

    static class Employee {

        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, i);
        }
        Stack<Employee> stack = new Stack();
        int importance = 0;
        stack.push(employees.get(map.get(id)));
        while (!stack.isEmpty()) {
            Employee current = stack.pop();
            importance += current.importance;
            for (int i = 0; i < current.subordinates.size(); i++) {
                stack.push(employees.get(map.get(current.subordinates.get(i))));
            }
        }
        return importance;
    }

    public static void main(String args[]) {
        EmployeeImportance ei = new EmployeeImportance();
        ArrayList<Employee> list = new ArrayList<>();
        Employee one = new Employee();
        one.id = 1;
        one.importance = 5;
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(2);
        sub.add(3);
        one.subordinates = sub;
        list.add(one);
        Employee two = new Employee();
        two.id = 2;
        two.importance = 3;
        two.subordinates = new ArrayList();
        list.add(two);
        Employee three = new Employee();
        three.id = 3;
        three.importance = 3;
        three.subordinates = new ArrayList();
        list.add(three);
        System.out.println(ei.getImportance(list, 1));
    }
}
