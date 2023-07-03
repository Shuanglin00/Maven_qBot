package com.Sl.Funcctions.Fudu;

import com.Sl.Data.GroupData;
import com.Sl.Event.GroupEvent;

import java.util.List;

public class Fudu {

	public boolean isFudu(List<String> list) {
		String temp = list.get(list.size() - 1);
		for (int i = list.size() - 2; i > -1; i--) {
			if (temp.equals(list.get(i))) {
				return true;
			}
		}
		return false;
	}

	public void haveDog(Long groupId, Long userId, List<String> list) {
		GroupData data =GroupEvent.groupDataMap.get(groupId);
		System.out.println(data);
		if (isFudu(list)) {
			//初始化复读
			if (data.getFuDus().get(userId)==null){
				data.firstFuDus(userId);
				System.out.println(data);
			}else {
				data.addfudu(userId);
			}
		}
		System.out.println(data);
	}
}