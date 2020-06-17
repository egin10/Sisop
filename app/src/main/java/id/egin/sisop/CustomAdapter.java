package id.egin.sisop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.BreakIterator;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    LayoutInflater mInflater;
    ArrayList<Sisop> sisop;
    Context mContext;

    public CustomAdapter(Context context, ArrayList<Sisop> sisop) {
        this.mInflater = LayoutInflater.from(context);
        this.sisop = sisop;
        this.mContext = context;
    }

    @Override public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create view from layout
        View itemView = mInflater.inflate( R.layout.rowview, parent, false);
        return new CustomViewHolder(itemView);
    }

    @Override public void onBindViewHolder(final CustomViewHolder holder, final int position) {
        // Retrieve the data for that position
        final Sisop current = sisop.get(position);
        // Add the data to the view
        holder.namaItemView.setText(current.nama);
        holder.logoItemView.setImageResource(current.imageId);
        // add the Listener to the view of that position if desired
        holder.logoItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), holder.namaItemView.getText(), Toast.LENGTH_SHORT).show();
                sisop.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override public int getItemCount() {
        // Return the number of
        // data items to display
        return sisop.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView namaItemView;
        private ImageView logoItemView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            namaItemView = itemView.findViewById(R.id.namaos);
            logoItemView = itemView.findViewById(R.id.logo);
        }
    }
}
