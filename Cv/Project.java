package org.techtown.cv;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.techtown.cv.R;

public class Project extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project);


        final VideoView videoview=(VideoView)findViewById(R.id.videoView);
        Uri url= Uri.parse("https://user-images.githubusercontent.com/64322765/116147960-4e077800-a71b-11eb-8fb8-99aba38e817a.mp4");
        videoview.setVideoURI(url);
        videoview.setMediaController(new MediaController(this));

        final VideoView videoview2=(VideoView)findViewById(R.id.videoView2);
        Uri url2= Uri.parse("https://user-images.githubusercontent.com/64322765/116149054-a4c18180-a71c-11eb-97ed-0a1bd65173d1.mp4");
        videoview2.setVideoURI(url2);
        videoview2.setMediaController(new MediaController(this));
    }
}