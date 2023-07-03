package com.Sl.Funcctions.Fudu;

import com.Sl.Event.GroupEvent;
import com.Sl.Tools.Tools;
import com.Sl.Tools.UseFunc;
import net.mamoe.mirai.contact.Group;

import net.mamoe.mirai.event.events.GroupMessageEvent;

public class SendFudu implements UseFunc {

	public String getDogs(Group group, Long groupId) {
		StringBuilder sb = new StringBuilder();
		GroupEvent.groupDataMap.get(groupId).getFuDus()
				.forEach((key, value) -> sb.append(Tools.getQQCard(group, key))
						.append(" :")
						.append(value)
						.append("\n"));
		System.out.println(GroupEvent.groupDataMap.get(groupId).getFuDus());
		return sb.toString();
	}

	@Override
	public void useFunc(String x, GroupMessageEvent groupBot) {
		Group group =groupBot.getGroup();
		Long id = group.getId();
		group.sendMessage(getDogs(group,id));
	}
}
