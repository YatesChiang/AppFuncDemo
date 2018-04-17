package sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jyc.appfuncdemo.R;

public class AccelerometerSensor extends AppCompatActivity {

    private SensorManager sensorManager;
    private TextView txt_value0;
    private TextView txt_value1;
    private TextView txt_value2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        txt_value0 = findViewById(R.id.txt_value0);
        txt_value1 = findViewById(R.id.txt_value1);
        txt_value2 = findViewById(R.id.txt_value2);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(listener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            //得到x,y,z上的加速度
            txt_value0.setText("X：" + sensorEvent.values[0]);
            txt_value1.setText("Y：" + sensorEvent.values[1]);
            txt_value2.setText("Z：" + sensorEvent.values[2]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sensorManager != null) {
            sensorManager.unregisterListener(listener);
        }
    }
}
