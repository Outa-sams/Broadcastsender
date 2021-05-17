package must.ac.csce.outasamson.xmlcolorswap;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class XmlColorSwap extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button;
        Button btnbroad = (Button) findViewById(R.id.broad);
        TextView textview = (TextView) findViewById(R.id.textcolor);
        final Random random= new Random();
        button= findViewById(R.id.sending);


        button.setOnClickListener((v )-> {
            float red= random.nextFloat();

            float green= random.nextFloat();
            float blue= random.nextFloat();
            textview.setText("r"+String.valueOf(red)+"   g"+String.valueOf(green+" b"+String.valueOf(blue)  ));
            textview.setTextColor(Color.rgb(red,green,blue));

    });

        btnbroad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message= "sending Broadcast Message";
                Intent intent= new Intent();
                intent.setAction("must.codes.programcolorswap");
                intent.putExtra("message",message);
                intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);
                Toast.makeText(getApplicationContext(),"Sending Broadcast",Toast.LENGTH_SHORT).show();

            }
        });
}
}
