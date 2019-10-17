package aurelienribon.bodyeditor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.badlogic.gdx.math.Vector2;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;

import aurelienribon.bodyeditor.io.JsonIo;
import aurelienribon.bodyeditor.models.PolygonModel;
import aurelienribon.bodyeditor.models.RigidBodyModel;
import aurelienribon.utils.io.FilenameHelper;
import aurelienribon.utils.notifications.ChangeableObject;

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
        FileUtils.writeStringToFile(projectFile, str, StandardCharsets.UTF_8);

    }

    public String toDefoldComponentString(String path, int id) {
        return String.format("embedded_components {" + System.lineSeparator() + " id: \"collisionobject" + id + "\" "
                + System.lineSeparator() + " type: \"collisionobject\" " + System.lineSeparator()
                + " data: \"collision_shape: \\\"/" + path + "\\\"\\n\" " + System.lineSeparator()
                + " \"type: COLLISION_OBJECT_TYPE_STATIC\\n\" " + System.lineSeparator() + " \"mass: 0.0\\n\" "
                + System.lineSeparator() + " \"friction: 0.1\\n\" " + System.lineSeparator()
                + " \"restitution: 0.5\\n\" " + System.lineSeparator() + " \"group: \\\"default\\\"\\n\" "
                + System.lineSeparator() + " \"mask: \\\"default\\\"\\n\" " + System.lineSeparator()
                + " \"linear_damping: 0.0\\n\" " + System.lineSeparator() + " \"angular_damping: 0.0\\n\" "
                + System.lineSeparator() + " \"locked_rotation: false\\n\" " + System.lineSeparator() + " \"\" "
                + System.lineSeparator() + " position { " + System.lineSeparator() + "     x: 0.0 "
                + System.lineSeparator() + "     y: 0.0 " + System.lineSeparator() + "     z: 0.0 "
                + System.lineSeparator() + " } " + System.lineSeparator() + " rotation { " + System.lineSeparator()
                + "     x: 0.0 " + System.lineSeparator() + "     y: 0.0 " + System.lineSeparator() + "     z: 0.0 "
                + System.lineSeparator() + "     w: 1.0 " + System.lineSeparator() + " } " + System.lineSeparator()
                + "} " + System.lineSeparator());
    }

    public void exportToDefoldFile() throws IOException, JSONException {

        assert projectFile != null;

        File path = getProjectDir();
        String modelName = "";

        File defoldDirectory = new File(path + "/defold");
        FileUtils.deleteDirectory(defoldDirectory);

        for (RigidBodyModel model : Ctx.bodies.getModels()) {

            modelName = model.getName();
            modelName = modelName.replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
            modelName = FilenameHelper.trim(modelName);
            String componentString = "";

            int i = 0;
            for (PolygonModel polygon : model.getPolygons()) {

                String shapeStringContainer = "";

                shapeStringContainer += "shape_type: TYPE_HULL" + System.lineSeparator();

                for (Vector2 vertex : polygon.vertices) {
                    shapeStringContainer += "data: " + (vertex.x - model.getOrigin().x) + System.lineSeparator();
                    shapeStringContainer += "data: " + (vertex.y - model.getOrigin().y) + System.lineSeparator();
                    shapeStringContainer += "data: 0" + System.lineSeparator();
                }

                i++;
                
                File filePath = new File(path + "/defold/" + modelName + "/" + modelName + "_" + i + ".convexshape");
                FileUtils.writeStringToFile(filePath, shapeStringContainer, StandardCharsets.UTF_8);

                componentString += toDefoldComponentString(modelName + "/" + modelName + "_" + i + ".convexshape", i);
            }

            File filePath = new File(path + "/defold/" + modelName + "/" + modelName + ".go");
            FileUtils.writeStringToFile(filePath, componentString, StandardCharsets.UTF_8);
            i = 0;
        }

    }

    public void importFromFile() throws IOException, JSONException {
        assert projectFile != null;
        assert projectFile.isFile();

        Ctx.bodies.getModels().clear();
        String str = FileUtils.readFileToString(projectFile, StandardCharsets.UTF_8);

        JsonIo.deserialize(str);
    }

    public String buildImagePath(File imgFile) {
        return FilenameHelper.getRelativePath(imgFile.getPath(), projectFile.getParent());
    }

    public File getImageFile(String imgPath) {
        if (imgPath == null)
            return null;
        File file = new File(projectFile.getParent(), imgPath);
        return file;
    }
}
