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

	//变量*************************************************************
	int level, quizCount, maxNumber, number,count1,count2;
	String question,answer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculate_now);

		// 从前面页面得到配置信息==============开始=================
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
		// 从前面页面得到配置信息==============结束=================

		number = 1;
		tv_showQuestionNumber.setText("第" + String.valueOf(number) + "题");

		calculate c = new calculate();

	 question = c.Question(level, maxNumber);
		answer = String.valueOf(new CalStr(question).getResult());
		TextView tv_showQuestion = (TextView) findViewById(R.id.tv_showQuestion);

		tv_showQuestion.setText(question + "=" );
	}
	
//函数*****************************************************************
	public void answerSubmit(View v) //提交
	{
		
		EditText et_answer=(EditText) findViewById(R.id.et_getAnswer);
		TextView tv_checkYes=(TextView) findViewById(R.id.checkYes);
		try {
			if(et_answer.length()==0){
				Toast.makeText(this, "请回答问题", 0).show();
			}
			else if(Float.parseFloat(et_answer.getText().toString().trim())==Float.parseFloat(answer)){
				count1++;
				tv_checkYes.setText("恭喜你答对了！！！"+"\n"+"一共答对了"+count1+"道题目，答错了"+count2+"道题目。");
				}
			else{
				count2++;
				tv_checkYes.setText("很抱歉答错了，答案是"+answer+"\n"+"一共答对了"+count1+"道题目，答错了"+count2+"道题目。");
			}
			
		} catch (NumberFormatException e) {
		Toast.makeText(this, "请输入正常的数字", 0).show();
		return;
			
		}
		
		
		if (number < quizCount) {
			number++;
			calculate c = new calculate();

			TextView tv_showQuestionNumber = (TextView) findViewById(R.id.tv_showQuestionNumber);
			TextView tv_showQuestion = (TextView) findViewById(R.id.tv_showQuestion);

			tv_showQuestionNumber.setText("第" + String.valueOf(number) + "题");
			question = c.Question(level, maxNumber);
			answer = String.valueOf(new CalStr(question).getResult());
			tv_showQuestion.setText(question + "=" );

		
	
	}
		else{
			Toast.makeText(this, "全部的题已经做完，请重新开始，或者退出系统", 1).show();
		}
		et_answer.setText("");

}
	public void Clear(View v)//重置
	{
		TextView txtView = (TextView) findViewById(R.id.et_getAnswer);
		txtView.setText(" ");
	}
	

}
