package android.codelabs.canadiandemocracy;

import android.codelabs.canadiandemocracy.representativesData.RepresentativeList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Representatives extends AppCompatActivity {

    String TAG = "MAIN ACTIVITY: ";

    // RETROFIT

    private final String baseUrl = "https://represent.opennorth.ca";

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    private ArrayList<String> mPic = new ArrayList<>();
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mParty = new ArrayList<>();
    private ArrayList<String> mWebsite = new ArrayList<>();

    // END RETROFIT

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_representatives);

        Bundle extras = getIntent().getExtras();

        String url = extras.getString("url");

        // Concatenating string to retrieve a result set with no paging
        url += "?limit=0";

        String name = extras.getString("name");
        setTitle(name);

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getRepresentatives(url);

    }

    private void getRepresentatives(String url) {
        Call<RepresentativeList> call = jsonPlaceHolderApi.getRepresentativeList(url);

        call.enqueue(new Callback<RepresentativeList>() {
            @Override
            public void onResponse(Call<RepresentativeList> call, Response<RepresentativeList> response) {
                if (!response.isSuccessful()) {
                    setTitle("Error Code: " + response.code());
                    return;
                }

                RepresentativeList result = response.body();

                for (int i = 0; i < result.getRepresentatives().size(); i++) {
                    mPic.add(result.getRepresentatives().get(i).getPhotoUrl());
                    mName.add(result.getRepresentatives().get(i).getName());
                    mParty.add(result.getRepresentatives().get(i).getPartyName());
                    mWebsite.add(result.getRepresentatives().get(i).getPersonalUrl());
//                    Debugging
//                    Log.d(TAG, "onResponse: " + result.getRepresentatives().get(i).getName());
//                    Log.d(TAG, "onResponse: " + result.getRepresentatives().get(i).getPhotoUrl());
//                    Log.d(TAG, "onResponse: " + result.getRepresentatives().get(i).getPartyName());
//                    Log.d(TAG, "onResponse: " + result.getRepresentatives().get(i).getPersonalUrl());
//                    Log.d(TAG, "********************************************");
                }

                loadRecyclerView();
            }

            @Override
            public void onFailure(Call<RepresentativeList> call, Throwable t) {
                setTitle(t.getMessage());
            }
        });
    }

    private void loadRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mPic, mName, mParty, mWebsite);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
