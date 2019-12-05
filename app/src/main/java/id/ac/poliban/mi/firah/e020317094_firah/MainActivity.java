package id.ac.poliban.mi.firah.e020317094_firah;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 100;
    MahasiswaActivity mahasiswaActivity;
    String nim;
    String nama;
    String alamat;
    String telp;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setTitle("Data");
        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                if (data.getExtras()!= null){

                    this.nim= data.getStringExtra("datanim");
                    this.nama= data.getStringExtra("datanama");
                    this.alamat= data.getStringExtra("dataalamat");
                    this.telp= data.getStringExtra("datatelp");
                }

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btShowInput = findViewById(R.id.btShowInput);
        Button btShowData = findViewById(R.id.btShowData);

        btShowInput.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MahasiswaActivity.class);
            startActivityForResult(intent,1);
        });

        btShowData.setOnClickListener(v -> {
                new AlertDialog.Builder(this)
                        .setTitle("INFO")
                        .setMessage("NIM : "+nim+ "\n"+
                                "NAMA : "+nama+ "\n"+
                                "ALAMAT : "+alamat+ "\n"+
                                "TELP : "+telp+"\n")
                        .setPositiveButton("OK", null).show();
        });


    }
}
