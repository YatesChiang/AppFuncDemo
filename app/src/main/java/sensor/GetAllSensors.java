package sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jyc.appfuncdemo.R;

import java.util.List;

public class GetAllSensors extends AppCompatActivity {

    private TextView txt_show_sensors;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_all_sensors);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        txt_show_sensors = findViewById(R.id.txt_all_sensors);

        //获取手机中所有的传感器
        List<Sensor> allSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sb = new StringBuilder();
        sb.append("此手机有" + allSensors.size() + "个传感器，分别是：\n\n");

        //将每个传感器的详细信息打印出来
        for (Sensor sensor: allSensors){
            switch(sensor.getType()){
                case Sensor.TYPE_ACCELEROMETER:
                    sb.append(sensor.getType() + " 加速度传感器（Accelerometer sensor）" + "\n");
                    break;
                case Sensor.TYPE_GRAVITY:
                    sb.append(sensor.getType() + " 重力传感器（Gravity sensor）" + "\n");
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    sb.append(sensor.getType() + " 陀螺仪传感器（Gyroscope sensor)" + "\n");
                    break;
                case Sensor.TYPE_LIGHT:
                    sb.append(sensor.getType() + " 光线传感器 (Light sensor)" + "\n");
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    sb.append(sensor.getType() + " 磁场传感器 (Magnetic field sensor)" + "\n");
                    break;
                case Sensor.TYPE_PRESSURE:
                    sb.append(sensor.getType() + " 压力传感器 (Pressure sensor)" + "\n");
                    break;
                case Sensor.TYPE_PROXIMITY:
                    sb.append(sensor.getType() + " 距离传感器 (Proximity sensor)" + "\n");
                    break;
                default:
                    sb.append(sensor.getType() + " 其他传感器" + "\n");
                    break;
            }
            sb.append("传感器名称：" + sensor.getName() + "\n 传感器模块版本：" + sensor.getVersion() + "\n 供应商："
                    + sensor.getVendor() + "\n\n");
        }
        txt_show_sensors.setText(sb.toString());
    }
}
