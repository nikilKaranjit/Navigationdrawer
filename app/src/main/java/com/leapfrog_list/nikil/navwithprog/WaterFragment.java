package com.leapfrog_list.nikil.navwithprog;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WaterFragment extends Fragment implements View.OnClickListener {

    private TextView tv;
    private ProgressBar progressBar;
    private Button button;
    private int progressStatus=0;
    private android.os.Handler handler= new android.os.Handler();

    public WaterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=null;
        view=inflater.inflate(R.layout.fragment_water,container,false);
        progressBar=(ProgressBar) view.findViewById(R.id.pb);
        button=(Button)view.findViewById(R.id.btn_pb);
        tv=(TextView)view.findViewById(R.id.tvProgress);
        button.setOnClickListener(this);
        return view;
    }



    @Override
    public void onClick(View v) {
        progressStatus=0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatus<100){
                    progressStatus +=1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            tv.setText("Water level" + progressStatus +"/" +progressBar.getMax());
                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    };
}

