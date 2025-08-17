import java.util.Map;

class SqueakyClean {
    private static final Map<Character, Character> LEET_MAP = Map.of(
        '4', 'a',
        '3', 'e',
        '0', 'o',
        '1', 'l',
        '7', 't'
    );
    
    static String clean(String identifier) {
        StringBuilder out = new StringBuilder();
        boolean isKebab = false;
        for (int i = 0; i < identifier.length(); i++){
            char c = identifier.charAt(i);

            // spaces to underscores
            if (c == ' ') { out.append('_'); isKebab = false; continue; }

            // remove leet
            c = isLeet(c);

            // check for kebabcase
            if (c == '-') { isKebab = true; continue; }

            // trim non-letters
            if (!Character.isLetter(c)) { continue; }

            // camelize after kebab
            if(isKebab) { out.append(Character.toUpperCase(c)); isKebab = false; }
            else {out.append(c);}
        }
        return out.toString();
    }

    private static char isLeet(char c) {
        return LEET_MAP.getOrDefault(c, c);
    }
}
