package com.Sl.Funcctions.Games.Pong;

import com.Sl.Data.GroupData;
import com.Sl.Event.GroupEvent;
import com.Sl.Tools.UseFunc;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import java.util.Random;

/**
 * @author Shuanglin
 */
public class Pong implements UseFunc {
	/**
	 * 是否开启游戏
	 * 游戏次数
	 * 随即子弹
	 */
	private static boolean PREFIX_SLEEP = false;
	private static final int A =100,B=22;
	Random random = new Random();
	/**
	 * 启动游戏
	 * @param x 参数
	 * @param groupBot 机器人
	 */
	@Override
	public void useFunc (String x, GroupMessageEvent groupBot){
		Long groupId = groupBot.getGroup().getId();
		groupBot.getGroup().sendMessage("\t欢迎进入午时游戏，你将扮演科尔卡西迪对自己的头颅开Q，每人有一次或多次开枪机会，直至子弹打光\n" +
				"\t猜猜傻逼麦克雷一次大打死多少个科尔卡西迪");
		try {
			Thread.sleep(random.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (random.nextInt(A) == B) {
			PREFIX_SLEEP = true;
		}
		if (PREFIX_SLEEP) {
			groupBot.getGroup().sendMessage("睡吧~\n" + "你被强化了快上(幻听)");
			PREFIX_SLEEP=false;
			GroupEvent.groupDataMap.get(groupId).setPongIsRunning(false);
		} else {
			first(groupId);
			System.out.println(groupId+"子弹数:" + GroupEvent.groupDataMap.get(groupId).getPongCount());
		}
	}
	/**
	 * 初始化游戏配置
	 * 			子弹个数
	 * 			是否开启游戏
	 * 			二级指令开枪
	 * 			游戏次数
	 */

	public void first(Long groupId){
		GroupData date =GroupEvent.groupDataMap.get(groupId);
		date.setPongIsRunning(true);
		date.setPongCount(random.nextInt(6));
		date.setPongTimes(6);
		date.setScInstrc(true);
	}
}
