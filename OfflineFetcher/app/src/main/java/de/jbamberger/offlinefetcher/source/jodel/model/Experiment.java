package de.jbamberger.offlinefetcher.source.jodel.model;

import java.util.List;

public class Experiment {
    public final List<String> features;
    public final String group;
    public final String name;

    public Experiment(String str, String str2, List<String> list) {
        this.name = str;
        this.group = str2;
        this.features = list;
    }
}
