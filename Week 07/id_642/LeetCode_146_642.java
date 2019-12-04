package Week7;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Author: xiang1.li
 * @Date: 2019/12/3 07:45
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class L146 {

  private Map<Integer, Integer> map;

  /**
   * LRU Cache，借助LinkedHashMap实现
   * */
  public L146(int capacity) {
    map = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
      // 移除策略
      @Override
      protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
        return size() > capacity;
      }
    };
  }

  public int get(int key) {
    return map.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    map.put(key, value);
  }

}
