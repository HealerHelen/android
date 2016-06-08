package tools.calculate;

import java.util.Random;

public class calculate {

	String[] symbol = { "+", "-", "*", "/" };
	Random ran = new Random(System.currentTimeMillis());

	public String Question(int level, int maxNum) {
		String question = "";
		int items = ran.nextInt(3) + 2;
		int singleitem;
		int kuohaojiawei = 0;

		if (items >= 3) {
			kuohaojiawei = ran.nextInt(items - 2) + 1;
		}

		for (int i = 0; i < items; i++) {
			if (level == 1) {
				singleitem = ran.nextInt(maxNum);
				question += String.valueOf(singleitem);
				if (i != items - 1) {
					question += symbol[ran.nextInt(2)];
				}
			}
			if (level == 2) {
				singleitem = ran.nextInt(maxNum);
				question += String.valueOf(singleitem);
				if (i != items - 1) {
					question += symbol[ran.nextInt(4)];
				}
			}

			if (level == 3) {
				if (items >= 3) {

					if (i == kuohaojiawei) {

						question += "(";
					}
					singleitem = ran.nextInt(maxNum);
					question += String.valueOf(singleitem);
					if (i == kuohaojiawei + 1) {

						question += ")";
					}
					if (i != items - 1) {
						question += symbol[ran.nextInt(2)];
					}
				
				} else {
					singleitem = ran.nextInt(maxNum);
					question += String.valueOf(singleitem);
					if (i != items - 1) {
						question += symbol[ran.nextInt(2)];
					}
				}
			}
			if (level == 4) {
				if (items >= 3) {
					if (i == kuohaojiawei) {

						question += "(";
					}
					singleitem = ran.nextInt(maxNum);
					question += String.valueOf(singleitem);
					if (i == kuohaojiawei + 1) {

						question += ")";
					}
					if (i != items - 1) {
						question += symbol[ran.nextInt(4)];

					}
				
				} else {
					singleitem = ran.nextInt(maxNum);
					question += String.valueOf(singleitem);
					if (i != items - 1) {
						question += symbol[ran.nextInt(4)];

					}
				}
			}
		}

		return question.trim();
	}
}
