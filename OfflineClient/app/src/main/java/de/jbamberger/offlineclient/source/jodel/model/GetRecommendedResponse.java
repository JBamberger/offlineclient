package de.jbamberger.offlineclient.source.jodel.model;

import java.util.List;

public class GetRecommendedResponse {
    public final List<ChannelInfo> country;
    public final List<ChannelInfo> local;
    public final List<ChannelInfo> recommended;

    public GetRecommendedResponse(List<ChannelInfo> list, List<ChannelInfo> list2, List<ChannelInfo> list3) {
        this.recommended = list;
        this.local = list2;
        this.country = list3;
    }
}
