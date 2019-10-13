package aurelienribon.bodyeditor;

import aurelienribon.bodyeditor.io.JsonIo;
import aurelienribon.utils.io.FilenameHelper;
import aurelienribon.utils.notifications.ChangeableObject;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class IoManager extends ChangeableObject {
    public static final String PROP_PROJECTFILE = "projectFile";
    private File projectFile;

    public File getProjectFile() {
        return projectFile;
    }

    public File getProjectDir() {
        return projectFile.getParentFile();
    }

    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
        firePropertyChanged(PROP_PROJECTFILE);
    }

    public void exportToFile() throws IOException, JSONException {
        assert projectFile != null;

        String str = JsonIo.serialize();
        FileUtils.writeStringToFile(projectFile, str);
    }

    public void exportToDefoldFile() throws IOException, JSONException {
        assert projectFile != null;

        //System.out.println("Projectdir: " + getProjectDir() + "file_name");
        //System.out.println("projectFile: " + projectFile);
        Map<String, ArrayList<String[]>>  result = JsonIo.prepareForDefold();

        for (Map.Entry<String, ArrayList<String[]>> entry : result.entrySet()) {

            System.out.println("File Name:  " + entry.getKey());
            //System.out.println( entry.getValue());
            ArrayList<String[]> t = entry.getValue();
            System.out.println("ArrayList Size: " + t.size());
            for (int i = 0; i < t.size(); i++) {
                //System.out.println(t.get(i));
                String[] a = t.get(i);
                System.out.println("StringArray Size: " + a.length);
                for (int ii = 0; ii < a.length; ii++) {
                    System.out.println(a[ii]);
                }
            }
        }
        


       
       // FileUtils.writeStringToFile(projectFile, str);
    }

    public void importFromFile() throws IOException, JSONException {
        assert projectFile != null;
        assert projectFile.isFile();

        Ctx.bodies.getModels().clear();
        String str = FileUtils.readFileToString(projectFile);

        JsonIo.deserialize(str);
    }

    public String buildImagePath(File imgFile) {
        return FilenameHelper.getRelativePath(imgFile.getPath(), projectFile.getParent());
    }

    public File getImageFile(String imgPath) {
        if (imgPath == null) return null;
        File file = new File(projectFile.getParent(), imgPath);
        return file;
    }
}
