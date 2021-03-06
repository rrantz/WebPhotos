/**
 * Copyright 2008 WebPhotos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sf.webphotos.netbeans.project;

import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.spi.project.ActionProvider;
import org.netbeans.spi.project.CopyOperationImplementation;
import org.netbeans.spi.project.DeleteOperationImplementation;
import org.netbeans.spi.project.ProjectState;
import org.netbeans.spi.project.ui.support.DefaultProjectOperations;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Guilherme
 */
public class WebPhotosProject implements Project {

    private final FileObject projectDirectory;
    private final ProjectState state;
    private Lookup lkp;

    public WebPhotosProject(FileObject projectDir, ProjectState state) {
        this.projectDirectory = projectDir;
        this.state = state;
    }

    FileObject getFolder(int folder, boolean create) {
        FileObject result =
                projectDirectory.getFileObject(WebPhotosProjectFactory.PROJECT_ARCHIVES[folder]).getParent();
        if (result == null && create) {
            try {
                result = projectDirectory.createData(WebPhotosProjectFactory.PROJECT_ARCHIVES[folder]).getParent();
            } catch (IOException ioe) {
                Exceptions.printStackTrace(ioe);
            }
        }
        return result;
    }

    @Override
    public FileObject getProjectDirectory() {
        return projectDirectory;
    }

    @Override
    public Lookup getLookup() {
        if (lkp == null) {
            lkp = Lookups.fixed(new Object[]{
                        state, //allow outside code to mark the project as needing saving
                        new ActionProviderImpl(), //Provides standard actions like Build and Clean
                        new WebPhotosDeleteOperation(),
                        new WebPhotosCopyOperation(this),
                        new WebPhotosProjectInformation(), //Project information implementation
                        new WebPhotosProjectLogicalView(this), //Logical view of project implementation
                    });
        }
        return lkp;
    }

    private final class ActionProviderImpl implements ActionProvider {

        private final Map<String, Runnable> supportedOps = new HashMap<>();

        /**
         * It builds a map with supported commands
         */
        public ActionProviderImpl() {
            supportedOps.put(ActionProvider.COMMAND_COPY, new Runnable() {

                @Override
                public void run() {
                    DefaultProjectOperations.performDefaultCopyOperation(WebPhotosProject.this);
                }
            });
            supportedOps.put(ActionProvider.COMMAND_DELETE, new Runnable() {

                @Override
                public void run() {
                    DefaultProjectOperations.performDefaultDeleteOperation(WebPhotosProject.this);
                }
            });
        }
        
        

        @Override
        public String[] getSupportedActions() {
            return supportedOps.keySet().toArray(new String[supportedOps.keySet().size()]);
        }

        @Override
        public void invokeAction(String action, Lookup lookup) throws IllegalArgumentException {
            supportedOps.get(action).run();
        }

        @Override
        public boolean isActionEnabled(String command, Lookup lookup) throws IllegalArgumentException {
            if (Arrays.binarySearch(getSupportedActions(), command) >= 0) {
                return true;
            } else {
                throw new IllegalArgumentException(command);
            }
        }
    }

    private final class WebPhotosDeleteOperation implements DeleteOperationImplementation {

        @Override
        public void notifyDeleting() throws IOException {
        }

        @Override
        public void notifyDeleted() throws IOException {
        }

        @Override
        public List<FileObject> getMetadataFiles() {
            List<FileObject> dataFiles = new ArrayList<>();
            return dataFiles;
        }

        @Override
        public List<FileObject> getDataFiles() {
            List<FileObject> dataFiles = new ArrayList<>();
            return dataFiles;
        }
    }

    private class WebPhotosCopyOperation implements CopyOperationImplementation {

        private final WebPhotosProject project;
        private final FileObject projectDir;

        public WebPhotosCopyOperation(WebPhotosProject project) {
            this.project = project;
            this.projectDir = project.getProjectDirectory();
        }

        @Override
        public void notifyCopying() throws IOException {
        }

        @Override
        public void notifyCopied(Project arg0, File arg1, String arg2) throws IOException {
        }

        @Override
        public List<FileObject> getMetadataFiles() {
            return Collections.EMPTY_LIST;
        }

        @Override
        public List<FileObject> getDataFiles() {
            return Collections.EMPTY_LIST;
        }
    }

    private final class WebPhotosProjectInformation implements ProjectInformation {

        @Override
        public String getName() {
            return getProjectDirectory().getName();
        }

        @Override
        public String getDisplayName() {
            return getName();
        }

        @Override
        public Icon getIcon() {
            return new ImageIcon(ImageUtilities.loadImage(
                    Constants.PROJECT_ICON));
        }

        @Override
        public Project getProject() {
            return WebPhotosProject.this;
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener arg0) {
            /** Do nothing */
            assert arg0 != null : arg0;
        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener arg0) {
            /** Do nothing */
            assert arg0 != null : arg0;
        }
    }
}
