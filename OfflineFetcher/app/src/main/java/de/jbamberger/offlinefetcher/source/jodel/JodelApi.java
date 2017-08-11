package de.jbamberger.offlinefetcher.source.jodel;

import java.util.Map;

import de.jbamberger.offlinefetcher.source.jodel.model.ActionTrackingRequest;
import de.jbamberger.offlinefetcher.source.jodel.model.ChannelInfo;
import de.jbamberger.offlinefetcher.source.jodel.model.DownVoteReason;
import de.jbamberger.offlinefetcher.source.jodel.model.EmptyResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.FlagReason;
import de.jbamberger.offlinefetcher.source.jodel.model.GetChannelsInfoResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.GetHashtagsSuggestedResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.GetKarmaResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.GetModerationPostsResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.GetNotificationStatusResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.GetPlaceSearchResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.GetPostsComboResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.GetPostsResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.GetRecommendedResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.GetUserConfigResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.InstanceIDToken;
import de.jbamberger.offlinefetcher.source.jodel.model.LocationUpdateResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.ModerationResult;
import de.jbamberger.offlinefetcher.source.jodel.model.ModerationTaskInfo;
import de.jbamberger.offlinefetcher.source.jodel.model.NewAccessTokenRequest;
import de.jbamberger.offlinefetcher.source.jodel.model.NewAccessTokenResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.PinPostResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.Post;
import de.jbamberger.offlinefetcher.source.jodel.model.PostDetailsResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.PostRequest;
import de.jbamberger.offlinefetcher.source.jodel.model.PostingResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.PushTokenRequest;
import de.jbamberger.offlinefetcher.source.jodel.model.PushVerificationDescriptor;
import de.jbamberger.offlinefetcher.source.jodel.model.RequestTokenRequest;
import de.jbamberger.offlinefetcher.source.jodel.model.SendLanguageRequest;
import de.jbamberger.offlinefetcher.source.jodel.model.SendLocationRequest;
import de.jbamberger.offlinefetcher.source.jodel.model.ShareInfo;
import de.jbamberger.offlinefetcher.source.jodel.model.TextSearchBody;
import de.jbamberger.offlinefetcher.source.jodel.model.UpVoteReason;
import de.jbamberger.offlinefetcher.source.jodel.model.UserNotifications;
import de.jbamberger.offlinefetcher.source.jodel.model.UserNotificationsNew;
import de.jbamberger.offlinefetcher.source.jodel.model.UserTypeRequest;
import de.jbamberger.offlinefetcher.source.jodel.model.VerifyAndGetAccessTokenResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.VoteInformation;
import retrofit2.Call;
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
    public abstract Call<GetPostsResponse> getMostPopularPosts(@Query("after") String paramString, @Query("lat") double paramDouble1, @Query("lng") double paramDouble2, @Query("home") boolean paramBoolean1, @Query("skipHometown") boolean paramBoolean2);

    @GET("/v3/pictures/location")
    public abstract Call<GetPostsResponse> getMostRecentPictures(@Query("after") String paramString, @Query("limit") int paramInt, @Query("home") boolean paramBoolean);

    @GET("/v2/posts/location/")
    public abstract Call<GetPostsResponse> getMostRecentPosts(@Query("after") String paramString, @Query("lat") double paramDouble1, @Query("lng") double paramDouble2, @Query("home") boolean paramBoolean1, @Query("skipHometown") boolean paramBoolean2);
