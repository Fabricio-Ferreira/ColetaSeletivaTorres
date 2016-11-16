package fabricioferreira.coletaseletivatorres.View;


import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import fabricioferreira.coletaseletivatorres.R;

public class MapsActivity extends FragmentActivity
        implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    //VARIAVEIS DO MAPS
    private SupportMapFragment mapFrag;
    private GoogleMap map;
    private Marker marker;

    //VARIAVEIS DO GPS
    private GoogleApiClient mGoogleApiClient;
    private TextView tvCoordinate;
    private LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        tvCoordinate = (TextView) findViewById(R.id.tv_coordinate);
        callConnection();

        GoogleMapOptions options = new GoogleMapOptions();
        options.zOrderOnTop(true);

        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        map = mapFrag.getMap();


        /*mapFrag = SupportMapFragment.newInstance(options);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.llcontainer , mapFrag);
        ft.commit();*/

    }

    private synchronized void callConnection() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    private void initLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(5000);
        mLocationRequest.setFastestInterval(2000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    private void startLocationUpadate() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        initLocationRequest();
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, MapsActivity.this);
    }

    private void stopLocationUpdate() {
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, MapsActivity.this);
    }

    // LISTERNER DO GPS
    @Override
    public void onConnected(Bundle bundle) {
        Log.i("LOG", "onConnected(" + bundle + ")");

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location l = LocationServices.FusedLocationApi
                .getLastLocation(mGoogleApiClient);


        if (l != null) {
            Log.i("LOG", "latitude: " + l.getLatitude());
            Log.i("LOG", "longitude: " + l.getLongitude());
            tvCoordinate.setText(l.getLatitude() + " | " + l.getLongitude());
        }

        startLocationUpadate();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i("LOG", "onConnectionSuspended(" + i + ")");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i("LOG", "onConnectionFailed(" + connectionResult + ")");
    }

    @Override
    public void onLocationChanged(Location location) {
        tvCoordinate.setText(Html.fromHtml("Location:" + location.getLatitude() + "<br />" +
                "Longetude:" + location.getLongitude() + "<br />" +
                "Bearing:" + location.getBearing() + "<br />" +
                "Altitude:" + location.getAltitude() + "<br />" +
                "Speed:" + location.getSpeed() + "<br />" +
                "Provider:" + location.getProvider() + "<br />" +
                "Accuracy:" + location.getAccuracy() + "<br />"));
    }

    // METODOS DO MAPS
    @Override
    public void onResume() {
        super.onResume();

        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            startLocationUpadate();
        }
        /*new Thread(){
            public void run(){
                while(mapFrag.getMap() == null){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ConfigMap();
                    }
                });
            }
        }.start();*/
    }

    public void onPause() {
        super.onPause();

        if (mGoogleApiClient != null) {
            stopLocationUpdate();
        }
    }

    public void ConfigMap() {

        map = mapFrag.getMap();
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        // ATIVA O BOTAO PRA MOSTRAR MINHA LOCALIZAÇAO
        map.setMyLocationEnabled(true);

        LatLng latLng = new LatLng(-29.3242,-49.7579);

        CameraPosition cameraposition = new CameraPosition.Builder().target(latLng).zoom(18).
                bearing(0).tilt(90).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraposition);

        /*map.moveCamera(update);*/
        map.animateCamera(update, 3000, new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {
                Log.i("Script", "CancelableCallback.onFinish");
            }

            @Override
            public void onCancel() {
                Log.i("Script", "CancelableCallback.onCancel");
            }
        });


        //MARKERS
        //cria marcador no mapa
        //customAddMarker(new LatLng(-29.3242,-49.7579)
        //        , "Marcador Alterado", "O Marcador foi reposicionado");

        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                LinearLayout ll = new LinearLayout(MapsActivity.this);
                ll.setPadding(20, 20, 20, 20);
                ll.setBackgroundColor(Color.GREEN);

                TextView tv = new TextView(MapsActivity.this);
                tv.setText(Html.fromHtml("<b><font color=\"0ff0000\">"+marker.getTitle()+
                        ":</font></b>"+marker.getSnippet()));
                ll.addView(tv);

                Button bt = new Button(MapsActivity.this);
                bt.setText("Botão");
                bt.setBackgroundColor(Color.RED);
                bt.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("Script", "Botão clicado");
                    }
                });

                ll.addView(bt);

                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                TextView tv = new TextView(MapsActivity.this);
                tv.setText(Html.fromHtml("<b><font color=\"0ff0000\">"+marker.getTitle()+
                                        ":</font></b>"+marker.getSnippet()));
                return tv;
            }
        });

        //EVENTS
        map.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {
                Log.i("Script", "setOnCameraChangeListener");

                if (marker != null){
                    marker.remove();
                }
                customAddMarker(new LatLng(cameraPosition.target.latitude , cameraPosition.target.longitude)
                        , "Marcador Alterado", "O Marcador foi reposicionado");
            }
        });

        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Log.i("Script", "setOnMapClickListener");

                if (marker != null){
                    marker.remove();
                }
                customAddMarker(new LatLng(latLng.latitude, latLng.longitude)
                        , "Marcador Alterado", "O Marcador foi reposicionado");

            }
        });

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Log.i("Script","Marker: "+ marker.getTitle());
                return false;
            }
        });

        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Log.i("Script","Marker: "+ marker.getTitle());
            }
        });
    }

    public void customAddMarker(LatLng latLng, String title, String snippert){
        MarkerOptions options = new MarkerOptions();
        options.position(latLng).title(title).snippet(snippert).draggable(true);

        //TROCANDO O ICONE DO MAPA
        options.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_play_light));

        marker = map.addMarker(options);

    }



}
