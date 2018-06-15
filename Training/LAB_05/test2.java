
package p0615;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class PM25Test {
    public static void main(String[] args) {
        HashMap<String,Integer> map =PM25LAB.pm25Map;
        System.out.println(PM25LAB.pm25Map.get("萬華"));
        //濃度最高
        Set<String> areas =  map.keySet();
        System.out.println(areas);
        System.out.println(map.values());
        System.out.println(areas);
        /*
        int max=0;
        for(String area:areas){
            //System.out.println(area +":"+map.get(area));
            if(!map.get(area).equals("ND")){
                int pm25 = map.get(area);
                max = (pm25>max)?pm25:max;
            }
        }
        System.out.println("pm25 max="+max);
    */
        int max = Collections.max(map.values());
        int min = Collections.min(getValuesExclude(map.values(), -1));
        int none = Collections.min(map.values());
        //System.out.println(max);
        //homework
        //reference https://openhome.cc/Gossip/Java/Variable-lengthArgument.html
        //Black–Litterman model
        //排除-1,0
        //排除-1,0,1,2...
        for(String area:areas){
            if(map.get(area)== max){
                System.out.println("max area : "+area+"pm25:"+max);
            }
            if(map.get(area)== min){
                System.out.println("min area : "+area+"pm25:"+min);
            }
            if(map.get(area)== none){
                System.out.println("none area : "+area+"pm25:"+none);
            }
        }
    }
//    public static HashMap<String,Integer> remove(HashMap<String,Integer> map,int item){
//        for(String key : map){
//            if(map.get(key)==item){
//                map.remove(key);
//            }
//        }
//        
//        return map;
//    }
    public static List<Integer> getValuesExclude(Collection<Integer>list,int exclude){
        List<Integer> newlist=new ArrayList();
        for(int value :list ){
            if(value !=exclude) newlist.add(value);
        }
        return  newlist;
    }
}
