package com.Sl.Event;

import com.Sl.Data.GroupData;
import com.Sl.Data.Sl;
import com.Sl.Tools.MsgMatch;
import com.Sl.Tools.UseFunction;
import kotlin.coroutines.CoroutineContext;
import com.Sl.Funcctions.Fudu.Fudu;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shuanglin
 */
public class GroupEvent extends SimpleListenerHost {
	public static final Map<Long, GroupData> groupDataMap = new HashMap<>();
	MsgMatch match = new MsgMatch();
	@EventHandler
	public synchronized void onMessage (GroupMessageEvent groupBot) {
		/*
		  获取消息，转化为mirai形式
		  获取发言人id
		  获取发言群id
		  将消息添加至群对象中
		 */
		String msg = groupBot.getMessage().serializeToMiraiCode().trim();
		Long userId = groupBot.getSender().getId();
		Long groupId = groupBot.getGroup().getId();
		UseFunction.addClass1();
		UseFunction.addClass2();
		//先建 群对象
		//反序列化文件，读取对象
		synchronized (groupDataMap.get(groupId)) {
			if (new Sl(groupId).load(groupId) == null) {
				groupDataMap.put(groupId, new GroupData(groupId));
			} else {
				groupDataMap.put(groupId, new Sl(groupId).load(groupId));
			}
			//存储消息
			groupDataMap.get(groupId).addMsgList(msg);
			groupDataMap.get(groupId).putUserData(userId, msg);
			//判断复读
			Fudu f = new Fudu();
			f.haveDog(groupId, userId, groupDataMap.get(groupId).getMsgList());
		}
		//
		match.match(groupDataMap.get(groupId).getUserData().get(userId),groupBot);
		//序列化对象，存储到文件中
		groupDataMap.forEach((key, value) -> new Sl(groupId).sava(value));
	}

	@Override
	public void handleException (@NotNull CoroutineContext context, @NotNull Throwable exception) {
		exception.printStackTrace();
	}
}
