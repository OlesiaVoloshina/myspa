package org.example.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoHtml;

@HippoEssentialsGenerated(internalName = "myproject:Product")
@Node(jcrType = "myproject:Product")
public class Product extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "myproject:title")
    public String getTitle() {
        return getSingleProperty("myproject:title");
    }

    @HippoEssentialsGenerated(internalName = "myproject:introduction")
    public String getIntroduction() {
        return getSingleProperty("myproject:introduction");
    }

    @HippoEssentialsGenerated(internalName = "myproject:price")
    public Double getPrice() {
        return getSingleProperty("myproject:price");
    }

    @HippoEssentialsGenerated(internalName = "myproject:rating")
    public Double getRating() {
        return getSingleProperty("myproject:rating");
    }

    @HippoEssentialsGenerated(internalName = "myproject:instock")
    public Long getInstock() {
        return getSingleProperty("myproject:instock");
    }

    @HippoEssentialsGenerated(internalName = "myproject:categories")
    public String[] getCategories() {
        return getMultipleProperty("myproject:categories");
    }

    @HippoEssentialsGenerated(internalName = "myproject:description")
    public HippoHtml getDescription() {
        return getHippoHtml("myproject:description");
    }
}
