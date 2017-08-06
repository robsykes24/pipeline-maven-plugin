package org.jenkinsci.plugins.pipeline.maven.trigger;

import hudson.Extension;
import hudson.model.Cause;
import hudson.model.Item;
import hudson.model.Job;
import hudson.triggers.Trigger;
import hudson.triggers.TriggerDescriptor;
import jenkins.branch.MultiBranchProject;
import jenkins.branch.OrganizationFolder;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * @author <a href="mailto:cleclerc@cloudbees.com">Cyrille Le Clerc</a>
 */
public class WorkflowJobDependencyTrigger extends Trigger<Job<?, ?>> {

    @DataBoundConstructor
    public WorkflowJobDependencyTrigger(){

    }

    @Extension
    public static class DescriptorImpl extends TriggerDescriptor {
        @Override
        public boolean isApplicable(Item item) {
            return item instanceof WorkflowJob || item instanceof MultiBranchProject || item instanceof OrganizationFolder;
        }

        public String getDisplayName() {
            return "Build whenever a SNAPSHOT dependency is built";
        }

    }
}
