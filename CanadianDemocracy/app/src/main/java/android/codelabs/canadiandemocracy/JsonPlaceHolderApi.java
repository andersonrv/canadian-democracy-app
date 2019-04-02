package android.codelabs.canadiandemocracy;

import android.codelabs.canadiandemocracy.representativeSetsData.RepresentativeSetList;
import android.codelabs.canadiandemocracy.representativesData.Representative;
import android.codelabs.canadiandemocracy.representativesData.RepresentativeList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET("/representative-sets/?limit=0") // Complimentary url = /representative-sets
    Call<RepresentativeSetList> getRepresentativeSetList();

    @GET // Complimentary url = /representative-sets
    Call<RepresentativeList> getRepresentativeList(@Url String getUrl);
}
