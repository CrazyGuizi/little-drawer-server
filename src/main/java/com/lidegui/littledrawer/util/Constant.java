package com.lidegui.littledrawer.util;

import java.io.File;

/**
 * @Author: lidegui
 * @Date:Created in 23:50 2019/4/12
 */
public class Constant {
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_FAIL = 1;
    public static final String MSG_SUCCESS = "操作成功";
    public static final String MSG_FAIL = "操作失败";

    public static final String LOCALHOST = "http://127.0.0.1:8080";

    public static final String[] USER_DEFAULT_ICON =
            new String[] {"http://wx4.sinaimg.cn/mw690/6a04b428ly1g19akwia0rg209b09qwgf.gif",
            "http://wx4.sinaimg.cn/mw690/6a04b428ly1g19al1td90g209q08sq4i.gif",
    "http://wx4.sinaimg.cn/mw690/6a04b428ly1g19akvdvgtg209q07bmyf.gif",
    "http://wx4.sinaimg.cn/mw690/6a04b428ly1g19akw738rg209q07dgn0.gif",
    "http://wx4.sinaimg.cn/mw690/6a04b428ly1g19akwy67ng208d09q0ua.gif",
    "http://wx4.sinaimg.cn/mw690/6a04b428ly1g19akzesteg207e09q761.gif",
    "http://wx4.sinaimg.cn/mw690/6a04b428ly1g19al0c9iog209q0773zw.gif",
    "http://wx4.sinaimg.cn/mw690/6a04b428ly1g19al0qbjag209q09q0u7.gif"};

    public static final String RESOURCE_IMAGE_PATH = "classpath:static" + File.separator + "image";
    public static final String RESOURCE_VIDEO_PATH = "classpath:static" + File.separator + "video";

    public static final String API_USER = "api/user";
    public static final String API_NEWS = "api/news";
    public static final String API_COMMON = "api/common";
    public static final String API_VIDEO = "api/video";
    public static final String API_PICTURE = "api/picture";
    public static final String API_RESOURCE = "api/resource";

    public static final String API_USER_VALIDATE_USERNAME = "/validateUsername";
    public static final String API_USER_LOGIN = "/login";
    public static final String API_USER_REGISTER = "/register";
    public static final String API_USER_UPDATE_USER = "/updateUser";
    public static final String API_USER_GET_ALL_USERS = "/getAllUsers";
    public static final String API_USER_DELETE_USER = "/deleteUser";


    public static final String API_NEWS_ADD_NEWS = "/addNews";
    public static final String API_NEWS_DELETE_NEWS_BY_ID = "/deleteNewsById";
    public static final String API_NEWS_UPDATE_NEWS_BY_ID = "/updateNewsById";
    public static final String API_NEWS_GET_NEWS_BY_ID = "/getNewsById";
    public static final String API_NEWS_GET_NEWS_BY_COLUMN = "/getNewsByColumn";
    public static final String API_NEWS_GET_NEWS_BY_USER_ID = "/getNewsByUserId";
    public static final String API_NEWS_GET_NEWS_RANDOM = "/getNewsRandom";
    public static final String API_NEWS_SEARCH_NEWS = "/searchNews";


    public static final String API_COMMON_ADD_COMMENT = "/addComment";
    public static final String API_COMMON_DELETE_COMMENT = "/deleteComment";
    public static final String API_COMMON_GET_COMMENTS_BY_TOPIC = "/getCommentsByTopic";
    public static final String API_COMMON_ADD_REPLY = "/addReply";
    public static final String API_COMMON_DELETE_REPLY = "/deleteReply";
    public static final String API_COMMON_GET_REPLYS_BY_COMMENT_ID = "/getReplysByCommentId";
    public static final String API_COMMON_ADD_LIKE = "/addLike";
    public static final String API_COMMON_SET_LIKE_STATUS = "/setLikeStatus";
    public static final String API_COMMON_GET_LIKE_STATUS = "/getLikeStatus";
    public static final String API_COMMON_ADD_COLLECTION = "/addCollection";
    public static final String API_COMMON_CANCEL_COLLECTION = "/cancelCollection";
    public static final String API_COMMON_GET_COLLECTION_STATUS = "/getCollectionStatus";


    public static final String API_VIDEO_ADD_VIDEO = "/addVideo";
    public static final String API_VIDEO_DELETE_VIDEO = "/deleteVideo";
    public static final String API_VIDEO_GET_VIDEO_BY_ID = "/getVideoById";
    public static final String API_VIDEO_GET_VIDEOS_BY_USER_ID = "/getVideosByUserId";
    public static final String API_VIDEO_GET_VIDEOS_BY_TYPE = "/getVideosByType";
    public static final String API_VIDEO_GET_VIDEOS_RANDOM = "/getVideosRandom";



    public static final String API_PICTURE_ADD_PICTURE = "/addPicture";
    public static final String API_PICTURE_DELETE_PICTURE = "/deletePicture";
    public static final String API_PICTURE_GET_PICTURE_BY_ID = "/getPictureById";
    public static final String API_PICTURE_GET_FUNNY_PICTURES_RANDOM = "/getFunnyPicturesRandom";
    public static final String API_PICTURE_GET_PICTURES_BY_USER_ID = "/getPicturesByUserId";



    public static final String API_RESOURCE_UPLOAD_PICTURE = "upload/picture";
    public static final String API_RESOURCE_UPLOAD_VIDEO = "upload/video";
    public static final String API_RESOURCE_DOWNLOAD_PICTURE = "download/picture";
    public static final String API_RESOURCE_DOWNLOAD_VIDEO = "download/video";



}
