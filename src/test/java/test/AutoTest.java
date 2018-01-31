package test;

import auto.AutoDao;
import auto.AutoService;

public class AutoTest {

	public static void main(String[] args) {
		AutoDao.createInterface();
//		AutoService.createInterface();
		AutoService.createInterface();
		AutoService.createImpl();
	}
}
