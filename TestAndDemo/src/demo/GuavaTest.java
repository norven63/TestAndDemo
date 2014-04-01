package demo;

import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

public class GuavaTest {
	public static void main(String[] args) {
		// 按照指定key对应的value将map排序(强大的分片集合)
		Map<String, String> map1 = ImmutableMap.of("1", "a", "2", "b", "3", "c");
		Map<String, String> map2 = ImmutableMap.of("1", "a", "2", "b_", "3", "c_");
		Map<String, String> map3 = ImmutableMap.of("1", "a_*", "2", "b_*", "3", "c_*");

		List<Map<String, String>> listOfMaps = Lists.newArrayList();
		listOfMaps.add(map1);
		listOfMaps.add(map2);
		listOfMaps.add(map3);

		Multimap<String, Map<String, String>> partitionedMap = Multimaps.index(listOfMaps, new Function<Map<String, String>, String>() {
			@Override
			public String apply(final Map<String, String> from) {
				from.keySet();
				return from.get("1");
			}
		});

		System.out.println("Multimaps.index: \n" + partitionedMap + "\n\n");

		// Multimap： 1个key对应N个value
		Multimap<String, String> customersByType = ArrayListMultimap.create();
		customersByType.put("abc", "123");
		customersByType.put("abc", "456");
		customersByType.put("abc", "789");
		customersByType.put("abc", "110");
		customersByType.put("abcd", "220");
		customersByType.put("abcde", "330");

		System.out.println("Multimap：");
		for (String item : customersByType.get("abc")) {
			System.out.println(item);
		}
		System.out.println("\n");

		// MapDifference的一些用法
		Map<String, String> mapA = ImmutableMap.of("1", "a", "2", "b", "3", "c", "22", "bb");
		Map<String, String> mapB = ImmutableMap.of("1", "a", "2", "b_", "3", "c_");

		MapDifference differenceMap = Maps.difference(mapA, mapB);

		Map entriesDiffering = differenceMap.entriesDiffering();// 同一个key,不同的value
		Map entriesOnlyOnLeft = differenceMap.entriesOnlyOnLeft();// 只在左map存在的key
		Map entriesOnlyOnRight = differenceMap.entriesOnlyOnRight();// 只在右map存在的key
		Map entriesInCommon = differenceMap.entriesInCommon();// 同一个key,同一个value

		System.out.println("MapDifference: \n" + differenceMap.entriesDiffering());
		System.out.println(differenceMap.entriesOnlyOnLeft());
		System.out.println(differenceMap.entriesOnlyOnRight());
		System.out.println(differenceMap.entriesInCommon() + "\n\n");

	}
}
