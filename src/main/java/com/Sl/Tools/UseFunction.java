package com.Sl.Tools;


import com.Sl.Funcctions.Fudu.SendFudu;
import com.Sl.Funcctions.Games.Pong.Pong;
import com.Sl.Funcctions.Games.Pong.Pong2;
import net.mamoe.mirai.event.events.GroupMessageEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一调动指令
 *
 * @author Shuanglin
 */
public class UseFunction {
	private static Map<String, UseFunc> instrusClasses1 = new HashMap<>();
	private static Map<String, UseFunc> instrusClasses2 = new HashMap<>();

	public static void addClass1 () {
		instrusClasses1.put("#午时", new Pong());
		instrusClasses1.put("#狗",new SendFudu());
	}

	public static void addClass2 () {
		instrusClasses2.put("开枪",new Pong2());
	}
	public UseFunc getClass1 (String instrc) {
		for (Map.Entry<String, UseFunc> entry : instrusClasses1.entrySet()) {
			if (entry.getKey().equals(instrc)) {
				return entry.getValue();
			}
		}
		return null;
	}
	public UseFunc getClass2 (String instrc) {
		for (Map.Entry<String, UseFunc> entry : instrusClasses2.entrySet()) {
			if (entry.getKey().equals(instrc)) {
				return entry.getValue();
			}
		}
		return null;
	}
	public void run1 (String instrc , String x, GroupMessageEvent groupBot){
		getClass1(instrc).useFunc(x,groupBot);
	}
	public void run2(String instrc , String x, GroupMessageEvent groupBot){
		try {
			getClass2(instrc).useFunc(x, groupBot);
		}catch (NullPointerException e){
			System.out.println("");
		}
	}
}
