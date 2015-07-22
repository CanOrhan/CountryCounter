package uk.co.kiwisoft.tomtom;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Can Orhan on 22/07/15.
 */
public class GraphFragment extends Fragment {
    @Bind({
        R.id.node_0_0, R.id.node_1_0, R.id.node_2_0,
        R.id.node_0_1, R.id.node_1_1, R.id.node_2_1,
        R.id.node_0_2, R.id.node_1_2, R.id.node_2_2
    }) TextView[] nodeTextViews;

    @Bind(R.id.calculate) TextView calculateTextView;
    private MainActivity activity;
    private final CountriesService countriesService = new CountriesService(3); //ToDo: Should be injected.

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (MainActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_graph, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @OnClick({
        R.id.node_0_0, R.id.node_1_0, R.id.node_2_0,
        R.id.node_0_1, R.id.node_1_1, R.id.node_2_1,
        R.id.node_0_2, R.id.node_1_2, R.id.node_2_2
    })
    public void increaseValue(TextView v){
        int val = Integer.valueOf(v.getText().toString());
        v.setText((val + 1) + "");
    }

    @OnClick(R.id.calculate)
    public void calculate(){
        for(TextView node : nodeTextViews){
            int x = Character.getNumericValue(node.getTag().toString().charAt(0));
            int y = Character.getNumericValue(node.getTag().toString().charAt(1));
            Integer color = Integer.valueOf(node.getText().toString());
            countriesService.addNode(new Node(x, y, color));
        }

        calculateTextView.setText("" + countriesService.calculate());
    }
}
