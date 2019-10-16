package aurelienribon.bodyeditor.ui;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.LwjglCanvas;

import org.json.JSONException;

import aurelienribon.bodyeditor.Ctx;
import aurelienribon.bodyeditor.canvas.Canvas;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Main {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true");

                config.useGL30 = false;
                LwjglCanvas glCanvas = new LwjglCanvas(new Canvas(), config);
                // LwjglAWTCanvas glCanvas = new LwjglAWTCanvas(new Canvas(), config);

                MainWindow mw = Ctx.window;

                //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                mw.setCanvas(glCanvas.getCanvas());

                mw.setSize(1175, 800);
                mw.setMinimumSize(new Dimension(1170, 800));
                mw.setLocationRelativeTo(null);

                mw.setVisible(true);
                
                parseArgs(args);

                
            }
        });
        
    }

    private static void parseArgs(String[] args) {
        for (int i = 1; i < args.length; i++) {
            if (args[i - 1].equals("-f")) {
                try {
                    File file = new File(args[i]).getCanonicalFile();
                    Ctx.io.setProjectFile(file);
                    Ctx.io.importFromFile();
                } catch (IOException ex) {
                } catch (JSONException ex) {
                }
            }
        }
    }
}
