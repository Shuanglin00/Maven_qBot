package com.Sl;

import com.Sl.Event.GroupEvent;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;

import java.util.Objects;

/**
 * @author Shuanglin
 */
public class Go {
	public static void main (String[] args) {
		Bot bot = BotFactory.INSTANCE.newBot(2784152733L,"Sl2020721",new BotConfiguration(){{
			setHeartbeatStrategy(HeartbeatStrategy.REGISTER);
			setProtocol(MiraiProtocol.ANDROID_PAD);
			fileBasedDeviceInfo("device.json");//设备信息
			noNetworkLog();
		}});
		bot.login();
		Objects.requireNonNull(bot.getBot().getGroup(638800819L)).sendMessage("已上线");
		bot.getEventChannel().registerListenerHost(new GroupEvent());
	}
}
