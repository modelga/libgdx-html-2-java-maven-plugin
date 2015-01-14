package com.littleinfinity.libgdx.html.processing.interaction;

import com.littleinfinity.libgdx.html.processing.common.joint.JavaSourceComponent;

import java.util.List;

public class InteractionComponent extends JavaSourceComponent {

    private List<InteractionType> interactions;
    private String componentName;

    public void setInteractions(List<InteractionType> interactions) {
        this.interactions = interactions;
    }

    public List<InteractionType> getInteractions() {
        return interactions;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }
}
