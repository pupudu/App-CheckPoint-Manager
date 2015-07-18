package checkpoint;

import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Main() {
        initComponents();
        txtTimeMan.addKeyListener(new KeyAdapter() { 	//prevent typing wrong inputs from keyboard(letters etc)
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        txtTimeManMod.addKeyListener(new KeyAdapter() {	//prevent typing wrong inputs from keyboard(letters etc)
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        txtNumMod.addKeyListener(new KeyAdapter() {		//prevent typing wrong inputs from keyboard(letters etc)
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        txtChkNumDel.addKeyListener(new KeyAdapter() {	//prevent typing wrong inputs from keyboard(letters etc)
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        txtChNameSearch.addKeyListener(new KeyAdapter() {	//prevent typing wrong inputs from keyboard(letters etc)
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        txtChkTimeSearch.addKeyListener(new KeyAdapter() {	//prevent typing wrong inputs from keyboard(letters etc)
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        gTimeAdd = new javax.swing.ButtonGroup();	//for grouping radio buttons
        gStateAdd = new javax.swing.ButtonGroup();	//for grouping radio buttons
        gStateMod = new javax.swing.ButtonGroup();	//for grouping radio buttons
        gTimeMod = new javax.swing.ButtonGroup();	//for grouping radio buttons

        TabbedPane = new javax.swing.JTabbedPane();	//new tabbed pane
        addTab = new javax.swing.JPanel();

        lblSelChkState = new javax.swing.JLabel();	//gui components for adding a new checkpoint
        btnAddChk = new javax.swing.JButton();
        lblChkTime = new javax.swing.JLabel();

        jPanel1 = new javax.swing.JPanel();			//gui components for grouping related radio buttons - time mode selection
        rdbtnTimeMan = new javax.swing.JRadioButton();
        rdBtnTimeSys = new javax.swing.JRadioButton();
        txtTimeMan = new javax.swing.JFormattedTextField("#");

        jPanel2 = new javax.swing.JPanel();				//gui components for displaing details 
        rdBtnOnAdd = new javax.swing.JRadioButton();
        rdBtnOffAdd = new javax.swing.JRadioButton();
        displayTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaDetails = new javax.swing.JTextArea();
        btnDisplayOneDetail = new javax.swing.JButton();	//for details of one checkpoint
        btnDisplayAll = new javax.swing.JButton();			//for details of all checkpoints
        txtNumDetail = new javax.swing.JTextField();
        modifyTab = new javax.swing.JPanel();
        lblChkMod = new javax.swing.JLabel();
        lblTimeMod = new javax.swing.JLabel();
        lblStatusMod = new javax.swing.JLabel();

        jPanel3 = new javax.swing.JPanel();				//gui components for grouping related radiio buttons - modification
        rdBtnOnMod = new javax.swing.JRadioButton();
        rdBtnOffMod = new javax.swing.JRadioButton();
        rdBtnDntMod = new javax.swing.JRadioButton();

        jPanel4 = new javax.swing.JPanel();					//gui components for searching existing checkpoints
        rdBtnTimeManMod = new javax.swing.JRadioButton();
        rdBtnTimeSysMod = new javax.swing.JRadioButton();
        txtTimeManMod = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        txtNumMod = new javax.swing.JTextField();
        btnMod = new javax.swing.JButton();
        deleteTab = new javax.swing.JPanel();
        lblChkNumDelete = new javax.swing.JLabel();
        txtChkNumDel = new javax.swing.JTextField();
        btnDeleteChk = new javax.swing.JButton();
        searchTab = new javax.swing.JPanel();
        lblChkNumSearch = new javax.swing.JLabel();
        lblChkTimeSearch = new javax.swing.JLabel();
        txtChNameSearch = new javax.swing.JTextField();
        txtChkTimeSearch = new javax.swing.JTextField();
        btnSearchNum = new javax.swing.JButton();
        btnSearchTime = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDisplay = new javax.swing.JTextArea();

        jMenuBar1 = new javax.swing.JMenuBar();			// gui components for creating a menu bar
        jMenu1 = new javax.swing.JMenu();
        exitMn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSelChkState.setText("Select Checkpoint State");

        btnAddChk.setText("Add New Checkpoint");	//command button action listener
        btnAddChk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddChkActionPerformed(evt);
            }
        });

        lblChkTime.setText("Checkpoint Time");

        gTimeAdd.add(rdbtnTimeMan);	//add radio buttons to applicable group
        rdbtnTimeMan.setText("Manually Enter a Value");
        rdbtnTimeMan.addChangeListener(new javax.swing.event.ChangeListener() {		// radio button action listner
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdbtnTimeManStateChanged(evt);
            }
        });

        gTimeAdd.add(rdBtnTimeSys);//add radio buttons to applicable group
        rdBtnTimeSys.setSelected(true);
        rdBtnTimeSys.setText("Current Time(System Generated)");
        rdBtnTimeSys.addChangeListener(new javax.swing.event.ChangeListener() {	// radio button action listner
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdBtnTimeSysStateChanged(evt);
            }
        });

        txtTimeMan.setText("");
        txtTimeMan.setToolTipText("TimeStamp as a Long");
        txtTimeMan.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);		// Arrange components in gui form
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rdbtnTimeMan)
                                .addComponent(rdBtnTimeSys)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(txtTimeMan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup( // Arrange components in gui form
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rdBtnTimeSys)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbtnTimeMan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimeMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(86, Short.MAX_VALUE))
        );

        gStateAdd.add(rdBtnOnAdd);		//add to corresponding button group
        rdBtnOnAdd.setSelected(true);//set default state
        rdBtnOnAdd.setText("ON");//set text

        gStateAdd.add(rdBtnOffAdd);//set default state
        rdBtnOffAdd.setText("OFF");//set text

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);		// Arrange components in gui form
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rdBtnOnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(rdBtnOffAdd)
                        .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup( // Arrange components in gui form
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdBtnOnAdd)
                                .addComponent(rdBtnOffAdd))
                        .addContainerGap())
        );

        javax.swing.GroupLayout addTabLayout = new javax.swing.GroupLayout(addTab);		// Arrange components in gui form
        addTab.setLayout(addTabLayout);
        addTabLayout.setHorizontalGroup(
                addTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addTabLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(addTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblSelChkState)
                                .addComponent(lblChkTime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(addTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTabLayout.createSequentialGroup()
                                        .addGroup(addTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8))
                                .addComponent(btnAddChk, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
        );
        addTabLayout.setVerticalGroup( // Arrange components in gui form
                addTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addTabLayout.createSequentialGroup()
                        .addGroup(addTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(addTabLayout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(lblSelChkState))
                                .addGroup(addTabLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(addTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(addTabLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(addTabLayout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(lblChkTime)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddChk)
                        .addContainerGap())
        );

        TabbedPane.addTab("Add Checkpoint", addTab);

        txtAreaDetails.setColumns(20);
        txtAreaDetails.setRows(5);
        jScrollPane2.setViewportView(txtAreaDetails);

        btnDisplayOneDetail.setText("Display Detail");
        btnDisplayOneDetail.addActionListener(new java.awt.event.ActionListener() {	//add action listener to button click
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayOneDetailActionPerformed(evt);
            }
        });

        btnDisplayAll.setText("Display All Details");
        btnDisplayAll.addActionListener(new java.awt.event.ActionListener() {//add action listener to button click
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout displayTabLayout = new javax.swing.GroupLayout(displayTab);		// Arrange components in gui form
        displayTab.setLayout(displayTabLayout);
        displayTabLayout.setHorizontalGroup(
                displayTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(displayTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(displayTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2)
                                .addGroup(displayTabLayout.createSequentialGroup()
                                        .addComponent(txtNumDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDisplayOneDetail)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDisplayAll)))
                        .addContainerGap())
        );
        displayTabLayout.setVerticalGroup( // Arrange components in gui form
                displayTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(displayTabLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(displayTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnDisplayOneDetail)
                                .addComponent(btnDisplayAll)
                                .addComponent(txtNumDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addContainerGap())
        );

        TabbedPane.addTab("Display Details", displayTab);

        lblChkMod.setText("Checkpoint to Modify ");

        lblTimeMod.setText("New Time");

        lblStatusMod.setText("New Status");

        gStateMod.add(rdBtnOnMod);
        rdBtnOnMod.setSelected(true);
        rdBtnOnMod.setText("ON");

        gStateMod.add(rdBtnOffMod);
        rdBtnOffMod.setText("OFF");

        gStateMod.add(rdBtnDntMod);
        rdBtnDntMod.setText("Don't Modify");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);		// Arrange components in gui form
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(rdBtnOnMod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdBtnOffMod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdBtnDntMod)
                        .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup( // Arrange components in gui form
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdBtnOnMod)
                                .addComponent(rdBtnOffMod)
                                .addComponent(rdBtnDntMod))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gTimeMod.add(rdBtnTimeManMod);
        rdBtnTimeManMod.setText("Manually Enter a Value");
        rdBtnTimeManMod.addChangeListener(new javax.swing.event.ChangeListener() {//add action listener to radio button click
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdBtnTimeManModStateChanged(evt);
            }
        });

        gTimeMod.add(rdBtnTimeSysMod);
        rdBtnTimeSysMod.setSelected(true);
        rdBtnTimeSysMod.setText("Current Time(System Generated)");
        rdBtnTimeSysMod.addChangeListener(new javax.swing.event.ChangeListener() {//add action listener to radio button click
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdBtnTimeSysModStateChanged(evt);
            }
        });

        txtTimeManMod.setEnabled(false);

        gTimeMod.add(jRadioButton1);
        jRadioButton1.setText("Don't Modify");
        jRadioButton1.addChangeListener(new javax.swing.event.ChangeListener() {//add action listener to button click
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);		// Arrange components in gui form
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButton1)
                                .addComponent(rdBtnTimeManMod)
                                .addComponent(rdBtnTimeSysMod)
                                .addComponent(txtTimeManMod, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup( // Arrange components in gui form
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(rdBtnTimeSysMod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdBtnTimeManMod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimeManMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnMod.setText("Update Checkpoint");
        btnMod.addActionListener(new java.awt.event.ActionListener() {//add action listener to button click
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout modifyTabLayout = new javax.swing.GroupLayout(modifyTab);		// Arrange components in gui form
        modifyTab.setLayout(modifyTabLayout);
        modifyTabLayout.setHorizontalGroup(
                modifyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(modifyTabLayout.createSequentialGroup()
                        .addGroup(modifyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(modifyTabLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(lblChkMod)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtNumMod, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(modifyTabLayout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(lblStatusMod)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(50, Short.MAX_VALUE))
                .addGroup(modifyTabLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMod))
                .addGroup(modifyTabLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(lblTimeMod)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
        );
        modifyTabLayout.setVerticalGroup( // Arrange components in gui form
                modifyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(modifyTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(modifyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblChkMod)
                                .addComponent(txtNumMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(modifyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(modifyTabLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(modifyTabLayout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(lblStatusMod)))
                        .addGap(31, 31, 31)
                        .addGroup(modifyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(modifyTabLayout.createSequentialGroup()
                                        .addComponent(lblTimeMod)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMod)
                        .addContainerGap())
        );

        TabbedPane.addTab("Modify Checkpoint", modifyTab);

        lblChkNumDelete.setText("Checkpoint Number");

        btnDeleteChk.setText("Delete Checkpoint");
        btnDeleteChk.addActionListener(new java.awt.event.ActionListener() {//add action listener to button click
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteChkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deleteTabLayout = new javax.swing.GroupLayout(deleteTab);		// Arrange components in gui form
        deleteTab.setLayout(deleteTabLayout);
        deleteTabLayout.setHorizontalGroup(
                deleteTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deleteTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(deleteTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnDeleteChk)
                                .addGroup(deleteTabLayout.createSequentialGroup()
                                        .addComponent(lblChkNumDelete)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtChkNumDel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(154, Short.MAX_VALUE))
        );
        deleteTabLayout.setVerticalGroup( // Arrange components in gui form
                deleteTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deleteTabLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(deleteTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblChkNumDelete)
                                .addComponent(txtChkNumDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(btnDeleteChk)
                        .addContainerGap(181, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Delete Checkpoint", deleteTab);

        lblChkNumSearch.setText("Checkpoint Number");

        lblChkTimeSearch.setText("Checkpoint Time");

        btnSearchNum.setText("Search by Number");
        btnSearchNum.addActionListener(new java.awt.event.ActionListener() {//add action listener to button click
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchNumActionPerformed(evt);
            }
        });

        btnSearchTime.setText("Search by Time");
        btnSearchTime.addActionListener(new java.awt.event.ActionListener() {//add action listener to button click
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchTimeActionPerformed(evt);
            }
        });

        txtAreaDisplay.setEditable(false);
        txtAreaDisplay.setColumns(20);
        txtAreaDisplay.setRows(5);
        jScrollPane1.setViewportView(txtAreaDisplay);

        javax.swing.GroupLayout searchTabLayout = new javax.swing.GroupLayout(searchTab);		// Arrange components in gui form
        searchTab.setLayout(searchTabLayout);
        searchTabLayout.setHorizontalGroup(
                searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(searchTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1)
                                .addGroup(searchTabLayout.createSequentialGroup()
                                        .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblChkNumSearch)
                                                .addComponent(lblChkTimeSearch))
                                        .addGap(18, 18, 18)
                                        .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtChNameSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                                .addComponent(txtChkTimeSearch))
                                        .addGap(18, 18, 18)
                                        .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btnSearchNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnSearchTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        searchTabLayout.setVerticalGroup( // Arrange components in gui form
                searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(searchTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblChkNumSearch)
                                .addComponent(txtChNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearchNum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblChkTimeSearch)
                                .addComponent(txtChkTimeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearchTime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addContainerGap())
        );

        TabbedPane.addTab("Search Checkpoint", searchTab);

        jMenu1.setText("Actions");

        exitMn.setText("Exit");
        exitMn.addActionListener(new java.awt.event.ActionListener() {//add action listener to button click
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMnActionPerformed(evt);
            }
        });
        jMenu1.add(exitMn);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());		// Arrange components in gui form
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(TabbedPane)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );

        pack();
    }

    /**
     * Exit button action
     */
    private void exitMnActionPerformed(java.awt.event.ActionEvent evt) {
        int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to Exit the application?"); //confirm before quitting application
        switch (option) {
            case 0: //selected yes
                System.exit(0); //Exit from application
                break;
            default: //selected No or cancel
            //do nothing
        }
    }

    /**
     * Button action for adding a new checkpoint to the file
     */
    private void btnAddChkActionPerformed(java.awt.event.ActionEvent evt) {
        Long time;
        try {
            time = Long.parseLong(txtTimeMan.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Incorrect Input for Time. Try Again");
            return;
        }
        int number = Checkpoint.getLastIndex();
        String state;
        time = (rdBtnTimeSys.isSelected()) ? System.currentTimeMillis() : time;
        if (time <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Incorrect Value for Time,Try Again");
            return;
        }
        state = (rdBtnOnAdd.isSelected()) ? "On" : "Off";
        Checkpoint.addCheckpoint(number, time, state);
        JOptionPane.showMessageDialog(rootPane, "Checkpoint Added");
    }

    /**
     * enable textfield if matching radio button is selected
     */
    private void rdbtnTimeManStateChanged(javax.swing.event.ChangeEvent evt) {
        if (rdbtnTimeMan.isSelected()) {
            txtTimeMan.setEnabled(true);
        }
    }

    /**
     * disable textfield if matching radio button is not selected
     */
    private void rdBtnTimeSysStateChanged(javax.swing.event.ChangeEvent evt) {
        if (!rdbtnTimeMan.isSelected()) {
            txtTimeMan.setEnabled(false);
        }
    }

    /**
     * Button action for modifying an existing checkpoint
     */
    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {
        Long time;
        int number;
        String current;
        String state;
        try {
            number = Integer.parseInt(txtNumMod.getText());
            current = Checkpoint.searchCheckpoint(number + "", 0);

            state = current.split(";")[2];
            state = (rdBtnOnMod.isSelected()) ? "On" : state;
            state = (rdBtnOffMod.isSelected()) ? "Off" : state;

            time = Long.parseLong(current.split(";")[1]);
            time = (rdBtnTimeManMod.isSelected() ? Long.parseLong(txtTimeManMod.getText()) : time);
            time = (rdBtnTimeSysMod.isSelected()) ? System.currentTimeMillis() : time;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Incorrect Input. Try Again");
            return;
        }
        if (time <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Incorrect Value for Time,Try Again");
            return;
        }
        Checkpoint.modifyCheckpoint(number, time, state);
        JOptionPane.showMessageDialog(rootPane, "Checkpoint Modified");
    }

    /**
     * disable textfield if matching radio button is not selected
     */
    private void rdBtnTimeSysModStateChanged(javax.swing.event.ChangeEvent evt) {
        if (!rdBtnTimeManMod.isSelected()) {
            txtTimeManMod.setEnabled(false);
        }
    }

    /**
     * disable text field if matching radio button is not selected
     */
    private void jRadioButton1StateChanged(javax.swing.event.ChangeEvent evt) {
        if (!rdBtnTimeManMod.isSelected()) {
            txtTimeManMod.setEnabled(false);
        }
    }

    /**
     * enable text field if matching radio button is not selected
     */
    private void rdBtnTimeManModStateChanged(javax.swing.event.ChangeEvent evt) {
        if (rdBtnTimeManMod.isSelected()) {
            txtTimeManMod.setEnabled(true);
        }
    }

    /**
     * Button action for deleting an existing checkpoint
     */
    private void btnDeleteChkActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int num = Integer.parseInt(txtChkNumDel.getText());
            if ("".equals(Checkpoint.searchCheckpoint(num + "", 0))) {
                JOptionPane.showMessageDialog(rootPane, "Checkpoint:" + num + " not found. Try Again");
                return;
            }
            Checkpoint.deleteCheckpoint(num);
            JOptionPane.showMessageDialog(rootPane, "Checkpoint Deleted:" + num);
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, "Incorrect Input. Try Again");
        }
    }

    /**
     * Button action for searching for an existing checkpoint based on
     * checkpoint number
     */
    private void btnSearchNumActionPerformed(java.awt.event.ActionEvent evt) {
        String line = Checkpoint.searchCheckpoint(txtChNameSearch.getText(), 0);
        if (line.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Entry with given number not found");
        }
        txtAreaDisplay.setText(line);
    }

    /**
     * Button action for searching an existing checkpoint based on timestamp
     */
    private void btnSearchTimeActionPerformed(java.awt.event.ActionEvent evt) {
        String text = Checkpoint.searchCheckpoint(txtChkTimeSearch.getText(), 1);
        if (text.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Entry with given number not found");
        }
        txtAreaDisplay.setText(text);
    }

    /**
     * Button action for displaying details of all checkpoints
     */
    private void btnDisplayAllActionPerformed(java.awt.event.ActionEvent evt) {
        String text = Checkpoint.getAllDetails();
        txtAreaDetails.setText(text);
        if (text.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "No checkpoints found in log file");
        }
    }

    /**
     * Button action for displaying details of a specific checkpoint based on
     * checkpoint number
     */
    private void btnDisplayOneDetailActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int number = Integer.parseInt(txtNumDetail.getText());
            String text = Checkpoint.getDetail(number);
            if (text.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "No checkpoints found in log file for given number");
            }
            txtAreaDetails.setText(text);
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, "Input Error.Add a valid number");
        }
    }

    /**
     * Main method for running the application
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    /*
     * Declare all the swing components to be used in the application
     */
    //List of buttons
    private javax.swing.JButton btnAddChk;
    private javax.swing.JButton btnDeleteChk;
    private javax.swing.JButton btnDisplayAll;
    private javax.swing.JButton btnDisplayOneDetail;
    private javax.swing.JButton btnMod;
    private javax.swing.JButton btnSearchNum;
    private javax.swing.JButton btnSearchTime;

    //menu components
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem exitMn;

    //scroll panes
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;

    //list of labels used
    private javax.swing.JLabel lblChkMod;
    private javax.swing.JLabel lblChkNumDelete;
    private javax.swing.JLabel lblChkNumSearch;
    private javax.swing.JLabel lblChkTime;
    private javax.swing.JLabel lblChkTimeSearch;
    private javax.swing.JLabel lblSelChkState;
    private javax.swing.JLabel lblStatusMod;
    private javax.swing.JLabel lblTimeMod;
    private javax.swing.JPanel modifyTab;
    private javax.swing.JPanel searchTab;
    private javax.swing.JPanel deleteTab;
    private javax.swing.JPanel displayTab;
    private javax.swing.JPanel addTab;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;

    //list of radio buttons used
    private javax.swing.JRadioButton rdBtnDntMod;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton rdBtnOffAdd;
    private javax.swing.JRadioButton rdBtnOffMod;
    private javax.swing.JRadioButton rdBtnOnAdd;
    private javax.swing.JRadioButton rdBtnOnMod;
    private javax.swing.JRadioButton rdBtnTimeManMod;
    private javax.swing.JRadioButton rdBtnTimeSys;
    private javax.swing.JRadioButton rdBtnTimeSysMod;
    private javax.swing.JRadioButton rdbtnTimeMan;

    //list of groups for grouping related radio buttons
    private javax.swing.ButtonGroup gStateAdd;
    private javax.swing.ButtonGroup gStateMod;
    private javax.swing.ButtonGroup gTimeAdd;
    private javax.swing.ButtonGroup gTimeMod;

    //text areas to display multi-line strings
    private javax.swing.JTextArea txtAreaDetails;
    private javax.swing.JTextArea txtAreaDisplay;

    //text fileds to display/take input from,  single line strings
    private javax.swing.JTextField txtChNameSearch;
    private javax.swing.JTextField txtChkNumDel;
    private javax.swing.JTextField txtChkTimeSearch;
    private javax.swing.JTextField txtNumDetail;
    private javax.swing.JTextField txtNumMod;
    private javax.swing.JTextField txtTimeMan;
    private javax.swing.JTextField txtTimeManMod;
}
