
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PeopleWhoseListofFavoriteCompaniesIsNotaSubsetofAnotherList {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        HashMap<String, HashSet<Integer>> map = new HashMap();
        HashSet<Integer> allSet = new HashSet();
        int index = 0;
        for (List<String> companies : favoriteCompanies) {
            for (String company : companies) {
                HashSet temp = map.getOrDefault(company, new HashSet());
                temp.add(index);
                map.put(company, new HashSet(temp));
            }
            allSet.add(index);
            index++;
        }
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            HashSet<Integer> common = new HashSet(allSet);
            for (int j = 0; j < favoriteCompanies.get(i).size(); j++) {
                HashSet<Integer> company = map.get(favoriteCompanies.get(i).get(j));
                common.retainAll(company);
            }
            if (common.size() == 1) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        PeopleWhoseListofFavoriteCompaniesIsNotaSubsetofAnotherList pwlofcnsal = new PeopleWhoseListofFavoriteCompaniesIsNotaSubsetofAnotherList();
        List<List<String>> favoriteCompanies = new ArrayList();
        List<String> l1 = new ArrayList();
        List<String> l2 = new ArrayList();
        List<String> l3 = new ArrayList();
        List<String> l4 = new ArrayList();
        List<String> l5 = new ArrayList();
        l1.add("leetcode");
        l1.add("google");
        l1.add("facebook");
        l2.add("google");
        l2.add("microsoft");
        l3.add("google");
        l3.add("facebook");
        l4.add("google");
        l5.add("amazon");
        favoriteCompanies.add(l1);
        favoriteCompanies.add(l2);
        favoriteCompanies.add(l3);
        favoriteCompanies.add(l4);
        favoriteCompanies.add(l5);
        System.out.println(pwlofcnsal.peopleIndexes(favoriteCompanies));
    }
}
