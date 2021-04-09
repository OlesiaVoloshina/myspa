package org.example.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoCompound;

@HippoEssentialsGenerated(internalName = "myproject:GeoLocation")
@Node(jcrType = "myproject:GeoLocation")
public class GeoLocation extends HippoCompound {
    @HippoEssentialsGenerated(internalName = "myproject:latitude")
    public String getLatitude() {
        return getSingleProperty("myproject:latitude");
    }

    @HippoEssentialsGenerated(internalName = "myproject:longitude")
    public String getLongitude() {
        return getSingleProperty("myproject:longitude");
    }
}
