package com.Sl.Tools;

import net.mamoe.mirai.event.events.GroupMessageEvent;

/**
 * @author Shuanglin
 */
public interface UseFunc {
	/**
	 * 统一调用指令
	 * @param x 参数
	 * @param groupBot 机器人
	 */
	void useFunc (String x, GroupMessageEvent groupBot);
}
