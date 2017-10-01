package de.jbamberger.offlineclient.source.jodel.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetUserConfigResponse {
    public final int channelsFollowLimit;
    public final List<Experiment> experiments;
    @SerializedName("feedInternationalized")
    public final boolean feedInternationalized;
    public final List<String> followedChannels;
    public final boolean homeClearAllowed;
    public final String homeName;
    public final boolean homeSet;
    public final boolean moderationNotify;
    public final boolean moderator;
    public final String userType;
    public final boolean verified;

    public GetUserConfigResponse(boolean z, String str, List<Experiment> list, List<String> list2, int i, boolean z2, String str2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.moderator = z;
        this.userType = str;
        this.experiments = list;
        this.followedChannels = list2;
        this.channelsFollowLimit = i;
        this.homeSet = z2;
        this.homeName = str2;
        this.verified = z3;
        this.moderationNotify = z5;
        this.homeClearAllowed = z4;
        this.feedInternationalized = z6;
    }

    public Set<String> getFeaturesNamesSet() {
        Set<String> hashSet = new HashSet();
        if (this.experiments != null) {
            for (Experiment experiment : this.experiments) {
                if (experiment.features != null) {
                    hashSet.addAll(experiment.features);
                }
            }
        }
        return hashSet;
    }

    public String[] getExperimentsNamesList() {
        if (this.experiments == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (Experiment experiment : this.experiments) {
            arrayList.add(experiment.name);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String getExperimentsNamesString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.experiments.size(); i++) {
            appendExperimentName(stringBuilder, i);
        }
        return stringBuilder.toString();
    }

    private void appendExperimentName(StringBuilder stringBuilder, int i) {
        stringBuilder.append(this.experiments.get(i));
        if (i < this.experiments.size() - 1) {
            stringBuilder.append(", ");
        }
    }
}
