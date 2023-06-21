package com.example.uts_10120028;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uts_10120028.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

// NIM : 10120028
// NAMA : MUHAMMAD FARHAN
// KELAS : IF 1
public class RestaurantFragment extends Fragment {

    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restauran, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        client = LocationServices.getFusedLocationProviderClient(getActivity());
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.my_map);

        getLocation();
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(location -> {
            if(location != null){
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(@NonNull GoogleMap googleMap) {
                        LatLng lokasi1 = new LatLng(-6.900213228474783, 107.63440325304246 );
                        MarkerOptions options1 = new MarkerOptions().position(lokasi1).title("Griya Pahlawan");
                        googleMap.addMarker(options1);
                        LatLng lokasi2 = new LatLng(-6.891709564182673, 107.63105801071335);
                        MarkerOptions options2 = new MarkerOptions().position(lokasi2).title("Borma Cikutra");
                        googleMap.addMarker(options2);
                        LatLng lokasi3 = new LatLng(-6.89173112524199, 107.62506502092904);
                        MarkerOptions options3 = new MarkerOptions().position(lokasi3).title("Pasar Sadang Serang");
                        googleMap.addMarker(options3);
                        LatLng lokasi4 = new LatLng(-6.8852817648367335, 107.61428453243794);
                        MarkerOptions options4 = new MarkerOptions().position(lokasi4).title("Daytrans Dipati Ukur");
                        googleMap.addMarker(options4);
                        LatLng lokasi5 = new LatLng(-6.888490961459188, 107.61322209541008);
                        MarkerOptions options5 = new MarkerOptions().position(lokasi5).title("Mie Gacoan Dago");
                        googleMap.addMarker(options5);
                        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi2,16));
                    }
                });
            }
        });
    }
}