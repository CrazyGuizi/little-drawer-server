package com.lidegui.littledrawer.dto;

import com.lidegui.littledrawer.bean.File;
import com.lidegui.littledrawer.bean.Picture;
import com.lidegui.littledrawer.bean.Video;

/**
 * @Author: lidegui
 * @Date:Created in 21:07 2019/4/16
 */
public class AddVideo {
    private Video video;

    private File videoSource;

    private Picture videoPoster;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public File getVideoSource() {
        return videoSource;
    }

    public void setVideoSource(File videoSource) {
        this.videoSource = videoSource;
    }

    public Picture getVideoPoster() {
        return videoPoster;
    }

    public void setVideoPoster(Picture videoPoster) {
        this.videoPoster = videoPoster;
    }
}
