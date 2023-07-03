package com.Sl.Data;
import java.io.Serializable;
import java.util.*;

/**
 * @author Shuanglin
 */
public class GroupData implements Serializable {
	/**
	 * 群员id ： 消息
	 * 群复读统计
	 * 群消息链
	 * 群二级指令是否开启
	 * pong游戏是否正在运行
	 */
	private static final long serialVersionUID = 3518813183768815686L;
	private final Map<Long, String> userData = new HashMap<>();
	private final Map<Long, Integer> fuDus = new HashMap<>();
	private final ArrayList<String> msgList = new ArrayList<>();
	private boolean scInstrc;
	private boolean pongIsRunning;
	private int pongTimes;
	private int pongCount;
	private final Long GROUP_ID;
	public GroupData(Long GROUP_ID) {
		this.GROUP_ID=GROUP_ID;
		msgList.add("测试");
		msgList.add("测试2");
		msgList.add("测试3");
		msgList.add("测试4");
		userData.put(1L, "测试");
		fuDus.put(0L, 0);
		scInstrc = false;
		pongIsRunning = false;
		pongTimes = 0;
		pongCount = 0;
	}

	public synchronized void putUserData(Long userId, String msg) {
		userData.put(userId, msg);
	}

	public synchronized void addMsgList(String msg) {
		msgList.add(msg);
		msgList.remove(0);
		if (msgList.size() > 5) {
			msgList.remove(0);
		}
	}

	public synchronized void firstFuDus(Long userId) {
		this.fuDus.put(userId, 0);
	}
	public synchronized void addfudu(Long userId) {
		this.fuDus.put(userId, this.fuDus.get(userId) + 1);
	}

	public void setScInstrc(boolean scInstrc) {
		this.scInstrc = scInstrc;
	}

	public void setPongIsRunning(boolean pongIsRunning) {
		this.pongIsRunning = pongIsRunning;
	}

	public void setPongTimes(int pongTimes) {
		this.pongTimes = pongTimes;
	}

	public void setPongCount(int pongCount) {
		this.pongCount = pongCount;
	}

	public Map<Long, Integer> getFuDus() {
		return fuDus;
	}

	public boolean getScInstrc() {
		return scInstrc;
	}

	public boolean getPongIsRunning() {
		return pongIsRunning;
	}

	public int getPongTimes() {
		return pongTimes;
	}

	public int getPongCount() {
		return pongCount;
	}

	public Map<Long, String> getUserData() {
		return userData;
	}

	public ArrayList<String> getMsgList() {
		return msgList;
	}

	@Override
	public String toString() {
		return GROUP_ID+"{" +
				"每个人的说话记录=" + userData +
				", 复读记录=" + fuDus +
				", 消息链=" + msgList +
				", 二级指令是否开启=" + scInstrc +
				",午时开启=" + pongIsRunning +
				", 午时记录=" + pongTimes +
				", 午时子弹数=" + pongCount +
				'}';
	}
}
