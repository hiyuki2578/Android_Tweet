package net.tomoka319.tweet;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class GPSActivity extends Activity implements LocationListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
         
        // LocationManager���擾
        LocationManager mLocationManager =
             (LocationManager) getSystemService(Context.LOCATION_SERVICE);
 
        // Criteria�I�u�W�F�N�g�𐶐�
        Criteria criteria = new Criteria();
 
        // Accuracy���w��(�ᐸ�x)
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
         
        // PowerRequirement���w��(�����d��)
        criteria.setPowerRequirement(Criteria.POWER_LOW);
         
        // ���P�[�V�����v���o�C�_�̎擾
        String provider = mLocationManager.getBestProvider(criteria, true);
 
        // �擾�������P�[�V�����v���o�C�_��\��
        TextView tv_provider = (TextView) findViewById(R.id.Provider);
        tv_provider.setText("�擾��: "+provider);
 
        // LocationListener��o�^
        mLocationManager.requestLocationUpdates(provider, 0, 0, this);
         
    }
 
    @Override
    public void onLocationChanged(Location location) {
        // �ܓx�̕\��
        TextView tv_lat = (TextView) findViewById(R.id.Latitude);
        tv_lat.setText("�ܓx:"+location.getLatitude());
 
        // �o�x�̕\��
        TextView tv_lng = (TextView) findViewById(R.id.Longitude);
        tv_lng.setText("�o�x:"+location.getLongitude());

    }
 
    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub
         
    }
 
    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
         
    }
 
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
 
    }
}