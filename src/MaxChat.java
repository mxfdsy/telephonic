import java.util.*;

/**
 * 给定大量手机用户通话记录，找出其中通话次数最多的聊天狂人。
 * Created by 没想法的岁月 on 2018/4/13.
 * 输出格式 ：在一行中给出聊天狂人的手机号码及其通话次数，其间以空格分隔。如果这样的人不唯一，
 * 则输出狂人中最小的号码及其通话次数，并且附加给出并列狂人的人数。
 * 输入格式：输入首先给出正整数N（≤10​5），为通话记录条数。随后N行，每行给出一条通话记录。
 * 简单起见，这里只列出拨出方和接收方的11位数字构成的手机号码，其中以空格分隔。
 */
public class MaxChat {
    private static int mage = 1;

    public static void main(String[] args) {
        imput(4,"13005711862 13588625832,13505711862 13088625832,13588625832 18087925832,15005713862 13588625832");
    }

    private static void imput(int i, String mums) {
        //拆分数据信息
        String[] split = mums.split(",");
//        String str1 = split[0];
//        String str2 = split[1];
//        String str3 = split[2];
//        String str4 = split[3];
         statisticsNumber(4,split);
    }

    private static void statisticsNumber(int a,String[] split) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(" ");
            for (String st:split1
                 ) {
                if (map.containsKey(st)) {
                    int o = (int)map.get(st) + mage;
                    map.put(st, o);
                } else {
                    map.put(st,mage);
                }
            }
        }
        System.out.println(map);

//        if (map == null) {
//            System.out.println("null");
//        }else {
//            Collection<Integer> values = map.values();
//            Object[] obj = values.toArray();
//            Arrays.sort(obj);
//
//        }
        Set<String> strings = map.keySet();
        for (String set:strings
             ) {
            list.add(map.get(set));
        }
        System.out.println(Collections.max(list));
    }
}
