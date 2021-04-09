package org.example;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.onehippo.cms7.services.eventbus.HippoEventListenerRegistry;
import org.onehippo.cms7.services.eventbus.Subscribe;
import org.onehippo.repository.events.HippoWorkflowEvent;
import org.onehippo.repository.modules.DaemonModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublicationPostProcessingModule implements DaemonModule {

    public static final String PUBLICATION_INTERACTION = "default:handle:publish";
    public static final Logger LOG = LoggerFactory.getLogger(PublicationPostProcessingModule.class);

    @Override
    public void initialize(final Session session) throws RepositoryException {
        HippoEventListenerRegistry.get().register(this);
    }

    @Override
    public void shutdown() {
        HippoEventListenerRegistry.get().unregister(this);
    }

    @Subscribe
    public void handleEvent(final HippoWorkflowEvent event) {
        if (event.success() && PUBLICATION_INTERACTION.equals(event.interaction())) {
            // how to do something to generate and send new event? how can we add some request to dashboard, for example?
            LOG.info("User {} has published {} at path {}", event.user(), event.documentType(), event.subjectPath());
        }
    }
}
