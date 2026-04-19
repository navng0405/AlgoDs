package Revist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 */
public class DomainsCount {
    public static void main(String[] args) {
        String[] domain = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(getSubdomainVisitsCount(domain));
    }

    private static List<String> getSubdomainVisitsCount(String[] domain) {
        Map<String,Integer> visits = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String cpDomain : domain){
            String[] subdomainSplit = cpDomain.split(" ");
            int count = Integer.parseInt(subdomainSplit[0]);
            String subDomain = subdomainSplit[1];

            while(subDomain!=null){
                visits.put(subDomain,visits.getOrDefault(subDomain,0)+count);
                int dotIndex=subDomain.indexOf(".");
                subDomain = dotIndex == -1 ? null : subDomain.substring(dotIndex+1);
            }

        }
        for(Map.Entry<String,Integer> entry : visits.entrySet()){
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;

    }
}
