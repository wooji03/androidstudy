package com.example.b.a22_location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSIONS = 100;
    TextView textView;
    Geocoder geocoder;
    LocationManager manager;
    LocationListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

        geocoder = new Geocoder(MainActivity.this);


        manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        List<String> providers = manager.getAllProviders();
        String str = "";
        for (int i = 0; i < providers.size(); i++) {
            str += "provider : " + providers.get(i) + " state : " +
                    manager.isProviderEnabled(providers.get(i)) + "\n";
        }
        textView.setText(str);

        listener = new LocationListener() {
            //        provider:passive ,state:true //최근에 사용했던 정보
//        provider:nexwork, state:false //기지국정보
//        provider:gps , state: false //gps 정보
            @Override
            public void onLocationChanged(Location location) {
                String str = "lat : " + location.getLatitude() +
                        "lon : " + location.getLongitude() + "\n";
                textView.append(str);

                try {
                    List<Address> list = geocoder.getFromLocation(location.getLatitude(),
                            location.getLongitude(), 10);
                    Address address = list.get(0);
                    textView.append(address.toString());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        //int REQUEST_PERMISSIONS = 100;
        //안드로이드 sdk 버전체크
        textView.append("My SDK VER : " + Build.VERSION.SDK_INT + "\n");
        textView.append("Build VER : " + Build.VERSION_CODES.M + "\n");
        textView.append("================" + REQUEST_PERMISSIONS + "\n");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //허가가 되었느냐..PackageManager.PERMISSION_GRANTED
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSIONS);

                return;
            } else {
                //manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
                manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
            }
        }


        //manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSIONS) {
            for (int i = 0; i < permissions.length; i++) {
                //사용자가 허용했는지 않했는지에 따라 달리처리해야된다.
                if (permissions[i].equals(Manifest.permission.ACCESS_FINE_LOCATION)) {

                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        //deny 유저에게 알려줘야한다....해줄게 없다...
                        Toast.makeText(MainActivity.this, "Setting..Plz....", Toast.LENGTH_SHORT).show();
                    } else {

                        //alow
                        //허용을 해줬다면...
                        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
                    }

                }else if(permissions[i].equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    //allow

                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
