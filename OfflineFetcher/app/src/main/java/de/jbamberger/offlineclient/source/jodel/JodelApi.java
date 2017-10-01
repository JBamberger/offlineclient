package de.jbamberger.offlineclient.source.jodel;

import android.arch.lifecycle.LiveData;

import java.util.Map;

import de.jbamberger.offlineclient.source.ApiResponse;
import de.jbamberger.offlineclient.source.jodel.model.ActionTrackingRequest;
import de.jbamberger.offlineclient.source.jodel.model.ChannelInfo;
import de.jbamberger.offlineclient.source.jodel.model.DownVoteReason;
import de.jbamberger.offlineclient.source.jodel.model.EmptyResponse;
import de.jbamberger.offlineclient.source.jodel.model.FlagReason;
import de.jbamberger.offlineclient.source.jodel.model.GetChannelsInfoResponse;
import de.jbamberger.offlineclient.source.jodel.model.GetHashtagsSuggestedResponse;
import de.jbamberger.offlineclient.source.jodel.model.GetKarmaResponse;
import de.jbamberger.offlineclient.source.jodel.model.GetModerationPostsResponse;
import de.jbamberger.offlineclient.source.jodel.model.GetNotificationStatusResponse;
import de.jbamberger.offlineclient.source.jodel.model.GetPlaceSearchResponse;
import de.jbamberger.offlineclient.source.jodel.model.GetPostsComboResponse;
import de.jbamberger.offlineclient.source.jodel.model.GetPostsResponse;
import de.jbamberger.offlineclient.source.jodel.model.GetRecommendedResponse;
import de.jbamberger.offlineclient.source.jodel.model.GetUserConfigResponse;
import de.jbamberger.offlineclient.source.jodel.model.InstanceIDToken;
import de.jbamberger.offlineclient.source.jodel.model.LocationUpdateResponse;
import de.jbamberger.offlineclient.source.jodel.model.ModerationResult;
import de.jbamberger.offlineclient.source.jodel.model.ModerationTaskInfo;
import de.jbamberger.offlineclient.source.jodel.model.NewAccessTokenRequest;
import de.jbamberger.offlineclient.source.jodel.model.NewAccessTokenResponse;
import de.jbamberger.offlineclient.source.jodel.model.PinPostResponse;
import de.jbamberger.offlineclient.source.jodel.model.Post;
import de.jbamberger.offlineclient.source.jodel.model.PostDetailsResponse;
import de.jbamberger.offlineclient.source.jodel.model.PostRequest;
import de.jbamberger.offlineclient.source.jodel.model.PostingResponse;
import de.jbamberger.offlineclient.source.jodel.model.PushTokenRequest;
import de.jbamberger.offlineclient.source.jodel.model.PushVerificationDescriptor;
import de.jbamberger.offlineclient.source.jodel.model.RequestTokenRequest;
import de.jbamberger.offlineclient.source.jodel.model.SendLanguageRequest;
import de.jbamberger.offlineclient.source.jodel.model.SendLocationRequest;
import de.jbamberger.offlineclient.source.jodel.model.ShareInfo;
import de.jbamberger.offlineclient.source.jodel.model.TextSearchBody;
import de.jbamberger.offlineclient.source.jodel.model.UpVoteReason;
import de.jbamberger.offlineclient.source.jodel.model.UserNotifications;
import de.jbamberger.offlineclient.source.jodel.model.UserNotificationsNew;
import de.jbamberger.offlineclient.source.jodel.model.UserTypeRequest;
import de.jbamberger.offlineclient.source.jodel.model.VerifyAndGetAccessTokenResponse;
import de.jbamberger.offlineclient.source.jodel.model.VoteInformation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public interface JodelApi {

    public static final String BASE_URL = "https://api.go-tellm.com:443/api/";
/*
    @GET("/v2/posts/location/popular")
    public abstract LiveData<ApiResponse<GetPostsResponse>> getMostPopularPosts(@Query("after") String paramString, @Query("lat") double paramDouble1, @Query("lng") double paramDouble2, @Query("home") boolean paramBoolean1, @Query("skipHometown") boolean paramBoolean2);

    @GET("/v3/pictures/location")
    public abstract LiveData<ApiResponse<GetPostsResponse>> getMostRecentPictures(@Query("after") String paramString, @Query("limit") int paramInt, @Query("home") boolean paramBoolean);

    @GET("/v2/posts/location/")
    public abstract LiveData<ApiResponse<GetPostsResponse>> getMostRecentPosts(@Query("after") String paramString, @Query("lat") double paramDouble1, @Query("lng") double paramDouble2, @Query("home") boolean paramBoolean1, @Query("skipHometown") boolean paramBoolean2);
*/

    /*@GET("v2/posts/{postId}/")
    public abstract LiveData<ApiResponse<Post>> getPost(@Path("postId") String postId, @Query("highlight") String highlight, @Query("home") boolean home);

    @GET("v3/posts/{id}/details")
    public abstract LiveData<ApiResponse<PostDetailsResponse>> getPostDetails(@Path("id") String paramString1, @Query("highlight") String paramString2, @Query("details") boolean paramBoolean1, @Query("reply") String paramString3, @Query("reversed") boolean paramBoolean2, @Query("origin") String paramString4);

    @GET("v3/posts/location/combo")
    public abstract LiveData<ApiResponse<GetPostsComboResponse>> getPostsCombo(@Query("lat") double lat, @Query("lng") double lng, @Query("stickies") boolean stickies, @Query("home") boolean home, @Query("skipHometown") boolean skipHometown);
*/


    @DELETE("/v3/user/home")
    LiveData<ApiResponse<EmptyResponse>> deleteUserHome();


    @DELETE("/v2/posts/{postId}")
    LiveData<ApiResponse<Response>> deletePost(
            @Path("postId") String str);


    @PUT("/v2/posts/{id}/notifications/disable")
    LiveData<ApiResponse<Post>> disablePostNotification(
            @Path("id") String str,
            @Body Object obj);


    @PUT("/v3/stickyposts/{id}/dismiss")
    LiveData<ApiResponse<Response>> dismissStickyPost(
            @Path("id") String str,
            @Body Object obj);


    @PUT("/v2/posts/{postId}/downvote")
    LiveData<ApiResponse<VoteInformation>> downvotePost(
            @Path("postId") String postId,
            @Body DownVoteReason downVoteReason,
            @Query("home") boolean z);


    @PUT("/v3/stickyposts/{id}/down")
    LiveData<ApiResponse<Response>> downvoteStickyPost(
            @Path("id") String postId,
            @Body Object obj);


    @PUT("/v2/posts/{id}/notifications/enable")
    LiveData<ApiResponse<Post>> enablePostNotification(
            @Path("id") String str,
            @Body Object obj);


    @PUT("/v3/user/feedInternationalization/disable")
    LiveData<ApiResponse<Response>> feedInternationalizationDisable(
            @Body Object obj);


    @PUT("/v3/user/feedInternationalization/enable")
    LiveData<ApiResponse<Response>> feedInternationalizationEnable(
            @Body Object obj);


    @PUT("/v2/posts/{postId}/flag")
    LiveData<ApiResponse<Response>> flagPost(
            @Path("postId") String str,
            @Body FlagReason flagReason);


    @PUT("/v3/user/followChannel")
    LiveData<ApiResponse<EmptyResponse>> followChannel(
            @Query("channel") String str,
            @Body Object obj);


    @GET("/v3/posts/channel/combo")
    LiveData<ApiResponse<GetPostsComboResponse>> getChannelCombo(
            @Query("channel") String str,
            @Query("home") boolean z);


    @GET("/v3/user/channelMeta")
    LiveData<ApiResponse<ChannelInfo>> getChannelMeta(
            @Query("channel") String str,
            @Query("home") boolean z);


    @GET("/v3/posts/channel/discussed")
    LiveData<ApiResponse<GetPostsResponse>> getDiscussedChannelPosts(
            @Query("channel") String str,
            @Query("after") String str2,
            @Query("home") boolean z);


    @GET("/v3/posts/hashtag/discussed")
    LiveData<ApiResponse<GetPostsResponse>> getDiscussedHashtagPosts(
            @Query("hashtag") String str,
            @Query("after") String str2,
            @Query("home") boolean z);


    @GET("/v3/posts/filter/places/{placeId}/combo")
    LiveData<ApiResponse<GetPostsComboResponse>> getFilterPlaceCombo(
            @Path("placeId") String str);


    @GET("/v3/posts/filter/places/{placeId}/discussed")
    LiveData<ApiResponse<GetPostsResponse>> getFilterPlaceDiscussed(
            @Path("placeId") String str,
            @Query("after") String str2,
            @Query("limit") int i);


    @GET("/v3/posts/filter/places/{placeId}/popular")
    LiveData<ApiResponse<GetPostsResponse>> getFilterPlacePopular(
            @Path("placeId") String str,
            @Query("after") String str2,
            @Query("limit") int i);


    @GET("/v3/posts/filter/places/{placeId}/recent")
    LiveData<ApiResponse<GetPostsResponse>> getFilterPlaceRecent(
            @Path("placeId") String str,
            @Query("after") String str2,
            @Query("limit") int i);


    @POST("/v3/user/followedChannelsMeta")
    LiveData<ApiResponse<GetChannelsInfoResponse>> getFollowedChannelsMeta(

            @Body Map<String, Long> map,
            @Query("home") boolean z);


    @GET("/v3/posts/hashtag/combo")
    LiveData<ApiResponse<GetPostsComboResponse>> getHashtagCombo(
            @Query("hashtag") String str,
            @Query("home") boolean z);


    @GET("/v3/hashtags/suggested")
    LiveData<ApiResponse<GetHashtagsSuggestedResponse>> getHashtagsSuggested(
            @Query("home") boolean z);


    @GET("/v2/users/karma")
    LiveData<ApiResponse<GetKarmaResponse>> getKarma();


    @GET("/v3/moderation")
    LiveData<ApiResponse<GetModerationPostsResponse>> getModerationFeed();


    @GET("/v3/moderation/notificationStatus")
    LiveData<ApiResponse<GetNotificationStatusResponse>> getModerationNotificationStatus();


    @GET("/v3/moderation/taskInfo")
    LiveData<ApiResponse<ModerationTaskInfo>> getModerationTaskInfo();


    @GET("/v3/pictures/location/discussed")
    LiveData<ApiResponse<GetPostsResponse>> getMostDiscussedPictures(
            @Query("after") String str,
            @Query("limit") int i,
            @Query("home") boolean z,
            @Query("timeRange") String str2);


    @GET("/v2/posts/location/discussed")
    LiveData<ApiResponse<GetPostsResponse>> getMostDiscussedPosts(
            @Query("after") String str,
            @Query("lat") double d,
            @Query("lng") double d2,
            @Query("home") boolean z,
            @Query("skipHometown") boolean z2,
            @Query("timeRange") String str2);


    @GET("/v3/pictures/location/popular")
    LiveData<ApiResponse<GetPostsResponse>> getMostPopularPictures(
            @Query("after") String str,
            @Query("limit") int i,
            @Query("home") boolean z,
            @Query("timeRange") String str2);


    @GET("/v2/posts/location/popular")
    LiveData<ApiResponse<GetPostsResponse>> getMostPopularPosts(
            @Query("after") String str,
            @Query("lat") double d,
            @Query("lng") double d2,
            @Query("home") boolean z,
            @Query("skipHometown") boolean z2,
            @Query("timeRange") String str2);


    @GET("/v3/pictures/location")
    LiveData<ApiResponse<GetPostsResponse>> getMostRecentPictures(
            @Query("after") String str,
            @Query("limit") int i,
            @Query("home") boolean z);


    @GET("/v2/posts/location/")
    LiveData<ApiResponse<GetPostsResponse>> getMostRecentPosts(
            @Query("after") String str,
            @Query("lat") double d,
            @Query("lng") double d2,
            @Query("home") boolean z,
            @Query("skipHometown") boolean z2);


    @GET("/v2/posts/mine/discussed/")
    LiveData<ApiResponse<GetPostsResponse>> getMyMostDiscussedPosts(
            @Query("skip") int i,
            @Query("limit") int i2);


    @GET("/v2/posts/mine/pinned/")
    LiveData<ApiResponse<GetPostsResponse>> getMyPinnedPosts();


    @GET("/v2/posts/mine/pinned/")
    LiveData<ApiResponse<GetPostsResponse>> getMyPinnedPosts(
            @Query("skip") int i,
            @Query("limit") int i2);


    @GET("/v2/posts/mine/popular/")
    LiveData<ApiResponse<GetPostsResponse>> getMyPopularPosts(
            @Query("skip") int i,
            @Query("limit") int i2);


    @GET("/v2/posts/mine/")
    LiveData<ApiResponse<GetPostsResponse>> getMyPosts(
            @Query("skip") int i,
            @Query("limit") int i2);

    @GET("/v2/posts/mine/combo")
    LiveData<ApiResponse<GetPostsComboResponse>> getMyPostsCombo();

    @GET("/v2/posts/mine/replies/")
    LiveData<ApiResponse<GetPostsResponse>> getMyRepliedPosts();


    @GET("/v2/posts/mine/replies/")
    LiveData<ApiResponse<GetPostsResponse>> getMyRepliedPosts(
            @Query("skip") int i,
            @Query("limit") int i2);


    @GET("/v2/posts/mine/votes/")
    LiveData<ApiResponse<GetPostsResponse>> getMyVotedPosts();


    @GET("/v2/posts/mine/votes/")
    LiveData<ApiResponse<GetPostsResponse>> getMyVotedPosts(
            @Query("skip") int i,
            @Query("limit") int i2);


    @GET("/v3/posts/newsfeed")
    LiveData<ApiResponse<GetPostsResponse>> getNewsFeed(
            @Query("after") String str,
            @Query("home") boolean z);


    @GET("/v3/places/search")
    LiveData<ApiResponse<GetPlaceSearchResponse>> getPlaceSearch(
            @Header("lat") double d,
            @Header("lng") double d2);


    @GET("/v3/posts/channel/popular")
    LiveData<ApiResponse<GetPostsResponse>> getPopularChannelPosts(
            @Query("channel") String str,
            @Query("after") String str2,
            @Query("home") boolean z);


    @GET("/v3/posts/hashtag/popular")
    LiveData<ApiResponse<GetPostsResponse>> getPopularHashtagPosts(
            @Query("hashtag") String str,
            @Query("after") String str2,
            @Query("home") boolean z);


    @GET("/v2/posts/{postId}/")
    LiveData<ApiResponse<Post>> getPost(
            @Path("postId") String str,
            @Query("highlight") String str2,
            @Query("home") boolean z);


    @GET("/v3/posts/{id}/details")
    LiveData<ApiResponse<PostDetailsResponse>> getPostDetails(
            @Path("id") String str,
            @Query("highlight") String str2,
            @Query("details") boolean z,
            @Query("reply") String str3,
            @Query("reversed") boolean z2,
            @Query("origin") String str4,
            @Query("bookmark") boolean z3);


    @GET("v3/posts/location/combo")
    public abstract LiveData<ApiResponse<GetPostsComboResponse>> getPostsCombo(
            @Query("lat") double lat,
            @Query("lng") double lng,
            @Query("stickies") boolean stickies,
            @Query("home") boolean home,
            @Query("skipHometown") boolean skipHometown);


    @GET("/v3/posts/channel")
    LiveData<ApiResponse<GetPostsResponse>> getRecentChannelPosts(
            @Query("channel") String str,
            @Query("after") String str2,
            @Query("home") boolean z);


    @GET("/v3/posts/hashtag")
    LiveData<ApiResponse<GetPostsResponse>> getRecentHashtagPosts(
            @Query("hashtag") String str,
            @Query("after") String str2,
            @Query("home") boolean z);


    @GET("/v3/user/recommendedChannels")
    LiveData<ApiResponse<GetRecommendedResponse>> getRecommendedChannels(
            @Query("home") boolean z);


    @POST("/v2/users/refreshToken")
    LiveData<ApiResponse<NewAccessTokenResponse>> getRefreshedAccessToken(
            @Body NewAccessTokenRequest newAccessTokenRequest);


    @GET("/v3/user/config")
    LiveData<ApiResponse<GetUserConfigResponse>> getUserConfig();


    @GET("/v3/user/notifications/new")
    LiveData<ApiResponse<UserNotificationsNew>> getUserNotificationsNew();


    @POST("/v3/posts/{id}/giveThanks")
    LiveData<ApiResponse<Object>> giveThanks(
            @Path("id") String str,
            @Body Object obj);


    @PUT("/v3/posts/{id}/hide")
    LiveData<ApiResponse<Response>> hidePost(
            @Path("id") String str,
            @Body Object obj);


    @PUT("/v2/posts/{postId}/pin")
    LiveData<ApiResponse<PinPostResponse>> pinPost(
            @Path("postId") String str,
            @Body Object obj);


    @POST("/v3/posts/{postId}/share")
    LiveData<ApiResponse<ShareInfo>> postFetchPostShareURL(
            @Path("postId") String str,
            @Body Object obj);


    @POST("/v3/posts/search")
    LiveData<ApiResponse<GetPostsResponse>> postPostsSearch(
            @Body TextSearchBody textSearchBody,
            @Query("skip") int i,
            @Query("limit") int i2,
            @Query("home") boolean z);


    @POST("/v3/posts/search")
    LiveData<ApiResponse<GetPostsResponse>> postPostsSearch(
            @Body TextSearchBody textSearchBody,
            @Query("home") boolean z);


    @POST("/v3/user/verification/iid")
    LiveData<ApiResponse<EmptyResponse>> postUserVerificationInstanceId(
            @Body InstanceIDToken instanceIDToken);


    @PUT("/v3/user/notifications/post/{postId}/read")
    LiveData<ApiResponse<Response>> putNotificationPostRead(
            @Path("postId") String str,
            @Body Object obj);


    @PUT("/v3/user/notifications")
    LiveData<ApiResponse<UserNotifications>> putUserNotifications(
            @Body Object obj);


    @PUT("/v3/user/home")
    LiveData<ApiResponse<EmptyResponse>> sendHomeTown(
            @Body SendLocationRequest sendLocationRequest);


    @PUT("/v3/user/language")
    LiveData<ApiResponse<EmptyResponse>> sendLanguage(
            @Body SendLanguageRequest sendLanguageRequest);


    @PUT("/v3/investigate")
    LiveData<ApiResponse<Response>> sendLogs(
            @Body Object obj);


    @POST("/v3/moderation")
    LiveData<ApiResponse<Object>> sendModerationResult(
            @Body ModerationResult moderationResult);


    @POST("/v3/posts/")
    LiveData<ApiResponse<PostingResponse>> sendPost(
            @Body PostRequest postRequest);


    @PUT("/v2/users/pushToken")
    LiveData<ApiResponse<Response>> sendPushToken(
            @Body PushTokenRequest pushTokenRequest);


    @PUT("/v2/users/location")
    LiveData<ApiResponse<LocationUpdateResponse>> sendUserLocation(
            @Body SendLocationRequest sendLocationRequest);


    @PUT("/v3/user/profile")
    LiveData<ApiResponse<Object>> setProfile(
            @Body UserTypeRequest userTypeRequest);


    @POST("/v2/users/")
    LiveData<ApiResponse<VerifyAndGetAccessTokenResponse>> signupToGetAccessToken(
            @Body RequestTokenRequest requestTokenRequest);


    @POST("/v3/action")
    LiveData<ApiResponse<Response>> trackAction(
            @Body ActionTrackingRequest actionTrackingRequest);


    @PUT("/v3/user/unfollowChannel")
    LiveData<ApiResponse<EmptyResponse>> unfollowChannel(
            @Query("channel") String str,
            @Body Object obj);


    @PUT("/v2/posts/{postId}/unpin")
    LiveData<ApiResponse<PinPostResponse>> unpinPost(
            @Path("postId") String str,
            @Body Object obj);


    @PUT("/v2/posts/{postId}/upvote")
    LiveData<ApiResponse<VoteInformation>> upvotePost(
            @Path("postId") String str,
            @Body UpVoteReason upVoteReason,
            @Query("home") boolean z);


    @PUT("/v3/stickyposts/{id}/up")
    LiveData<ApiResponse<Response>> upvoteStickyPost(
            @Path("id") String str,
            @Body Object obj);


    @POST("/v3/user/verification/push")
    LiveData<ApiResponse<Object>> verifyPush(
            @Body PushVerificationDescriptor pushVerificationDescriptor);

}
