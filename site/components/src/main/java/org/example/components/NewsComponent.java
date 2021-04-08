package org.example.components;
/*
 * Copyright 2020 Bloomreach B.V. (http://www.bloomreach.com)
 * Usage is prohibited except for people attending a training given or authorised by Bloomreach B.V., and only for that purpose.
 */

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.exceptions.FilterException;
import org.hippoecm.hst.content.beans.query.filter.BaseFilter;
import org.hippoecm.hst.content.beans.query.filter.Filter;
import org.hippoecm.hst.content.beans.query.filter.FilterImpl;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.onehippo.cms7.essentials.components.EssentialsNewsComponent;
import org.onehippo.cms7.essentials.components.info.EssentialsNewsComponentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ParametersInfo(type = NewsComponentInfo.class)
public class NewsComponent extends EssentialsNewsComponent {

    private static final Logger log = LoggerFactory.getLogger(NewsComponent.class);

    @Override
    protected void contributeAndFilters(List<BaseFilter> filters, HstRequest request, HstQuery query) {
        super.contributeAndFilters(filters, request, query);
        try {
            final NewsComponentInfo paramInfo = getComponentParametersInfo(request);
            if( BooleanUtils.isTrue(paramInfo.isFilterNews())
                    && StringUtils.isNotEmpty(paramInfo.getTextToFilter())) {
                final Filter fakeFilter = query.createFilter();
                fakeFilter.addNotContains("myproject:title", paramInfo.getTextToFilter());
                filters.add(fakeFilter);
            }

        } catch (Exception e) {
            log.error("Can't add fake news filter: " + e.getMessage(), e);
        }
    }
}
