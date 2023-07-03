package com.Sl.Tools;

import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.NormalMember;
import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Shuanglin
 */
public class Tools {
	/**
	 * 默认降序
	 *
	 * @param map 待排序，map
	 * @return 返回已经排序好的
	 */
	public static Map<Long, Integer> sortMapByValue(Map<Long, Integer> map) {
		map = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(o1, o2) -> o1, LinkedHashMap::new
				));
		return map;
	}

	/**
	 * @param userId q号
	 * @return 如果有群名称则返回群名片 否则返回qq名称
	 */
	public static String getQQCard(Group group,Long userId) {
		NormalMember member = group.get(userId);
		assert member != null;
		return member.getNick();

	}
	/**
	 * @param userId q号
	 * @return 返回头像
	 */
	public static Image getQQImage(Long userId) {
		return null;
	}
//	public static Image fileToImage(){
//		return new Image();
//	}
}
