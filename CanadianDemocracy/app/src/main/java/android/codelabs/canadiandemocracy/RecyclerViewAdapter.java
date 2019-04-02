package android.codelabs.canadiandemocracy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private final String defaultImage = "http://www.stephenvilletx.gov/wp-content/uploads/2013/07/image-not-available-male.jpg";

    private final String noWebsiteMessage = "Sorry, no personal website available";

    private final String noNameMessage = "Name is not available";

    private final String noPartyMessage = "Party is not available";

    private Context mContext;
    private ArrayList<String> mPic = new ArrayList<>();
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mParty = new ArrayList<>();
    private ArrayList<String> mWebsite = new ArrayList<>();

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mPic, ArrayList<String> mName, ArrayList<String> mParty, ArrayList<String> mWebsite) {
        this.mContext = mContext;
        this.mPic = mPic;
        this.mName = mName;
        this.mParty = mParty;
        this.mWebsite = mWebsite;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.representative_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        // Binding loaded data into the view holder in RecyclerView

        String fetchedPic = mPic.get(position);
        String fetchedName = mName.get(position);
        String fetchedParty = mPic.get(position);
        String fetchedWebsite = mWebsite.get(position);

        if (fetchedPic != null && !fetchedPic.isEmpty()) {
            Picasso.get().load(mPic.get(position)).into(holder.pic);
        } else {
            Picasso.get().load(defaultImage).into(holder.pic);
        }

        if (fetchedName != null && !fetchedName.isEmpty()) {
            holder.name.setText(mName.get(position));
        } else {
            holder.name.setText(noNameMessage);
        }

        if (fetchedParty != null && !fetchedParty.isEmpty()) {
            holder.party.setText(mParty.get(position));
        } else {
            holder.party.setText(noPartyMessage);
        }

        // Binding onClick if personal website is available
        if (fetchedWebsite != null && !fetchedWebsite.isEmpty()) {
            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = mWebsite.get(position);
                    openWebPage(url);
                }
            });
        } else {
            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, noWebsiteMessage, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView name;
        TextView party;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.representative_pic);
            name = itemView.findViewById(R.id.representative_name);
            party = itemView.findViewById(R.id.representative_party);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
            mContext.startActivity(intent);
        }
    }
}
