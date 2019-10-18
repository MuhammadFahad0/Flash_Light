package fahad.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    boolean Switch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);






    }

    public void press(View view)
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

            String CameraID= null;

            if (cameraManager != null) {
                try {

                    CameraID = cameraManager.getCameraIdList()[0];

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            if(Switch == true)
            {
                imageView.setImageResource(R.drawable.on);

                Switch = false;

                if (cameraManager != null) {
                    try {

                        cameraManager.setTorchMode(CameraID,true);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }}


            }
            else
            {
                imageView.setImageResource(R.drawable.off);

                Switch = true;

                if (cameraManager != null) {
                    try {

                        cameraManager.setTorchMode(CameraID,false);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }}


            }


        }


    }



}
