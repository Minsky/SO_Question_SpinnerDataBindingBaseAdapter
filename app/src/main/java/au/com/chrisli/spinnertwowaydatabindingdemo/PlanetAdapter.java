package au.com.chrisli.spinnertwowaydatabindingdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.adapters.TextViewBindingAdapter;
import android.media.tv.TvView;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import au.com.chrisli.spinnertwowaydatabindingdemo.databinding.PlanetSpinnerItemBinding;

public class PlanetAdapter extends BaseAdapter
{
    private int itemLayoutResourceId;
    private final List<Planet> planets;
    private LayoutInflater inflater;

    public PlanetAdapter(@NonNull Context context, @LayoutRes int itemLayoutResourceId, List<Planet> planets)
    {
        inflater = LayoutInflater.from(context);
        this.itemLayoutResourceId = itemLayoutResourceId;
        this.planets = planets;
    }

    @Override
    public int getCount()
    {
        return planets.size();
    }

    @Override
    public Object getItem(int position)
    {
        return planets.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        PlanetViewHolder holder;

        if (convertView == null) {
            PlanetSpinnerItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.planet_spinner_item, parent, false);

            holder = new PlanetViewHolder(itemBinding);
            holder.view = itemBinding.getRoot();
            holder.view.setTag(holder);
            itemBinding.executePendingBindings();
        }
        else {
            holder = (PlanetViewHolder) convertView.getTag();
        }
        holder.binding.setPlanet(planets.get(position));
        return holder.binding.getRoot();
    }

    private static class PlanetViewHolder
    {
        private View view;
        private PlanetSpinnerItemBinding binding;

        PlanetViewHolder(PlanetSpinnerItemBinding binding)
        {
            this.view = binding.getRoot();
            this.binding = binding;
        }
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent)
//    {
//        View row = convertView;
//        PlanetViewHolder holder;
//
//        if (row == null) {
//            row = inflater.inflate(itemLayoutResourceId, parent, false);
//            // row = inflater.inflate(R.layout.planet_spinner_item, parent, false);
//            holder = new PlanetViewHolder();
//            holder.name = (TextView) row.findViewById(R.id.planetName);
//            holder.distance = (TextView) row.findViewById(R.id.planetDistance);
//
//            row.setTag(holder);
//        }
//        else {
//            holder = (PlanetViewHolder) row.getTag();
//        }
//
//        Planet planet = planets.get(position);
//        holder.name.setText(planet.getName());
//        holder.distance.setText(String.valueOf(planet.getDistance()) + " am");
//
//        return row;
//    }
//
//    private static class PlanetViewHolder
//    {
//        private TextView name;
//        private TextView distance;
//    }
}
