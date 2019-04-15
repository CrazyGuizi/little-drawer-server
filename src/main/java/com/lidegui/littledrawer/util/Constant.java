package com.lidegui.littledrawer.util;

/**
 * @Author: lidegui
 * @Date:Created in 23:50 2019/4/12
 */
public class Constant {
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_FAIL = 1;
    public static final String MSG_SUCCESS = "操作成功";
    public static final String MSG_FAIL = "操作失败";

    public static final String[] USER_DEFAULT_ICON = new String[] {"https://hbimg.huabanimg.com/0cd458748df3517e0e0ab07e9f669ff36d52fa1532f0f-ra8CU6_fw658",
            "https://hbimg.huabanimg.com/5845718d9c6fc5f6e492d6351ff34626c1e821a53004f-PPjNj6_fw658",
    "https://hbimg.huabanimg.com/b450e9cc2e3d3e96b5437fb745eb3f1d686653a34aedd-onv08G_fw658",
    "https://hbimg.huabanimg.com/7a8bdf3d8748587564c8c079fd5b0c70b3278b5a37271-oOYBGZ_fw658",
    "https://hbimg.huabanimg.com/9d9a273cf7ce7a1ccbd87301f86e459cebd4b3853edf3-ynvIFn_fw658",
    "https://hbimg.huabanimg.com/4e5a94e9240a099b462d5e5371d137ddd0eb097743947-vpjnd3_fw658",
    "https://hbimg.huabanimg.com/4f1b23073e6162f6cc057644da466bbb2980bce451cad-MRi6mO_fw658",
    "https://hbimg.huabanimg.com/dfc5922d4a92172cbd789202b7ed1b0b98c6bcfa4343b-aA0e53_fw658"};
    public static final String s = "";

    public static final String API_USER = "api/user";
    public static final String API_NEWS = "api/news";
    public static final String API_COMMON = "api/common";
    public static final String API_VIDEO = "api/video";
    public static final String API_PICTURE = "api/picture";

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


}
