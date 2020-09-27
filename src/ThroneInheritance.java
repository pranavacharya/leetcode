
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThroneInheritance {

    private class Person {

        private String name;
        private boolean isAlive;

        Person(String name) {
            this.name = name;
            this.isAlive = true;
        }
    }

    private HashMap<String, ArrayList<Person>> graph;
    private HashMap<String, Person> personMap;
    private String king;

    public ThroneInheritance(String kingName) {
        this.graph = new HashMap();
        this.personMap = new HashMap();
        this.king = kingName;
        Person king = new Person(kingName);
        this.personMap.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Person newPerson = new Person(childName);
        ArrayList<Person> children = this.graph.getOrDefault(parentName, new ArrayList());
        children.add(newPerson);
        this.graph.put(parentName, children);
        this.personMap.put(childName, newPerson);
    }

    public void death(String name) {
        personMap.get(name).isAlive = false;
    }

    private List<String> inheritanceOrder;

    public List<String> getInheritanceOrder() {
        this.inheritanceOrder = new ArrayList();
        dfs(this.graph, inheritanceOrder, this.king, this.personMap);
        return inheritanceOrder;
    }

    private void dfs(HashMap<String, ArrayList<Person>> graph, List<String> order, String king,
            HashMap<String, Person> personMap) {
        if (personMap.get(king).isAlive) {
            order.add(king);
        }
        if (graph.get(king) != null) {
            ArrayList<Person> children = graph.get(king);
            for (Person child : children) {
                dfs(graph, order, child.name, personMap);
            }
        }
    }

    public static void main(String args[]) {
        ThroneInheritance obj = new ThroneInheritance("pranav");
        obj.birth("pranav", "appu");
        obj.birth("appu", "geetu");
        obj.birth("appu", "geeta");
        obj.birth("appu", "papa");
        obj.death("appu");
        obj.death("pranav");
        List<String> order = obj.getInheritanceOrder();
        System.out.println(order);
    }
}
