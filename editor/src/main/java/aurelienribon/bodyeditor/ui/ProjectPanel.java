package aurelienribon.bodyeditor.ui;

import aurelienribon.bodyeditor.Ctx;
import aurelienribon.bodyeditor.IoManager;
import aurelienribon.ui.css.Style;
import aurelienribon.utils.notifications.ChangeListener;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;;
/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class ProjectPanel extends javax.swing.JPanel {
    public ProjectPanel() {
        initComponents();

        Style.registerCssClasses(headerPanel, ".headerPanel");
        Style.registerCssClasses(saveBtn, ".bold");

        newBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newProject();
            }
        });
        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadProject();
            }
        });
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProject();
            }
        });

        exportDefoldBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               exportDefoldProject();
            }
        });

        prjPathField.setForeground(new Color(211,211,211));
        prjPathField.setBackground(new Color(49,49,49));
        prjPathField.setOpaque(true);
        prjPathField.setBorder(new LineBorder( new Color(87, 87, 87), 2, true ));


        saveBtn.setEnabled(false);
        exportDefoldBtn.setEnabled(false);

        Ctx.io.addChangeListener(new ChangeListener() {
            @Override
            public void propertyChanged(Object source, String propertyName) {
                if (propertyName.equals(IoManager.PROP_PROJECTFILE)) {
                    saveBtn.setEnabled(true);
                    exportDefoldBtn.setEnabled(true);
                    prjPathField.setText(Ctx.io.getProjectFile().getPath());
        
                    Ctx.bodies.getModels().clear();
                }
            }
        });
    }

    private void newProject() {
        File dir = Ctx.io.getProjectFile();
        dir = dir != null ? dir.getParentFile() : new File(".");
        dir = dir != null ? dir : new File(".");

        JFileChooser chooser = new JFileChooser(dir);
        chooser.setDialogTitle("Add new project file");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        chooser.setMultiSelectionEnabled(false);

        if (chooser.showSaveDialog(Ctx.window) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            
            if(!file.getName().contains(".")) file = new File(file.toString() + ".json");
            Ctx.io.setProjectFile(file);
        }
    }

    private void loadProject() {
        File dir = Ctx.io.getProjectFile();
        dir = dir != null ? dir.getParentFile() : new File(".");
        dir = dir != null ? dir : new File(".");

        JFileChooser chooser = new JFileChooser(dir);
        chooser.setDialogTitle("Select the project to load");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(new FileNameExtensionFilter("Json file", "json"));
        chooser.setMultiSelectionEnabled(false);

        if (chooser.showOpenDialog(Ctx.window) == JFileChooser.APPROVE_OPTION) {
            Ctx.io.setProjectFile(chooser.getSelectedFile());

            try {
                Ctx.io.importFromFile();
            } catch (IOException ex) {
                String msg = "Something went wrong while loading the selected file.\n\n"
                        + ex.getClass().getSimpleName() + " - " + ex.getMessage();
                JOptionPane.showMessageDialog(Ctx.window, msg);
            } catch (JSONException ex) {
                String msg = "The selected file is either not compatible or corrupted.\nSorry.";
                JOptionPane.showMessageDialog(Ctx.window, msg);
            }
        }
    }

    private void exportDefoldProject(){
        try {
            Ctx.io.exportToDefoldFile();
            JOptionPane.showMessageDialog(Ctx.window, "Defold export successfully done.");

        } catch (IOException ex) {
            String msg = "Something went wrong while saving.\n\n" + ex.getClass().getSimpleName() + " - " + ex.getMessage();
            JOptionPane.showMessageDialog(Ctx.window, msg);
        } catch (JSONException ex) {
            String msg = "Something went wrong while saving.\n\n" + ex.getClass().getSimpleName() + " - " + ex.getMessage();
            JOptionPane.showMessageDialog(Ctx.window, msg);
        }
    }
    private void saveProject() {
        File file = Ctx.io.getProjectFile();

        if (file == null) {
            String msg = "Please create a new project first.";
            JOptionPane.showMessageDialog(Ctx.window, msg);
            return;
        }

        try {
            Ctx.io.exportToFile();
            JOptionPane.showMessageDialog(Ctx.window, "Save successfully done.");

        } catch (IOException ex) {
            String msg = "Something went wrong while saving.\n\n" + ex.getClass().getSimpleName() + " - " + ex.getMessage();
            JOptionPane.showMessageDialog(Ctx.window, msg);
        } catch (JSONException ex) {
            String msg = "Something went wrong while saving.\n\n" + ex.getClass().getSimpleName() + " - " + ex.getMessage();
            JOptionPane.showMessageDialog(Ctx.window, msg);
        }
    }

    // -------------------------------------------------------------------------
    // Generated stuff
    // -------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new aurelienribon.ui.components.PaintedPanel();
        jToolBar1 = new javax.swing.JToolBar();
        newBtn = new javax.swing.JButton();
        loadBtn = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        saveBtn = new javax.swing.JButton();
        exportDefoldBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        prjPathField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        newBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/ic_new.png"))); // NOI18N

        //newBtn.setBackground(new Color(49, 49, 49));
        newBtn.setContentAreaFilled(false);
        newBtn.setOpaque(true);
        newBtn.setBorderPainted(true);
        newBtn.setFocusPainted(false);
        newBtn.setBorder(new LineBorder( new Color(87, 87, 87), 2, true ));
        newBtn.setToolTipText("New project");
        newBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        newBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(newBtn);

        loadBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/ic_open.png"))); // NOI18N
        loadBtn.setToolTipText("Load project");
        loadBtn.setContentAreaFilled(false);
        loadBtn.setOpaque(true);
        loadBtn.setBorderPainted(true);
        loadBtn.setFocusPainted(false);
        loadBtn.setBorder(new LineBorder( new Color(87, 87, 87), 2, true ));
        
        loadBtn.setFocusable(false);
        loadBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        loadBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(loadBtn);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/ic_save.png"))); // NOI18N
        saveBtn.setContentAreaFilled(false);
        saveBtn.setOpaque(true);
        saveBtn.setBorderPainted(true);
        saveBtn.setFocusPainted(false);
        saveBtn.setToolTipText("Save project");
        saveBtn.setBorder(new LineBorder( new Color(87, 87, 87), 2, true ));
        jToolBar1.add(saveBtn);


        exportDefoldBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/ic_defold.png"))); // NOI18N
        exportDefoldBtn.setContentAreaFilled(false);
        exportDefoldBtn.setOpaque(true);
        exportDefoldBtn.setBorderPainted(true);
        exportDefoldBtn.setFocusPainted(false);
        exportDefoldBtn.setToolTipText("Export for Defold");
        exportDefoldBtn.setBorder(new LineBorder( new Color(87, 87, 87), 2, true ));
        jToolBar2.add(exportDefoldBtn);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(headerPanel, java.awt.BorderLayout.NORTH);

        jPanel1.setOpaque(false);

        prjPathField.setColumns(25);
        prjPathField.setEditable(false);
        prjPathField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        prjPathField.setText("<create or load a project>");
   

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Project file: ");
        jLabel1.setForeground(new Color(219, 219, 219) );
        jLabel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prjPathField, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(prjPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{jLabel1, prjPathField});

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private aurelienribon.ui.components.PaintedPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton loadBtn;
    private javax.swing.JButton newBtn;
    private javax.swing.JTextField prjPathField;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton exportDefoldBtn;
    // End of variables declaration//GEN-END:variables

}