*/

    /*@GET("v2/posts/{postId}/")
    public abstract Call<Post> getPost(@Path("postId") String postId, @Query("highlight") String highlight, @Query("home") boolean home);

    @GET("v3/posts/{id}/details")
    public abstract Call<PostDetailsResponse> getPostDetails(@Path("id") String paramString1, @Query("highlight") String paramString2, @Query("details") boolean paramBoolean1, @Query("reply") String paramString3, @Query("reversed") boolean paramBoolean2, @Query("origin") String paramString4);

    @GET("v3/posts/location/combo")
    public abstract Call<GetPostsComboResponse> getPostsCombo(@Query("lat") double lat, @Query("lng") double lng, @Query("stickies") boolean stickies, @Query("home") boolean home, @Query("skipHometown") boolean skipHometown);
*/

    @DELETE("/v3/user/home")
    Call<EmptyResponse> deletUserHome();

    @DELETE("/v2/posts/{postId}")
    Call<Response> deletePost(@Path("postId") String str);

    @PUT("/v2/posts/{id}/notifications/disable")
    Call<Post> disablePostNotification(@Path("id") String str, @Body Object obj);

    @PUT("/v3/stickyposts/{id}/dismiss")
    Call<Response> dismissStickyPost(@Path("id") String str, @Body Object obj);

    @PUT("/v2/posts/{postId}/downvote")
    Call<VoteInformation> downvotePost(
            @Path("postId") String str, @Body DownVoteReason downVoteReason,
            @Query("home") boolean z);

    @PUT("/v3/stickyposts/{id}/down")
    Call<Response> downvoteStickyPost(@Path("id") String str, @Body Object obj);

    @PUT("/v2/posts/{id}/notifications/enable")
    Call<Post> enablePostNotification(@Path("id") String str, @Body Object obj);

    @PUT("/v3/user/feedInternationalization/disable")
    Call<Response> feedInternationalizationDisable(@Body Object obj);

    @PUT("/v3/user/feedInternationalization/enable")
    Call<Response> feedInternationalizationEnable(@Body Object obj);

    @PUT("/v2/posts/{postId}/flag")
    Call<Response> flagPost(@Path("postId") String str, @Body FlagReason flagReason);

    @PUT("/v3/user/followChannel")
    Call<EmptyResponse> followChannel(@Query("channel") String str, @Body Object obj);

    @GET("/v3/posts/channel/combo")
    Call<GetPostsComboResponse> getChannelCombo(
            @Query("channel") String str, @Query("home") boolean z);

    @GET("/v3/user/channelMeta")
    Call<ChannelInfo> getChannelMeta(@Query("channel") String str, @Query("home") boolean z);

    @GET("/v3/posts/channel/discussed")
    Call<GetPostsResponse> getDiscussedChannelPosts(
            @Query("channel") String str, @Query("after") String str2, @Query("home") boolean z);

    @GET("/v3/posts/hashtag/discussed")
    Call<GetPostsResponse> getDiscussedHashtagPosts(
            @Query("hashtag") String str, @Query("after") String str2, @Query("home") boolean z);

    @GET("/v3/posts/filter/places/{placeId}/combo")
    Call<GetPostsComboResponse> getFilterPlaceCombo(
            @Path("placeId") String str);

    @GET("/v3/posts/filter/places/{placeId}/discussed")
    Call<GetPostsResponse> getFilterPlaceDiscussed(
            @Path("placeId") String str, @Query("after") String str2, @Query("limit") int i);

    @GET("/v3/posts/filter/places/{placeId}/popular")
    Call<GetPostsResponse> getFilterPlacePopular(
            @Path("placeId") String str, @Query("after") String str2, @Query("limit") int i);

    @GET("/v3/posts/filter/places/{placeId}/recent")
    Call<GetPostsResponse> getFilterPlaceRecent(
            @Path("placeId") String str, @Query("after") String str2, @Query("limit") int i);

    @POST("/v3/user/followedChannelsMeta")
    Call<GetChannelsInfoResponse> getFollowedChannelsMeta(
            @Body Map<String, Long> map, @Query("home") boolean z);

    @GET("/v3/posts/hashtag/combo")
    Call<GetPostsComboResponse> getHashtagCombo(
            @Query("hashtag") String str, @Query("home") boolean z);

    @GET("/v3/hashtags/suggested")
    Call<GetHashtagsSuggestedResponse> getHashtagsSuggested(@Query("home") boolean z);

    @GET("/v2/users/karma")
    Call<GetKarmaResponse> getKarma();

    @GET("/v3/moderation")
    Call<GetModerationPostsResponse> getModerationFeed();

    @GET("/v3/moderation/notificationStatus")
    Call<GetNotificationStatusResponse> getModerationNotificationStatus();

    @GET("/v3/moderation/taskInfo")
    Call<ModerationTaskInfo> getModerationTaskInfo();

    @GET("/v3/pictures/location/discussed")
    Call<GetPostsResponse> getMostDiscussedPictures(
            @Query("after") String str, @Query("limit") int i,
            @Query("home") boolean z, @Query("timeRange") String str2);

    @GET("/v2/posts/location/discussed")
    Call<GetPostsResponse> getMostDiscussedPosts(
            @Query("after") String str, @Query("lat") double d, @Query("lng") double d2,
            @Query("home") boolean z, @Query("skipHometown") boolean z2,
            @Query("timeRange") String str2);

    @GET("/v3/pictures/location/popular")
    Call<GetPostsResponse> getMostPopularPictures(
            @Query("after") String str, @Query("limit") int i, @Query("home") boolean z,
            @Query("timeRange") String str2);

    @GET("/v2/posts/location/popular")
    Call<GetPostsResponse> getMostPopularPosts(
            @Query("after") String str, @Query("lat") double d, @Query("lng") double d2,
            @Query("home") boolean z, @Query("skipHometown") boolean z2,
            @Query("timeRange") String str2);

    @GET("/v3/pictures/location")
    Call<GetPostsResponse> getMostRecentPictures(
            @Query("after") String str, @Query("limit") int i, @Query("home") boolean z);

    @GET("/v2/posts/location/")
    Call<GetPostsResponse> getMostRecentPosts(
            @Query("after") String str, @Query("lat") double d, @Query("lng") double d2,
            @Query("home") boolean z, @Query("skipHometown") boolean z2);

    @GET("/v2/posts/mine/discussed/")
    Call<GetPostsResponse> getMyMostDiscussedPosts(
            @Query("skip") int i, @Query("limit") int i2);

    @GET("/v2/posts/mine/pinned/")
    Call<GetPostsResponse> getMyPinnedPosts();

    @GET("/v2/posts/mine/pinned/")
    Call<GetPostsResponse> getMyPinnedPosts(@Query("skip") int i, @Query("limit") int i2);

    @GET("/v2/posts/mine/popular/")
    Call<GetPostsResponse> getMyPopularPosts(@Query("skip") int i, @Query("limit") int i2);

    @GET("/v2/posts/mine/")
    Call<GetPostsResponse> getMyPosts(@Query("skip") int i, @Query("limit") int i2);

    @GET("/v2/posts/mine/combo")
    Call<GetPostsComboResponse> getMyPostsCombo();

    @GET("/v2/posts/mine/replies/")
    Call<GetPostsResponse> getMyRepliedPosts();

    @GET("/v2/posts/mine/replies/")
    Call<GetPostsResponse> getMyRepliedPosts(@Query("skip") int i, @Query("limit") int i2);

    @GET("/v2/posts/mine/votes/")
    Call<GetPostsResponse> getMyVotedPosts();

    @GET("/v2/posts/mine/votes/")
    Call<GetPostsResponse> getMyVotedPosts(@Query("skip") int i, @Query("limit") int i2);

    @GET("/v3/posts/newsfeed")
    Call<GetPostsResponse> getNewsFeed(@Query("after") String str, @Query("home") boolean z);

    @GET("/v3/places/search")
    Call<GetPlaceSearchResponse> getPlaceSearch(
            @Header("lat") double d, @Header("lng") double d2);

    @GET("/v3/posts/channel/popular")
    Call<GetPostsResponse> getPopularChannelPosts(
            @Query("channel") String str, @Query("after") String str2, @Query("home") boolean z);

    @GET("/v3/posts/hashtag/popular")
    Call<GetPostsResponse> getPopularHashtagPosts(
            @Query("hashtag") String str, @Query("after") String str2, @Query("home") boolean z);

    @GET("/v2/posts/{postId}/")
    Call<Post> getPost(
            @Path("postId") String str, @Query("highlight") String str2, @Query("home") boolean z);

    @GET("/v3/posts/{id}/details")
    Call<PostDetailsResponse> getPostDetails(
            @Path("id") String str, @Query("highlight") String str2, @Query("details") boolean z,
            @Query("reply") String str3, @Query("reversed") boolean z2,
            @Query("origin") String str4, @Query("bookmark") boolean z3);

    @GET("v3/posts/location/combo")
    public abstract Call<GetPostsComboResponse> getPostsCombo(
            @Query("lat") double lat, @Query("lng") double lng, @Query("stickies") boolean stickies,
            @Query("home") boolean home, @Query("skipHometown") boolean skipHometown);


    @GET("/v3/posts/channel")
    Call<GetPostsResponse> getRecentChannelPosts(
            @Query("channel") String str, @Query("after") String str2, @Query("home") boolean z);

    @GET("/v3/posts/hashtag")
    Call<GetPostsResponse> getRecentHashtagPosts(
            @Query("hashtag") String str, @Query("after") String str2, @Query("home") boolean z);

    @GET("/v3/user/recommendedChannels")
    Call<GetRecommendedResponse> getRecommendedChannels(@Query("home") boolean z);

    @POST("/v2/users/refreshToken")
    Call<NewAccessTokenResponse> getRefreshedAccessToken(
            @Body NewAccessTokenRequest newAccessTokenRequest);

    @GET("/v3/user/config")
    Call<GetUserConfigResponse> getUserConfig();

    @GET("/v3/user/notifications/new")
    Call<UserNotificationsNew> getUserNotificationsNew();

    @POST("/v3/posts/{id}/giveThanks")
    Call<Object> giveThanks(@Path("id") String str, @Body Object obj);

    @PUT("/v3/posts/{id}/hide")
    Call<Response> hidePost(@Path("id") String str, @Body Object obj);

    @PUT("/v2/posts/{postId}/pin")
    Call<PinPostResponse> pinPost(@Path("postId") String str, @Body Object obj);

    @POST("/v3/posts/{postId}/share")
    Call<ShareInfo> postFetchPostShareURL(@Path("postId") String str, @Body Object obj);

    @POST("/v3/posts/search")
    Call<GetPostsResponse> postPostsSearch(
            @Body TextSearchBody textSearchBody, @Query("skip") int i, @Query("limit") int i2,
            @Query("home") boolean z);

    @POST("/v3/posts/search")
    Call<GetPostsResponse> postPostsSearch(
            @Body TextSearchBody textSearchBody, @Query("home") boolean z);

    @POST("/v3/user/verification/iid")
    Call<EmptyResponse> postUserVerificationInstanceId(@Body InstanceIDToken instanceIDToken);

    @PUT("/v3/user/notifications/post/{postId}/read")
    Call<Response> putNotificationPostRead(@Path("postId") String str, @Body Object obj);

    @PUT("/v3/user/notifications")
    Call<UserNotifications> putUserNotifications(@Body Object obj);

    @PUT("/v3/user/home")
    Call<EmptyResponse> sendHomeTown(@Body SendLocationRequest sendLocationRequest);

    @PUT("/v3/user/language")
    Call<EmptyResponse> sendLanguage(@Body SendLanguageRequest sendLanguageRequest);

    @PUT("/v3/investigate")
    Call<Response> sendLogs(@Body Object obj);

    @POST("/v3/moderation")
    Call<Object> sendModerationResult(@Body ModerationResult moderationResult);

    @POST("/v3/posts/")
    Call<PostingResponse> sendPost(@Body PostRequest postRequest);

    @PUT("/v2/users/pushToken")
    Call<Response> sendPushToken(@Body PushTokenRequest pushTokenRequest);

    @PUT("/v2/users/location")
    Call<LocationUpdateResponse> sendUserLocation(
            @Body SendLocationRequest sendLocationRequest);

    @PUT("/v3/user/profile")
    Call<Object> setProfile(@Body UserTypeRequest userTypeRequest);

    @POST("/v2/users/")
    Call<VerifyAndGetAccessTokenResponse> signupToGetAccessToken(
            @Body RequestTokenRequest requestTokenRequest);

    @POST("/v3/action")
    Call<Response> trackAction(@Body ActionTrackingRequest actionTrackingRequest);

    @PUT("/v3/user/unfollowChannel")
    Call<EmptyResponse> unfollowChannel(@Query("channel") String str, @Body Object obj);

    @PUT("/v2/posts/{postId}/unpin")
    Call<PinPostResponse> unpinPost(@Path("postId") String str, @Body Object obj);

    @PUT("/v2/posts/{postId}/upvote")
    Call<VoteInformation> upvotePost(
            @Path("postId") String str, @Body UpVoteReason upVoteReason, @Query("home") boolean z);

    @PUT("/v3/stickyposts/{id}/up")
    Call<Response> upvoteStickyPost(@Path("id") String str, @Body Object obj);

    @POST("/v3/user/verification/push")
    Call<Object> verifyPush(@Body PushVerificationDescriptor pushVerificationDescriptor);

}
