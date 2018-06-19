import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
    原先在map地區與pm2.5值對映中，並未處理ND與empty的狀況，
    在原程式碼加入判別，ND與空值則存為-1，並將pm2.5存成數值，
    以方便使用Collection找尋最大最小值，在找尋最大最小值時建立method，
    將-1的值排除。
    該method原本想法為移除map值回傳map但此作法並未考量map往後的使用，並不妥當，
    改為建立一arraylist並返回其值。
    
    Homework：將method getValuesExclude改寫可傳入多個移除值並返回
        ex.排除-1,0
        ex.排除-1,0,1,2...
        reference：https://openhome.cc/Gossip/Java/Variable-lengthArgument.html
        reference：https://stackoverflow.com/questions/31422025/arrays-aslistint-not-working
*/

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
        //找最小值需處理-1的情形
        int min = Collections.min(getValuesExclude(map.values(), -1));
        //-1為空值或ND，直接使用Collections.min找出來的為-1
        int none = Collections.min(map.values());
        //System.out.println(max);
        //從最小值及最大值反推地區
        int excludeMin=Collections.min(getValuesExclude2(map.values(), -1,2,3));
        for(String area:areas){
            if(map.get(area)== max){
                System.out.println("max area : "+area+"pm25:"+max);
            }
            if(map.get(area)== min){
                System.out.println("min area : "+area+"pm25:"+min);
            }
            if(map.get(area)== none){
                System.out.println("none area : "+area+"pm25:"+none);
            }if(map.get(area)==excludeMin){
                System.out.println("excludeMin area : "+area+"pm25:"+excludeMin);
            }
        }
    }
//原本想做一個移除map元素的方法，但並不妥當   
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
    //notice：use Integer not int
    public static List<Integer> getValuesExclude2(Collection<Integer>list,Integer ...numbers){
        List<Integer> newlist = new ArrayList<>();
//        for(int number:numbers){
//            System.out.print(number+" ");
//        }
        //傳統寫法
        for(int value :list){
            if(!Arrays.asList(numbers).contains(value)){
                newlist.add(value);
            }
        }
        System.out.println("newlist"+newlist);
        
//JAVA 8 Stream寫法
        List<Integer> newlist2 =  list.stream().filter(item->!Arrays.asList(numbers).contains(item)).collect(Collectors.toList());
        System.out.println("newlist2"+newlist2);
        
        return newlist;
    }
}
