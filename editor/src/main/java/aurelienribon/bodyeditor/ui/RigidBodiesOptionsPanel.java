package aurelienribon.bodyeditor.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import aurelienribon.ui.css.Style;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import aurelienribon.bodyeditor.Ctx;
import aurelienribon.bodyeditor.Settings;
import aurelienribon.bodyeditor.canvas.Canvas;
import aurelienribon.bodyeditor.canvas.rigidbodies.RigidBodiesScreen;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class RigidBodiesOptionsPanel extends javax.swing.JPanel {

    public static final String PROP_SELECTION = "selection";

    public RigidBodiesOptionsPanel() {
        initComponents();

        Style.registerCssClasses(headerPanel, ".headerPanel");

        setPivotBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPivot();
            }
        });

        resetZoomBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetZoom();
            }
        });

        drawImageChk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateOptions();
            }
        });
        drawShapeChk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateOptions();
            }
        });
        drawPolysChk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateOptions();
            }
        });
        debugPhysicsChk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateOptions();
            }
        });
        drawGridChk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateOptions();
            }
        });
        enableSnapToGridChk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateOptions();
            }
        });
        gridGapSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateOptions();
            }
        });
    }

    private void setPivot() {
        RigidBodiesScreen.setPivot();
        Canvas.resetZoom();
        // Ctx.bodies.getSelectedModel().;
    }

    private void resetZoom() {
        Canvas.resetZoom();
    }

    private void updateOptions() {
        Settings.isImageDrawn = drawImageChk.isSelected();
        Settings.isShapeDrawn = drawShapeChk.isSelected();
        Settings.isPolygonDrawn = drawPolysChk.isSelected();
        Settings.isPhysicsDebugEnabled = debugPhysicsChk.isSelected();
        Settings.isGridShown = drawGridChk.isSelected();
        Settings.isSnapToGridEnabled = enableSnapToGridChk.isSelected();
        Settings.gridGap = (Float) gridGapSpinner.getValue();
    }

    // -------------------------------------------------------------------------
    // Generated Stuff
    // -------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new aurelienribon.ui.components.PaintedPanel();
        setPivotBtn = new javax.swing.JButton();
        resetZoomBtn = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();

        jPanel6 = new javax.swing.JPanel();
        drawGridChk = new javax.swing.JCheckBox();
        drawPolysChk = new javax.swing.JCheckBox();
        drawImageChk = new javax.swing.JCheckBox();
        gridGapSpinner = new javax.swing.JSpinner();
        drawShapeChk = new javax.swing.JCheckBox();
        enableSnapToGridChk = new javax.swing.JCheckBox();
        debugPhysicsChk = new javax.swing.JCheckBox();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(2000, 0),
                new java.awt.Dimension(32767, 32767));

        setOpaque(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel6.setOpaque(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setOpaque(false);
        jToolBar1.setRollover(true);

        java.awt.Color fontColor = new java.awt.Color(219, 219, 219);

        drawGridChk.setText("Draw grid with gap");
        drawGridChk.setFocusable(false);
        drawGridChk.setOpaque(true);
        drawGridChk.setForeground(fontColor);

        drawPolysChk.setSelected(true);
        drawPolysChk.setText("Draw convex polygons");
        drawPolysChk.setFocusable(false);
        drawPolysChk.setOpaque(false);
        drawPolysChk.setForeground(fontColor);

        drawImageChk.setSelected(true);
        drawImageChk.setText("Draw background image");
        drawImageChk.setFocusable(false);
        drawImageChk.setOpaque(false);
        drawImageChk.setForeground(fontColor);

        gridGapSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(100.0f), Float.valueOf(1.0f),
                Float.valueOf(1000.0f), Float.valueOf(0.1f)));
        gridGapSpinner.setFocusable(false);

        drawShapeChk.setSelected(true);
        drawShapeChk.setText("Draw shapes");
        drawShapeChk.setFocusable(false);
        drawShapeChk.setOpaque(false);
        drawShapeChk.setForeground(fontColor);

        enableSnapToGridChk.setText("Enable snap-to-grid");
        enableSnapToGridChk.setFocusable(false);
        enableSnapToGridChk.setOpaque(false);
        enableSnapToGridChk.setForeground(fontColor);

        debugPhysicsChk.setText("Debug physics");
        debugPhysicsChk.setFocusable(false);
        debugPhysicsChk.setOpaque(false);
        debugPhysicsChk.setForeground(fontColor);

        resetZoomBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/ic_zoom.png"))); // NOI18N

        resetZoomBtn.setToolTipText("Reset zoom");
        resetZoomBtn.setMargin(new Insets(10, 100, 10, 10));
        resetZoomBtn.setFocusable(false);
        resetZoomBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        resetZoomBtn.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        resetZoomBtn.setContentAreaFilled(false);
        resetZoomBtn.setOpaque(true);
        resetZoomBtn.setBackground(new Color(87, 87, 87));
        resetZoomBtn.setBorderPainted(true);
        resetZoomBtn.setFocusPainted(false);

        resetZoomBtn.setBorder(new LineBorder(new Color(87, 87, 87), 2, true));

        setPivotBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/ic_axis.png"))); // NOI18N
        setPivotBtn.setToolTipText("Set pivot center");
        setPivotBtn.setFocusable(false);
        setPivotBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        setPivotBtn.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        setPivotBtn.setBackground(new Color(87, 87, 87));
        setPivotBtn.setContentAreaFilled(false);
        setPivotBtn.setOpaque(true);
        setPivotBtn.setBorderPainted(true);
        setPivotBtn.setFocusPainted(false);
        setPivotBtn.setBorder(new LineBorder(new Color(87, 87, 87), 2, true));

        jToolBar1.add(resetZoomBtn);
        jToolBar1.add(setPivotBtn);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(headerPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)));
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jToolBar1,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

        );

        add(headerPanel, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup().addContainerGap()

                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(drawImageChk).addComponent(drawShapeChk))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(debugPhysicsChk).addComponent(drawPolysChk))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(enableSnapToGridChk)
                                .addGroup(jPanel6Layout.createSequentialGroup().addComponent(drawGridChk)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gridGapSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(drawGridChk).addComponent(gridGapSpinner,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enableSnapToGridChk))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(drawImageChk).addComponent(drawPolysChk))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(drawShapeChk).addComponent(debugPhysicsChk))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        // add(resetZoomBtn);
        // add(setPivotBtn);

        add(jPanel6);
        add(filler1);

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private aurelienribon.ui.components.PaintedPanel headerPanel;
    private javax.swing.JButton resetZoomBtn;
    private javax.swing.JButton setPivotBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox debugPhysicsChk;
    private javax.swing.JCheckBox drawGridChk;
    private javax.swing.JCheckBox drawImageChk;
    private javax.swing.JCheckBox drawPolysChk;
    private javax.swing.JCheckBox drawShapeChk;
    private javax.swing.JCheckBox enableSnapToGridChk;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JSpinner gridGapSpinner;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
