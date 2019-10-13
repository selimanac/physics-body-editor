package aurelienribon.bodyeditor;

import aurelienribon.bodyeditor.io.JsonIo;
import aurelienribon.bodyeditor.models.PolygonModel;
import aurelienribon.bodyeditor.models.RigidBodyModel;
import aurelienribon.utils.io.FilenameHelper;
import aurelienribon.utils.notifications.ChangeableObject;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.badlogic.gdx.math.Vector2;

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

        File path = getProjectDir();
        String modelName = "";

        File defoldDirectory =  new File(path + "/defold");
        FileUtils.deleteDirectory(defoldDirectory);
       
        for (RigidBodyModel model : Ctx.bodies.getModels()) {

            
            System.out.println(model.getName());
            modelName = model.getName();
            int i = 0;
            for (PolygonModel polygon : model.getPolygons()) {

                String shapeStringContainer = "";
                
                shapeStringContainer += "shape_type: TYPE_HULL" + System.lineSeparator();

                for (Vector2 vertex : polygon.vertices) {
                    shapeStringContainer += "data: " + (vertex.x - model.getOrigin().x) + System.lineSeparator();
                    shapeStringContainer += "data: " + (vertex.y - model.getOrigin().y) + System.lineSeparator();
                    shapeStringContainer += "data: 0" + System.lineSeparator();
                }

                System.out.println(shapeStringContainer);
                i++;
               
                File filePath =  new File(path + "/defold/" + modelName + "_" + i + ".convexshape");
                System.out.println("Save File Name: " + filePath);
                FileUtils.writeStringToFile(filePath, shapeStringContainer);
            }
            i = 0;
        }


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
