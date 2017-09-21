package com.example.android.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {


    /**
     * API KEY and Video ID for playing the Video
     **/
    public static final String API_KEY = "AIzaSyB0VuiAuIZjupbwZywr0VOdLOhSUK4Qk4c";
    public static String VIDEO_ID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        Intent intent = getIntent();
        VIDEO_ID = intent.getStringExtra(EXTRA_MESSAGE);

        /** Initializing the Youtube Player View **/
        YouTubePlayerView tubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        tubePlayerView.initialize(API_KEY, this);
    }

    /**
     * This method gets the video if the connection is successfully established
     *
     * @param provider
     * @param youTubePlayer is the youtube player object
     * @param b
     */
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        /**Add Listeners to Youtube Player Instance **/
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        /** Start Buffering **/
        if (!b) {
            youTubePlayer.cueVideo(VIDEO_ID);
        }
    }


    /**
     * This method is called when, youtubeplayer is not initialized
     *
     * @param provider
     * @param youTubeInitializationResult
     */
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(getApplicationContext(), "Failed To Initialize Player!", Toast.LENGTH_SHORT).show();
    }


    /**
     * This Calss is used to handle video loading chatracteristics
     */
    YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };
}
