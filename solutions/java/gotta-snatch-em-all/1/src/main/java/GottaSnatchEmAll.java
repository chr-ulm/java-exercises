import java.util.List;
import java.util.Set;
import java.util.HashSet;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        Set<String> myUniques = new HashSet<>(myCollection);
        myUniques.removeAll(theirCollection);

        Set<String> theirUniques = new HashSet<>(theirCollection);
        theirUniques.removeAll(myCollection);

        return !myUniques.isEmpty() && !theirUniques.isEmpty();
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> common = new HashSet<>(collections.get(0));
        for (Set<String> s : collections.subList(1, collections.size())) {
            common.retainAll(s);
        }
        return common;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> common = new HashSet<>(collections.get(0));
        for (Set<String> s : collections.subList(1, collections.size())) {
            common.addAll(s);
        }
        return common;
    }
}
