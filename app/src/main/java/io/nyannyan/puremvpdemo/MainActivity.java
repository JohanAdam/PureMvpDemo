package io.nyannyan.puremvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DetailsContract.View {

  private EditText firstName, lastName;
  private TextView tvDetail;
  private Button btnSubmit;

  private DetailsContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    firstName = findViewById(R.id.etFirstName);
    lastName = findViewById(R.id.etLastName);
    tvDetail = findViewById(R.id.tvMessage);
    btnSubmit = findViewById(R.id.btnSubmit);

    presenter= new DetailsPresenter(this);

    btnSubmit.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

        if (TextUtils.isEmpty(firstName.getText().toString())){

          Toast.makeText(MainActivity.this, "Please enter first name", Toast.LENGTH_SHORT).show();

        } else {

          presenter.submitName(firstName.getText().toString(), lastName.getText().toString());
          presenter.loadMessage();

        }

      }
    });


  }

  @Override
  public void showMessage(String message) {
    tvDetail.setText(message);
  }
}
