package edu.temple.classbrowser;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BrowserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrowserFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private String url;

    TextView browserTextView;

    public BrowserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment BrowserFragment.
     */
    /*TODO this is not the way to do what we did when creating fragments for browsers*/

    public static BrowserFragment newInstance(String url) {
        BrowserFragment fragment = new BrowserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, url);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_browser, container, false);

       browserTextView = (TextView) v.findViewById(R.id.browserTexView);
       browserTextView.setText(loadWebPage(url));

       return v;
    }


    public String loadWebPage(final @javax.NonNull String urlString) {
        Thread t = new Thread() {
            public void run() {
                try {
                    URL url = new URL(urlString);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                    StringBuilder tmpString = new StringBuilder();
                    String response = "";
                    while((response = bufferedReader.readLine() != null)
                }catch (InterruptedException e){}
            }
        }.start();
    }

}
