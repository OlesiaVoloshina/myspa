package org.example.mixin;

import org.hippoecm.hst.core.container.HstComponentWindow;
import org.hippoecm.hst.pagemodelapi.v09.core.model.ComponentWindowModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public abstract class ComponentWindowModelMixin extends ComponentWindowModel {

    ComponentWindowModelMixin(final HstComponentWindow window) {
        super(window);
    }

    @JsonIgnore
    @Override
    public String getComponentClass() {
        return super.getComponentClass();
    }

    @JsonSerialize(converter = ComponentNameConverter.class)
    @Override
    public String getName() {
        return super.getName();
    }
}
