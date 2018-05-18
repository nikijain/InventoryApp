package sfatechgroup.inventory.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class HomeFragment extends Fragment {

    LinearLayout linearRateContract;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(sfatechgroup.inventory.R.layout.fragment_home, container, false);

//        linearRateContract = view.findViewById(sfatechgroup.inventory.R.id.linearRateContract);
//        linearRateContract.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent = new Intent(getActivity(), sfatechgroup.inventory.RateContractActivity.class);
//                startActivity(intent);
//            }
//        });

        return view;
    }

}
