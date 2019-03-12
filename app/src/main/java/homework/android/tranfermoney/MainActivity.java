package homework.android.tranfermoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    double ti_gia;
    Button button;
    EditText edit1;
    TextView result;
    Spinner spinner;
    String[] items = {"USD - US DOLLAR",
            "EUR - EURO",
            "THB - THAI BAHT",
            "SGD - SINGAPORE DOLLAR",
            "SEK - SWEDISH KRONA",
            "SAR - SAUDI RIAL",
            "RUB - RUSSIAN RUBLE",
            "CAD - CANADIAN DOLLAR",
            "JPY - JAPANESE YEN",
            "KRW - SOUTH KOREAN WON"};
    double[] Ti_gia = {23150.00, 25924.86 ,718.79, 16886.36, 2446.17, 6171.33, 351.19, 17075.09, 203.27, 20.13};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        spinner = (Spinner)findViewById( R.id.spin );
        edit1 = (EditText)findViewById( R.id.edit_1 );
        result = (TextView)findViewById( R.id.txtv_result );
        button = (Button)findViewById( R.id.btn );

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                items
        );
        spinner.setAdapter( adapter );
        spinner.setOnItemSelectedListener( this );

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double input = Double.parseDouble( String.valueOf( edit1.getText() ) );
                result.setText( String.valueOf( input* ti_gia) );
            }
        } );
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ti_gia = Ti_gia[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
