package de.jbamberger.offlinefetcher.source.jodel.model;

import java.util.List;

public class GetChannelsInfoResponse {
    public final List<ChannelInfo> channels;

    public GetChannelsInfoResponse(List<ChannelInfo> list) {
        this.channels = list;
    }
}
