package android.codelabs.canadiandemocracy;

import android.codelabs.canadiandemocracy.representativeSetsData.RepresentativeSet;
import android.codelabs.canadiandemocracy.representativeSetsData.RepresentativeSetList;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String TAG = "MAIN ACTIVITY: ";

    // RETROFIT

    private final String baseUrl = "https://represent.opennorth.ca";

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    // END RETROFIT

    // SPINNER

    private TextView errorMessage;

    private Spinner spinner;

    final List<RepresentativeSet> spinnerData = new ArrayList<>();

    // END SPINNER

    // INTENT DATA

    public String url;

    public String name;

    // END INTENT DATA

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.view_spinner);

        errorMessage = findViewById(R.id.view_error);

        spinner.setOnItemSelectedListener(this);

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getRepresentativeSets();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        java.lang.Object item = parent.getItemAtPosition(position);

        RepresentativeSet selectedItem = (RepresentativeSet)item;

        url = selectedItem.getRelated().getRepresentativesUrl();

        name = selectedItem.getName();

        // Showing a toast to let the user know an item was selected
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void getRepresentativeSets() {
        Call<RepresentativeSetList> call = jsonPlaceHolderApi.getRepresentativeSetList();

        call.enqueue(new Callback<RepresentativeSetList>() {
            @Override
            public void onResponse(Call<RepresentativeSetList> call, Response<RepresentativeSetList> response) {
                if (!response.isSuccessful()) {
                    errorMessage.setText("Error Code: " + response.code());
                    return;
                }

                RepresentativeSetList arrayOfObjects = response.body();

                populateSpinner(arrayOfObjects, spinner);
            }

            @Override
            public void onFailure(Call<RepresentativeSetList> call, Throwable t) {
                errorMessage.setText(t.getMessage());
            }
        });
    }

    private void populateSpinner(RepresentativeSetList mList, Spinner mSpinner) {

        List<RepresentativeSet> data = new ArrayList<>();

        for (int i = 0; i < mList.getRepresentativeSets().size(); i++) {

            data.add(mList.getRepresentativeSets().get(i));
        }

        ArrayAdapter<RepresentativeSet> adapter;

        adapter = new ArrayAdapter<RepresentativeSet>(this, android.R.layout.simple_list_item_1, data);

        //setting adapter to spinner
        mSpinner.setAdapter(adapter);
    }

    public void launchRepresentatives(View view) {
        // Testing button responsiveness on Log
        Log.d(TAG, "launchRepresentatives: Button Clicked!");


        Intent intent = new Intent(this, Representatives.class);
        Bundle dataBundle = new Bundle();
        dataBundle.putString("url", url);
        dataBundle.putString("name", name);
        intent.putExtras(dataBundle);
        startActivity(intent);
    }
}
