package i.love.icalculator;

import tools.calculate.*;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.luyang.csdn.*;

public class CalculateNow extends Activity {

	//����*************************************************************
	int level, quizCount, maxNumber, number,count1,count2;
	String question,answer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculate_now);

		// ��ǰ��ҳ��õ�������Ϣ==============��ʼ=================
		//TextView tv_level = (TextView) findViewById(R.id.tv_level);
		TextView tv_quizCount = (TextView) findViewById(R.id.tv_quizCount);
		TextView tv_maxNumber = (TextView) findViewById(R.id.tv_maxNumber);
		TextView tv_showQuestionNumber = (TextView) findViewById(R.id.tv_showQuestionNumber);

		Intent intent = getIntent();
		level = intent.getIntExtra("level", 0);
		quizCount = intent.getIntExtra("quizCount", 0);
		maxNumber = intent.getIntExtra("maxNumber", 0);
		count1=intent.getIntExtra("count1", 0);
		count2=intent.getIntExtra("count2", 0);
		//tv_level.setText(String.valueOf(level));
		tv_quizCount.setText(String.valueOf(quizCount));
		tv_maxNumber.setText(String.valueOf(maxNumber));
		// ��ǰ��ҳ��õ�������Ϣ==============����=================

		number = 1;
		tv_showQuestionNumber.setText("��" + String.valueOf(number) + "��");

		calculate c = new calculate();

	 question = c.Question(level, maxNumber);
		answer = String.valueOf(new CalStr(question).getResult());
		TextView tv_showQuestion = (TextView) findViewById(R.id.tv_showQuestion);

		tv_showQuestion.setText(question + "=" );
	}
	
//����*****************************************************************
	public void answerSubmit(View v) //�ύ
	{
		
		EditText et_answer=(EditText) findViewById(R.id.et_getAnswer);
		TextView tv_checkYes=(TextView) findViewById(R.id.checkYes);
		try {
			if(et_answer.length()==0){
				Toast.makeText(this, "��ش�����", 0).show();
			}
			else if(Float.parseFloat(et_answer.getText().toString().trim())==Float.parseFloat(answer)){
				count1++;
				tv_checkYes.setText("��ϲ�����ˣ�����"+"\n"+"һ�������"+count1+"����Ŀ�������"+count2+"����Ŀ��");
				}
			else{
				count2++;
				tv_checkYes.setText("�ܱ�Ǹ����ˣ�����"+answer+"\n"+"һ�������"+count1+"����Ŀ�������"+count2+"����Ŀ��");
			}
			
		} catch (NumberFormatException e) {
		Toast.makeText(this, "����������������", 0).show();
		return;
			
		}
		
		
		if (number < quizCount) {
			number++;
			calculate c = new calculate();

			TextView tv_showQuestionNumber = (TextView) findViewById(R.id.tv_showQuestionNumber);
			TextView tv_showQuestion = (TextView) findViewById(R.id.tv_showQuestion);

			tv_showQuestionNumber.setText("��" + String.valueOf(number) + "��");
			question = c.Question(level, maxNumber);
			answer = String.valueOf(new CalStr(question).getResult());
			tv_showQuestion.setText(question + "=" );

		
	
	}
		else{
			Toast.makeText(this, "ȫ�������Ѿ����꣬�����¿�ʼ�������˳�ϵͳ", 1).show();
		}
		et_answer.setText("");

}
	public void Clear(View v)//����
	{
		TextView txtView = (TextView) findViewById(R.id.et_getAnswer);
		txtView.setText(" ");
	}
	

}
