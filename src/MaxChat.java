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
        imput(4, "13005711862 13588625832,13505711862 13088625832,13588625832 18087925832,15005713862 13588625832");
    }

    private static void imput(int i, String mums) {
        //拆分数据信息
        String[] split = mums.split(",");
        statisticsNumber(4, split);
    }

    private static void statisticsNumber(int a, String[] split) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> newMap = new HashMap<>();

        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(" ");
            for (String st : split1
                    ) {
                //判断map中的key是否已经有这个元素了
                if (map.containsKey(st)) {
                    int o = (int) map.get(st) + mage;
                    map.put(st, o);
//                    if (newMap.containsKey(o)) {
//                        int exitValue =Integer.parseInt(newMap.get(o));
//                        int newValue = Integer.parseInt(st);
//                        if (exitValue>newValue ) {
//                            st = String.valueOf(newValue);
//                        }
//                    }else {
//
//                    }
                    newMap.put(o, st);
                } else {
                    map.put(st, mage);
                    newMap.put(mage, st);
                }
            }
        }
        System.out.println(map);
        System.out.println(newMap);
//        if (map == null) {
//            System.out.println("null");
//        }else {
//            Collection<Integer> values = map.values();
//            Object[] obj = values.toArray();
//            Arrays.sort(obj);
//
//        }
        Set<Integer> strings = newMap.keySet();
        Integer max = Collections.max(strings);
        System.out.println("聊天狂人是 " + newMap.get(max) + " 其聊天的次数为 " + max);
    }
}
