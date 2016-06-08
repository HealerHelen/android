package i.love.icalculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CalculatorConfig extends Activity {

	Button bt_startQuiz;
	RadioButton rb_level1, rb_level2, rb_level3, rb_level4;
	EditText et_quizCount, et_maxNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator_config);

		bt_startQuiz = (Button) findViewById(R.id.bt_startQuiz);
		rb_level1 = (RadioButton) findViewById(R.id.rb_level1);
		rb_level2 = (RadioButton) findViewById(R.id.rb_level2);
		rb_level3 = (RadioButton) findViewById(R.id.rb_level3);
		rb_level4 = (RadioButton) findViewById(R.id.rb_level4);
		et_quizCount = (EditText) findViewById(R.id.et_quizCount);
		et_maxNumber = (EditText) findViewById(R.id.et_maxNumber);

	}

	// �жϵõ����⼶��
	public int checkWhichLevelIsSelected() {
		if (rb_level1.isChecked()) {
			return 1;
		} else if (rb_level2.isChecked()) {
			return 2;
		} else if (rb_level3.isChecked()) {
			return 3;
		} else if (rb_level4.isChecked()) {
			return 4;
		} else {
			return 0;
		}
	}

	// �����ʼ���ⰴť����
	public void startQuiz(View v) {

		if (et_quizCount.length() == 0) {
			Toast.makeText(this, "��������Ŀ����", Toast.LENGTH_SHORT).show();
			return;
		} else if (et_maxNumber.length() == 0) {
			Toast.makeText(this, "����������ʽ���������ֵ", Toast.LENGTH_SHORT).show();
			return;
		} else if (Integer.parseInt(et_quizCount.getText().toString()) == 0) {
			Toast.makeText(this, "��Ŀ��������Ϊ0", Toast.LENGTH_SHORT).show();
			return;
		}  else if (Integer.parseInt(et_maxNumber.getText().toString()) == 0) {
			Toast.makeText(this, "���ֵ����Ϊ0", Toast.LENGTH_SHORT).show();
			return;
		} else {
			int level = checkWhichLevelIsSelected();
			int quizCount = Integer.parseInt(et_quizCount.getText().toString()
					.trim());
			int maxNumber = Integer.parseInt(et_maxNumber.getText().toString()
					.trim());

			Intent intent = new Intent(this, CalculateNow.class);
			intent.putExtra("level", level);
			intent.putExtra("quizCount", quizCount);
			intent.putExtra("maxNumber", maxNumber);
			startActivity(intent);
		}
	}
}
