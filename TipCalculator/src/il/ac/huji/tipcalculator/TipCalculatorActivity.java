package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {
	
	private static final double TIP_PERCENTAGE = 0.12;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		final CheckBox chkB =(CheckBox)findViewById(R.id.chkRound);
		final TextView tvResult = (TextView)findViewById(R.id.txtTipResult); 
		final EditText txtBillAmount = (EditText)findViewById(R.id.edtBillAmount);
		final Button btnCalc = (Button)findViewById(R.id.btnCalculate);
		
		btnCalc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				double billAmount, tip;
				// parse string to double
				String getAmount = txtBillAmount.getText().toString();
				if (getAmount == null || getAmount.isEmpty())
					billAmount = 0.0;
				else {
					billAmount = Double.parseDouble(getAmount);
				}
				tip = TIP_PERCENTAGE * billAmount;
				if (chkB.isChecked())
					tip = (int)tip;
				tvResult.setText("Tip: $" + tip);
			}
			

			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

}
