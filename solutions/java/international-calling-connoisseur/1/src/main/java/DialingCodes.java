import java.util.Map;
import java.util.HashMap;

public class DialingCodes {
    private Map<Integer,String> codeToCountry = new HashMap<>();
    private Map<String,Integer> countryToCode = new HashMap<>(); // Map is optimized for one,way key->value lookups, so we'll maintain a reverse map to speed up looking up country->code
    
    public Map<Integer, String> getCodes() {
        return codeToCountry;
    }

    public void setDialingCode(Integer code, String country) {
        // If code already mapped, remove old reverse mapping
        String oldCountry = codeToCountry.put(code, country);
        if (oldCountry != null && !oldCountry.equals(country)) {
            countryToCode.remove(oldCountry);
        }
        // If country already mapped to some other code, remove old forward mapping
        Integer oldCode = countryToCode.put(country, code);
        if (oldCode != null && !oldCode.equals(code)) {
            codeToCountry.remove(oldCode);
        }
    }

    public String getCountry(Integer code) {
        return codeToCountry.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if(!codeToCountry.containsKey(code) && !countryToCode.containsKey(country))
            this.setDialingCode(code,country);
    }

    public Integer findDialingCode(String country) {
        return countryToCode.get(country); // This is where our reverse map pays off!
    }

    public void updateCountryDialingCode(Integer code, String country) {
        if(countryToCode.containsKey(country))
            setDialingCode(code,country);
    }
}
