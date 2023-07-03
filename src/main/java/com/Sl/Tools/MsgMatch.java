package com.Sl.Tools;

import com.Sl.Event.GroupEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Shuanglin
 */
public class MsgMatch {
	/**
	 * 前缀参数
	 * 判断二级指令
	 */
	private static final String PREFIX = "#";
	UseFunction use = new UseFunction();

	/**
	 * 判断指令
	 *
	 * @param msg 消息
	 */
	public void match (String msg, GroupMessageEvent groupBot) {
		Long groupId = groupBot.getGroup().getId();
		String regx = "#[^#^\\[]+";
		Matcher matcher = Pattern.compile(regx).matcher(msg);
		if (!GroupEvent.groupDataMap.get(groupId).getScInstrc()|msg.startsWith(PREFIX)) {
				if (matcher.find()) {
					String instrcMsg = matcher.group().trim();
					String x = msg.replace(instrcMsg, "").trim();
					System.out.println("指令:" + instrcMsg);
					System.out.println("参数:" + x);
					use.run1(instrcMsg, x, groupBot);
				}
		} else if (GroupEvent.groupDataMap.get(groupId).getScInstrc()){
			System.out.println("进入二级指令！");
			System.out.println("指令:" + msg);
			use.run2(msg, msg, groupBot);
		}
		if (GroupEvent.groupDataMap.get(groupId).getScInstrc()){
			try {
				Thread.sleep(60000);
				GroupEvent.groupDataMap.get(groupId).setScInstrc(false);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}