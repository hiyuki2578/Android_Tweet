package net.tomoka319.tweet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ITBCalculatorActivity extends Activity {
	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) { // �A�N�e�B�r�e�B�����������ۂɕK���Ăяo�����
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_calculator); // UI�̃��C�A�E�g��ݒ�
	    // �w�肵�����\�[�X(R.java)�C���f�b�N�X����r���[(res/layout/main.xml)����id�̃R���|�[�l���g(�����ł�Button)�C���X�^���X���擾
	    Button button = (Button) findViewById(R.id.button_convert);
	    button.setOnClickListener(convertToBinary); // �{�^���������ꂽ�ۂ̃C�x���g��o�^
	  }
	 
	  // �o�^����C�x���g���X�i�[��View.OnClickListener������
	  private View.OnClickListener convertToBinary = new View.OnClickListener() {
	    public void onClick(View view) { // �{�^���������ꂽ�Ƃ��ɌĂяo����郁�\�b�h
	      EditText textInteger = (EditText) findViewById(R.id.text_integer); // ���͒l�������Ă���R���|�[�l���g���擾
	      String input = textInteger.getText().toString();
	      if (input.equals("")) return;
	      int intValue = Integer.parseInt(input);
	      String binValue = Integer.toBinaryString(intValue); // 10�i��������2�i��������ɕϊ�
	      TextView labelResult = (TextView) findViewById(R.id.label_result); // ���ʂ�\������TextView���擾
	      labelResult.setText("2�i���F" + binValue);
	    }
	  };
	}