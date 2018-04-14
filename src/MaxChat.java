import java.math.BigInteger;
import java.util.*;

/**
 * @author 平凡的世界
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
        imput(4, "13005711862 13588625832," +
                "13005711862 13088625832," +
                "15005713862 18087925832," +
                "15005713862 13588625832");
    }

    private static void imput(int i, String mums) {
        //拆分数据信息
        String[] split = mums.split(",");
        statisticsNumber(4, split);
    }

    private static void statisticsNumber(int a, String[] split) {

        HashMap<String, Integer> map = new HashMap<>(a);
        HashMap<Integer, String> newMap = new HashMap<>(a);

        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(" ");
            for (String st : split1
                    ) {
                //判断map中的key是否已经有这个元素了
                if (map.containsKey(st)) {
                    int o = map.get(st) + mage;
                    map.put(st, o);
                    //判断newMap中是否有这个数，我们把值小手机号码存到newMap里面
                    if (newMap.containsKey(o)) {
                        int exitValue = BigInteger.valueOf(Long.parseLong(newMap.get(o))).intValue();
                        int newValue = BigInteger.valueOf(Long.parseLong(st)).intValue();
                        if (exitValue > newValue) {
                            st = String.valueOf(newValue);
                            newMap.put(o, st);
                        }
                    } else {
                        newMap.put(o, st);
                    }
                } else {
                    map.put(st, mage);
                    //判断newMap中是否有 1 这个数，我们把值小手机号码存到newMap里面
                    if (newMap.containsKey(1)) {
                        int exitValue = BigInteger.valueOf(Long.parseLong(newMap.get(1))).intValue();
                        int newValue = BigInteger.valueOf(Long.parseLong(st)).intValue();
                        if (exitValue > newValue) {
                            st = String.valueOf(newValue);
                            newMap.put(1, st);
                        }
                    } else {
                        newMap.put(mage, st);
                    }
                }
            }
        }
        System.out.println(map);
        System.out.println(newMap);
        Set<Integer> strings = newMap.keySet();
        Integer max = Collections.max(strings);

        //获取同话次数一样多的人数
        List<Object> list = new ArrayList<>();
        Collection<Integer> values = map.values();
        Object[] objects =  values.toArray();
        for (Object obj: objects
             ) {
            if (max.equals(obj)) {
                list.add(obj);
            }
        }
        int sameChatter = list.size();

        //判断输出
        if (sameChatter == 1) {
            System.out.println("聊天狂人是 " + newMap.get(max) + " 其聊天的次数为 " + max);
        } else {
            System.out.println("聊天狂人是 " + newMap.get(max) + " 其聊天的次数为 " + max +"拥有相同的聊天人数为"+sameChatter);
        }
    }
}
