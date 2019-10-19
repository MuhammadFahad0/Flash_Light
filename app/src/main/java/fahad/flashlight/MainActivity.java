package fahad.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    boolean witch = true;

    Camera mCamera;

    Camera.Parameters parameters;

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


            if(witch == true)
            {
                imageView.setImageResource(R.drawable.on);
                Switch = false;
                if (cameraManager != null) {
                    try
                    {
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
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M)
        {
            if(witch == true)
            {
                imageView.setImageResource(R.drawable.on);
                witch = false;
                mCamera = Camera.open();
                parameters = mCamera.getParameters();
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                mCamera.setParameters(parameters);
                mCamera.startPreview();
            }
        else
            {
                imageView.setImageResource(R.drawable.off);
                witch = true;
                mCamera = Camera.open();
                parameters = mCamera.getParameters();
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                mCamera.setParameters(parameters);
                mCamera.stopPreview();
            }
        }
    }
}
