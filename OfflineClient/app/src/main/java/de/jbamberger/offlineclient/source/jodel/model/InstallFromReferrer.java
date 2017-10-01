package de.jbamberger.offlineclient.source.jodel.model;

public class InstallFromReferrer extends ActionTrackingRequest {
    private static String SHARE_REFERRAL_SOURCE = "RegistrationCompleted";
    public final InstallReferrerMetadata metadata;

    public InstallFromReferrer(String str, String str2) {
        super(SHARE_REFERRAL_SOURCE);
        this.metadata = new InstallReferrerMetadata(str, str2);
    }

    public class InstallReferrerMetadata {
        public final String post;
        public final String source;

        private InstallReferrerMetadata(String str, String str2) {
            this.post = str;
            this.source = str2;
        }
    }
}
