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

public class GyroscopeSensor extends AppCompatActivity {

    private SensorManager sensorManager;
    private TextView txt_value0;
    private TextView txt_value1;
    private TextView txt_value2;
    private static final float NS2S = 1.0f / 1000000000.0f; //将纳秒转换为秒
    private float timestamp; //记录旋转开始时的时间
    private final float[] angle = new float[3]; //记录xyz轴的旋转角度

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        txt_value0 = findViewById(R.id.txt_value0);
        txt_value1 = findViewById(R.id.txt_value1);
        txt_value2 = findViewById(R.id.txt_value2);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(listener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (timestamp!=0) {
                //event.timesamp表示当前的时间，单位是纳秒（1百万分之一毫秒）,
                final float deltaTime = (sensorEvent.timestamp - timestamp) * NS2S; //计算一次旋转需要的时间
                angle[0] += Math.toDegrees(sensorEvent.values[0] * deltaTime);//角速度乘以时间得弧度，转化为角度
                angle[1] += Math.toDegrees(sensorEvent.values[1] * deltaTime);
                angle[2] += Math.toDegrees(sensorEvent.values[2] * deltaTime);
                txt_value0.setText("X: " + angle[0]);
                txt_value1.setText("Y: " + angle[1]);
                txt_value2.setText("Z: " + angle[2]);
            }
            timestamp = sensorEvent.timestamp;
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
