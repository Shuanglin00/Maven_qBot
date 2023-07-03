package com.Sl.Funcctions.Games.Pong;

import com.Sl.Data.GroupData;
import com.Sl.Event.GroupEvent;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.*;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.File;
import java.util.Random;

/**
 * @author Shuanglin
 */
public class Pong2 extends Pong {
	private static final String PREFIX = "开枪";
	String[] send = {"Is time~~~~", "it's high tide", "理财财time", "午时~已到", "吾食已到", "巨浪已到", "午夜已到", "猜猜看啊","吃榴莲"};
	String[] die = {"有人被抹除了噢~", "死了", "可怜的生命", "有铸币死了", "戳戳,还活着吗", "嘿嘿,又枪毙一个", "小菜一碟,随手杀了", "让我们为逝去的生命,salute", "好惨~\n看一眼"};
	String[] nodie = {"啊,活下来了,o_o ....", "吓,居然没死,手误了吗?", "怎么没死啊( -'`-)", "哼,居然没死,那就放你一horse了", "咦?居然没死,奇了怪了(´･_･`)", "啊咧咧,没死掉(-@y@)"};
	Random random = new Random();

	public String bong () {
		Random random = new Random();
		int roll = random.nextInt(send.length);
		return send[roll];
	}

	public void judgeBong (GroupMessageEvent groupBot) {
		Group group = groupBot.getGroup();
		Long groupId =groupBot.getGroup().getId();
		GroupData data= GroupEvent.groupDataMap.get(groupId);
		/*
		Times 游戏次数
		rollCount 随机子弹数
		 */
		if (data.getPongIsRunning() & data.getPongTimes() > 0) {
			int roll = random.nextInt(data.getPongTimes());
			//小于枪决，大于侥幸
			if (roll < data.getPongCount()) {
				/*
				获取随机数 图片个数
				找到图片
				上传图片
				制作消息链,发送
				 */
				int roolDie = random.nextInt(die.length);
				File file = new File("Image\\枪毙\\枪毙" + roolDie + ".png");
				Image image = ExternalResource.uploadAsImage(file, group);
				MessageChain chain = new MessageChainBuilder()
						.append(new QuoteReply(groupBot.getMessage()))
						.append(new PlainText(die[roolDie]))
						.append(image)
						.build();
				group.sendMessage(chain);
				data.setPongTimes(data.getPongTimes()-1);
				data.setPongCount(data.getPongCount()-1);
			} else {
				int rollNodie = random.nextInt(nodie.length);
				File file = new File("Image\\没死\\没死" + rollNodie + ".png");
				Image image = ExternalResource.uploadAsImage(file, group);
				MessageChain chain = new MessageChainBuilder()
						.append(new PlainText(nodie[rollNodie]))
						.append(image)
						.build();
				group.sendMessage(chain);
				data.setPongTimes(data.getPongTimes()-1);
			}
		}
		if (data.getPongTimes() == 0) {
			/*
			关闭游戏
			关闭二级指令
			 */
			data.setPongIsRunning(false);
			data.setScInstrc(false);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			File file = new File("Image/电量低.png");
			Image image = ExternalResource.uploadAsImage(file, group);
			MessageChain chain = new MessageChainBuilder()
					.append(new PlainText("歇逼了家人们,去充充电再来玩吧"))
					.append(image)
					.build();
			group.sendMessage(chain);
		}
	}

	@Override
	public void useFunc (String x, GroupMessageEvent groupBot) {
		if (GroupEvent.groupDataMap.get(groupBot.getGroup().getId()).getPongIsRunning() & x.startsWith(PREFIX)) {
			groupBot.getGroup().sendMessage(bong());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			judgeBong(groupBot);
		}
	}
}
